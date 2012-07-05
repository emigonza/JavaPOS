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

import jpos.JposException;

import jpos.util.JposProperties;
import jpos.config.JposEntryRegistry;
import jpos.config.JposRegPopulator;
import jpos.profile.Profile;
import jpos.profile.ProfileRegistry;
import jpos.profile.ProfileException;

/**
 * An implementation of the jpos.config must provide an implementation of
 * this interface which is used to create the JposServiceConnection objects.
 * This also provides a way to access the JposEntryPopulator to allow for
 * dynamic updates of the currently configured JposEntry objects.
 * @since 0.1 (Philly 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface JposServiceManager
{
    /**
     * @return a JposServiceConnection for the service with the logical name specified
     * This should use the populator to see if there exist any entry with the logical
     * name provided, get the entry and create the JposServiceConnection
     * @since 0.1 (Philly 99 meeting)
     * @throws jpos.JposException if an error occurs while creating this connection
     */
    public JposServiceConnection createConnection( String logicalName ) throws JposException;

    /**
     * @return the JposEntryRegistry object that this factory uses to allow entries to be
     * querried and added dynamically
     * @since 0.1 (Philly 99 meeting)
     */
    public JposEntryRegistry getEntryRegistry();

    /**
     * @return the JposProperties object containing access to all Jpos properties
     * @since 1.2 (NY 2K meeting)
     */
    public JposProperties getProperties();

    /**
     * @return the JposRegPopulator object used to populate the registry
     * @since 1.2 (NY 2K meeting)
     */
    public JposRegPopulator getRegPopulator();

    /**
     * @return the ProfileRegistry currently loaded
     * @since 1.3 (SF 2K meeting)
     */
    public ProfileRegistry getProfileRegistry();

    /**
	 * Tries to load the Profile by specified in the file.  If successful returns
	 * it and adds it to the ProfileRegistry otherwise throw exception
     * @return the profile specified in the XML profile file after loading it
	 * @param xmlProfileFileName the file name for the XML profile
	 * @exception jpos.profile.ProfileException if the profile could not be loaded from file
     * @since 1.3 (SF 2K meeting)
     */
	public Profile loadProfile( String xmlProfileFileName ) throws ProfileException;

	/** 
	 * Ask the manager to reload the registry by reloading the properties file
	 * creating a new registry and repopulating the registry.  Also creates sets
	 * the JposRegPopulator for the registry as a side-effect
	 * NOTE: this method should only be used if at runtime the properties and/or 
	 * populator files have changed
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public void reloadEntryRegistry();
}
