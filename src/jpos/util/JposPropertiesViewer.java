package jpos.util;

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

import jpos.loader.*;

/**
 * Simple application to printout the current values from the JposProperties 
 * implementing class
 * @since 1.2 (NY 2K 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class JposPropertiesViewer extends Object
{
    //-------------------------------------------------------------------------
    // Public class methods
    //

    /**
     * Simple main entry point that prints out all current properties (name and value) defined
     * @param args the array for String argument
     */
    public static void main( String[] args )
    {
        System.out.println( "<!-- JavaPOS jpos.config/loader (JCL) defined Java properties: -->" );
        System.out.println( "<!-- name = \"propName\" value = \"propValue\" -->" );

        System.out.println( JposServiceLoader.getManager().getProperties() );
    }
}
