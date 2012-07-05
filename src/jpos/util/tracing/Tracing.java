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
 * Tracing class to help in the debugging of other package code
 * This class uses the Tracer class for all its static methods implementations
 * its a convinient class to avoid having to cache the Tracer object or having
 * to do Tracer.getInstance() everytime you need to access the Tracer.
 * @see jpos.util.Tracer#getInstance
 * @author E. Michael Maximilien
 */
public class Tracing extends Object
{
    //-------------------------------------------------------------------------
    // Ctor
    //

    /** Make ctor private to avoid construction */
    private Tracing() {}

    //-------------------------------------------------------------------------
    // Public class methods
    //

    /**
     * Class method that facilitate usage of Tracer.println() method
     * @param obj the Object to print -- obj.toString()
     */
    public static void println( Object obj ) { tracer.println( obj.toString() ); }

    /**
     * Class print method that facilitate usage Tracer.print() method
     * @param obj the Object to print -- obj.toString()
     */
    public static void print( Object obj ) { tracer.print( obj.toString() ); }

    /**
     * Prints a StackTrace from an Exception object.
     * @param e the Exception to extract StackTrace from
     */
    public static void print( Exception e ) { tracer.print( e ); }
    
    /** Flushes the TracerOutput */
    public static void flush() { tracer.flush(); }

    /**
     * Sets this tracer ON or OFF
     * @param b the boolean parameter
     */
    public static void setOn( boolean b ) { tracer.setOn( b ); }

    /** @return true if the tracer is ON (i.e. enabled) */
    public static boolean isOn() { return tracer.isOn(); }
    
    //---------------------------------------------------------------------------
    // Class variables
    //
    
    private static Tracer tracer = TracerFactory.getInstance().createGlobalTracer();
}
