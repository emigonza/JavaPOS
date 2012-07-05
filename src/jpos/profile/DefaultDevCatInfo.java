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

/**
 * Default implementation of the DevCatInfo interface
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
class DefaultDevCatInfo extends Object implements DevCatInfo
{
	//-------------------------------------------------------------------------
	// Ctor(s)
	//

	/**
	 * Creates a DevCatInfo with the <Profile, DevCat> parameter
	 * @param profile the Profile
	 * @param devCat the DevCat
	 */
	DefaultDevCatInfo( Profile profile, DevCat devCat )
	{
		this.profile = profile;
		this.devCat = devCat;
	}

	//-------------------------------------------------------------------------
	// Public methods
	//

	/** @return the Profile associated with this DevCatInfo */
	public Profile getProfile() { return profile; }

	/** @return the DevCat */
	public DevCat getDevCat() { return devCat; }

	/** @return the list of standard properties for this DevCat */
	public PropInfoList getStandardProps() { return standardProps; }

	/** @return the list of required properties for this DevCat */
	public PropInfoList getRequiredProps() { return requiredProps; }

	/** @return the list of optional properties for this DevCat */
	public PropInfoList getOptionalProps() { return optionalProps; }

	/** @return the String representation of this DevCat */
	public String toString()
	{
		StringBuffer sb = new StringBuffer();

		sb.append( "<DevCatInfo>\n" );
		sb.append( "   <Profile name = " + profile.getName() + 
				        " vendorName = " + profile.getVendorName() + "/>\n" );
		sb.append( "   <DevCat name = " + devCat.toString() + "/>\n" ); 
		sb.append( "</DevCatInfo>\n" );

		return sb.toString();
	}

	//-------------------------------------------------------------------------
	// Package methods
	//

	//-------------------------------------------------------------------------
	// Instance variables
	//

	private Profile profile = null;
	private DevCat devCat = null;

	private PropInfoList standardProps = new DefaultPropInfoList();
	private PropInfoList requiredProps = new DefaultPropInfoList();
	private PropInfoList optionalProps = new DefaultPropInfoList();
}
