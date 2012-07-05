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

import java.io.*;
import java.util.*;

/**
 * Default implementation of the JposProperties interface
 * Loads/looks for the Jpos properties from the System properties and
 * from the jpos/res/jpos.properties files
 * NOTE: changed so that the properties are no longer loaded via the ResourceBundle
 * class but instead though the System class
 * @since 1.2 (NY 2K 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class DefaultProperties extends Object implements JposProperties 
{
    //-------------------------------------------------------------------------
    // Public methods
    //

    /**
     * Loads the jpos.properties file from the "./jpos/res" directory
     * @since 1.2 (NY 2K meeting)
     */
    public void loadJposProperties()
    {
		loadJposPropertiesByName( JposProperties.JPOS_PROPERTIES_FILENAME );
    }

	/**
	 * @return true if the properties are loaded
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public boolean isLoaded() { return loaded; }

	/** 
	 * @return the last Exception wile loading if any otherwise null 
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public Exception getLastException() { return lastException; }

    /**
     * @return the String property by name specified looking in System then the "jpos.properties" resource bundle
     * @param propName the property name to search for
     * @since 1.2 (NY 2K meeting)
     */
    public String getPropertyString( String propName )
    {
        String propValue = "";

        if( System.getProperties().containsKey( propName ) )
            propValue = System.getProperties().getProperty( propName );
        else
        if( jposProperties != null )
            propValue = jposProperties.getProperty( propName );

        return propValue;
    }

    /**
     * @return true if this property is defined in the Java System properties or in
     * the jpos.properties resource file
     * @param propName the property name to look for
     * @since 1.2 (NY 2K meeting)
     */
    public boolean isPropertyDefined( String propName )
    {
        if( System.getProperties().containsKey( propName ) )
            return true;

        if( jposProperties != null )
        {
            Enumeration keys = jposProperties.keys();

            while( keys.hasMoreElements() )
            {
                String key = (String)keys.nextElement();

                if( key.equals( propName ) )
                    return true;
            }
        }

        return false;
    }

    /**
     * @return an enumeration of properties names defined
     * @since 1.2 (NY 2K meeting)
     */
    public Enumeration getPropertyNames() { return getJposProperties().keys(); }

	/**
	 * @return the MultiProperty by the name passed.  MultiProperty are properties
	 * named like <propName>.<n> where n = 0, 1, ...  If the multi-property does not
	 * exist then null is returned
	 * @param multiPropName the multi-property name
	 * @since 1.3 (Wahington DC 2001 meeting)
	 */
	public JposProperties.MultiProperty getMultiProperty( String multiPropName )
	{ return (JposProperties.MultiProperty)multiPropMap.get( multiPropName ); }

	/**
	 * @return true if the MultiProperty by the name passed exist otherwise false
	 * @param multiPropName the multi-property name
	 * @since 1.3 (Wahington DC 2001 meeting)
	 */
	public boolean hasMultiProperty( String multiPropName )
	{ return multiPropMap.containsKey( multiPropName ); }

	/**
	 * @return the number of properties in this JposProperties
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public int size() { return jposProperties.size(); }
	
    /**
     * @return a List of property value parsed from the property value found
     * for the property name.  The value is expected to be a list of comma 
     * separated values
     * @param propName the property name for which the values will be parsed from
     * @since 2.1.0
     */
	public List getStringListProperty( String propName )
	{
		String propValue = getPropertyString( propName );
		List list = new ArrayList();
		
		if( propValue == null ) return list;
		
		StringTokenizer st = new StringTokenizer( propValue, STRING_LIST_SEPARATOR );
		
		while( st.hasMoreTokens() )
			list.add( st.nextToken() );
		
		return list;
	}

    //-------------------------------------------------------------------------
    // Public overridden methods
    //

	/**
	 * @return a formated String representation list all properties with names
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String toString()
	{
		StringBuffer sb = new StringBuffer();

		sb.append( "<JposProperties>\n" );

        Enumeration propNames = getPropertyNames();

		List list = new ArrayList();

        while( propNames.hasMoreElements() )
			list.add( propNames.nextElement() );

		Collections.sort( list );

		Iterator iterator = list.iterator();

        while( iterator.hasNext() )
        {
            String propName = (String)iterator.next();
            String propValue = (String)getPropertyString( propName );

            sb.append( "<name = \"" + propName + "\"" + " value = \"" + propValue + "\" />\n" );
        }

		sb.append( "</JposProperties>\n" );

		return sb.toString();
	}

    //-------------------------------------------------------------------------
    // Public class methods
    //

	/**
	 * @return a Comparator object to compare 2 JposProperties.Prop objects
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public static Comparator propComparator()
	{
		if( propComparator == null )
			propComparator = 	new Comparator()
								{
									public int compare( Object o1, Object o2 ) 
									{
										if( !( o1 instanceof JposProperties.Prop ) ) return -1;
										if( !( o2 instanceof JposProperties.Prop ) ) return -1;

										String o1Name = ( (JposProperties.Prop)o1 ).getName();
										String o2Name = ( (JposProperties.Prop)o2 ).getName();

										return o1Name.compareTo( o2Name );
									}
								};


		return propComparator;
	}

	/**
	 * @return an Iterator of valid property names
	 * @since 1.3 (Washington DC 2001)
	 */
	public static Iterator getDefinedPropertyNames()
	{
		List list = new ArrayList();

		for( int i = 0; i < PROP_NAME_ARRAY.length; ++i )
			list.add( PROP_NAME_ARRAY[ i ] );

		return list.iterator();
	}

    //-------------------------------------------------------------------------
    // Protected methods
    //

	/**
	 * Creates the set of MultiProperty from the loaded properties
     * @since 1.3 (Washington DC 2001 meeting)
	 */
	protected void createMultiProperties()
	{
		Enumeration propNames = jposProperties.keys();

		while( propNames.hasMoreElements() )
		{
			String propName = (String)propNames.nextElement();
			String propValue = (String)jposProperties.get( propName );

			if( isMultiProp( propName ) )
			{
				String multiPropBaseName = getMultiPropBaseName( propName );
				if( multiPropMap.containsKey( multiPropBaseName ) )
				{
					MultiProp multiProp = (MultiProp)multiPropMap.get( multiPropBaseName );
					multiProp.add( propName, propValue );
				}
				else
				{
					MultiProp multiProp = this.new MultiProp( multiPropBaseName );
					multiProp.add( propName, propValue );
					multiPropMap.put( multiPropBaseName, multiProp );
				}
			}
		}
	}

	/** 
	 * @return true if the propName passed is a multi-property
	 * @param propName the property name 
     * @since 1.3 (Washington DC 2001 meeting)
	 */
	protected boolean isMultiProp( String propName )
	{
		if( propName.indexOf( "." ) == -1 )
			return false;

		int dotIndex = propName.lastIndexOf( "." );

		String numberString = propName.substring( dotIndex + 1 );
		int number = -1;

		try{ number = Integer.parseInt( numberString ); }
		catch( NumberFormatException nfe ) { number = -1; }

		if( number < 0 ) return false;

		return true;
	}

	/**
	 * @return the base name of the multi-property that the propName belongs to
	 * @param propName the multi-property name 
     * @since 1.3 (Washington DC 2001 meeting)
	 * @throws java.lang.IllegalArgumentException if the argument is not a multi-property
	 */
	protected String getMultiPropBaseName( String propName ) throws IllegalArgumentException
	{
		if( !isMultiProp( propName ) )
			throw new IllegalArgumentException( "getMultiPropBaseName( propName ) expects a propName that is a MuliProp" );

		return propName.substring( 0, propName.lastIndexOf( "." ) );
	}

	/**
	 * @return an iterator of JposProperties.Prop for all the properties in this
	 * JposProperties.  Changes to these properties do not affect the JposProperties properties
	 * @see jpos.util.JposProperties.Prop
	 * @since 1.3 (Washington DC 2001)
	 */
	public Iterator getProps()
	{
		List list = new ArrayList();

		Enumeration names = getPropertyNames();
		while( names.hasMoreElements() )
		{
			String name = (String)names.nextElement();
			String value = getPropertyString( name );

			JposProperties.Prop prop = new DefaultProperties.Prop( name, value );
			list.add( prop );
		}

		return list.iterator();
	}

    //-------------------------------------------------------------------------
    // Package methods
    //

    /**
     * Loads the JposProperties from the fileName specified
     * @since 1.3 (Washington DC 2001 meeting)
     */
    void loadJposPropertiesByName( String propFileName )
    {
		loaded = false;
		lastException = null;

		jposProperties = findProperties( propFileName );

		createMultiProperties();
    }

	/**
	 * @return the properties file name that was loaded or "" if none was loaded
	 * @since 1.3 (Washington DC 20001 meeting)
	 */
	String getLoadedPropFileName() { return loadedPropFileName; }

    /**
     * @return the jposProerties loading it if necessary
	 * @since 1.3 (SF-2K meeting)
     */
    Properties getJposProperties()
    {
        if( jposProperties == null )
            loadJposProperties();

        return jposProperties;
    }

    /**
     * @return a Properties object loaded with the properties file passed
     * Looks for the properties file in the current set JAR or Zip files
     * @param propFileName the properties file name
	 * @since 1.3 (SF-2K meeting)
     */
    Properties findProperties( String propFileName )
    {
        Properties properties = new Properties();
        loadedPropFileName = propFileName;

		InputStream is = getClass().getClassLoader().getResourceAsStream( loadedPropFileName );

        if( is != null ) 
        {
            is = new BufferedInputStream( is );

            try 
            {
                properties.load( is );
                loaded = true;
            }
            catch( Exception e ) 
            {
                loaded = false;
				loadedPropFileName = "";
                lastException = e;
            }
            finally 
            {
                try{ is.close(); }
                catch( Exception e ) 
				{ System.err.println( "Unexpected exception while closing stream Exception.message = " + e.getMessage() ); }
            }
        }
        else
        {
            loaded = false;
            System.err.println( propFileName + " file not found" );
        }

        return properties;
    }

    //-------------------------------------------------------------------------
    // Private instance variables
    //

    private Properties jposProperties = null;
	private HashMap multiPropMap = new HashMap();

	private String loadedPropFileName = "";

	private boolean loaded = false;
	private Exception lastException = null;

    //-------------------------------------------------------------------------
    // Class variables
    //

	private static Comparator propComparator = null;

	//-------------------------------------------------------------------------
	// Inner classes
	//

	/**
	 * Default implementation of the jpos.util.JposProperties interface
	 * Speficies an interface used for returning multi properties.  That is
	 * properties that are named like <name>.x where x = 0, 1, ...x
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	class MultiProp extends Object implements JposProperties.MultiProperty
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/**
		 * Creates a DefaultMultiProp with base prop name passed
		 * @param s the String base prop name
		 */
		MultiProp( String s )
		{
			basePropName = s;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** 
		 * @return the base property name for this multi-property that is the
		 * name w/o the number suffix
		 */
		public String getBasePropertyName() { return basePropName; }

		/** @return an iterator of the property names for this multi-property */
		public Iterator getPropertyNames() { return propMap.keySet().iterator(); }

		/** @return an iterator of the property names alphabetically sorted for this multi-property */
		public Iterator getSortedPropertyNames() 
		{ 
			List namesList = new ArrayList( propMap.keySet() );

			Collections.sort( namesList );

			return namesList.iterator();
		}

		/** @return an iterator of the property values for this multi-property */
		public Iterator getPropertyValues() { return propMap.values().iterator(); }

		/**
		 * @return the value for this property from the full property name
		 * @param propName the full property name <name>.x
		 */
		public String getPropertyString( String propName )
		{ return (String)propMap.get( propName ); }

		/**
		 * @return the value for this property from the full property name
		 * @param number suffix for the property name
		 * @throws java.lang.IllegalArgumentException if the i negative
		 */
		public String getPropertyString( int i ) throws IllegalArgumentException
		{
			if( i < 0 )
				throw new IllegalArgumentException( "Cannot find property in multiprop with number i = " + i );

			return getPropertyString( getBasePropertyName() + "." + i ); 
		}															

		/** @return the number of properties defined in this multi-property */
		public int getNumberOfProperties() { return propMap.size(); }

		/** 
		 * @return the number of this property name that is for property <propName>.x returns x 
		 * @param propName the property name to get the number of
		 * @throws java.lang.IllegalArgumentException if the property name does not follow the <propName>.x name pattern
		 */
		public int propertyNumber( String propName ) throws IllegalArgumentException
		{
			return validatePropName( propName );
		}

		//---------------------------------------------------------------------
		// Package methods
		//

		/** 
		 * Validates that propName passed is valid for this multi-prop
		 * @return the number of this property
		 * @throws java.lang.IllegalArgumentException if propName is not valid
		 */
		int validatePropName( String propName ) throws IllegalArgumentException
		{
			if( !propName.startsWith( getBasePropertyName() + "." ) )
				throw new IllegalArgumentException( "propName = " + propName + " passed does not match base prop name of " + getBasePropertyName() );

			if( propName.endsWith( "." ) )
				throw new IllegalArgumentException( "propName = " + propName + " passed must end with a pattern .<number>" );

			String numberString = propName.substring( propName.lastIndexOf( "." ) + 1 );

			int number = 0;

			try{ number = Integer.parseInt( numberString ); }
			catch( NumberFormatException nfe )
			{ throw new IllegalArgumentException( "propName = " + propName + " passed must end with a pattern .<number>" ); }

			return number;
		}

		/**
		 * Adds a new <propName, propValue> to this multi property
		 * @param propName the property name
		 * @param propValue the property value
		 * @throws java.lang.IllegalArgumentException if the propName does not match the base prop name
		 */
		void add( String propName, String propValue ) throws IllegalArgumentException
		{
			validatePropName( propName );
			propMap.put( propName, propValue );
		}

		/**
		 * Removes existing property by name propName.  If property does not exist does nothing
		 * @return the propValue of the property removed or null if not found
		 * @param propName the property name
		 */
		String remove( String propName ) { return (String)propMap.remove( propName ); }

		//---------------------------------------------------------------------
		// Instance variables
		//

		private String basePropName = "";
		private HashMap propMap = new HashMap();
	}

	/**
	 * Simple wrapper class for a property pair <name, value>
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 * @since 1.3 (Washington DC 2001)
	 */
	public static class Prop extends Object implements JposProperties.Prop
	{
		//---------------------------------------------------------------------
		// Ctor
		//

		/**
		 * Creates a new Prop with name and value passed
		 * @param name this prop's name
		 * @param value this prop's value
		 */
		public Prop( String name, String value )
		{
			this.name = name;
			this.value = value;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the name of this property */
		public String getName() { return name; }

		/** @return the value of this property */
		public String getValue() { return value; }

		/**
		 * Sets the value of this property 
		 * @param s the new prop name
		 */
		public void setName( String s ) { name = s; }

		/** 
		 * Sets the value of this property 
		 * @param s the name String
		 */
		public void setValue( String s ) { value = s; }

		/**
		 * @return 0 if 2 objects same -1 if this is less or +1 if this is more than other
		 * @param other the other object to compare against this
		 */
		public int compareTo( JposProperties.Prop other )
		{
			if( other == null ) return -1;

			return getName().compareTo( ( (JposProperties.Prop)other ).getName() );
		}

		/**
		 * @return 0 if 2 objects same -1 if this is less or +1 if this is more than other
		 * @param other the other object to compare against this
		 */
		public int compareTo( Object other )
		{
			return compareTo( (JposProperties.Prop)other );
		}

		//---------------------------------------------------------------------
		// Public overridden methods
		//

		/**
		 * @return true if this is logically equivalent to the other Prop
		 * @param otherProp the other Prop object
		 */
		public boolean equals( Object otherProp )
		{
			if( otherProp == null ) return false;

			if( !( otherProp instanceof JposProperties.Prop ) ) return false;

			JposProperties.Prop prop = (JposProperties.Prop)otherProp;

			return ( getName().equals( prop.getName() ) && getValue().equals( prop.getValue() ) );
		}

		/** @return a String representation of this property */
		public String toString()
		{
			return "<name = " + getName() + ", value = " + getValue() + ">";
		}

		//---------------------------------------------------------------------
		// Instance variables
		//

		private String name = "";
		private String value = "";
	}
	
	//-------------------------------------------------------------------------
	// Public static constants
	//
	
	public static final String STRING_LIST_SEPARATOR = ",";
}