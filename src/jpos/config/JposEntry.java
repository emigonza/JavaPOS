package jpos.config;

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

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Defines the minimal set of methods for a JposEntry object
 * It allows the entries to contain properties <key, value> pairs
 * The key being a String and the value any serializable Java objects
 * NOTE: JposEntry implementation can be easily implemented using a 
 * java.util.Hashtable
 * @since 0.1 (Philly 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface JposEntry extends Serializable, Comparable
{
    /**
     * @return count of number of properties 
     * @since 0.1 (Philly 99 meeting)
     */
    public int getPropertyCount();

    /**
     * @return an enumerator for the properties names 
     * @since 0.1 (Philly 99 meeting)
     */
    public Enumeration getPropertyNames();

    /**
     * @return true if there is a property by the name specified
     * @since 0.1 (Philly 99 meeting)
     * @param propName the property name String
     */
    public boolean hasPropertyWithName( String propName );

    /**
     * @return true if there is a property by the value specified
     * <p><b>NOTE: Object.equals method will be used to compare</b></p>
     * @param propValue the property's value Object
     * @since 0.1 (Philly 99 meeting)
     */
    public boolean hasPropertyWithValue( Object propValue );

    /** 
     * @return the property's value Object
     * @param propName the property's name String
     * @since 0.1 (Philly 99 meeting)
     */
    public Object getPropertyValue( String propName );

    /** 
     * @return the property's type
     * @param propName the property's name String
     * @since 2.0.0
     */
    public Class getPropertyType( String propName );

    /**
     * Modifies the property value of the property passed
	 * @return the oldPropValue or null if this property does not exist
     * @param propName the property name
	 * @param propValue the new property value
	 * @since 1.3 (Tokyo 2001 meeting)
	 * @throws java.lang.IllegalArgumentException if the propName or propValue is null
     */
    public Object modifyPropertyValue( String propName, Object propValue ) throws IllegalArgumentException;

    /**
     * Adds a property to the JposEntry object.
     * NOTE: any property with the same name gets overlaid
     * @param propName the name of this property (should be unique per property)
     * @param propValue the properties value Object
     * @since 0.1 (Philly 99 meeting)
	 * @throws java.lang.IllegalArgumentException if the propName or propValue is null
     */
    public Object addProperty( String propName, Object propValue ) throws IllegalArgumentException;

    /**
     * Looks for a property with name specified and removes it
     * @param propName the name String of the property to remove
     * @since 0.1 (Philly 99 meeting)
     */
    public Object removeProperty( String propName );

    /**
     * @return true if the two JposEntries have the same properties 
     * @since 0.1 (Philly 99 meeting)
     */
    public boolean equals( JposEntry otherEntry );

	/**
	 * @return the JposRegPopulator that loads/saves this entry.  If null the default
	 * populator is used
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public JposRegPopulator getRegPopulator();

	/**
	 * @return the logical name for this JposEntry.  This is a shortcut for easily getting
	 * the logical name vs getting a property and passing the logical name constant
	 * @see jpos.config.JposEntry#getPropertyValue
	 * @see jpos.config.JposEntry#LOGICAL_NAME_PROP_NAME
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getLogicalName();

	/**
	 * Returns a JposEntry.Prop with name specified.
	 * <p><b>
	 * Changes to that property object are not reflected in this entry.  You must
	 * apply the changes to the property to the entry by calling modifyProp() method
	 * </b></p>
	 * @return the JposEntry.Prop with name specified or null if no such property exist
	 * @param propName the property name
	 * @since 2.0.0
	 */
	public JposEntry.Prop getProp( String propName );

	/**
	 * Returns an Iterator of JposEntry.Prop in this entry
	 * <p><b>
	 * Changes to any of the returned property object are not reflected in this entry.  
	 * You must apply the changes to the property to the entry by calling modifyProp() method
	 * </b></p>
	 * @return an Iterator over the properties in this JposEntry as JposEntry.Prop objects
	 * @since 1.3 (Washington DC 2001)
	 */
	public Iterator getProps();

	/**
	 * Adds a new property
	 * @param prop the JposEntry.Prop to add
	 * @since 1.3 (Washington DC 2001 meeting)
	 * @throws java.lang.IllegalArgumentException if the prop is null
	 */
	public void add( JposEntry.Prop prop ) throws IllegalArgumentException;

    /**
     * Looks for a property with name specified and removes it.  If none exist then 
	 * does nothing and return null
	 * @return the value for the name passed
     * @param name the name String of the property to remove
     * @since 0.1 (Philly 99 meeting)
     */
	public void remove( JposEntry.Prop prop );

	/**
	 * Modifies the property with name of property passed with the new value if
	 * that property currently exist in the entry otherwise does nothing
	 * @param prop the JposEntry.Prop to modify
	 * @since 2.0.0
	 * @throws java.lang.IllegalArgumentException if the prop is null
	 */
	public void modify( JposEntry.Prop prop ) throws IllegalArgumentException;

	/** 
	 * @return true if this entry has the property passed
	 * @param prop the JposEntry.Prop to check for
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public boolean hasProp( JposEntry.Prop prop );

	/** 
	 * @return a JposEntry.Prop object created with the <name, value, type> tripplet
	 * passed as arguments
	 * @param propName the property name
	 * @param propValue the property value
	 * @param propType the property type (valid for this value)
	 * @throws jpos.config.JposConfigException if any of the argument is null or the
	 * property value and type mismatch or this is not a valid property type
	 * @see jpos.config.JposEntryConst#PROP_TYPES
	 * @since 2.0.0
	 */
	public JposEntry.Prop createProp( String propName, Object propValue, Class propType ) throws JposConfigException;

	//-------------------------------------------------------------------------
	// Inner interfaces
	//

	/**
	 * Inner interface to represent a property of a JposEntry
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 * @since 1.3 (Washington DC 2001)
	 */
	public interface Prop extends Comparable
	{
		/** @return the name of this property */
		public String getName();

		/** @return the value of this property (the value is returned as an Object) */
		public Object getValue();

		/** @return the value of this property as a String */
		public String getValueAsString();

		/**
		 * Returns the Class object that is the type of this property value
		 * possible values returned are the java.lang wrapper classes for the
		 * primitive types e.g. Integer, Byte, Boolean, ... 
		 * @return the type of this property as a java.lang.Class object 
		 */
		public Class getType();

		/** 
		 * Sets the name of this property 
		 * @param s the String object
		 * @throws java.lang.IllegalArgumentException if the value is null
		 */
		public void setName( String s ) throws IllegalArgumentException;

		/** 
		 * Sets the value of this property (String).  Also sets its Type.
		 * <p><b>This is the default type of any property</b></p>
		 * @param objValue the object value
		 * @throws java.lang.IllegalArgumentException if the value is null or
		 * that this is not a valid typed property value
		 */
		public void setValue( Object objValue ) throws IllegalArgumentException;

		/** 
		 * @return true if the property is of the type specified by the Class
		 * object passed
		 * @param type the Class object
		 */
		public boolean isOfType( Class type );

		/** 
		 * @return true if this and otherProp have same name and value
		 * @param otherProp the other JposEntry.Prop
		 */
		public boolean equals( Object otherProp );

		/** @return a new copy of this JposEntry.Prop object */
		public JposEntry.Prop copy();
	}

    //-------------------------------------------------------------------------
    // Interface constants
    //

    /**
     * JposEntry property name defining the JposServiceInstanceFactory class for this JposEntry 
     * @since 0.1 (Philly 99 meeting)
     */
    public static final String SI_FACTORY_CLASS_PROP_NAME = "serviceInstanceFactoryClass";

    /**
     * JposEntry property name that must be defined by all JposEntry objects used to create services
     * @since 0.1 (Philly 99 meeting)
     */
    public static final String LOGICAL_NAME_PROP_NAME = "logicalName";

    /**
     * JposEntry property name that specifies the fully qualified class name for the service
     * @since 1.2 (NY 2K meeting)
     */
    public static final String SERVICE_CLASS_PROP_NAME = "serviceClass";

    /**
     * The vendor name string
     * @since 1.2 (NY 2K meeting)
     */
    public static final String VENDOR_NAME_PROP_NAME = "vendorName";

    /**
     * The vendor URL string
     * @since 1.2 (NY 2K meeting)
     */
    public static final String VENDOR_URL_PROP_NAME = "vendorURL";

    /**
     * The device category for the service must be one of JavaPOS defined categories
     * i.e. CashDrawer, CashChanger, MSR, MICR, ...
     * @since 1.2 (NY 2K meeting)
     */
    public static final String DEVICE_CATEGORY_PROP_NAME = "deviceCategory";

    /**
     * The JavaPOS version supported by this service (i.e. 1.4, 1.5...)
     * @since 1.2 (NY 2K meeting)
     */
    public static final String JPOS_VERSION_PROP_NAME = "jposVersion";

    /**
     * A short name for this product
     * @since 1.2 (NY 2K meeting)
     */
    public static final String PRODUCT_NAME_PROP_NAME = "productName";

    /**
     * A string description for this product
     * @since 1.2 (NY 2K meeting)
     */
    public static final String PRODUCT_DESCRIPTION_PROP_NAME = "productDescription";

    /**
     * The product's URL string
     * @since 1.2 (NY 2K meeting)
     */
    public static final String PRODUCT_URL_PROP_NAME = "productURL";
}
