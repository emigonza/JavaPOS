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

import jpos.util.*;
import java.io.PrintStream;

/**
 * Tracing class to help in the debugging of other package code
 * <ol>
 * <li>
 * <b>Note 1:</b> this class is a Singleton (see GoF Design Pattern book)
 * ccess the sole instance by doing: Tracer.getInstance() call
 * </li>
 * <li>
 * <b>Note 2:</b> Will allow (in the future) the option of defining different
 * ouput for the tracer (1.3 version)
 * </li>
 * <li>
 * By default Tracer objects are turned OFF but can dynamically or via
 * properties file be turned OFF
 * </li>
 * </ol>
 * @see com.ibm.jutil.Tracer#getInstance
 * @author E. Michael Maximilien
 * @since 2.1.0
 */
public class Tracer extends Object
{
    //-------------------------------------------------------------------------
    // Ctor
    //

    /** Make ctor private to avoid construction (this is a Singleton class) */
    protected Tracer() { appendName = false; }

    /** 
     * Creates a Tracer instance with name specified
     * @param name the Tracer name
     */
    Tracer( String name ) 
    {
    	if( name == null || name.equals( "" ) ) 
    	{
    		appendName = false;
    		tracerName = "";
    		onTracerOutput = new DefaultTracerOutput();
    	}
	    else
		{
			appendName = true;
    		onTracerOutput = new DefaultTracerOutput( "[" + name + "]" );
    	 	tracerName = name; 
 		}
    }

    //-------------------------------------------------------------------------
    // Public class methods
    //

    /** @return the sole instance of this class (creating it if necessary) */
    public static Tracer getInstance()
    {
        if( instance == null )
        {
            instance = new Tracer();
            instance.init();
        }

        return instance;
    }
    
    //-------------------------------------------------------------------------
    // Public methods
    //

    /**
     * Prints a string appended with a new line to the tracer output
     * @param s the String to print
     */
    public void println( String s ) { getTracerOutput().println( s ); }

    /**
     * Prints the String representation of the Object passed
     * @param obj the Object to println
     */
    public void println( Object obj ) { getTracerOutput().println( obj.toString() ); }

    /**
     * Prints a string appended without a new line to the tracer output
     * @param s the String to print
     */
    public void print( String s ) { getTracerOutput().print( s ); }

    /**
     * Prints a String representation of the Object passed
     * @param obj the Object to print
     */
    public void print( Object obj ) { getTracerOutput().print( obj.toString() ); }

    /**
     * Prints a StackTrace from an Exception object.
     * @param e the Exception to extract StackTrace from
     */
    public void print( Exception e ) { getTracerOutput().print( e ); }
    
    /** Flushes the Tracer */
    public void flush() { getTracerOutput().flush(); }

    /**
     * Sets this tracer ON or OFF
     * @param b the boolean parameter
     */
    public void setOn( boolean b ) { tracerOn = b; }

    /** @return true if the tracer is ON (i.e. enabled) */
    public boolean isOn() { return tracerOn; }

	/** @return this Tracer's name */
	public String getName() { return tracerName; }

	/** 
	 * Tells Tracer instance whether it should append name for each trace
	 * message or not
	 * @param b the boolean parameter
	 */
	public void setAppendName( boolean b ) { appendName = b; }
    
    /** @return whether the Tracer should append its name to each println method call */
    public boolean isAppendName() { return appendName; }

    //-------------------------------------------------------------------------
    // Protected methods
    //
         
    //-------------------------------------------------------------------------
    // Private methods
    //

    /** Intialize the current instance using the DefaultProperties class */
    private void init()
    {
        JposProperties props = new DefaultProperties();
        props.loadJposProperties();

        if( !props.isPropertyDefined( JposProperties.TRACING_PROP_NAME ) )
            setOn( false );
        else
        {
            String tracingPropValue = props.getPropertyString( JposProperties.TRACING_PROP_NAME );

            if( tracingPropValue.equalsIgnoreCase( JposProperties.TRACING_ON_PROP_VALUE ) ||
                tracingPropValue.equalsIgnoreCase( JposProperties.TRACING_TRUE_PROP_VALUE ) )
                setOn( true );
        }
    }

    /** @return the tracerOutput object for the Tracer */
    private TracerOutput getTracerOutput() 
    { 
    	if( customTracerOutput != null ) return customTracerOutput;
    	
        return ( isOn() ? onTracerOutput : offTracerOutput );
    }

    //-------------------------------------------------------------------------
    // Package methods
    //
    
    /**
     * Sets the TracerOutput object -- for debugging purposes
     * @param tracerOutput the TracerOutput object
     */
    void setTracerOutput( TracerOutput tracerOutput )
    {
    	tracerOn = true;
    	customTracerOutput = tracerOutput;
    }

    //-------------------------------------------------------------------------
    // Private instance variables
    //

    private boolean tracerOn = false;
	
	private String tracerName = "";
	private boolean appendName = true;

	private TracerOutput customTracerOutput = null;
    private TracerOutput onTracerOutput = new DefaultTracerOutput();

    private TracerOutput offTracerOutput =  new TracerOutput()
                                            {
                                            	public void close() {}
                                            	public String getPrefix() { return ""; }
                                                public void print( Exception e ) {}
                                                public void println( String s ) {}
                                                public void print( String s ) {}
                                                public void flush() {}
                                            };

    //-------------------------------------------------------------------------
    // Private class variables
    //

    private static Tracer instance = null;
    
    //-------------------------------------------------------------------------
    // Private static inner classes
    //

    /**
     * Inner class for a default TracerOutput.  Just prints out info to System.err
     * @author E. Michael Maximilien
     */
    class DefaultTracerOutput extends Object implements TracerOutput
    {
        //---------------------------------------------------------------------
        // Ctor(s)
        //    	
    	
        /** 
         * Default ctor.  No prefix is used and the PrintStream is set
         * to the System.err PrintStream
         */
        public DefaultTracerOutput() 
        {
        	prefix = "";
        	appendName = false;
        }

        /** 
         * Default ctor 
         * @param s the String prefix to use for this TracerOutput
         */
        public DefaultTracerOutput( String s ) 
        {
        	if( s == null ) prefix = "";
        	else
        		if( s.equals( "" ) ) prefix = ""; 
        		else     	
        		{
		        	prefix = s;
		        	appendName = true;
        		}
        }
        
        /** 
         * Default ctor 
         * @param s the String prefix to use for this TracerOutput
         * @param pStream the PrintStream object used for this TracerOutput
         */
        public DefaultTracerOutput( String s, PrintStream pStream ) 
        {
			this( s );
			printStream = pStream;
        }

        //---------------------------------------------------------------------
        // Public methods
        //
       
	    /** 
	     * @return any prefix that is to be used with this TracerOutput
	     * <p>An existing prefix gets appended to every message</p>
	     */
	    public String getPrefix() { return prefix; }
	    
	    /**
	     * Closes the TracerOutput.  If it is a file then closes the file
	     * Any errors are not propagated up and rather printed to the System.errr
	     */
	    public void close() { getPrintStream().close(); }
        
        /**
         * Prints a string appended with a new line to the tracer output
         * @param s the String to print
         */
        public void println( String s ) 
        { 		
        	getPrintStream().println( ( appendName ? prefix : "" ) + s ); 
        }

        /**
         * Prints a string appended without a new line to the tracer output
         * @param s the String to print
         */
        public void print( String s ) 
        { 
        	getPrintStream().print( ( appendName ? prefix : "" ) + s ); 
        }

        /**
         * Prints a StackTrace from an Exception object.
         * @param e the Exception to extract StackTrace from
         */
        public void print( Exception e ) 
        { 
        	if( appendName ) System.err.println( "<" + prefix + ">" );
        	
        	e.printStackTrace( getPrintStream() ); 

        	if( appendName ) System.err.println( "</" + prefix + ">" );
        }
        
        /**
         * Flushes this TracerOutput
         * <i>
         * For this TracerOutput does not do anything since output flushes
         * automatically
         * </i>
         */
        public void flush() { getPrintStream().flush(); }

	    //-------------------------------------------------------------------------
	    // Protected methods
	    //
	    
	    /** @return the PrintStream object that is used for this TracerOutput */
	    protected PrintStream getPrintStream() { return printStream; }
	    
	    /**
	     * Sets the PrintStream for this TracerOutput
	     * @param pStream a PrintStream object
	     */
	    protected void setPrintStream( PrintStream pStream ) { printStream = pStream; }
                    
	    //-------------------------------------------------------------------------
	    // Instance variables
	    //

	    protected String prefix = "";
	    protected PrintStream printStream = System.err;
    }
}