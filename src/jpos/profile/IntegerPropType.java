package jpos.profile;

///////////////////////////////////////////////////////////////////////////////
//
// This software is provided "AS IS".  The JavaPOS working group (including
// each of the Corporate members, contributors and individuals)  MAKES NO
// REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
// EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED 
// WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
// NON-INFRINGEMENT. The JavaPOS working group shall not be liable for
// any damages suffered as a result of using, modifying or distributing this
// software or its derivatives. Permission to use, copy, modify, and distribute
// the software and its documentation for any purpose is hereby granted. 
//
// The JavaPOS Config/Loader (aka JCL) is now under the CPL license, which 
// is an OSS Apache-like license.  The complete license is located at:
//    http://oss.software.ibm.com/developerworks/opensource/license-cpl.html
//
///////////////////////////////////////////////////////////////////////////////

import java.io.Serializable;

/**
 * Defines a Integer property type
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class IntegerPropType extends AbstractPropType implements PropType, Serializable
{
	//-------------------------------------------------------------------------
	// Ctor(s)
	//

	/** Default ctor */
	IntegerPropType() {}

	//---------------------------------------------------------------------
	// Class methods
	//

	/** @return the unique instance of this class (create if necessary) */
	public static PropType getInstance()
	{
		if( instance == null )
			instance = new IntegerPropType();

		return instance;
	}

	//-------------------------------------------------------------------------
	// Public methods
	//

	/** @return a String representation of this PropType */
	public String toString() { return "IntegerPropType"; }

	/** @return a Java class that defines this type */
	public Class getJavaTypeClass() { return ( new Integer( 0 ) ).getClass(); }

	/**
	 * @return true if the object passed is of this PropType
	 * @param i the int primitive type
	 */
	public boolean isValidValue( int i ) { return true; }

	/**
	 * @return true if the object passed is of this PropType
	 * @param obj the Java Object
	 */
	public boolean isValidValue( Object obj ) { return ( obj instanceof Integer ); }

	/**
	 * @return true if the PropValue passed is of this PropType
	 * @param propValue the PropValue
	 */
	public boolean isValidValue( PropValue propValue ) { return isValidValue( propValue.getValue() ); }

	//-------------------------------------------------------------------------
	// Class instance
	//

	private static PropType instance = null;
}
