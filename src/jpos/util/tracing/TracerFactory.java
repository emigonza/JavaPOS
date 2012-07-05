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

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import jpos.util.*;

/**
 * This is a singleton factory used to create Tracer objects and access the
 * global tracer.  This implementation has the following semantics:
 * <ol>
 * <li>Its a Singleton class but can be subclassed if necessary</li>
 * <li>It caches the default no-named Tracer.  This is the global Tracer</li>
 * <li>
 * It caches the Tracer objects according to name and any access for the 
 * same named Tracer will return the same Tracer object
 * </li>
 * </ol>
 * @see com.ibm.jutil.tracing.Tracer#getInstance
 * @author E. Michael Maximilien
 * @since 2.1.0
 */
public class TracerFactory extends Object
{
    //-------------------------------------------------------------------------
    // Ctor
    //

    /** Make ctor protected to avoid construction (this is a Singleton class) */
    protected TracerFactory() {}

    //-------------------------------------------------------------------------
    // Public class methods
    //

    /** @return the sole instance of this class (creating it if necessary) */
    public static TracerFactory getInstance()
    {
        if( instance == null )
        {
            instance = new TracerFactory();
            instance.init();
        }

        return instance;
    }
    
    //-------------------------------------------------------------------------
    // Public methods
    //
    
    /** 
     * Sets the File that all subsequently created Tracer objects will print to
     * if these Tracer objects are turned on.  Successfully calling this method
     * overrides the current setting for TracerOutput to files
     * @throws java.io.IOException if a PrintStream could not be created from File
     */
    public void setOutputFile( File file ) throws IOException
    {
    	//<todo/>
    }
    
    /** 
     * @return the global no named Tracer object -- creates it if necessary
     * Its state is determined by the jutil.properties value
     */
    public Tracer createGlobalTracer() { return globalTracer; }

    /** 
     * @return the global no named Tracer object -- creates it if necessary
     * Its state is determined by the jutil.properties value
     * @param b the boolean parameter for the initial state of the tracer
     */
    public Tracer createGlobalTracer( boolean b ) 
    { 
    	globalTracer.setOn( b );
    	return globalTracer;
    }

    /** 
     * @return creates (if necessary) and return the Tracer with named specified
     * Its state is determined by the jutil.properties value
     * @param name the Tracer name
     */
    public Tracer createTracer( String name ) 
    { 
    	if( tracerMap.containsKey( name ) )
    		return (Tracer)tracerMap.get( name );
    		
    	Tracer tracer = new Tracer( name );
    	
    	if( namedTracerState.containsKey( name ) )
    		tracer.setOn( ( (Boolean)namedTracerState.get( name ) ).booleanValue() );
    	else
    		tracer.setOn( false );
    		
		if( turnOnAllNamedTracers ) tracer.setOn( true );
    	
    	tracerMap.put( name, tracer );
    	
    	return tracer;
    }

    /** 
     * @return creates (if necessary) and return the Tracer with named specified
     * Its state is determined by the jutil.properties value
     * @param name the Tracer name
     * @param b the boolean parameter for the initial state of the tracer
     */
    public Tracer createTracer( String name, boolean b ) 
    { 
    	Tracer tracer = createTracer( name );
    	tracer.setOn( b );
    	
    	return tracer;
    }

    //-------------------------------------------------------------------------
    // Protected methods
    //
    
    /** 
     * Finalizes this Tracer by closing the TracerOutput.  This is useful
     * if the TracerOutput is printing to a file.  This method would then
     * close that file
     * @throws java.lang.Thowable any exception occuring while finalizing
     */
    protected void finalize()
    {
    	if( printStream != null ) printStream.close();
    }
     
    //-------------------------------------------------------------------------
    // Private methods
    //
    
    /**
     * @return true if the propertyValue passed is valid and is equals (ignoring
     * case) to TRUE or YES
     * @param propValue the property value to check
     */
    private boolean isPropertyTrue( String propValue )
    {
    	if( propValue == null ) return false;
    	
        if( propValue.
            equalsIgnoreCase( JposProperties.TRACING_ON_PROP_VALUE ) ||
            propValue.
            equalsIgnoreCase( JposProperties.TRACING_TRUE_PROP_VALUE ) )
			return true;
			
		return false;
    }

    /** Intialize the current instance using the DefaultProperties class */
    private void init()
    {
        JposProperties props = new DefaultProperties();
        props.loadJposProperties();
        
		initGlobalTracer( props );
		initTurnedOnTracers( props );
		initNamedTracers( props );
		initTracerOutput();
    }

	/**
	 * Initializes the state of the globalTracer -not named
	 * @param props the JposProperties instance
	 */
	private void initGlobalTracer( JposProperties props )
	{
        if( !props.isPropertyDefined( TRACING_PROP_NAME ) )
            globalTracer.setOn( false );
        else
        {
            String tracingPropValue = 
                   props.getPropertyString( TRACING_PROP_NAME );

            if( isPropertyTrue( tracingPropValue ) )
                globalTracer.setOn( true );
        }
	}

	/**
	 * Sets to on all named tracers listed in the value of the... 
	 * TurnOnNamedTracers property
	 * @param props the JposProperties instance
	 */
	private void initTurnedOnTracers( JposProperties props )
	{
		if( props.isPropertyDefined( TURN_ON_ALL_NAMED_TRACERS_PROP_NAME ) )
		{
			String turnOnAllNamedTracersValue = props.
			getPropertyString( TURN_ON_ALL_NAMED_TRACERS_PROP_NAME );
			
			if( isPropertyTrue( turnOnAllNamedTracersValue ) )
				turnOnAllNamedTracers = true;
			else
				turnOnAllNamedTracers = false;
		}
		else		
		if( props.isPropertyDefined( TURN_ON_NAMED_TRACERS_PROP_NAME ) )
		{			
			List turnOnNamedTracersList = 
			     props.getStringListProperty( TURN_ON_NAMED_TRACERS_PROP_NAME );
			
			for( int i = 0; i < turnOnNamedTracersList.size(); ++i )
			{
				String tracerName = turnOnNamedTracersList.get( i ).toString();
                namedTracerState.put( tracerName, Boolean.TRUE );
			}			
		}
	}

	/**
	 * Initializes the state of all named Tracer objects
	 * @param props the JposProperties instance
	 */
	private void initNamedTracers( JposProperties props )
	{
		Enumeration propNames = props.getPropertyNames();
		
		while( propNames.hasMoreElements() )
		{
			String propName = (String)propNames.nextElement();
						
			if( propName.startsWith( TRACER_PROP_NAME ) )
			{
				String name = propName.
				              substring( ( TRACER_PROP_NAME + "." ).length(),
				                         propName.length() );
				
				if( props.isPropertyDefined( propName ) )
				{
					String propValue = (String)props.
					                   getPropertyString( propName );
					
		            if( propValue.equalsIgnoreCase( JposProperties.
		                                            TRACING_ON_PROP_VALUE ) ||
                		propValue.equalsIgnoreCase( JposProperties.
                		                            TRACING_TRUE_PROP_VALUE ) )
		                namedTracerState.put( name, Boolean.TRUE );
		            else
		            	namedTracerState.put( name, Boolean.FALSE );
				}
			}
		}
	}

	/**
	 * Initializes whether TracerOutput will be to a file or System.err and
	 * if to a file its location and name.  By default TracerOutput is to
	 * System.err for all tracers that are turned on
	 */
	private void initTracerOutput()
	{
		//<todo/>
	}
    
    //-------------------------------------------------------------------------
    // Private instance variables
    //
    
    private HashMap tracerMap = new HashMap();
    private HashMap namedTracerState = new HashMap();

	private Tracer globalTracer = Tracer.getInstance();

	private PrintStream printStream = null;
	
	private boolean turnOnAllNamedTracers = false;

    //-------------------------------------------------------------------------
    // Private class variables
    //

    private static TracerFactory instance = null;

    //-------------------------------------------------------------------------
    // Class constants
    //
    
    public static final String TRACING_PROP_NAME = "jpos.tracing";
    
    public static final String TRACER_PROP_NAME = 
                                 "jpos.util.tracing.Tracer";
                               
    public static final String TURN_ON_NAMED_TRACERS_PROP_NAME = 
                                 "jpos.util.tracing.TurnOnNamedTracers";

    public static final String TURN_ON_ALL_NAMED_TRACERS_PROP_NAME = 
                                 "jpos.util.tracing.TurnOnAllNamedTracers";
                               
    public static final String TRACER_OUTPUT_TO_FILE_PROP_NAME =
    						     "jpos.util.tracing.TracerOutputToFile";

	public static final String TRACER_OUTPUT_FILE_NAME_PROP_NAME =
							     "jpos.util.tracing.TracerOutputFileName";
	
	public static final String TRACER_OUTPUT_FILE_LOCATION =
							     "jpos.util.tracing.TracerOutputFileLocation";
							   
	public static final String USER_HOME_LOCATION_VALUE = "<user.home>";					
}