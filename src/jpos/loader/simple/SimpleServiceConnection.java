package jpos.loader.simple;

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

import java.util.*;
import java.lang.reflect.*;

import jpos.JposConst;
import jpos.JposException;
import jpos.loader.*;
import jpos.config.*;
import jpos.util.tracing.Tracer;
import jpos.util.tracing.TracerFactory;

/**
 * This is a simple implementation of the JposServiceConnection interface
 * @since 0.1 (Philly 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class SimpleServiceConnection extends Object 
									  implements JposServiceConnection
{
    /**
     * Creates a new SimpleServiceConnection by passing the logicalName, 
     * the associated JposEntry and JposServiceInstanceFactory
     * @param logicalName the logicalName for this connection
     * @param entry the JposEntry matching this logicalName
     * @param siFactoryClassName the class name implememting the 
     * JposServiceInstanceFactory interface    
     * @since 0.1 (Philly 99 meeting)
     */
    SimpleServiceConnection( String logicalName, JposEntry entry, 
                             String siFactoryClassName )
    {
        this.logicalName = logicalName;
        this.entry = entry;
        this.siFactoryClassName = siFactoryClassName;
    }

    /**
     * @return the JposServiceInstance for this connection (it's null 
     * util a succesful connection)
     * @since 0.1 (Philly 99 meeting)
     */
    public JposServiceInstance getService() { return service; }

    /** 
     * @return the logicalName of the JposServiceInstance of this connection
     * @since 0.1 (Philly 99 meeting)
     */
    public String getLogicalName() { return logicalName; }

    /**
     * Connects this service by trying to create the JposServiceInstance
     * @since 0.1 (Philly 99 meeting)
     * @throws jpos.JposException if the service throws a exception while
     * disconnecting
     */
    public void connect() throws JposException
    {
        try 
        {
            Class[] parameterTypes = new Class[ 2 ];
            parameterTypes[ 0 ] = Class.forName( "java.lang.String" );
            parameterTypes[ 1 ] = Class.forName( "jpos.config.JposEntry");             

            JposServiceInstanceFactory siFactory = null;

            if( siFactoryTable.containsKey( siFactoryClassName ) )
                siFactory = (JposServiceInstanceFactory)siFactoryTable.
                            get( siFactoryClassName );
            else
            {
                Class instanceClass = Class.forName( siFactoryClassName );
                Constructor defaultCtor = instanceClass.
                						  getConstructor( new Class[ 0 ] );
                siFactory = (JposServiceInstanceFactory)defaultCtor.
                			newInstance( new Object[ 0 ] );
                siFactoryTable.put( siFactoryClassName, siFactory );
            }

            service = (JposServiceInstance)siFactory.
            		  createInstance( logicalName, entry );
        } 
        catch( Exception e ) 
        {
        	String msg = "Could not connect to service with logicalName = " + 
      				     logicalName + ": Exception.message=" + e.getMessage();
        
        	tracer.println( msg );
        	 
        	throw new JposException( JposConst.JPOS_E_NOSERVICE, msg, e ); 
    	}
    }

    /**
     * Disconnect this connection
     * @since 0.1 (Philly 99 meeting)
     * @throws jpos.JposException if the service throws a exception while disconnecting
     */
    public void disconnect() throws JposException 
    {
    	if( service != null )
    	{
	        service.deleteInstance();
	        service = null;
    	}
        
        tracer.println( "Disconnected to service OK" );
    }

    /**
     * Add a finalizer method in case the service connection is garbage collected
     * and the service of this connection has not been disconnected
     * @since 0.1 (Philly 99 meeting)
     * @throws jpos.JposException if the service throws a exception while disconnecting
     */
    protected void finalize() throws JposException { disconnect(); }

    //---------------------------------------------------------------------------
    // Class variables
    //

    private static Hashtable siFactoryTable = new Hashtable();

    //--------------------------------------------------------------------------
    // Instance variables
    //

    private JposServiceInstance service = null;
    private JposEntry entry = null;
    private String logicalName = null;
    private String siFactoryClassName = null;
    
    private Tracer tracer = TracerFactory.getInstance().
    						 createTracer( "SimpleServiceConnection" );
}