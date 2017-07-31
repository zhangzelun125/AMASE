/*
 * generated by Xtext
 */
package edu.umn.cs.crisys.safety.serializer;

import com.google.inject.Inject;
import com.rockwellcollins.atc.agree.agree.AgreeContract;
import com.rockwellcollins.atc.agree.agree.AgreeContractLibrary;
import com.rockwellcollins.atc.agree.agree.AgreeContractSubclause;
import com.rockwellcollins.atc.agree.agree.AgreePackage;
import com.rockwellcollins.atc.agree.agree.AlwaysStatement;
import com.rockwellcollins.atc.agree.agree.Arg;
import com.rockwellcollins.atc.agree.agree.AssignStatement;
import com.rockwellcollins.atc.agree.agree.AsynchStatement;
import com.rockwellcollins.atc.agree.agree.BinaryExpr;
import com.rockwellcollins.atc.agree.agree.BoolLitExpr;
import com.rockwellcollins.atc.agree.agree.CalenStatement;
import com.rockwellcollins.atc.agree.agree.ClosedTimeInterval;
import com.rockwellcollins.atc.agree.agree.ConstStatement;
import com.rockwellcollins.atc.agree.agree.EnumStatement;
import com.rockwellcollins.atc.agree.agree.EqStatement;
import com.rockwellcollins.atc.agree.agree.EventExpr;
import com.rockwellcollins.atc.agree.agree.FloorCast;
import com.rockwellcollins.atc.agree.agree.FnCallExpr;
import com.rockwellcollins.atc.agree.agree.FnDefExpr;
import com.rockwellcollins.atc.agree.agree.GetPropertyExpr;
import com.rockwellcollins.atc.agree.agree.IfThenElseExpr;
import com.rockwellcollins.atc.agree.agree.InputStatement;
import com.rockwellcollins.atc.agree.agree.IntLitExpr;
import com.rockwellcollins.atc.agree.agree.LatchedExpr;
import com.rockwellcollins.atc.agree.agree.LatchedStatement;
import com.rockwellcollins.atc.agree.agree.LibraryFnDefExpr;
import com.rockwellcollins.atc.agree.agree.LinearizationDefExpr;
import com.rockwellcollins.atc.agree.agree.LinearizationInterval;
import com.rockwellcollins.atc.agree.agree.MNSynchStatement;
import com.rockwellcollins.atc.agree.agree.NamedID;
import com.rockwellcollins.atc.agree.agree.NestedDotID;
import com.rockwellcollins.atc.agree.agree.NodeBodyExpr;
import com.rockwellcollins.atc.agree.agree.NodeDefExpr;
import com.rockwellcollins.atc.agree.agree.NodeEq;
import com.rockwellcollins.atc.agree.agree.NodeLemma;
import com.rockwellcollins.atc.agree.agree.OpenLeftTimeInterval;
import com.rockwellcollins.atc.agree.agree.OpenRightTimeInterval;
import com.rockwellcollins.atc.agree.agree.OpenTimeInterval;
import com.rockwellcollins.atc.agree.agree.OrderStatement;
import com.rockwellcollins.atc.agree.agree.PeriodicStatement;
import com.rockwellcollins.atc.agree.agree.PreExpr;
import com.rockwellcollins.atc.agree.agree.PrevExpr;
import com.rockwellcollins.atc.agree.agree.PrimType;
import com.rockwellcollins.atc.agree.agree.PropertyStatement;
import com.rockwellcollins.atc.agree.agree.RealCast;
import com.rockwellcollins.atc.agree.agree.RealLitExpr;
import com.rockwellcollins.atc.agree.agree.RecordDefExpr;
import com.rockwellcollins.atc.agree.agree.RecordExpr;
import com.rockwellcollins.atc.agree.agree.RecordType;
import com.rockwellcollins.atc.agree.agree.RecordUpdateExpr;
import com.rockwellcollins.atc.agree.agree.SporadicStatement;
import com.rockwellcollins.atc.agree.agree.SynchStatement;
import com.rockwellcollins.atc.agree.agree.ThisExpr;
import com.rockwellcollins.atc.agree.agree.TimeExpr;
import com.rockwellcollins.atc.agree.agree.TimeFallExpr;
import com.rockwellcollins.atc.agree.agree.TimeOfExpr;
import com.rockwellcollins.atc.agree.agree.TimeRiseExpr;
import com.rockwellcollins.atc.agree.agree.UnaryExpr;
import com.rockwellcollins.atc.agree.agree.WhenHoldsStatement;
import com.rockwellcollins.atc.agree.agree.WhenOccursStatment;
import com.rockwellcollins.atc.agree.agree.WheneverBecomesTrueStatement;
import com.rockwellcollins.atc.agree.agree.WheneverHoldsStatement;
import com.rockwellcollins.atc.agree.agree.WheneverImpliesStatement;
import com.rockwellcollins.atc.agree.agree.WheneverOccursStatement;
import com.rockwellcollins.atc.agree.serializer.AgreeSemanticSequencer;
import edu.umn.cs.crisys.safety.safety.DurationStatement;
import edu.umn.cs.crisys.safety.safety.EnablerCondition;
import edu.umn.cs.crisys.safety.safety.EqValue;
import edu.umn.cs.crisys.safety.safety.FaultStatement;
import edu.umn.cs.crisys.safety.safety.IntervalEq;
import edu.umn.cs.crisys.safety.safety.MustCondition;
import edu.umn.cs.crisys.safety.safety.OutputStatement;
import edu.umn.cs.crisys.safety.safety.PermanentConstraint;
import edu.umn.cs.crisys.safety.safety.SafetyContract;
import edu.umn.cs.crisys.safety.safety.SafetyContractLibrary;
import edu.umn.cs.crisys.safety.safety.SafetyContractSubclause;
import edu.umn.cs.crisys.safety.safety.SafetyPackage;
import edu.umn.cs.crisys.safety.safety.SetEq;
import edu.umn.cs.crisys.safety.safety.TransientConstraint;
import edu.umn.cs.crisys.safety.safety.TriggerStatement;
import edu.umn.cs.crisys.safety.services.SafetyGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;

@SuppressWarnings("all")
public abstract class AbstractSafetySemanticSequencer extends AgreeSemanticSequencer {

	@Inject
	private SafetyGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Aadl2Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.ARRAY_RANGE:
				sequence_ArrayRange(context, (ArrayRange) semanticObject); 
				return; 
			case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
				sequence_FieldPropertyAssociation(context, (BasicPropertyAssociation) semanticObject); 
				return; 
			case Aadl2Package.BOOLEAN_LITERAL:
				sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case Aadl2Package.CLASSIFIER_VALUE:
				sequence_ComponentClassifierTerm(context, (ClassifierValue) semanticObject); 
				return; 
			case Aadl2Package.COMPUTED_VALUE:
				sequence_ComputedTerm(context, (ComputedValue) semanticObject); 
				return; 
			case Aadl2Package.CONTAINED_NAMED_ELEMENT:
				sequence_ContainmentPath(context, (ContainedNamedElement) semanticObject); 
				return; 
			case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
				sequence_ContainmentPathElement(context, (ContainmentPathElement) semanticObject); 
				return; 
			case Aadl2Package.INTEGER_LITERAL:
				sequence_IntegerTerm(context, (IntegerLiteral) semanticObject); 
				return; 
			case Aadl2Package.LIST_VALUE:
				sequence_ListTerm(context, (ListValue) semanticObject); 
				return; 
			case Aadl2Package.MODAL_PROPERTY_VALUE:
				if (rule == grammarAccess.getModalPropertyValueRule()) {
					sequence_ModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOptionalModalPropertyValueRule()) {
					sequence_OptionalModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyValueRule()) {
					sequence_PropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.NAMED_VALUE:
				if (rule == grammarAccess.getConstantValueRule()
						|| rule == grammarAccess.getNumAltRule()) {
					sequence_ConstantValue(context, (NamedValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getLiteralorReferenceTermRule()) {
					sequence_LiteralorReferenceTerm(context, (NamedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.OPERATION:
				sequence_SignedConstant(context, (Operation) semanticObject); 
				return; 
			case Aadl2Package.PROPERTY_ASSOCIATION:
				if (rule == grammarAccess.getBasicPropertyAssociationRule()) {
					sequence_BasicPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPModelRule()
						|| rule == grammarAccess.getContainedPropertyAssociationRule()) {
					sequence_ContainedPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyAssociationRule()) {
					sequence_PropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RANGE_VALUE:
				sequence_NumericRangeTerm(context, (RangeValue) semanticObject); 
				return; 
			case Aadl2Package.REAL_LITERAL:
				sequence_RealTerm(context, (RealLiteral) semanticObject); 
				return; 
			case Aadl2Package.RECORD_VALUE:
				if (rule == grammarAccess.getOldRecordTermRule()) {
					sequence_OldRecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getRecordTermRule()) {
					sequence_RecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REFERENCE_VALUE:
				sequence_ReferenceTerm(context, (ReferenceValue) semanticObject); 
				return; 
			case Aadl2Package.STRING_LITERAL:
				sequence_StringTerm(context, (StringLiteral) semanticObject); 
				return; 
			}
		else if (epackage == AgreePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case AgreePackage.AGREE_CONTRACT:
				sequence_AgreeContract(context, (AgreeContract) semanticObject); 
				return; 
			case AgreePackage.AGREE_CONTRACT_LIBRARY:
				sequence_AgreeLibrary(context, (AgreeContractLibrary) semanticObject); 
				return; 
			case AgreePackage.AGREE_CONTRACT_SUBCLAUSE:
				sequence_AgreeSubclause(context, (AgreeContractSubclause) semanticObject); 
				return; 
			case AgreePackage.ALWAYS_STATEMENT:
				sequence_PatternStatement(context, (AlwaysStatement) semanticObject); 
				return; 
			case AgreePackage.ARG:
				sequence_Arg(context, (Arg) semanticObject); 
				return; 
			case AgreePackage.ASSIGN_STATEMENT:
				sequence_AssignStatement(context, (AssignStatement) semanticObject); 
				return; 
			case AgreePackage.ASYNCH_STATEMENT:
				sequence_SynchStatement(context, (AsynchStatement) semanticObject); 
				return; 
			case AgreePackage.BINARY_EXPR:
				sequence_AddSubExpr_AndExpr_ArrowExpr_EquivExpr_ImpliesExpr_MultDivExpr_OrExpr_PowerExpr_RelateExpr(context, (BinaryExpr) semanticObject); 
				return; 
			case AgreePackage.BOOL_LIT_EXPR:
				sequence_TermExpr(context, (BoolLitExpr) semanticObject); 
				return; 
			case AgreePackage.CALEN_STATEMENT:
				sequence_SynchStatement(context, (CalenStatement) semanticObject); 
				return; 
			case AgreePackage.CLOSED_TIME_INTERVAL:
				sequence_TimeInterval(context, (ClosedTimeInterval) semanticObject); 
				return; 
			case AgreePackage.CONST_STATEMENT:
				sequence_ConstStatement(context, (ConstStatement) semanticObject); 
				return; 
			case AgreePackage.ENUM_STATEMENT:
				sequence_EnumStatement(context, (EnumStatement) semanticObject); 
				return; 
			case AgreePackage.EQ_STATEMENT:
				sequence_EqStatement(context, (EqStatement) semanticObject); 
				return; 
			case AgreePackage.EVENT_EXPR:
				sequence_TermExpr(context, (EventExpr) semanticObject); 
				return; 
			case AgreePackage.FLOOR_CAST:
				sequence_TermExpr(context, (FloorCast) semanticObject); 
				return; 
			case AgreePackage.FN_CALL_EXPR:
				sequence_ComplexExpr(context, (FnCallExpr) semanticObject); 
				return; 
			case AgreePackage.FN_DEF_EXPR:
				sequence_FnDefExpr(context, (FnDefExpr) semanticObject); 
				return; 
			case AgreePackage.GET_PROPERTY_EXPR:
				sequence_PreDefFnExpr(context, (GetPropertyExpr) semanticObject); 
				return; 
			case AgreePackage.IF_THEN_ELSE_EXPR:
				sequence_IfThenElseExpr(context, (IfThenElseExpr) semanticObject); 
				return; 
			case AgreePackage.INPUT_STATEMENT:
				sequence_InputStatement(context, (InputStatement) semanticObject); 
				return; 
			case AgreePackage.INT_LIT_EXPR:
				sequence_TermExpr(context, (IntLitExpr) semanticObject); 
				return; 
			case AgreePackage.LATCHED_EXPR:
				sequence_TermExpr(context, (LatchedExpr) semanticObject); 
				return; 
			case AgreePackage.LATCHED_STATEMENT:
				sequence_SynchStatement(context, (LatchedStatement) semanticObject); 
				return; 
			case AgreePackage.LIBRARY_FN_DEF_EXPR:
				sequence_LibraryFnDefExpr(context, (LibraryFnDefExpr) semanticObject); 
				return; 
			case AgreePackage.LINEARIZATION_DEF_EXPR:
				sequence_LinearizationDefExpr(context, (LinearizationDefExpr) semanticObject); 
				return; 
			case AgreePackage.LINEARIZATION_INTERVAL:
				sequence_LinearizationInterval(context, (LinearizationInterval) semanticObject); 
				return; 
			case AgreePackage.MN_SYNCH_STATEMENT:
				sequence_SynchStatement(context, (MNSynchStatement) semanticObject); 
				return; 
			case AgreePackage.NAMED_ID:
				sequence_NamedID(context, (NamedID) semanticObject); 
				return; 
			case AgreePackage.NESTED_DOT_ID:
				sequence_NestedDotID(context, (NestedDotID) semanticObject); 
				return; 
			case AgreePackage.NODE_BODY_EXPR:
				sequence_NodeBodyExpr(context, (NodeBodyExpr) semanticObject); 
				return; 
			case AgreePackage.NODE_DEF_EXPR:
				sequence_NodeDefExpr(context, (NodeDefExpr) semanticObject); 
				return; 
			case AgreePackage.NODE_EQ:
				sequence_NodeStmt(context, (NodeEq) semanticObject); 
				return; 
			case AgreePackage.NODE_LEMMA:
				sequence_NodeStmt(context, (NodeLemma) semanticObject); 
				return; 
			case AgreePackage.OPEN_LEFT_TIME_INTERVAL:
				sequence_TimeInterval(context, (OpenLeftTimeInterval) semanticObject); 
				return; 
			case AgreePackage.OPEN_RIGHT_TIME_INTERVAL:
				sequence_TimeInterval(context, (OpenRightTimeInterval) semanticObject); 
				return; 
			case AgreePackage.OPEN_TIME_INTERVAL:
				sequence_TimeInterval(context, (OpenTimeInterval) semanticObject); 
				return; 
			case AgreePackage.ORDER_STATEMENT:
				sequence_OrderStatement(context, (OrderStatement) semanticObject); 
				return; 
			case AgreePackage.PERIODIC_STATEMENT:
				sequence_RealTimeStatement(context, (PeriodicStatement) semanticObject); 
				return; 
			case AgreePackage.PRE_EXPR:
				sequence_TermExpr(context, (PreExpr) semanticObject); 
				return; 
			case AgreePackage.PREV_EXPR:
				sequence_PreDefFnExpr(context, (PrevExpr) semanticObject); 
				return; 
			case AgreePackage.PRIM_TYPE:
				sequence_Type(context, (PrimType) semanticObject); 
				return; 
			case AgreePackage.PROPERTY_STATEMENT:
				sequence_PropertyStatement(context, (PropertyStatement) semanticObject); 
				return; 
			case AgreePackage.REAL_CAST:
				sequence_TermExpr(context, (RealCast) semanticObject); 
				return; 
			case AgreePackage.REAL_LIT_EXPR:
				sequence_TermExpr(context, (RealLitExpr) semanticObject); 
				return; 
			case AgreePackage.RECORD_DEF_EXPR:
				sequence_RecordDefExpr(context, (RecordDefExpr) semanticObject); 
				return; 
			case AgreePackage.RECORD_EXPR:
				sequence_ComplexExpr(context, (RecordExpr) semanticObject); 
				return; 
			case AgreePackage.RECORD_TYPE:
				sequence_Type(context, (RecordType) semanticObject); 
				return; 
			case AgreePackage.RECORD_UPDATE_EXPR:
				sequence_RecordUpdateExpr(context, (RecordUpdateExpr) semanticObject); 
				return; 
			case AgreePackage.SPORADIC_STATEMENT:
				sequence_RealTimeStatement(context, (SporadicStatement) semanticObject); 
				return; 
			case AgreePackage.SYNCH_STATEMENT:
				sequence_SynchStatement(context, (SynchStatement) semanticObject); 
				return; 
			case AgreePackage.THIS_EXPR:
				sequence_TermExpr(context, (ThisExpr) semanticObject); 
				return; 
			case AgreePackage.TIME_EXPR:
				sequence_TermExpr(context, (TimeExpr) semanticObject); 
				return; 
			case AgreePackage.TIME_FALL_EXPR:
				sequence_TermExpr(context, (TimeFallExpr) semanticObject); 
				return; 
			case AgreePackage.TIME_OF_EXPR:
				sequence_TermExpr(context, (TimeOfExpr) semanticObject); 
				return; 
			case AgreePackage.TIME_RISE_EXPR:
				sequence_TermExpr(context, (TimeRiseExpr) semanticObject); 
				return; 
			case AgreePackage.UNARY_EXPR:
				sequence_UnaryExpr(context, (UnaryExpr) semanticObject); 
				return; 
			case AgreePackage.WHEN_HOLDS_STATEMENT:
				sequence_WhenStatement(context, (WhenHoldsStatement) semanticObject); 
				return; 
			case AgreePackage.WHEN_OCCURS_STATMENT:
				sequence_WhenStatement(context, (WhenOccursStatment) semanticObject); 
				return; 
			case AgreePackage.WHENEVER_BECOMES_TRUE_STATEMENT:
				sequence_WheneverStatement(context, (WheneverBecomesTrueStatement) semanticObject); 
				return; 
			case AgreePackage.WHENEVER_HOLDS_STATEMENT:
				sequence_WheneverStatement(context, (WheneverHoldsStatement) semanticObject); 
				return; 
			case AgreePackage.WHENEVER_IMPLIES_STATEMENT:
				sequence_WheneverStatement(context, (WheneverImpliesStatement) semanticObject); 
				return; 
			case AgreePackage.WHENEVER_OCCURS_STATEMENT:
				sequence_WheneverStatement(context, (WheneverOccursStatement) semanticObject); 
				return; 
			}
		else if (epackage == SafetyPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case SafetyPackage.DURATION_STATEMENT:
				sequence_FaultSubcomponent(context, (DurationStatement) semanticObject); 
				return; 
			case SafetyPackage.ENABLER_CONDITION:
				sequence_TriggerCondition(context, (EnablerCondition) semanticObject); 
				return; 
			case SafetyPackage.EQ_VALUE:
				sequence_SafetyEqStatement(context, (EqValue) semanticObject); 
				return; 
			case SafetyPackage.FAULT_STATEMENT:
				sequence_SpecStatement(context, (FaultStatement) semanticObject); 
				return; 
			case SafetyPackage.INPUT_STATEMENT:
				sequence_FaultSubcomponent(context, (edu.umn.cs.crisys.safety.safety.InputStatement) semanticObject); 
				return; 
			case SafetyPackage.INTERVAL_EQ:
				sequence_SafetyEqStatement(context, (IntervalEq) semanticObject); 
				return; 
			case SafetyPackage.MUST_CONDITION:
				sequence_TriggerCondition(context, (MustCondition) semanticObject); 
				return; 
			case SafetyPackage.OUTPUT_STATEMENT:
				sequence_FaultSubcomponent(context, (OutputStatement) semanticObject); 
				return; 
			case SafetyPackage.PERMANENT_CONSTRAINT:
				sequence_TemporalConstraint(context, (PermanentConstraint) semanticObject); 
				return; 
			case SafetyPackage.SAFETY_CONTRACT:
				sequence_SafetyContract(context, (SafetyContract) semanticObject); 
				return; 
			case SafetyPackage.SAFETY_CONTRACT_LIBRARY:
				sequence_SafetyLibrary(context, (SafetyContractLibrary) semanticObject); 
				return; 
			case SafetyPackage.SAFETY_CONTRACT_SUBCLAUSE:
				sequence_SafetySubclause(context, (SafetyContractSubclause) semanticObject); 
				return; 
			case SafetyPackage.SET_EQ:
				sequence_SafetyEqStatement(context, (SetEq) semanticObject); 
				return; 
			case SafetyPackage.TRANSIENT_CONSTRAINT:
				sequence_TemporalConstraint(context, (TransientConstraint) semanticObject); 
				return; 
			case SafetyPackage.TRIGGER_STATEMENT:
				sequence_FaultSubcomponent(context, (TriggerStatement) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     FaultSubcomponent returns DurationStatement
	 *
	 * Constraint:
	 *     (tc=TemporalConstraint interv=TimeInterval)
	 */
	protected void sequence_FaultSubcomponent(ISerializationContext context, DurationStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SafetyPackage.Literals.DURATION_STATEMENT__TC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SafetyPackage.Literals.DURATION_STATEMENT__TC));
			if (transientValues.isValueTransient(semanticObject, SafetyPackage.Literals.DURATION_STATEMENT__INTERV) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SafetyPackage.Literals.DURATION_STATEMENT__INTERV));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFaultSubcomponentAccess().getTcTemporalConstraintParserRuleCall_2_3_0(), semanticObject.getTc());
		feeder.accept(grammarAccess.getFaultSubcomponentAccess().getIntervTimeIntervalParserRuleCall_2_4_0(), semanticObject.getInterv());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     FaultSubcomponent returns InputStatement
	 *
	 * Constraint:
	 *     (in_conn=Expr out_conn=ID)
	 */
	protected void sequence_FaultSubcomponent(ISerializationContext context, edu.umn.cs.crisys.safety.safety.InputStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SafetyPackage.Literals.INPUT_STATEMENT__IN_CONN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SafetyPackage.Literals.INPUT_STATEMENT__IN_CONN));
			if (transientValues.isValueTransient(semanticObject, SafetyPackage.Literals.INPUT_STATEMENT__OUT_CONN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SafetyPackage.Literals.INPUT_STATEMENT__OUT_CONN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFaultSubcomponentAccess().getIn_connExprParserRuleCall_0_3_0(), semanticObject.getIn_conn());
		feeder.accept(grammarAccess.getFaultSubcomponentAccess().getOut_connIDTerminalRuleCall_0_5_0(), semanticObject.getOut_conn());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     FaultSubcomponent returns OutputStatement
	 *
	 * Constraint:
	 *     (out_conn=ID nom_conn=ID)
	 */
	protected void sequence_FaultSubcomponent(ISerializationContext context, OutputStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SafetyPackage.Literals.OUTPUT_STATEMENT__OUT_CONN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SafetyPackage.Literals.OUTPUT_STATEMENT__OUT_CONN));
			if (transientValues.isValueTransient(semanticObject, SafetyPackage.Literals.OUTPUT_STATEMENT__NOM_CONN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SafetyPackage.Literals.OUTPUT_STATEMENT__NOM_CONN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFaultSubcomponentAccess().getOut_connIDTerminalRuleCall_1_3_0(), semanticObject.getOut_conn());
		feeder.accept(grammarAccess.getFaultSubcomponentAccess().getNom_connIDTerminalRuleCall_1_5_0(), semanticObject.getNom_conn());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     FaultSubcomponent returns TriggerStatement
	 *
	 * Constraint:
	 *     (cond=TriggerCondition probability=REAL_LIT?)
	 */
	protected void sequence_FaultSubcomponent(ISerializationContext context, TriggerStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SafetyContract returns SafetyContract
	 *
	 * Constraint:
	 *     specs+=SpecStatement*
	 */
	protected void sequence_SafetyContract(ISerializationContext context, SafetyContract semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns EqValue
	 *     FaultSubcomponent returns EqValue
	 *     SafetyEqStatement returns EqValue
	 *
	 * Constraint:
	 *     (lhs+=Arg lhs+=Arg* expr=Expr?)
	 */
	protected void sequence_SafetyEqStatement(ISerializationContext context, EqValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns IntervalEq
	 *     FaultSubcomponent returns IntervalEq
	 *     SafetyEqStatement returns IntervalEq
	 *
	 * Constraint:
	 *     (lhs_int=ID interv=TimeInterval)
	 */
	protected void sequence_SafetyEqStatement(ISerializationContext context, IntervalEq semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SafetyPackage.Literals.INTERVAL_EQ__LHS_INT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SafetyPackage.Literals.INTERVAL_EQ__LHS_INT));
			if (transientValues.isValueTransient(semanticObject, SafetyPackage.Literals.INTERVAL_EQ__INTERV) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SafetyPackage.Literals.INTERVAL_EQ__INTERV));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSafetyEqStatementAccess().getLhs_intIDTerminalRuleCall_1_2_0(), semanticObject.getLhs_int());
		feeder.accept(grammarAccess.getSafetyEqStatementAccess().getIntervTimeIntervalParserRuleCall_1_4_0(), semanticObject.getInterv());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Element returns SetEq
	 *     FaultSubcomponent returns SetEq
	 *     SafetyEqStatement returns SetEq
	 *
	 * Constraint:
	 *     (lhs_set=ID l1=INTEGER_LIT list+=INTEGER_LIT*)
	 */
	protected void sequence_SafetyEqStatement(ISerializationContext context, SetEq semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AnnexLibrary returns SafetyContractLibrary
	 *     SafetyLibrary returns SafetyContractLibrary
	 *
	 * Constraint:
	 *     contract=SafetyContract
	 */
	protected void sequence_SafetyLibrary(ISerializationContext context, SafetyContractLibrary semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SafetyPackage.Literals.SAFETY_CONTRACT_LIBRARY__CONTRACT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SafetyPackage.Literals.SAFETY_CONTRACT_LIBRARY__CONTRACT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSafetyLibraryAccess().getContractSafetyContractParserRuleCall_1_0(), semanticObject.getContract());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AnnexSubclause returns SafetyContractSubclause
	 *     SafetySubclause returns SafetyContractSubclause
	 *
	 * Constraint:
	 *     contract=SafetyContract
	 */
	protected void sequence_SafetySubclause(ISerializationContext context, SafetyContractSubclause semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SafetyPackage.Literals.SAFETY_CONTRACT_SUBCLAUSE__CONTRACT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SafetyPackage.Literals.SAFETY_CONTRACT_SUBCLAUSE__CONTRACT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSafetySubclauseAccess().getContractSafetyContractParserRuleCall_1_0(), semanticObject.getContract());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SpecStatement returns FaultStatement
	 *
	 * Constraint:
	 *     (str=STRING faultDefName=Expr faultDefinitions+=FaultSubcomponent*)
	 */
	protected void sequence_SpecStatement(ISerializationContext context, FaultStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TemporalConstraint returns PermanentConstraint
	 *
	 * Constraint:
	 *     {PermanentConstraint}
	 */
	protected void sequence_TemporalConstraint(ISerializationContext context, PermanentConstraint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TemporalConstraint returns TransientConstraint
	 *
	 * Constraint:
	 *     {TransientConstraint}
	 */
	protected void sequence_TemporalConstraint(ISerializationContext context, TransientConstraint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TriggerCondition returns EnablerCondition
	 *
	 * Constraint:
	 *     exprList+=Expr+
	 */
	protected void sequence_TriggerCondition(ISerializationContext context, EnablerCondition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TriggerCondition returns MustCondition
	 *
	 * Constraint:
	 *     exprList+=Expr+
	 */
	protected void sequence_TriggerCondition(ISerializationContext context, MustCondition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
