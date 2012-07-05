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

import java.util.*;
import java.io.*;

import jpos.config.*;

import jpos.util.tracing.Tracer;
import jpos.util.tracing.TracerFactory;

/**
 * This is a simple implementation for the JposEntryRegistry using a Hashtable 
 * to collect the entries.  The entry's logicalName property value is used as 
 * the key to the table and the entry itself as the value
 * @since 0.1 (Philly 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class SimpleEntryRegistry extends Object implements JposEntryRegistry 
{
    /**
     * Default ctor
     * @deprecated no longer used, see the 1 argument ctor 
     * @since 0.1 (Philly 99 meeting)
     */
    public SimpleEntryRegistry() {}

    /**
     * One-argument constructor
     * @param populator the JposRegPopulator used by the registry
     * @since 1.2 (NY 2K meeting)
     */
    public SimpleEntryRegistry( JposRegPopulator populator ) 
    { regPopulator = populator; }

    //--------------------------------------------------------------------------
    // Public methods implementing the JposEntryRegistry interface
    //

    /**
     * @return true if there is an JposEntry with the specified logical name
     * @param logicalName the logical name for the service
     * @since 0.1 (Philly 99 meeting)
     */
    public boolean hasJposEntry( String logicalName ) 
    { return jposEntries.containsKey( logicalName ); }

    /**
     * @return an enumeration of JposEntry objects 
     * @since 0.1 (Philly 99 meeting)
     */
    public Enumeration getEntries() 
	{
		Vector vector = new Vector();
		Enumeration entries = jposEntries.elements(); 

		while( entries.hasMoreElements() )
			vector.addElement( entries.nextElement() );

		return vector.elements();
	}

    /**
     * @return the JposEntry for the logicalName specified
     * @param logicalName the logical name of the JposEntry to find
     * @since 0.1 (Philly 99 meeting)
     */
    public JposEntry getJposEntry( String logicalName ) 
    { return (JposEntry)jposEntries.get( logicalName ); }

    /**
     * Modify the JposEntry with logicalName with the new entry indicated
     * @param logicalName the JposEntry's logical name
     * @param newEntry the new JposEntry
     * @since 0.1 (Philly 99 meeting)
     */
    public void modifyJposEntry( String logicalName, JposEntry newEntry )
    {
        jposEntries.put( logicalName, newEntry ); 
        
		tracer.println( "Modified entry.logicalName = " + logicalName );                							    		                 

		fireJposEntryRegistryEventModified( new JposEntryRegistryEvent( 
											this, newEntry ) );
    }   

    /**
     * Add an JposEntry for the service with logical name specified
     * @param logicalName the logicalName of the service
     * @since 0.1 (Philly 99 meeting)
     */
    public void addJposEntry( String logicalName, JposEntry entry ) 
    { 
        jposEntries.put( logicalName, entry );
        		
		tracer.println( "Added entry.logicalName = " + logicalName );                							    		         

		fireJposEntryRegistryEventAdded( new JposEntryRegistryEvent( 
										 this, entry ) );
    }

    /**
     * Add an JposEntry for the service.  The logical name is obtained 
     * from the entry
	 * @param entry the JposEntry to add
	 * @see jpos.config.JposEntry#getLogicalName()
     * @since 1.3 (Washington DC 2001 meeting)
     */
    public void addJposEntry( JposEntry entry )
	{
		addJposEntry( entry.getLogicalName(), entry );
	}

    /**
     * Removes the specified JposEntry 
     * @param entry the entry to remove
     * @since 0.1 (Philly 99 meeting)
     */
    public void removeJposEntry( JposEntry entry ) 
    {
        Enumeration entries = jposEntries.elements();

        while( entries.hasMoreElements() )
        {
            JposEntry jposEntry = (JposEntry)entries.nextElement();

            if( jposEntry.hasPropertyWithName( JposEntry.
            								   LOGICAL_NAME_PROP_NAME ) )
            {
                JposEntry removedEntry = (JposEntry)jposEntries.
                remove( entry.getPropertyValue( JposEntry.
                							    LOGICAL_NAME_PROP_NAME ) );

		        tracer.println( "Removed entry.logicalName = " + 
                                entry.getLogicalName() );                							    
                							    
                fireJposEntryRegistryEventRemoved( new JposEntryRegistryEvent( 
                								   this, removedEntry ) );				
				
                return;
            }
        }
        
        tracer.println( "Could not find entry to remove entry.logicalName = " + 
                        entry.getLogicalName() );
    }

    /**
     * Removes the JposEntry with the logicalName specified 
     * @param logicalName the JposEntry's logical name
     * @since 0.1 (Philly 99 meeting)
     */
    public void removeJposEntry( String logicalName ) 
    {
        JposEntry entry = (JposEntry)jposEntries.get( logicalName );

        if( entry != null )
        {
            jposEntries.remove( logicalName ); 

            fireJposEntryRegistryEventRemoved( new JposEntryRegistryEvent( 
            								   this, entry ) );
        }
    }

    /**
     * Adds a new JposEntryRegistryListener to the list of listeners
     * @param l the JposEntryRegistryListener object
     * @since 0.1 (Philly 99 meeting)
     */
    public void addJposEntryRegistryListener( JposEntryRegistryListener l ) 
    { listeners.addElement( l ); }
                                    
    /**
     * Removes a new JposEntryRegistryListener to the list of listeners
     * @param l the JposEntryRegistryListener object
     * @since 0.1 (Philly 99 meeting)
     */
    public void removeJposEntryRegistryListener( JposEntryRegistryListener l ) 
    { listeners.removeElement( l ); }
   
    /**
     * Tell the JposEntryRegistry to save the current entries 
     * NOTE: the actual implementation will save it in dependent manner
     * @since 0.1 (Philly 99 meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    public void save() throws Exception 
    { getRegPopulator().save( getEntries() ); }
    
    /**
     * Tell the JposEntryRegistry to save the current entries to the file 
     * specified.  Depending on the current JposEntryPopulator the file might
     * be an XML or serialized or other file.
     * @since 2.1.0
     * @throws java.lang.Exception if any error occurs while saving or if the
     * current populator does not support saving in a file
     */
    public void saveToFile( File file ) throws Exception
    { getRegPopulator().save( getEntries(), file.getCanonicalPath() ); }

    /**
     * @return the JposRegPopulator for this registry
     * @since 1.2 (NY 2K meeting)
     */
    public JposRegPopulator getRegPopulator() { return regPopulator; }

    /**
     * Loads the JposEntryRegistry using the current populator
     * NOTE: if no entries are found or an error occurs then the 
     * registry is empty
     * @since 1.2 (NY 2K meeting)
     */
    public void load() 
    { 
        getRegPopulator().load();
        jposEntries.clear();

        Enumeration entries = getRegPopulator().getEntries();

        while( entries.hasMoreElements() )
        {
            try
            {
                JposEntry jposEntry = (JposEntry)entries.nextElement();

                jposEntries.put( jposEntry.
                				 getPropertyValue( JposEntry.
                				 				   LOGICAL_NAME_PROP_NAME ),
				                                   jposEntry );
            }
            catch( Exception e ) { tracer.print( e ); }
        }

		loaded = true;
    }

	/**
	 * @return the current size of the registry 
	 * @since 1.3 (Tokyo 2001 meeting)
	 */
	public int getSize() { return jposEntries.size(); }

	/**
	 * @return true if the registry has already been loaded or false otherwise
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public boolean isLoaded() { return loaded; }

	//-------------------------------------------------------------------------
	// Public methods
	//

	/**
	 * @return a String with a list of all logical name of entries in the registry
	 * as well as the registry size and populator name
	 */
	public String toString()
	{
		StringBuffer sb = new StringBuffer();

		sb.append( "<SimpleEntryRegistry>\n" );

		sb.append( "<size=\"" + getSize() + "\"\n/>" );
		sb.append( "<populatorUniqueId=\"" + getRegPopulator().
											 getUniqueId() + "\"\n/>" );
		sb.append( "numberOfListeners=\"" + listeners.size() + "\"\n/>" );

		sb.append( "<entries>\n" );

		Enumeration entries = getEntries();
		int count = 0;

		while( entries.hasMoreElements() )
		{
			sb.append( "<entry" + count + ".LogicalName=\"" + 
			           ( (JposEntry)entries.nextElement() ).
			           getLogicalName() + "\"\n/>" );
			count++;
		}

		sb.append( "</entries>\n" );

		sb.append( "</SimpleEntryRegistry>\n" );

		return sb.toString();
	}

    //-------------------------------------------------------------------------
    // Protected methods
    //

    /**
     * Fires a new JposEntryRegistry event when a new JposEntry is added
     * @param e the JposEntryRegistryEvent object to fire
     * @since 0.1 (Philly 99 meeting)
     */
    protected void fireJposEntryRegistryEventAdded( JposEntryRegistryEvent e )
    {
    	tracer.println( "fireJposEntryRegistryEventAdded: " + 
    	                "e.getJposEntry().logicalName = " + 
    	                e.getJposEntry().getLogicalName() );    	
    	
        Vector listenersClone = (Vector)listeners.clone();

        synchronized( listenersClone )
        {
            for( int i = 0; i < listenersClone.size(); ++i )
                ((JposEntryRegistryListener)listenersClone.elementAt( i ) ).
                jposEntryAdded( e );
        }
    }

    /**
     * Fires a new JposEntryRegistry event when a new JposEntry is added
     * @param e the JposEntryRegistryEvent object to fire
     * @since 0.1 (Philly 99 meeting)
     */
    protected void fireJposEntryRegistryEventRemoved( JposEntryRegistryEvent e )
    {
    	tracer.println( "fireJposEntryRegistryEventRemoved: " + 
    	                "e.getJposEntry().logicalName = " + 
    	                e.getJposEntry().getLogicalName() );
    	
        Vector listenersClone = (Vector)listeners.clone();

        synchronized( listenersClone )
        {
            for( int i = 0; i < listenersClone.size(); ++i )
                ((JposEntryRegistryListener)listenersClone.elementAt( i ) ).
                jposEntryRemoved( e );
        }
    }

    /**
     * Fires a new JposEntryRegistry event when a JposEntry is modified
     * @param e the JposEntryRegistryEvent object to fire
     * @since 0.1 (Philly 99 meeting)
     */
    protected void fireJposEntryRegistryEventModified( JposEntryRegistryEvent e )
    {
    	tracer.println( "fireJposEntryRegistryEventModified: " + 
    	                "e.getJposEntry().logicalName = " + 
    	                e.getJposEntry().getLogicalName() );    	
    	
        Vector listenersClone = (Vector)listeners.clone();

        synchronized( listenersClone )
        {
            for( int i = 0; i < listenersClone.size(); ++i )
                ((JposEntryRegistryListener)listenersClone.elementAt( i ) ).
                jposEntryModified( e );
        }
    }

    //--------------------------------------------------------------------------
    // Instance variables
    //

    public Hashtable jposEntries = new Hashtable();
    private Vector listeners = new Vector();
    private JposRegPopulator regPopulator = null;
	private boolean loaded = false;
	
	private Tracer tracer = TracerFactory.getInstance().
	                         createTracer( "SimpleEntryRegistry" );
}
