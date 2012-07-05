package jpos.util;

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

import java.util.Iterator;
import java.util.Enumeration;
import java.util.List;

/**
 * Sample interface that contains constants for all the JposProperties (names, default
 * values, etc...) and some methods that the implementing property class must define.
 * @since 1.2 (NY 2K 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface JposProperties extends JposPropertiesConst 
{
    //-------------------------------------------------------------------------
    // Public methods
    //

    /**
     * Loads the jpos.properties file from the "./jpos/res" directory
     * @since 1.2 (NY 2K meeting)
     */
    public void loadJposProperties();

	/**
	 * @return true if the properties are loaded
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public boolean isLoaded();

    /**
     * @return the String property by name specified looking in System then the "jpos.properties" resource bundle
     * @param propName the property name to search for
     * @since 1.2 (NY 2K meeting)
     */
    public String getPropertyString( String propName );

    /**
     * @return true if this property is defined in the Java System properties or in
     * the jpos.properties resource file
     * @param propName the property name to look for
     * @since 1.2 (NY 2K meeting)
     */
    public boolean isPropertyDefined( String propName );

    /**
     * @return an enumeration of properties names defined
     * @since 1.2 (NY 2K meeting)
     */
    public Enumeration getPropertyNames();
    
    /**
     * @return a List of property value parsed from the property value found
     * for the property name
     * @param propName the property name for which the values will be parsed from
     * @since 2.1.0
     */
	public List getStringListProperty( String propName );

	/**
	 * @return the MultiProperty by the name passed.  MultiProperty are properties
	 * named like <propName>.<n> where n = 0, 1, ...  If the multi-property does not
	 * exist then null is returned
	 * @param multiPropName the multi-property name
	 * @since 1.3 (Wahington DC 2001 meeting)
	 */
	public JposProperties.MultiProperty getMultiProperty( String multiPropName );

	/**
	 * @return true if the MultiProperty by the name passed exist otherwise false
	 * @param multiPropName the multi-property name
	 * @since 1.3 (Wahington DC 2001 meeting)
	 */
	public boolean hasMultiProperty( String multiPropName );

	/**
	 * @return an iterator of JposProperties.Prop for all the properties in this
	 * JposProperties.  Changes to these properties do not affect the JposProperties properties
	 * @see jpos.util.JposProperties.Prop
	 * @since 1.3 (Washington DC 2001)
	 */
	public Iterator getProps();

	/**
	 * @return the number of properties in this JposProperties
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public int size();

	//-------------------------------------------------------------------------
	// Public inner interfaces
	//

	/**
	 * Speficies an interface used for returning multi properties.  That is
	 * properties that are named like <name>.x where x = 0, 1, ...x
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public interface MultiProperty
	{
		/** 
		 * @return the number of this property name that is for property <propName>.x returns x 
		 * @param propName the property name to get the number of
		 * @throws java.lang.IllegalArgumentException if the property name does not follow the <propName>.x name pattern
		 */
		public int propertyNumber( String propName ) throws IllegalArgumentException;

		/** 
		 * @return the base property name for this multi-property that is the
		 * name w/o the number suffix
		 */
		public String getBasePropertyName();

		/** @return an iterator of the property names for this multi-property */
		public Iterator getPropertyNames();

		/** @return an iterator of the property names alphabetically sorted for this multi-property */
		public Iterator getSortedPropertyNames();

		/** @return an iterator of the property values for this multi-property */
		public Iterator getPropertyValues();

		/**
		 * @return the value for this property from the full property name
		 * @param propName the full property name <name>.x
		 */
		public String getPropertyString( String propName );

		/**
		 * @return the value for this property from the full property name
		 * @param number suffix for the property name
		 * @throws java.lang.IllegalArgumentException if the i negative
		 */
		public String getPropertyString( int i ) throws IllegalArgumentException;

		/** @return the number of properties defined in this multi-property */
		public int getNumberOfProperties();
	}

	/**
	 * Simple wrapper class for a property pair <name, value>
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 * @since 1.3 (Washington DC 2001)
	 */
	public interface Prop extends Comparable
	{
		/** @return the name of this property */
		public String getName();

		/** @return the value of this property */
		public String getValue();

		/**
		 * Sets the value of this property 
		 * @param s the new prop name
		 */
		public void setName( String s );

		/** 
		 * Sets the value of this property 
		 * @param s the name String
		 */
		public void setValue( String s );

		/**
		 * @return 0 if 2 objects same -1 if this is less or +1 if this is more than other
		 * @param other the other object to compare against this
		 */
		public int compareTo( JposProperties.Prop other );

		/**
		 * @return 0 if 2 objects same -1 if this is less or +1 if this is more than other
		 * @param other the other object to compare against this
		 */
		public int compareTo( Object other );
	}
	
	//-------------------------------------------------------------------------
	// Public static constants
	//
	
	public static final String TRACING_PROP_NAME = "jpos.util.tracing";
	public static final String TRACING_ON_PROP_VALUE = "ON";
	public static final String TRACING_TRUE_PROP_VALUE = "TRUE";
}