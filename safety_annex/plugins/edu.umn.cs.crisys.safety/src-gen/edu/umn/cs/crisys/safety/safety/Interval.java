/**
 */
package edu.umn.cs.crisys.safety.safety;

import com.rockwellcollins.atc.agree.agree.Expr;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.umn.cs.crisys.safety.safety.Interval#getLow <em>Low</em>}</li>
 *   <li>{@link edu.umn.cs.crisys.safety.safety.Interval#getHigh <em>High</em>}</li>
 * </ul>
 *
 * @see edu.umn.cs.crisys.safety.safety.SafetyPackage#getInterval()
 * @model
 * @generated
 */
public interface Interval extends EObject
{
  /**
   * Returns the value of the '<em><b>Low</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Low</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Low</em>' containment reference.
   * @see #setLow(Expr)
   * @see edu.umn.cs.crisys.safety.safety.SafetyPackage#getInterval_Low()
   * @model containment="true"
   * @generated
   */
  Expr getLow();

  /**
   * Sets the value of the '{@link edu.umn.cs.crisys.safety.safety.Interval#getLow <em>Low</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Low</em>' containment reference.
   * @see #getLow()
   * @generated
   */
  void setLow(Expr value);

  /**
   * Returns the value of the '<em><b>High</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>High</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>High</em>' containment reference.
   * @see #setHigh(Expr)
   * @see edu.umn.cs.crisys.safety.safety.SafetyPackage#getInterval_High()
   * @model containment="true"
   * @generated
   */
  Expr getHigh();

  /**
   * Sets the value of the '{@link edu.umn.cs.crisys.safety.safety.Interval#getHigh <em>High</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>High</em>' containment reference.
   * @see #getHigh()
   * @generated
   */
  void setHigh(Expr value);

} // Interval
