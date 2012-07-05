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

/**
 * Default implementation of the PropInfo interface
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
class DefaultPropInfo extends Object implements PropInfo, Serializable
{
	//-------------------------------------------------------------------------
	// Ctor(s)
	//

	/**
	 * Creates a PropInfo with name and profile passed
	 * @param name the PropInfo name
	 * @param profile the Profile for this PropInfo
	 */
	public DefaultPropInfo( String name, Profile profile )
	{
		this.name = name;
		this.profile = profile;
	}
							
	//-------------------------------------------------------------------------
	// Public methods
	//

	/** @return the Profile associated with this PropInfo */
	public Profile getProfile() { return profile; }

	/** @return the name of this property (MUST be unique per profile) */
	public String getName() { return name; }

	/** @return the type of this property */
	public PropType getType() { return type; }

	/** @return the default value for this property */
	public PropValue getDefaultValue() { return defaultValue; }

	/** @return the list of possible values for this property */
	public PropValueList getValues() { return values; }

	/** @return the DevCat that this property can be applied to */
	public DevCat getDevCat() { return devCat; }

	/** @return the PropInfoViewer for this property */
	public PropInfoViewer getViewer() { return viewer; }

	/** @return a description of this PropInfo (this can be HTML formated) */
	public String getDescription() { return description; }

	/** @return a short description of this PropInfo (this can be HTML formated) */
	public String getShortDescription() { return shortDescription; }

	//-------------------------------------------------------------------------
	// Package setter methods
	//

	/**
	 * Sets the type of this property 
	 * @param type the PropType
	 */
	void setType( PropType type ) { this.type = type; }

	/**
	 * Sets the default value for this property
	 * @param propValue the PropValue
	 */
	void setDefaultValue( PropValue value ) { defaultValue = value; }

	/** 
	 * Sets the DevCat that this property can be applied to 
	 * @param devCat the DevCat
	 */
	void setDevCat( DevCat devCat ) { this.devCat = devCat; }

	/**
	 * Sets the PropInfoViewer for this property 
	 * @param viewer the PropInfoViewer
	 */
	void setViewer( PropInfoViewer viewer ) { this.viewer = viewer; }

	/**
	 * Sets the description of this PropInfo (this can be HTML formated) 
	 * @param s the String
	 */
	void setDescription( String s ) { description = s; } 

	/**
	 * Sets a short description of this PropInfo used as TootipText (this can be HTML formated)
	 * @param s the String
	 */
	void setShortDescription( String s ) { shortDescription = s; }

	//-------------------------------------------------------------------------
	// Instance variables
	//

	private Profile profile = null;
	private String name = "";
	private PropType type = null;
	private PropValue defaultValue = null;
	private PropValueList values = new DefaultPropValueList();
	private DevCat devCat = null;
	private PropInfoViewer viewer = null;
	private String description = "";
	private String shortDescription = "";
}
