package edu.umn.cs.crisys.safety.analysis.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.impl.ComponentImplementationImpl;
import org.osate.aadl2.impl.DefaultAnnexSubclauseImpl;

import com.rockwellcollins.atc.agree.analysis.Activator;
import com.rockwellcollins.atc.agree.analysis.ConsistencyResult;
import com.rockwellcollins.atc.agree.analysis.handlers.RerunHandler;
import com.rockwellcollins.atc.agree.analysis.handlers.TerminateHandler;
import com.rockwellcollins.atc.agree.analysis.handlers.VerifyAllHandler;
import com.rockwellcollins.atc.agree.analysis.preferences.PreferenceConstants;
import com.rockwellcollins.atc.agree.analysis.preferences.PreferencesUtil;
import com.rockwellcollins.atc.agree.analysis.saving.AgreeFileUtil;

import edu.umn.cs.crisys.safety.analysis.SafetyException;
import edu.umn.cs.crisys.safety.analysis.ast.visitors.AddFaultsToNodeVisitor;
import edu.umn.cs.crisys.safety.analysis.transform.AddFaultsToAgree;
import edu.umn.cs.crisys.safety.safety.AnalysisStatement;
import edu.umn.cs.crisys.safety.safety.ProbabilityBehavior;
import edu.umn.cs.crisys.safety.safety.SafetyContract;
import edu.umn.cs.crisys.safety.safety.SpecStatement;
import edu.umn.cs.crisys.safety.safety.impl.SafetyContractSubclauseImpl;
import jkind.JKindException;
import jkind.api.JKindApi;
import jkind.api.JRealizabilityApi;
import jkind.api.KindApi;
import jkind.api.results.JKindResult;
import jkind.api.results.JRealizabilityResult;
import jkind.lustre.Program;

public class FaultsVerifyAllHandler extends VerifyAllHandler {

	private static MenuItem item;
	private static final String RERUN_ID = "com.rockwellcollins.atc.agree.analysis.commands.rerunAgree";
	private IHandlerActivation terminateActivation;
	private IHandlerActivation terminateAllActivation;
	private IHandlerService handlerService;
	private Map<String, String> rerunAdviceMap = new HashMap<>();
	private int adviceCount = 0;
	@Override
	public Object execute(ExecutionEvent event) {
		AddFaultsToAgree.resetStaticVars();
		Event selEvent = (Event) event.getTrigger();
		item = (MenuItem) selEvent.widget;
		AddFaultsToAgree.setTransformFlag(item);
		// clear static variables before each run
		AddFaultsToNodeVisitor.init();
		if (isProbabilisticAnalysis()) {
			new SafetyException("Probabilistic behavior cannot be analyzed using "
					+ "this compositional approach. Either choose monolithic "
					+ "analysis or compositionally generate MinCutSets.");
			return Status.CANCEL_STATUS;
		}
		return super.execute(event);
	}

	@Override
	protected IStatus doAnalysis(final Element root, final IProgressMonitor globalMonitor) {

		Thread analysisThread = new Thread() {
			@Override
			public void run() {

				// Record the analysis start time and get model hashcode for
				// saving to property analysis log, if necessary
				String modelHash = "";
				long startTime = 0;
				if (Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.PREF_PROP_LOG)) {
					try {
						modelHash = AgreeFileUtil.getModelHashcode(root);
						startTime = System.currentTimeMillis();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						return;
					}
				}

				activateTerminateHandlers(globalMonitor);
				KindApi api = PreferencesUtil.getKindApi();
				KindApi consistApi = PreferencesUtil.getConsistencyApi();
				JRealizabilityApi realApi = PreferencesUtil.getJRealizabilityApi();

				while (!queue.isEmpty() && !globalMonitor.isCanceled()) {
					JKindResult result = queue.peek();
					NullProgressMonitor subMonitor = new NullProgressMonitor();
					monitorRef.set(subMonitor);

					Program program = linker.getProgram(result);

					if (api instanceof JKindApi) {
						String resultName = result.getName();
						String adviceFileName = rerunAdviceMap.get(resultName);
						if (adviceFileName == null) {
							adviceFileName = "agree_advice" + adviceCount++;
							rerunAdviceMap.put(resultName, adviceFileName);
						} else {
							((JKindApi) api).setReadAdviceFile(adviceFileName);
						}
						((JKindApi) api).setWriteAdviceFile(adviceFileName);
					}

					try {
						if (result instanceof ConsistencyResult) {
							consistApi.execute(program, result, subMonitor);
						} else if (result instanceof JRealizabilityResult) {
							realApi.execute(program, (JRealizabilityResult) result, subMonitor);
						} else {
							api.execute(program, result, subMonitor);
						}
					} catch (JKindException e) {

						System.out.println("******** JKindException Text ********");
						e.printStackTrace(System.out);
						String errStr = e.getMessage();
						int l = Math.min(errStr.length(), 300);
						System.out.println(e.getMessage().substring(0, l));
						break;
					}

					// Print to property analysis log, if necessary
					if (Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.PREF_PROP_LOG)) {
						AgreeFileUtil.printLog(result, startTime, modelHash);
					}

					queue.remove();
				}

				while (!queue.isEmpty()) {
					queue.remove().cancel();
				}
				AddFaultsToAgree.resetStaticVars();
				deactivateTerminateHandlers();
				enableRerunHandler(root);

			}
		};
		analysisThread.start();
		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 *
	 * @see edu.umn.cs.crisys.safety.analysis.handlers.AadlHandler#getJobName()
	 *
	 * Output job name (will see it at the bottom of Osate2 after selected)
	 */
	@Override
	protected String getJobName() {
		return "Fault analysis: compositional";
	}

	private boolean isProbabilisticAnalysis() {
		List<Classifier> classifiers = getClassifiers();
		if (classifiers == null) {
			return false;
		}
		// This is a partial fix on the problem:
		// If multiple implementations and none have max n behavior,
		// then error out. If any impl have max n, run analysis.
		// Doesn't fix the problem, only partially.
		// Need to access the implementation selected for analysis
		// and check that spec stmt. To do this is taking more time than
		// what priority allows for.
		// VerifyHandler has methods that perform this type of check, but to
		// implement them, need access to Element root. This access is granted in
		// runJob method which will need to be overridden from VerifyHandler.
		// TODO: Finish addressing this issue.
		for (Classifier cl : classifiers) {
			// Get impl of this level
			if (cl instanceof ComponentImplementationImpl) {
				List<AnnexSubclause> asList = cl.getOwnedAnnexSubclauses();
				for (AnnexSubclause as : asList) {
					if (as.getName().equalsIgnoreCase("safety")) {
						if (as instanceof DefaultAnnexSubclauseImpl) {
							DefaultAnnexSubclauseImpl defaultAnnex = (DefaultAnnexSubclauseImpl) as;
							SafetyContractSubclauseImpl safetyAnnex = (SafetyContractSubclauseImpl) defaultAnnex
									.getParsedAnnexSubclause();

							// Get analysis stmt
							List<SpecStatement> specs = ((SafetyContract) safetyAnnex.getContract()).getSpecs();
							for (SpecStatement spec : specs) {
								if (spec instanceof AnalysisStatement) {
									if (!(((AnalysisStatement) spec).getBehavior() instanceof ProbabilityBehavior)) {
										return false;
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	private List<Classifier> getClassifiers() {
		XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor();
		if (xtextEditor == null) {
			return null;
		}
		EObject original = xtextEditor.getDocument().readOnly(resource -> resource.getContents().get(0));
		AadlPackage aadlPackage = null;
		if (original instanceof AadlPackage) {
			aadlPackage = (AadlPackage) original;
		}
		if (aadlPackage == null) {
			return null;
		}
		return aadlPackage.getOwnedPublicSection().getOwnedClassifiers();
	}

	private void enableRerunHandler(final Element root) {

		getWindow().getShell().getDisplay().syncExec(() -> {
			IHandlerService handlerService = getHandlerService();
			handlerService.activateHandler(RERUN_ID,
					new RerunHandler(root, FaultsVerifyAllHandler.this));
		});
	}

	private void activateTerminateHandlers(final IProgressMonitor globalMonitor) {
		getWindow().getShell().getDisplay().syncExec(() -> {
			terminateActivation = handlerService.activateHandler(TERMINATE_ID, new TerminateHandler(monitorRef));
			terminateAllActivation = handlerService.activateHandler(TERMINATE_ALL_ID,
					new TerminateHandler(monitorRef, globalMonitor));
		});
	}

	private void deactivateTerminateHandlers() {
		getWindow().getShell().getDisplay().syncExec(() -> {
			handlerService.deactivateHandler(terminateActivation);
			handlerService.deactivateHandler(terminateAllActivation);
		});
	}

	private IHandlerService getHandlerService() {
		return getWindow().getService(IHandlerService.class);
	}
}
