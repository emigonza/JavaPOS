package jpos.util.tracing;

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
 * @author E. Michael Maximilien
 * @since 2.1.0
 */
public interface TracerOutput
{
    //-------------------------------------------------------------------------
    // Public methods
    //
    
    /** 
     * @return any suffix that is to be used with this TracerOutput
     * <p>An existing suffix gets appended to every message</p>
     */
    public String getPrefix();
    
    /**
     * Closes the TracerOutput.  If it is a file then closes the file
     * Any errors are not propagated up and rather printed to the System.errr
     */
    void close();

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
    
    /**
     * Prints a StackTrace from an Exception object.
     * @param e the Exception to extract StackTrace from
     */
    public void print( Exception e );
    
    /** Flushes the output */
    public void flush();
}