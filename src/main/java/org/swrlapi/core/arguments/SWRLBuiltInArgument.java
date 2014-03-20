package org.swrlapi.core.arguments;

import org.semanticweb.owlapi.model.SWRLDArgument;

/**
 * Interface representing an argument to a SWRL built-in. It extends the SWRLAtomArgument} interface, which is the
 * SWRLAPI's primary OWLAPI extension point. The SWRLBuiltInArgument} interface represents SWRL built-in atoms in the
 * SWRLAPI, which has a wider range of built-in argument types than the OWLAPI. The OWLAPI envisions built-in arguments
 * as simple literals or variables only. In addition to literals and variables, the SWRLAPI allows classes, properties,
 * datatypes, individuals, as well as SQWRL-specific arguments.
 * 
 * @see SWRLLiteralBuiltInArgument, SWRLVariableBuiltInArgument, SWRLClassBuiltInArgument,
 *      SWRLIndividualBuiltInArgument, SWRLObjectPropertyBuiltInArgument, SWRLDataPropertyBuiltInArgument,
 *      SWRLDataPropertyBuiltInArgument, SWRLAnnotationPropertyBuiltInArgument, SWRLDatatypeBuiltInArgument,
 *      SQWRLCollectionBuiltInArgument, SWRLMultiArgument
 */
public interface SWRLBuiltInArgument extends SWRLAtomArgument, SWRLDArgument
{ // TODO These methods should really be in SWRLVariableBuiltInArgument
	void setBuiltInResult(SWRLBuiltInArgument builtInResult);

	SWRLBuiltInArgument getBuiltInResult();

	boolean hasBuiltInResult();

	String getVariableName();

	void setVariableName(String variableName);

	boolean isVariable();

	boolean isUnbound();

	boolean isBound();

	void setUnbound();

	void setBound();
}
