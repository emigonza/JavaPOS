package jpos.config;

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

import jpos.JposException;

/**
 * Defines an Exception class for JCL config related classes/interfaces and 
 * implementing classes
 * @since 2.0.0
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class JposConfigException extends JposException
{
	//-------------------------------------------------------------------------
	// Ctor(s)
	// 
	
	/**
	 * Creates a JposConfigException with the description passed
	 * @param description the description String
	 */
    public JposConfigException( String description )
    {
        super( 0, description );
    }

	/**
	 * Creates a JposConfigException with the description passed and 
	 * the original exception that caused this one
	 * @param description the description String
	 * @param origException the exception that originally caused this one
	 */
    public JposConfigException( String description, Exception origException )
    {
        super( 0, description, origException );
    }
}
