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

import java.net.URL;

/**
 * Defines a Profile which is an abstract definition of a set of JposEntry 
 * objects and each entry's required set of properties
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface Profile
{
	//-------------------------------------------------------------------------
	// Public methods
	//

	/** @return the unique name of this profile */
	public String getName();

	/** @return the version of this profile */
	public String getVersion();

	/** @return a String description of this profile */
	public String getDescription();

	/** @return the vendor name of this profile */
	public String getVendorName();

	/** @return the URL for this vendor */
	public URL getVendorUrl();

	/** @return the list of DevCatInfo for this profile */
	public DevCatInfoList getDevCatInfoList();
}
