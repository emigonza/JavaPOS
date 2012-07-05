package jpos.loader;

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

import jpos.JposConst;
import jpos.JposException;

import jpos.util.*;
import jpos.util.tracing.Tracer;
import jpos.util.tracing.TracerFactory;

import java.lang.reflect.*;

/**
 * The JavaPOS JposServiceLoader class.  It creates an instance of the 
 * installed JposServiceFactory or default to the SimpleServiceFactory
 * and is used by the controls to create JposServiceConnection object
 * that are used to bind the controls to the actual loaded services.
 * Modification history
 * @since 0.1 (Philly 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public final class JposServiceLoader extends Object
{
    //--------------------------------------------------------------------------
    // Class variables
    //

	private static Tracer tracer = TracerFactory.getInstance().
									 createTracer( "JposServiceLoader" );

    private static JposServiceManager manager = null;

    /**
     * Static initializer.
     * Creates the manager by getting the property 
     * JPOS_SERVICE_MANAGER_CLASS_PROP_NAME.  If this property is not defined 
     * then defaults to the SimpleServiceManager 
     * NOTE: since the JposServiceManager interface was moved to the 
     * jpos.loader package then we define 2 property to specify the custom
     * serviceManager one with the previous jpos.config prefix and the other 
     * with the correct jpos.loader prefix
     * @see jpos.util.JposProperties#JPOS_SERVICE_MANAGER_CLASS_PROP_NAME
     * @see jpos.util.JposProperties#JPOS_SERVICE_MANAGER_CLASS_PROP_NAME2
     * @since 0.1 (Philly 99 meeting)
     * @see jpos.loader.simple.SimpleServiceManager
     */
    static
    {
        JposProperties jposProperties = new DefaultProperties();
        jposProperties.loadJposProperties();

        boolean customManagerDefined = false;
        String customManagerClassName = "";

        if( jposProperties.isPropertyDefined( JposProperties.
        	JPOS_SERVICE_MANAGER_CLASS_PROP_NAME ) )
        {
            customManagerDefined = true;
            customManagerClassName = jposProperties.
            getPropertyString( JposProperties.
                               JPOS_SERVICE_MANAGER_CLASS_PROP_NAME );
        }
        else
        if( jposProperties.isPropertyDefined( JposProperties.
        	JPOS_SERVICE_MANAGER_CLASS_PROP_NAME2 ) )
        {
            customManagerDefined = true;
            customManagerClassName = 
            jposProperties.
            getPropertyString( JposProperties.
            				   JPOS_SERVICE_MANAGER_CLASS_PROP_NAME2 );
        }

        if( customManagerDefined )
        {
			tracer.println( "Custom manager is defined: className= " +
							customManagerClassName );        	
        	
            try
            {
                Class managerClass = Class.forName( customManagerClassName );

                Class arg1Class = Class.forName( "jpos.util.JposProperties" );
                Class[] argsClass = { arg1Class };

                Constructor oneArgCtor = managerClass.
                                         getConstructor( argsClass );

                Object[] args = { jposProperties };

                manager = (JposServiceManager)oneArgCtor.newInstance( args );
            }
            catch( Exception e ) 
            {
                tracer.println( "Error creating instance of specified " +
                                "jpos.config.serviceManagerClass class: " + 
                                customManagerClassName );
                                
				tracer.println( "Using default manager class: " +
								"jpos.loader.simple.SimpleServiceManager" );                                

                manager = new jpos.loader.simple.
                              SimpleServiceManager( jposProperties ); 
            }
        }
        else
            manager = new jpos.loader.simple.
                          SimpleServiceManager( jposProperties );

        manager.getEntryRegistry().load();
        
		tracer.println( "manager.getEntryRegistry().load() OK" );
    }

    /**
     * @return a service connection for the logicalName specified
     * @param logicalName the logical name of the service to find 
     * @throws jpos.JposException if any error occurs     
     * @since 0.1 (Philly 99 meeting)
     */
    public static JposServiceConnection findService( String logicalName ) 
    throws JposException
    {
        if( manager == null )
        {
        	String msg = "Did not find a valid " + 
        	             JposProperties.JPOS_SERVICE_MANAGER_CLASS_PROP_NAME + 
        	             " to create";

			tracer.println( msg );
        	        
            throw new JposException( JposConst.JPOS_E_NOSERVICE, msg );
        }

		tracer.println( "findService: " + logicalName );

        return manager.createConnection( logicalName );
    }

    /**
     * @return the JposServiceManager associated with the 
     * running of the JposServiceLoader      
     * @since 0.1 (Philly 99 meeting)
     */
    public static JposServiceManager getManager() { return manager; }
}