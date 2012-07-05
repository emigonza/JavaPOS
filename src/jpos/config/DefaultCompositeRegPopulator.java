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

import java.util.*;
import java.lang.reflect.*;
import java.net.URL;

import jpos.loader.*;
import jpos.util.*;
import jpos.util.tracing.Tracer;
import jpos.util.tracing.TracerFactory;

/**
 * Default implementation of the CompositeRegPopulator interface
 * @since 1.3 (Washington DC 2001 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class DefaultCompositeRegPopulator extends Object 
										   implements CompositeRegPopulator
{
    //-------------------------------------------------------------------------
    // Ctor(s)
    //

	/**
	 * Creates a CompositePopulator with a null default populator 
	 * NOTE: you must set the default populator before this is usable or
	 * call the load() method which will set the default populator from
	 * the multi-property in the jpos.properties file if that file exist
	 */
	public DefaultCompositeRegPopulator() {}

	/**
	 * Creates a CompositePopulator with a default populator 
	 * @param populator the default populator for this composite
	 */
	public DefaultCompositeRegPopulator( JposRegPopulator populator ) 
	{
		add( populator );
		setDefaultPopulator( populator );
	}

    //-------------------------------------------------------------------------
    // Private methods
    //

	/** 
	 * @return a JposPopulator using the popName as unique ID, populator class name passed
	 * If could not create the populator then returns null and add a trace info
	 * @param popName the unique ID for this populator
	 * @param className the JposRegPopulator implementing class name
	 */
	private JposRegPopulator createPopulator( String popName, String className )
	{
		JposRegPopulator populator = null;

		try
		{
			Class popClass = Class.forName( className );

			try
			{
				Class[] ctorParamTypes = { String.class };
				Constructor ctor = popClass.getConstructor( ctorParamTypes );

				Object[] args = { popName };
				populator = (JposRegPopulator)ctor.newInstance( args );
			}
			catch( NoSuchMethodException nsme )
			{
				Constructor ctor = popClass.getConstructor( new Class[ 0 ] );
				populator = (JposRegPopulator)ctor.newInstance( new Object[ 0 ] );
			}

		}
		catch( ClassNotFoundException cnfe )
		{ 
			tracer.println( "Could not find populator class with name: " + 
										  className + " exception message = " + 
										  cnfe.getMessage() );
		}
		catch( NoSuchMethodException nsme )
		{
			tracer.println( "Populator by class name: " + 
			                className +
							" must define a no-arg ctor or a 1-arg ctor with String param as the unique ID" );
		}
		catch( InstantiationException ie )
		{
			tracer.println( "Could not instantiate populator class with name: " + 
						    className + " exception message = " + 
							ie.getMessage() );
		}
		catch( Exception e )
		{
			tracer.println( "Could not instantiate populator class with name: " + 
							className + " exception message = " + 
							e.getMessage() );
		}

		return populator;
	}

    //-------------------------------------------------------------------------
    // Protected methods
    //

	/**
	 * Sets the default JposRegPopulator.  Orphan JposEntry objects (that is the ones that
	 * do not have a JposRegPopulator) are automatically assign to this one.
	 * @param populator the JposRegPopulator
	 * @throws java.lang.IllegalArgumentException if the argument is null or not a valid JposRegPopulator
	 */
	protected void setDefaultPopulator( JposRegPopulator populator ) throws IllegalArgumentException
	{
		if( populator == null )
			throw new IllegalArgumentException( "Null value cannot be used for default JposRegPopualtor" );

		if( populator.getUniqueId() == null || "".equals( populator.getUniqueId() ) )
			throw 
			new IllegalArgumentException( "Default JposRegPopualtor cannot have a unique ID of null or empty string" );

		add( populator );

		defaultPop = populator;
	}

    //-------------------------------------------------------------------------
    // Public JposRegPopulator methods
    //

	/**
	 * @return a unique String ID for this JposRegPopulator instance
	 * Can be implemented in terms of the getClassName() method
	 */
	public String getUniqueId() { return getClassName(); }

	/** 
	 * @return the fully qualified class name implementing the 
	 * JposRegPopulator interface 
	 */
	public String getClassName() 
	{ return DefaultCompositeRegPopulator.class.getName(); }

    /**
     * Tell the populator to save the current entries 
     * @param entries an enumeration of JposEntry objects
     * @throws java.lang.Exception if any error occurs while saving
     */
    public void save( Enumeration entries ) throws Exception
	{
		HashMap popEntriesMap = new HashMap();
		
		Iterator popIterator = popMap.values().iterator();
		while( popIterator.hasNext() )
			popEntriesMap.put( ( (JposRegPopulator)popIterator.next() ).
			                   getUniqueId(),
							   new ArrayList() );

		while( entries.hasMoreElements() )
		{
			JposEntry entry = (JposEntry)entries.nextElement();

			JposRegPopulator populator = (JposRegPopulator)entry.
			                             getRegPopulator();

			if( populator == null )
			{
				Collection defaultEntryList = (Collection)popEntriesMap.
				                              get( getDefaultPopulator().
				                              getUniqueId() );
				defaultEntryList.add( entry );
			}
			else
			{
				Collection entryList = (Collection)popEntriesMap.
				                       get( populator.getUniqueId() );
				
				if( entryList == null )
					tracer.println( "Trying to save entry with logicalName = " +
							        entry.getLogicalName() + 
							        " and populator with" );
				else
					entryList.add( entry );
			}
		}

		Exception exception = null;
		popIterator = popMap.values().iterator();
		while( popIterator.hasNext() )
		{
			JposRegPopulator populator = (JposRegPopulator)popIterator.next();
			String popUniqueId = populator.getUniqueId();
			Collection entryList = (Collection)popEntriesMap.get( popUniqueId );

			try
			{
				if( popFileMap.get( populator.getUniqueId() ) != null )
					populator.save( new Vector( entryList ).elements(),
									(String)popFileMap.get( populator.getUniqueId() ) );
				else
					populator.save( new Vector( entryList ).elements() );
			}
			catch( Exception e )
			{
				exception = e;
				tracer.println( "Error while saving to populator with unique ID:" +
							    populator.getUniqueId() );
			}
		}

		if( exception != null ) throw exception;
	}

    /**
     * Tell the populator to save the current entries in the file specified using
	 * the default JposRegPopulator
     * @param entries an enumeration of JposEntry objects
     * @param fileName the file name to save entries
     * @throws java.lang.Exception if any error occurs while saving
     */
    public void save( Enumeration entries, String fileName ) throws Exception
	{
		getDefaultPopulator().save( entries, fileName );
	}

    /**
     * Tell the populator to load the entries.  Looks for 2 multi-properties for the 
	 * populator class and populator file name called:
     * jpos.config.populator.class.0	 
     * jpos.config.populator.file.0 	 
	 * All entries are loaded by using the file name in the properties file for each
	 * populator defined in the JposEntryProperties.
     */
    public void load()
	{
        JposProperties jposProperties = JposServiceLoader.getManager().getProperties();

		JposProperties.MultiProperty populatorClassMultiProp = 
		jposProperties.getMultiProperty( JposProperties.JPOS_CONFIG_POPULATOR_CLASS_MULTIPROP_NAME );

		JposProperties.MultiProperty populatorFileMultiProp = 
		jposProperties.getMultiProperty( JposProperties.JPOS_CONFIG_POPULATOR_FILE_MULTIPROP_NAME );

		if( populatorClassMultiProp.getNumberOfProperties() == 0 )
		{
			tracer.println( "CompositeRegPopulator.load() w/o any defined multi-property" );
			throw new RuntimeException( "CompositeRegPopulator.load() w/o any defined multi-property" );
		}

		Iterator popClasses = populatorClassMultiProp.getSortedPropertyNames();

		String defaultPopName = (String)popClasses.next();
		String defaultPopClass = populatorClassMultiProp.getPropertyString( defaultPopName );
		int defaultPopClassNumber = populatorClassMultiProp.propertyNumber( defaultPopName );

		JposRegPopulator defaultPopulator = createPopulator( defaultPopName, defaultPopClass );

		if( populatorFileMultiProp != null && populatorFileMultiProp.getNumberOfProperties() > 0 )
		{
			String defaultPopFile = (String)populatorFileMultiProp.getPropertyString( defaultPopClassNumber );

			if( defaultPopFile != null )
			{
				defaultPopulator.load( defaultPopFile );
				lastLoadException = defaultPopulator.getLastLoadException();
				popFileMap.put( defaultPopulator.getUniqueId(), defaultPopFile );
			}
			else
			{
				tracer.println( "Created default populator with name = " + defaultPopName + 
											  " OK but populator file is null" );
				defaultPopulator.load();
				lastLoadException = defaultPopulator.getLastLoadException();
			}
		}
		else
		{
			defaultPopulator.load();
			lastLoadException = defaultPopulator.getLastLoadException();
		}

		if( defaultPopulator != null )
			setDefaultPopulator( defaultPopulator );
		else
			tracer.println( "Did not add default populator by <name, className>: " +
										  "<" + defaultPopName + ", " + defaultPopClass + ">" );
		while( popClasses.hasNext() )
		{
			String popName = (String)popClasses.next();
			String popClass = populatorClassMultiProp.getPropertyString( popName );
			int popClassNumber = populatorClassMultiProp.propertyNumber( popName );

			JposRegPopulator populator = createPopulator( popName, popClass );

			if( populator != null )
			{
				if( populatorFileMultiProp != null && populatorFileMultiProp.getNumberOfProperties() > 0 )
				{
					String popFile = (String)populatorFileMultiProp.getPropertyString( popClassNumber );
					populator.load( popFile );
					popFileMap.put( populator.getUniqueId(), popFile );
				}
				else
				{
					tracer.println( "Created populator with name = " + popName + 
												  " OK but populator file is null" );
					populator.load();
					lastLoadException = populator.getLastLoadException();
				}

                add( populator );
			}
			else
				tracer.println( "Did not add populator by <name, className>: " +
											  "<" + popName + ", " + popClass + ">" );
		}
	}

    /**
     * Loads the entries specified in the fileName for the default populator
     * @param fileName the entries file name
     */
    public void load( String fileName ) { getDefaultPopulator().load( fileName ); }

    /** @return the URL pointing to the entries file loaded or saved */
    public URL getEntriesURL() { return this.getDefaultPopulator().getEntriesURL(); }

    /** 
	 * @return an Enumeration of JposEntry objects 
	 * NOTE: this method is O(nm) where n == number of populators and m == average
	 * number of entries in populator.  Could do better by keeping more data structure
	 * but not worth it if n and m are small (as expected in typical system)
	 */
    public Enumeration getEntries()
	{
		Vector entryVector = new Vector();
		Iterator populators = getPopulators();

		while( populators.hasNext() )
		{
			JposRegPopulator pop = (JposRegPopulator)populators.next();

			Enumeration entries = pop.getEntries();
			while( entries.hasMoreElements() )
				entryVector.add( entries.nextElement() );
		}

		return entryVector.elements();
	}

	/**
	 * @retun true if this populator is a composite populator or false otherwise
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public boolean isComposite() { return true; }

	/**
	 * @return the name of this populator.  This should be a short descriptive name
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getName() { return COMPOSITE_REG_POPULATOR_STRING; }

	/**
	 * @return the last exception (if any) during the last load or null if no exception occurred
	 * @since 2.0.0
	 */
	public Exception getLastLoadException() { return lastLoadException; }

	/**
	 * @return a String representation of this JposRegPopulator
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String toString() { return getName(); }

    //-------------------------------------------------------------------------
    // Public methods
    //

	/** @return the default JposRegPopulator */
	public JposRegPopulator getDefaultPopulator() { return defaultPop; }

    /**
	 * Adds this JposRegPopulator to the composite
	 * @param populator adds the populator to the composite reg populator.  Does nothing
	 * if the popualator already is in the composite
	 */
	public void add( JposRegPopulator populator ) { popMap.put( populator.getUniqueId(), populator ); }

	/**
	 * Removes this JposRegPopulator from the composite
	 * @param populator removes the populator to the composite reg populator
	 */
	public void remove( JposRegPopulator populator ) { popMap.remove( populator.getUniqueId() ); }

	/** @return an iterator over all populators in this composite */
	public Iterator getPopulators() { return popMap.values().iterator(); }

	/** 
	 * @return the populator with unique ID passed
	 * @param uniqueId the populator unique ID
	 * @see jpos.config.JposRegPopulator#getUniqueId()
	 */
	public JposRegPopulator getPopulator( String uniqueId ) 
	{ return (JposRegPopulator)popMap.get( uniqueId ); }

	/** @return the number of populator in this composite */
	public int size() { return popMap.size(); }

    //-------------------------------------------------------------------------
    // Instance variables
    //

	private HashMap popMap = new HashMap();
	private HashMap popFileMap = new HashMap();
	private JposRegPopulator defaultPop = null;
	private Exception lastLoadException = null;
	
	private Tracer tracer = TracerFactory.getInstance().
							 createTracer( "DefaultCompositeRegPopulator" );
}