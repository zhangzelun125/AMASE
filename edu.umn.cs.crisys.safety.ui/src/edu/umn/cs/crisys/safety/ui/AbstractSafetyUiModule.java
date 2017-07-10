package edu.umn.cs.crisys.safety.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.resource.IResourceDescription;

public class AbstractSafetyUiModule extends org.eclipse.xtext.ui.DefaultUiModule{

	public AbstractSafetyUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
		public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
			return org.eclipse.xtext.ui.shared.Access.getJavaProjectsState();
		}

		// contributed by org.eclipse.xtext.generator.parser.antlr.ex.rt.AntlrGeneratorFragment
		public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper> bindIProposalConflictHelper() {
			return org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper.class;
		}

		// contributed by org.eclipse.xtext.generator.parser.antlr.ex.rt.AntlrGeneratorFragment
//		public void configureHighlightingLexer(com.google.inject.Binder binder) {
//			binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(com.rockwellcollins.atc.agree.parser.antlr.lexer.InternalAgreeLexer.class);
//		}

		// contributed by org.eclipse.xtext.generator.parser.antlr.ex.rt.AntlrGeneratorFragment
		public void configureHighlightingTokenDefProvider(com.google.inject.Binder binder) {
			binder.bind(org.eclipse.xtext.parser.antlr.ITokenDefProvider.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class);
		}

		// contributed by org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
		public Class<? extends org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher> bindPrefixMatcher() {
			return org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher.class;
		}

		// contributed by org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
		public Class<? extends org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator> bindIDependentElementsCalculator() {
			return org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator.class;
		}

		// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
		public void configureIResourceDescriptionsBuilderScope(com.google.inject.Binder binder) {
			binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(org.eclipse.xtext.builder.clustering.CurrentDescriptions.ResourceSetAware.class);
		}

		// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
		public Class<? extends org.eclipse.xtext.ui.editor.IXtextEditorCallback> bindIXtextEditorCallback() {
			return org.eclipse.xtext.builder.nature.NatureAddingEditorCallback.class;
		}

		// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
		public Class<? extends org.eclipse.xtext.generator.IContextualOutputConfigurationProvider> bindIContextualOutputConfigurationProvider() {
			return org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.class;
		}

		// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
		public void configureIResourceDescriptionsPersisted(com.google.inject.Binder binder) {
			binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)).to(org.eclipse.xtext.builder.builderState.IBuilderState.class);
		}

		// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
		public Class<? extends org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource> bindDocumentBasedDirtyResource() {
			return org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource.class;
		}

		// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
		public Class<? extends org.eclipse.jface.viewers.ILabelProvider> bindILabelProvider() {
			return edu.umn.cs.crisys.safety.ui.labeling.SafetyLabelProvider.class;
		}

		// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
		public void configureResourceUIServiceLabelProvider(com.google.inject.Binder binder) {
			binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class).to(edu.umn.cs.crisys.safety.ui.labeling.SafetyDescriptionLabelProvider.class);
		}

		// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
		public Class<? extends org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider> bindIOutlineTreeProvider() {
			return edu.umn.cs.crisys.safety.ui.outline.SafetyOutlineTreeProvider.class;
		}

		// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
		public Class<? extends org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider> bindIOutlineTreeStructureProvider() {
			return edu.umn.cs.crisys.safety.ui.outline.SafetyOutlineTreeProvider.class;
		}

		// contributed by org.eclipse.xtext.ui.generator.quickfix.QuickfixProviderFragment
//		public Class<? extends org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider> bindIssueResolutionProvider() {
//			return edu.umn.cs.crisys.safety.ui.quickfix.SafetyQuickfixProvider.class;
//		}

		// contributed by org.eclipse.xtext.ui.generator.contentAssist.JavaBasedContentAssistFragment
//		public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider> bindIContentProposalProvider() {
//			return edu.umn.cs.crisys.safety.ui.contentassist.SafetyProposalProvider.class;
//		}

		// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
		public Class<? extends org.eclipse.xtext.ui.refactoring.IRenameStrategy> bindIRenameStrategy() {
			return org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy.class;
		}

		// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
		public Class<? extends org.eclipse.xtext.ui.refactoring.IReferenceUpdater> bindIReferenceUpdater() {
			return org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater.class;
		}

		// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
		public void configureIPreferenceStoreInitializer(com.google.inject.Binder binder) {
			binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class).annotatedWith(com.google.inject.name.Names.named("RefactoringPreferences")).to(org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences.Initializer.class);
		}

		// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
		public Class<? extends org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider> bindIRenameRefactoringProvider() {
			return org.eclipse.xtext.ui.refactoring.impl.DefaultRenameRefactoringProvider.class;
		}

		// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
		public Class<? extends org.eclipse.xtext.ui.refactoring.ui.IRenameSupport.Factory> bindIRenameSupport$Factory() {
			return org.eclipse.xtext.ui.refactoring.ui.DefaultRenameSupport.Factory.class;
		}

		// contributed by org.eclipse.xtext.generator.parser.antlr.ex.ca.ContentAssistParserGeneratorFragment
		public Class<? extends org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory> bindContentAssistContext$Factory() {
			return org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.class;
		}

		// contributed by org.eclipse.xtext.generator.parser.antlr.ex.ca.ContentAssistParserGeneratorFragment
//		public Class<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser> bindIContentAssistParser() {
//			return com.rockwellcollins.atc.agree.ui.contentassist.antlr.AgreeParser.class;
//		}

		// contributed by org.eclipse.xtext.generator.parser.antlr.ex.ca.ContentAssistParserGeneratorFragment
//		public void configureContentAssistLexerProvider(com.google.inject.Binder binder) {
//			binder.bind(com.rockwellcollins.atc.agree.ui.contentassist.antlr.lexer.InternalAgreeLexer.class).toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(com.rockwellcollins.atc.agree.ui.contentassist.antlr.lexer.InternalAgreeLexer.class));
//		}

		// contributed by org.eclipse.xtext.generator.parser.antlr.ex.ca.ContentAssistParserGeneratorFragment
//		public void configureContentAssistLexer(com.google.inject.Binder binder) {
//			binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST)).to(com.rockwellcollins.atc.agree.ui.contentassist.antlr.lexer.InternalAgreeLexer.class);
//		}

		// contributed by org.eclipse.xtext.generator.parser.antlr.ex.ca.ContentAssistParserGeneratorFragment
//		public Class<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory> bindParserBasedContentAssistContextFactory$StatefulFactory() {
//			return org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.PartialStatefulFactory.class;
//		}

}
