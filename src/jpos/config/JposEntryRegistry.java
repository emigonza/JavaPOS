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

import java.util.Enumeration;
import java.io.File;

/**
 * This interface defines the populator used by the service connection
 * and the JposServiceFactory to access the JavaPOS JposEntry objects.
 * It also allows a consistent place to aggregates the defined JposEntry
 * and allows for dynamic updates of the current set of JposEntry objects.
 * @since 0.1 (Philly 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface JposEntryRegistry
{
    /**
     * @return true if there is an JposEntry with the specified logical name
     * @param logicalName the logical name for the service
     * @since 0.1 (Philly 99 meeting)
     */
    public boolean hasJposEntry( String logicalName );

    /**
     * @return an enumeration of JposEntry objects 
     * @since 0.1 (Philly 99 meeting)
     */
    public Enumeration getEntries();

    /**
     * @return the JposEntry for the logicalName specified
     * @param logicalName the logical name of the JposEntry to find
     * @since 0.1 (Philly 99 meeting)
     */
    public JposEntry getJposEntry( String logicalName );

    /**
     * Add an JposEntry for the service with logical name specified
     * @param logicalName the logicalName of the service
	 * @param entry the JposEntry to add
     * @since 0.1 (Philly 99 meeting)
     */
    public void addJposEntry( String logicalName, JposEntry entry );

    /**
     * Add an JposEntry for the service.  The logical name is obtained from the entry
	 * @param entry the JposEntry to add
	 * @see jpos.config.JposEntry#getLogicalName()
     * @since 1.3 (Washington DC 2001 meeting)
     */
    public void addJposEntry( JposEntry entry );

    /**
     * Removes the specified JposEntry 
     * @param entry the entry to remove
     * @since 0.1 (Philly 99 meeting)
     */
    public void removeJposEntry( JposEntry entry );

    /**
     * Removes the JposEntry with the logicalName specified 
     * @param logicalName the JposEntry's logical name
     * @since 0.1 (Philly 99 meeting)
     */
    public void removeJposEntry( String logicalName );

    /**
     * Modify the JposEntry with logicalName with the new entry indicated
     * @param logicalName the JposEntry's logical name
     * @param newEntry the new JposEntry
     * @since 0.1 (Philly 99 meeting)
     */
    public void modifyJposEntry( String logicalName, JposEntry newEntry );

    /**
     * Adds a new JposEntryRegistryListener to the list of listeners
     * @param l the JposEntryRegistryListener object
     * @since 0.1 (Philly 99 meeting)
     */
    public void addJposEntryRegistryListener( JposEntryRegistryListener l );

    /**
     * Removes a new JposEntryRegistryListener to the list of listeners
     * @param l the JposEntryRegistryListener object
     * @since 0.1 (Philly 99 meeting)
     */
    public void removeJposEntryRegistryListener( JposEntryRegistryListener l );

    /**
     * Tell the JposEntryRegistry to save the current entries 
     * NOTE: the actual implementation will save it in dependent manner
     * @since 0.1 (Philly 99 meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    public void save() throws Exception;

    /**
     * Tell the JposEntryRegistry to save the current entries to the file 
     * specified.  Depending on the current JposEntryPopulator the file might
     * be an XML or serialized or other file.
     * @since 2.1.0
     * @throws java.lang.Exception if any error occurs while saving or if the
     * current populator does not support saving in a file
     */
    public void saveToFile( File file ) throws Exception;

    /**
     * Loads the JposEntryRegistry using the current populator
     * NOTE: if no entries are found or an error occurs then the registry is empty
     * @since 1.2 (NY 2K meeting)
     */
    public void load();

    /**
     * @return the JposRegPopulator for this registry
     * @since 1.2 (NY 2K meeting)
     */
    public JposRegPopulator getRegPopulator();

	/**
	 * @return the current size of the registry 
	 * @since 1.3 (Tokyo 2001 meeting)
	 */
	public int getSize();

	/**
	 * @return true if the registry has already been loaded or false otherwise
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public boolean isLoaded();
}
