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
import java.net.URL;

/**
 * Defines an interface to load, save JposEntries
 * @since 1.2 (NY 2K 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface JposRegPopulator 
{
    //-------------------------------------------------------------------------
    // Public methods
    //

	/**
	 * @return a unique String ID for this JposRegPopulator instance
	 * Can be implemented in terms of the getClassName() method
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getUniqueId();

	/**
	 * @return the fully qualified class name implementing the 
	 * JposRegPopulator interface
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getClassName();

    /**
     * Tell the populator to save the current entries 
     * @param entries an enumeration of JposEntry objects
     * @since 1.2 (NY 2K meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    public void save( Enumeration entries ) throws Exception;

    /**
     * Tell the populator to save the current entries in the file specified 
     * @param entries an enumeration of JposEntry objects
     * @param fileName the file name to save entries
     * @since 1.3 (SF 2K meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    public void save( Enumeration entries, String fileName ) throws Exception;

    /**
     * Tell the populator to load the entries 
     * @since 1.2 (NY 2K meeting)
     */
    public void load();

    /**
     * Loads the entries specified in the fileName
     * @param fileName the entries file name
     * @since 1.3 (SF 2K meeting)
     */
    public void load( String fileName );

	/**
	 * @return the last exception (if any) during the last load or null 
	 * if no exception occurred
	 * @since 2.0.0
	 */
	public Exception getLastLoadException();

    /**
     * @return the URL pointing to the entries file loaded or saved
     * @since 1.2 (NY 2K meeting)
     */
    public URL getEntriesURL();

    /**
     * @return an Enumeration of JposEntry objects
     * @since 1.2 (NY 2K meeting)
     */
    public Enumeration getEntries();

	/**
	 * @retun true if this populator is a composite populator or false 
	 * otherwise
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public boolean isComposite();

	/**
	 * @return the name of this populator.  This should be a short 
	 * descriptive name
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getName();
}
