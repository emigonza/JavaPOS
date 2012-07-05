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

import java.util.Enumeration;

/**
 * Defines a registry for aggregating Profile objects
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface ProfileRegistry
{
	/** @return the size of the registry */
	public int getSize();

	/** @return true if the registry is empty or not */
	public boolean isEmpty();

    /**
     * @return true if there is an Profile with the specified logical name
     * @param profileName the unique name of this profile
     */
    public boolean hasProfile( String profileName );

    /**
     * @return true if there is an Profile with the specified logical name
     * @param profile the profile
     */
    public boolean hasProfile( Profile profile );

    /** @return an enumeration of Profile objects  */
    public Enumeration getProfiles();

    /**
     * @return the Profile for the profileName specified
     * @param profileName the unique name of this profile
     */
    public Profile getProfile( String profileName );

    /**
     * Add an Profile for the service with logical name specified
     * @param profile the profile
     */
    public void addProfile( Profile profile );

    /**
     * Add an Profile for the service with logical name specified
     * @param profileName the unique name of this profile
     * @param profile the profile
     */
    public void addProfile( String profileName, Profile profile );

    /**
     * Removes the specified Profile 
     * @param profile the profile to remove
     */
    public void removeProfile( Profile profile );

    /**
     * Removes the Profile with the profileName specified 
     * @param profileName the unique name of this profile
     */
    public void removeProfile( String profileName );
}
