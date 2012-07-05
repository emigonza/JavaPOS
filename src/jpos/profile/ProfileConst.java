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

/**
 * Defines constants used for the jpos.profile package
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface ProfileConst
{
	//-------------------------------------------------------------------------
	// Public class constants
	//

	public static final PropType STRING_PROP_TYPE = StringPropType.getInstance();
	public static final PropType INTEGER_PROP_TYPE = IntegerPropType.getInstance();
	public static final PropType FLOAT_PROP_TYPE = FloatPropType.getInstance();
	public static final PropType BOOLEAN_PROP_TYPE = BooleanPropType.getInstance();
	public static final PropType CHARACTER_PROP_TYPE = CharacterPropType.getInstance();

	public static final PropType[] PROPTYPE_ARRAY = { STRING_PROP_TYPE, INTEGER_PROP_TYPE, FLOAT_PROP_TYPE,
													  BOOLEAN_PROP_TYPE, CHARACTER_PROP_TYPE };

}
