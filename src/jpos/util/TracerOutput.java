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

/**
 * Defines an interface for outputing tracing info
 * @since 1.2 (NY 2K 99 meeting)
 * @author EMM
 */
public interface TracerOutput
{
    //-------------------------------------------------------------------------
    // Public methods
    //

    /**
     * Prints a string appended with a new line to the tracer output
     * @param s the String to print
     */
    public void println( String s );

    /**
     * Prints a string appended without a new line to the tracer output
     * @param s the String to print
     */
    public void print( String s );
}
