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

import java.io.Serializable;
import java.net.URL;

/**
 * Defines a Profile which is an abstract definition of a set of JposEntry 
 * objects and each entry's required set of properties
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
class DefaultProfile extends Object implements Profile, Serializable
{
	//-------------------------------------------------------------------------
	// Ctor(s)
	//

	/** 
	 * Creates a profile with name passed
	 * @param name the Profile's name
	 */
	DefaultProfile( String name ) { this.name = name; }

	//-------------------------------------------------------------------------
	// Public methods
	//

	/** @return the unique name of this profile */
	public String getName() { return name; }

	/** @return the version of this profile */
	public String getVersion() { return version; }

	/** @return a String description of this profile */
	public String getDescription() { return description; }

	/** @return the vendor name of this profile */
	public String getVendorName() { return vendorName; }

	/** @return the URL for this vendor */
	public URL getVendorUrl() { return vendorUrl; }

	/** @return the list of DevCatInfo for this profile */
	public DevCatInfoList getDevCatInfoList() { return devCatInfoList; }

	//-------------------------------------------------------------------------
	// Public overridden methods
	// 

	/** @return a String representation of this Profile */
	public String toString()
	{
		StringBuffer sb = new StringBuffer();

		sb.append( "<Profile name='" + getName() + "'>\n" );

		sb.append( "    <ProfileInfo version='" + getVersion() + "' vendorName='" + getVendorName() + "'\n" );
		sb.append( "                 vendorUrl=" + ( getVendorUrl() == null ? "'null'" : "'" + getVendorUrl().toString() + "'" ) + "\n" );
		sb.append( "                 description='" + getDescription() + "'/>\n" );

		sb.append( "</Profile>" );

		return sb.toString();
	}

	//-------------------------------------------------------------------------
	// Package setter methods
	//

	/** 
	 * Sets the the version of this profile 
	 * @param s the String object
	 */
	void setVersion( String s ) { version = s; }

	/**
	 * @return a String description of this profile
	 * @param s the String
	 */
	void setDescription( String s ) { description = s; }

	/**
	 * Sets the vendorName
	 * @param s the String vendor name
	 */
	void setVendorName( String s ) { vendorName = s; }

	/**
	 * Sets the URL for this vendor
	 * @param url the URL
	 */
	void setVendorUrl( URL url ) { vendorUrl = url; }

	//-------------------------------------------------------------------------
	// Instance variables
	// 

	private String name = "";
	private String version = "";
	private String description = "";

	private String vendorName = "";
	private URL vendorUrl = null;

	private DevCatInfoList devCatInfoList = new DefaultDevCatInfoList();
}
