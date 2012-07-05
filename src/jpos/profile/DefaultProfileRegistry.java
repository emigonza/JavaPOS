package jpos.profile;

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

/**
 * Default implementation of the ProfileRegistry using a Hashtable
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class DefaultProfileRegistry extends Object implements ProfileRegistry
{
	//-------------------------------------------------------------------------
	// Ctor(s)
	//

	/** Default ctor*/
	public DefaultProfileRegistry() {}

	//-------------------------------------------------------------------------
	// Public methods
	//

	/** @return the size of the registry */
	public int getSize() { return table.size(); }

	/** @return true if the registry is empty or not */
	public boolean isEmpty() { return table.isEmpty(); }

    /**
     * @return true if there is an Profile with the specified logical name
     * @param profileName the unique name of this profile
     */
    public boolean hasProfile( String profileName ) { return table.containsKey( profileName ); }

    /**
     * @return true if there is an Profile with the specified logical name
     * @param profile the profile
     */
    public boolean hasProfile( Profile profile ) { return table.containsValue( profile ); }

    /** @return an enumeration of Profile objects  */
    public Enumeration getProfiles() { return table.elements(); }

    /**
     * @return the Profile for the profileName specified
     * @param profileName the unique name of this profile
     */
    public Profile getProfile( String profileName ) { return (Profile)table.get( profileName ); }

    /**
     * Add an Profile for the service with logical name specified
     * @param profile the profile
     */
    public void addProfile( Profile profile ) { table.put( profile.getName(), profile ); }

    /**
     * Add an Profile for the service with logical name specified
     * @param profileName the unique name of this profile
     * @param profile the profile
     */
    public void addProfile( String profileName, Profile profile ) { table.put( profileName, profile ); }

    /**
     * Removes the specified Profile 
     * @param profile the profile to remove
     */
    public void removeProfile( Profile profile ) { table.remove( profile.getName() ); }

    /**
     * Removes the Profile with the profileName specified 
     * @param profileName the unique name of this profile
     */
    public void removeProfile( String profileName ) { table.remove( profileName ); }

	//-------------------------------------------------------------------------
	// Instance varaibles
	//

	private Hashtable table = new Hashtable();
}
