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
 * Tracing class to help in the debugging of the JCL and JavaPOS controls:
 * This class is a Singleton (see GoF Design Pattern book)
 * <b>This class is superceded by the classes in the jpos.util.tracing package
 * access the sole instance by doing: Tracer.getInstance() call
 * @see jpos.util.tracing.Tracer
 * @see jpos.util.tracing.TracerFactory
 * @deprecated see the classes in the jpos.util.tracing package
 * @since 1.2 (NY 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class Tracer extends Object
{
    //--------------------------------------------------------------------------
    // Ctor
    //

    /**
     * Make ctor private to avoid construction (this is a Singleton class)
     * @since 1.2 (NY 2K meeting)
     */
    private Tracer() {}

    //--------------------------------------------------------------------------
    // Public class methods
    //

    /**
     * @return the sole instance of this class (creating it if necessary)
     * @since 1.2 (NY 2K meeting)
     */
    public static Tracer getInstance()
    {
        if( instance == null )
        {
            instance = new Tracer();

            instance.init();
        }

        return instance;
    }

    //--------------------------------------------------------------------------
    // Public methods
    //

    /**
     * Prints a string appended with a new line to the tracer output
     * @param s the String to print
     */
    public void println( String s ) { getTracerOutput().println( s ); }

    /**
     * Prints a string appended without a new line to the tracer output
     * @param s the String to print
     */
    public void print( String s ) { getTracerOutput().print( s ); }

    /**
     * Sets this tracer ON or OFF
     * @param b the boolean parameter
     * @since 1.2 (NY 2K meeting)
     */
    public void setOn( boolean b ) { tracerOn = b; }

    /**
     * @return true if the tracer is ON (i.e. enabled)
     * @since 1.2 (NY 2K meeting)
     */
    public boolean isOn() { return tracerOn; }
     
    //--------------------------------------------------------------------------
    // Private methods
    //

    /**
     * Intialize the current JCL instance using the DefaultProperties class
     * @since 1.2 (NY 2K meeting)
     */
    private void init()
    {
        JposProperties props = new DefaultProperties();
        props.loadJposProperties();

        if( !props.isPropertyDefined( JposProperties.JPOS_TRACING_PROP_NAME ) )
            setOn( false );
        else
        {
            String tracingPropValue = 
                   props.getPropertyString( JposProperties.
                                            JPOS_TRACING_PROP_NAME );

            if( tracingPropValue.
                equalsIgnoreCase( JposProperties.
                                  JPOS_TRACING_ON_PROP_VALUE ) ||
                tracingPropValue.
                equalsIgnoreCase( JposProperties.
                				  JPOS_TRACING_TRUE_PROP_VALUE ) )
                setOn( true );
        }
    }

    /**
     * @return the tracerOutput object for the Tracer
     * @since 1.2 (NY 2K meeting)
     */
    private TracerOutput getTracerOutput() 
    { 
        return ( isOn() ? onTracerOutput : offTracerOutput );
    }

    //--------------------------------------------------------------------------
    // Private instance variables
    //

    private boolean tracerOn = false;

    private TracerOutput onTracerOutput = new DefaultTracerOutput();
    private TracerOutput offTracerOutput =  
    					  	new TracerOutput()
                          	{
                          		public void println( String s ) {}
                                public void print( String s ) {}
                            };

    //--------------------------------------------------------------------------
    // Private class variables
    //

    private static Tracer instance = null;

    //--------------------------------------------------------------------------
    // Private static inner classes
    //

    /**
     * Inner class for a default TracerOutput.  Just prints out info to 
     * System.err
     * @since 1.2 (NY 2K meeting)
     * @author E. Michael Maximilien (maxim@us.ibm.com)
     */
    static class DefaultTracerOutput extends Object implements TracerOutput
    {
        /**
         * Default ctor
         * @since 1.2 (NY 2K meeting)
         */
        public DefaultTracerOutput() {}

        //----------------------------------------------------------------------
        // Public methods
        //
        
        /**
         * Prints a string appended with a new line to the tracer output
         * @param s the String to print
         */
        public void println( String s ) { System.err.println( s ); }

        /**
         * Prints a string appended without a new line to the tracer output
         * @param s the String to print
         */
        public void print( String s ) { System.err.print( s ); }
    }
}