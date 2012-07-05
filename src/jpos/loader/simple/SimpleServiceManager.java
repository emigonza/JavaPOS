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

import jpos.JposConst;
import jpos.JposException;

import jpos.loader.*;
import jpos.config.*;
import jpos.config.simple.*;
import jpos.profile.*;
import jpos.util.*;
import jpos.util.tracing.Tracer;
import jpos.util.tracing.TracerFactory;

/**
 * This is a simple implementation of the JposServiceManager interface
 * @since 0.1 (Philly 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class SimpleServiceManager extends Object 
implements JposServiceManager
{
	//--------------------------------------------------------------------------
	// Ctor(s)
	//

    /**
     * Default ctor
     * NOTE: necessary because it will be used by jpos.config.JposServiceLoader 
     * to create the simple factory
     * @deprecated replaced by 1-argument ctor
     * @since 0.1 (Philly 99 meeting)
     */
    public SimpleServiceManager() 
    { 
        getProperties().loadJposProperties();
        init(); 
    }

    /**
     * One argument ctor
     * @param properties the JposProperties for this manager
     * NOTE: this could be an instance of the simple 
     * jpos.loader.DefaultProperties or a this class could also create its own 
     * JposProperties object
     */
    public SimpleServiceManager( JposProperties properties ) 
    { 
        jposProperties = properties;
        init();
    }

    //--------------------------------------------------------------------------
    // Private instance methods
    //

    /**
     * Initializes all the manager objects
     * @since 1.2 (NY 2K meeting)
     */
    private void init() { initEntryRegistry(); }

    /**
     * Initializes the registry object and also loads the property
     * @since 1.3 (Washington DC 2001 meeting)
     */
    private void initEntryRegistry()
    {
        initRegPopulator();
        entryRegistry = new SimpleEntryRegistry( regPopulator );
	}

    /**
     * Initializes the JposRegPopulator to be used by this manager
     * If the a JposRegPopulator is defined then try to use it otherwise use default
     * @since 1.2 (NY 2K meeting)
     */
    private void initRegPopulator()
    {
		JposProperties properties = getProperties();

        if( properties.isPropertyDefined( JposProperties.
            JPOS_REG_POPULATOR_CLASS_PROP_NAME ) )
        {
			String regPopulatorClassName = properties.
			       getPropertyString( JposProperties.
			       JPOS_REG_POPULATOR_CLASS_PROP_NAME );

            try
            {
                Class regPopulatorClass = Class.forName( regPopulatorClassName );

                regPopulator = (JposRegPopulator)regPopulatorClass.newInstance();
            }
            catch( Exception e ) 
			{
				tracer.println( "Could not create populator by name: " + 
				                regPopulatorClassName + " Exception.message= " +
				                e.getMessage() );
				regPopulator = new SimpleRegPopulator(); 
			}
        }
        else
		if( properties.hasMultiProperty( JposPropertiesConst.JPOS_CONFIG_POPULATOR_CLASS_MULTIPROP_NAME ) )
			regPopulator = new DefaultCompositeRegPopulator();
		else
            regPopulator = new SimpleRegPopulator();
    }
    
    /**
     * @return the ProfileFactory (lazilly creating it, if necessary)
     * @since 2.1.0
     */
    private ProfileFactory getProfileFactory()
    {
		if( profileFactory == null )
			profileFactory = new XercesProfileFactory();
		
		return profileFactory;
    }

    //---------------------------------------------------------------------------
    // Public instance methods
    //

    /**
     * @return the JposEntryRegistry object 
     * @since 0.1 (Philly 99 meeting)
     */
    public JposEntryRegistry getEntryRegistry() { return entryRegistry; }

    /**
     * @return the JposProperties object containing access to all 
     * Jpos properties
     * @since 1.2 (NY 2K meeting)
     */
    public JposProperties getProperties() { return jposProperties; }

    /**
     * @return the JposRegPopulator object used to populate the registry
     * @since 1.2 (NY 2K meeting)
     */
    public JposRegPopulator getRegPopulator() { return regPopulator; }

    /**
     * @return a ServiceConnection used to connect to the service
     * @param logicalName the logical name of the service to find
     * @since 0.1 (Philly 99 meeting)
     * @throws jpos.config.JposException 
     */
    public JposServiceConnection createConnection( String logicalName ) 
    throws JposException
    {
        JposServiceConnection sc = null;

        try 
        {
            JposEntry jposEntry = (JposEntry)entryRegistry.
                                  getJposEntry( logicalName );

            if( jposEntry == null )
                throw new JposException( JposConst.JPOS_E_NOEXIST, 
                                          "Service does not exist in loaded JCL registry" );

            String siFactoryClassName = 
            (String)jposEntry.getPropertyValue( JposEntry.
            									SI_FACTORY_CLASS_PROP_NAME );

            sc = new SimpleServiceConnection( logicalName, 
            								  jposEntry, 
            								  siFactoryClassName );
        }
        catch( JposException je )
        {
        	tracer.println( "createConnection: JposException.msg=" + 
        				    je.getMessage() );
        	throw je;
        } 
        catch( Exception e ) 
        { 
        	tracer.println( "createConnection: Exception.msg=" + 
        					e.getMessage() );        	
        	throw new JposException( JposConst.JPOS_E_NOSERVICE, 
        							  "Could not find service" ); 
        }

		return sc;
	}

    /**
     * @return the current ProfileRegistry
     * @since 1.3 (SF 2K meeting)
     */
	public ProfileRegistry getProfileRegistry() 
	{
		if( profileRegistry == null )
			profileRegistry = new DefaultProfileRegistry();
		 
		return profileRegistry; 
	}

    /**
	 * Tries to load the Profile by specified in the file.  If successful 
	 * returns it and adds it to the ProfileRegistry otherwise throw exception
     * @return the profile specified in the XML profile file after loading it
	 * @param xmlProfileFileName the file name for the XML profile
	 * @exception jpos.profile.ProfileException if the profile could not be 
	 * loaded from file
     * @since 1.3 (SF 2K meeting)
     */
	public Profile loadProfile( String xmlProfileFileName ) 
	throws ProfileException 
	{ 
		Profile profile = getProfileFactory().
						  createProfile( xmlProfileFileName );

		if( profile != null )
			profileRegistry.addProfile( profile );

		return profile; 
	}

	/** 
	 * Ask the manager to reload the registry by reloading the properties file
	 * creating a new registry and repopulating the registry.  Also creates sets
	 * the JposRegPopulator for the registry as a side-effect
	 * NOTE: this method should only be used if at runtime the properties and/or 
	 * populator files have changed
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public void reloadEntryRegistry()
	{
		getProperties().loadJposProperties();
		initEntryRegistry();

		getEntryRegistry().load();
		
		tracer.println( "Sucessfully reloaded registry" );
	}

    //--------------------------------------------------------------------------
    // Instance variables
    //

    private JposRegPopulator regPopulator = null;
    private SimpleEntryRegistry entryRegistry = null;
	
	private ProfileRegistry profileRegistry = null;
	private ProfileFactory  profileFactory = null;

    private JposProperties jposProperties = new DefaultProperties();
    
    private Tracer tracer = TracerFactory.getInstance().
                             createTracer( "SimpleServiceManager" );
}