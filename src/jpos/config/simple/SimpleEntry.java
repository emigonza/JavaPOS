package jpos.config.simple;

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

import jpos.config.JposEntry;

import java.util.*;
import java.io.Serializable;

import jpos.config.*;
import jpos.util.JposEntryUtility;

/**
 * This is a simple implementation of the JposEntry interface using a Hashtable 
 * to collect the properties
 * @since 0.1 (Philly 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class SimpleEntry implements JposEntry, Serializable, Comparable
{
    //--------------------------------------------------------------------------
    // Ctor(s)
    //

	/**
	 * Default ctor (sets the JposRegPopulator to null)
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public SimpleEntry() { regPopulator = null; }

	/**
	 * One argument ctor taking the JposRegPopulator for this entry
	 * @param populator the JposRegPopulator for this entry
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public SimpleEntry( JposRegPopulator populator ) { regPopulator = populator; }

	/**
	 * One argument ctor taking the JposRegPopulator for this entry
	 * @param logicalName the logical name for this entry
	 * @param populator the JposRegPopulator for this entry
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public SimpleEntry( String logicalName, JposRegPopulator populator ) 
	{
		this( populator );

		addProperty( LOGICAL_NAME_PROP_NAME, logicalName );
	}

	/**
	 * One argument ctor taking the LogicalName this entry
	 * @param logicalName the logical name string for this entry
	 * @since 2.0.0
	 */
	SimpleEntry( String logicalName ) { addProperty( LOGICAL_NAME_PROP_NAME, logicalName ); }

    //--------------------------------------------------------------------------
    // Public instance methods
    //

    /**
     * @return count of number of properties 
     * @since 0.1 (Philly 99 meeting)
     */
    public int getPropertyCount() { return properties.size(); }

    /**
     * @return an enumerator for the properties names 
     * @since 0.1 (Philly 99 meeting)
     */
    public Enumeration getPropertyNames() { return properties.keys(); }

    /**
     * @return true if there is a property by the name specified
     * @param propName the property name String
     * @since 0.1 (Philly 99 meeting)
     */
    public boolean hasPropertyWithName( String propName ) { return properties.containsKey( propName ); }

    /**
     * @return true if there is a property by the value specified
     * NOTE: Object.equals method will be used to compare
     * @param propValue the property's value Object
     * @since 0.1 (Philly 99 meeting)
     */
    public boolean hasPropertyWithValue( Object propValue ) { return properties.contains( propValue ); }

    /** 
     * @return the property's value Object
     * @param propName the property's propName String
     * @since 0.1 (Philly 99 meeting)
     */
    public Object getPropertyValue( String propName ) { return properties.get( propName ); }

    /** 
     * @return the property's type
     * @param propName the property's name String
     * @since 2.0.0
     */
    public Class getPropertyType( String propName ) { return getPropertyValue( propName ).getClass(); }

    /**
     * Modifies the property value of the property passed
	 * @return the oldPropValue or null if this property does not exist
     * @param propName the property name
	 * @param propValue the new property value
	 * @since 1.3 (Tokyo 2001 meeting)
     * @throws java.lang.IllegalArgumentException if the propName or propValue is null
     */
    public Object modifyPropertyValue( String propName, Object propValue ) throws IllegalArgumentException
	{
		checkNull( propName );
		checkNull( propValue );

		if( hasPropertyWithName( propName ) == false )
			return null;

		Object oldValue = removeProperty( propName );

		addProperty( propName, propValue );

		return oldValue;
	}

    /**
     * Adds a property to the JposEntry object.
     * NOTE: any property with the same name gets overlaid
     * @param propName the name of this property (should be unique per property)
     * @param propValue the properties value Object
     * @since 0.1 (Philly 99 meeting)
     * @throws java.lang.IllegalArgumentException if the propName or propValue is null
     */
    public Object addProperty( String propName, Object propValue ) throws IllegalArgumentException
	{
		checkNull( propName );
		checkNull( propValue );

		return properties.put( propName, propValue ); 
	}

    /**
     * Looks for a property with name specified and removes it.  If none exist then 
	 * does nothing and return null
	 * @return the value for the name passed
     * @param propName the name String of the property to remove
     * @since 0.1 (Philly 99 meeting)
     */
    public Object removeProperty( String propName ) { return properties.remove( propName ); }

    /** 
     * @return true if the two JposEntries have the same properties 
     * @since 0.1 (Philly 99 meeting)
     */
    public boolean equals( JposEntry otherEntry )
    {
        if( otherEntry == null ) return false;

        if( getPropertyCount() != otherEntry.getPropertyCount() ) return false;

        Enumeration otherPropNames = otherEntry.getPropertyNames();

        while( otherPropNames.hasMoreElements() )
        {
            String name = (String)otherPropNames.nextElement();
            Object value = otherEntry.getPropertyValue( name );

            if( !hasPropertyWithName( name ) ) return false;

            if( !getPropertyValue( name ).equals( value ) ) return false;
        }

        return true;
    }

	/**
	 * @return a copy of this JposEntry object
	 * @since 1.3 (Tokyo 2001 meeting)
	 */
	public JposEntry copy() 
	{
		JposEntry entryCopy = new SimpleEntry();

		Enumeration entryNames = getPropertyNames();

		while( entryNames.hasMoreElements() )
		{
			String propName = (String)entryNames.nextElement();
			entryCopy.addProperty( propName,getPropertyValue( propName ) );
		}

		return entryCopy; 
	}

	/**
	 * @return the JposRegPopulator that loads/saves this entry.  If null the default
	 * populator is used
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public JposRegPopulator getRegPopulator() { return regPopulator; }

	/**
	 * @return the logical name for this JposEntry.  This is a shortcut for easily getting
	 * the logical name vs getting a property and passing the logical name constant
	 * @see jpos.config.JposEntry#getPropertyValue
	 * @see jpos.config.JposEntry#LOGICAL_NAME_PROP_NAME
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getLogicalName() { return (String)getPropertyValue( JposEntry.LOGICAL_NAME_PROP_NAME ); }

	/**
	 * @return the JposEntry.Prop with name specified or null if no such property exist
	 * @param propName the property name
	 * @since 2.0.0
	 */
	public JposEntry.Prop getProp( String propName )
	{
		Object propValue = getPropertyValue( propName );

		if( propValue == null ) return null;

		return new Prop( propName, propValue );
	}

	/**
	 * @return an Iterator over the properties in this JposEntry as JposEntry.Prop objects
	 * @since 1.3 (Washington DC 2001)
	 */
	public Iterator getProps()
	{
		List list = new ArrayList();

		Enumeration names = getPropertyNames();

		while( names.hasMoreElements() )
		{
			String name = (String)names.nextElement();

			list.add( new Prop( name, getPropertyValue( name ) ) );
		}

		return list.iterator();
	}

	/**
	 * Adds a new property
	 * @param prop the JposEntry.Prop to add
	 * @since 1.3 (Washington DC 2001 meeting)
	 * @throws java.lang.IllegalArgumentException if the argument is null
	 */
	public void add( JposEntry.Prop prop ) throws IllegalArgumentException
	{
		checkNull( prop );

		addProperty( prop.getName(), prop.getValue() ); 
	}

	/**
	 * Removes the property
	 * @param prop the JposEntry.Prop to remove
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public void remove( JposEntry.Prop prop ) { removeProperty( prop.getName() ); }

	/**
	 * Modifies the property with name of property passed with the new value if
	 * that property currently exist in the entry otherwise does nothing
	 * @param prop the JposEntry.Prop to modify
	 * @since 2.0.0
	 * @throws java.lang.IllegalArgumentException if the prop is null
	 */
	public void modify( JposEntry.Prop prop ) throws IllegalArgumentException
	{
		checkNull( prop );

		if( hasPropertyWithName( prop.getName() ) == false ) return;

		modifyPropertyValue( prop.getName(), prop.getValue() );
	}

	/** 
	 * @return true if this entry has the property passed
	 * @param prop the JposEntry.Prop to check for
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public boolean hasProp( JposEntry.Prop prop ) { return hasPropertyWithName( prop.getName() ); }

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
	public JposEntry.Prop createProp( String propName, Object propValue, Class propType ) throws JposConfigException
	{
		if( propName == null || propValue == null || propType == null )
			throw new JposConfigException( "Cannot create JposEntry.Prop with null argument" );

		if( JposEntryUtility.validatePropValue( propValue, propType ) == false )
			throw new JposConfigException( "Cannot create JposEntry.Prop with invalid value or type" );

		return new Prop( propName, propValue );
	}

    //--------------------------------------------------------------------------
    // Public overidden methods
    //

    /** 
     * @return true if the two JposEntries have the same properties 
     * @since 1.3 (SF 2K meeting)
     */
    public boolean equals( Object object )
    {
        if( object instanceof JposEntry )
            return equals( (JposEntry)object );

        return false;
    }

	/**
	 * @return 0 if two entries are the same -1 if this is less or 1 of more than other
	 * the comparison for > and < uses the logicalName of the entry to decide
	 * @param otherEntry the other JposEntry
	 */
	public int compareTo( Object other )
	{
		if( other == null || ( (other instanceof JposEntry ) == false ) )
			throw new RuntimeException( "Cannot compare: " + other + " with JposEntry: " + this );

		JposEntry otherEntry = (JposEntry)other;

		if( equals( otherEntry ) ) return 0;

		return getLogicalName().compareTo( otherEntry.getLogicalName() );
	}

    /** 
     * @return a String representation of this entry
     * @since 1.3 (SF 2K meeting)
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        sb.append( "<JposEntry logicalName=\"" + getPropertyValue( JposEntry.LOGICAL_NAME_PROP_NAME ) + "\">\n" );
        sb.append( "\t<creation factoryClass=\"" + getPropertyValue( JposEntry.SI_FACTORY_CLASS_PROP_NAME ) + "\" serviceClass=\"" + getPropertyValue( JposEntry.SERVICE_CLASS_PROP_NAME ) + "\"/>\n" );
        sb.append( "\t<vendor name=\"" + getPropertyValue( JposEntry.VENDOR_NAME_PROP_NAME ) + "\" url=" + getPropertyValue( JposEntry.VENDOR_URL_PROP_NAME ) + "\"/>\n" );
        sb.append( "\t<jpos category=\"" + getPropertyValue( JposEntry.DEVICE_CATEGORY_PROP_NAME ) + "\" version=\"" + getPropertyValue( JposEntry.JPOS_VERSION_PROP_NAME ) + "\"/>\n" );
        sb.append( "\t<product description=\"" + getPropertyValue( JposEntry.PRODUCT_DESCRIPTION_PROP_NAME ) + "\" name=\"" + getPropertyValue( JposEntry.PRODUCT_NAME_PROP_NAME ) + "\" url=\"" + getPropertyValue( JposEntry.PRODUCT_URL_PROP_NAME ) + "\"/>\n" );

		sb.append( "\n" );

		Enumeration otherPropNames = JposEntryUtility.getNonRequiredPropNames( this );
		while( otherPropNames.hasMoreElements() )
		{
			String name = (String)otherPropNames.nextElement();
			String value = getPropertyValue( name ).toString();
			String typeClassName = JposEntryUtility.shortClassName( value.getClass() );

			sb.append( "\t<prop name=\"" + name + "\" value=\"" + value + 
					   "\" type=\"" + typeClassName +"\"/>\n" );
		}

        sb.append( "</JposEntry>\n" );

        return sb.toString();
    }

    //--------------------------------------------------------------------------
    // Package methods
    //

	/**
	 * Sets the JposRegPopulator that loads/saves this entry.  If null the default
	 * populator is used
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	void setRegPopulator( JposRegPopulator populator ) { regPopulator = populator; }

	//---------------------------------------------------------------------
	// Class methods
	//

	/**
	 * Checks that the Object argument is not null and if it is throw a IllegalArgumentException
	 * @param object the Object argument
	 * @throws java.lang.IllegalArgumentException if the object is null
	 */
	protected static void checkNull( Object object ) throws IllegalArgumentException
	{
		if( object == null ) 
			throw new IllegalArgumentException( "Invalid null argument passed for a JposEntry property value or name" );
	}

    //--------------------------------------------------------------------------
    // Instance variables
    //

    private Hashtable properties = new Hashtable();
	private transient JposRegPopulator regPopulator = null;

	//-------------------------------------------------------------------------
	// Inner classes
	//

	/**
	 * Inner class to represent a property of a JposEntry
	 * @author E. Michael Maximilien
	 * @since 1.3 (Washington DC 2001)
	 */
	public static class Prop implements JposEntry.Prop, Comparable
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		// 

		/**
		 * Creates a JposEntry.Prop object
		 * @param name the name of this property
		 * @param value the value of this property
		 * @throws java.lang.IllegalArgumentException if any of the arguments are null
		 */
		public Prop( String name, Object value ) throws IllegalArgumentException
		{
			checkNull( name );
			checkNull( value );

			this.name = name;
			this.value = value;
			this.typeClass = value.getClass();
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the name of this property */
		public String getName() { return name; }

		/** @return the value of this property (the value is returned as an Object) */
		public Object getValue() { return value; }

		/** @return the value of this property as a String */
		public String getValueAsString() { return String.valueOf( value ); }

		/**
		 * Returns the Class object that is the type of this property value
		 * possible values returned are the java.lang wrapper classes for the
		 * primitive types e.g. Integer, Byte, Boolean, ... 
		 * @return the type of this property as a java.lang.Class object 
		 */
		public Class getType() { return typeClass; }

		/** 
		 * Sets the name of this property 
		 * @param s the String object
         * @throws java.lang.IllegalArgumentException if the argument is null
		 */
		public void setName( String s ) throws IllegalArgumentException
		{ 
			checkNull( s );

			name = s; 
		}

		/** 
		 * Sets the value of this property (String).  Also sets its Type.
		 * <p><b>This is the default type of any property</b></p>
		 * @param objValue the object's value
		 * @throws java.lang.IllegalArgumentException if the value is null or
		 * that this is not a valid typed property value
		 */
		public void setValue( Object objValue ) throws IllegalArgumentException
		{
			checkNull( objValue );

			if( JposEntryUtility.validatePropValue( objValue, objValue.getClass() ) == false )
				throw new IllegalArgumentException( "Cannot set property named = " + getName() + 
													" with value = " + objValue + 
													" invalid value or type" );

			setValue( objValue, objValue.getClass() );
		}

		/** 
		 * @return true if the property is of the type specified by the Class
		 * object passed
		 * @param type the Class object
		 */
		public boolean isOfType( Class type )
		{
			if( type == null || typeClass == null ) return false;

			return typeClass.equals( type );
		}

		/** @return a new copy of this JposEntry.Prop object */
		public JposEntry.Prop copy() { return new SimpleEntry.Prop( getName(), getValue() ); }

		//---------------------------------------------------------------------
		// Public overridden
		//

		/** 
		 * @return true if this and otherProp have same name and value
		 * @param otherProp the other JposEntry.Prop
		 */
		public boolean equals( Object otherProp )
		{
			if( otherProp == null ) return false;

			if( !( otherProp instanceof JposEntry.Prop ) ) return false;

			JposEntry.Prop prop = (JposEntry.Prop)otherProp;

			return ( getName().equals( prop.getName() ) ) &&
				   ( getValue().equals( prop.getValue() ) );
		}

		
		/**
		 * @return 0 if two entries are the same -1 if this is less or 1 of more than other
		 * the comparison for > and < uses the logicalName of the entry to decide
		 * @param otherEntry the other JposEntry
		 */
		public int compareTo( Object other )
		{
			if( other == null || ( (other instanceof JposEntry.Prop ) == false ) )
				throw new RuntimeException( "Cannot compare: " + other + " with JposEntry.Prop: " + this );

			JposEntry.Prop otherEntryProp = (JposEntry.Prop)other;

			if( equals( otherEntryProp ) ) return 0;

			return getName().compareTo( otherEntryProp.getName() );
		}

		/** @return a unique key for this object */
		public int hashCode() { return getName().hashCode(); }

		//---------------------------------------------------------------------
		// Private methods
		//

		/** 
		 * Sets the value of this property as an Object that must match the 
		 * the type specified.  Also sets its Type.
		 * @param object the Object value (must be one of wrapper for primitive types
		 * or java.lang.String)
		 * @param type the java.lang.Class object matching the object type
		 * @throws java.lang.IllegalArgumentException if the object value type does not
		 * match the Class type
		 */
		private void setValue( Object object, Class type ) throws IllegalArgumentException
		{
			checkNull( object );
			checkNull( type );

			if( !object.getClass().equals( type ) )
				throw new IllegalArgumentException( "Value and value type not in agreement for property named = " + name );

			value = object;
			typeClass = type;
		}

		//---------------------------------------------------------------------
		// Instance variables
		//

		private String name = "";
		private Object value = null;
		private Class typeClass = null;
	}

    //--------------------------------------------------------------------------
    // Public constants
    //
    
    /**
     * serialVersionUID constant to maintain serialization compatibility between releases
     * @since 1.3 (SF 2K meeting)
     */
    public static final long serialVersionUID = 6937048853319310114L;
} 
