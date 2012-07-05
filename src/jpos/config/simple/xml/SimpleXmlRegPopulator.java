package jpos.config.simple.xml;

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
import java.net.URL;

import jpos.config.simple.AbstractRegPopulator;

/**
 * Simple implementation of the JposRegPopulator that loads and saves the entries
 * in XML using the "jpos/res/jcl.dtd" DTD and the XML4J (Xerces) API
 * <p>
 * <b>NOTE</b>: this class must define a public no-argument ctor so that it may be created 
 * via reflection when its defined in the jpos.properties as 
 * the jpos.config.regPopulatorClass
 * </p>
 * @see jpos.util.JposProperties#JPOS_REG_POPULATOR_CLASS_PROP_NAME
 * @since 1.2 (NY 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class SimpleXmlRegPopulator extends AbstractRegPopulator 
									implements XmlRegPopulator
{
    //-------------------------------------------------------------------------
    // Ctor(s)
    //

    /**
     * Default ctor
     * @since 1.2 (NY 2K meeting)
     */
    public SimpleXmlRegPopulator() 
    { super( SimpleXmlRegPopulator.class.getName() ); }

    /**
     * 1-arg constructor that takes the unique ID
	 * @param s the unique ID string
     * @since 1.3 (Washington DC 2001)
     */
    public SimpleXmlRegPopulator( String s ) { super( s ); }

    //-------------------------------------------------------------------------
    // Public methods
    //

	/**
	 * @return the fully qualified class name implementing the JposRegPopulator interface
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getClassName() { return SimpleXmlRegPopulator.class.getName(); }

    /**
     * Tell the populator to save the current entries 
     * @param entries an enumeration of JposEntry objects
     * @since 1.2 (NY 2K meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    public void save( Enumeration entries ) throws Exception
    { regPopulator.save( entries ); }

    /**
     * Tell the populator to save the current entries in the file specified 
     * @param entries an enumeration of JposEntry objects
     * @param fileName the file name to save entries
     * @since 1.3 (SF 2K meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    public void save( Enumeration entries, String fileName ) throws Exception
    { regPopulator.save( entries, fileName ); }

    /**
     * Tell the populator to load the entries 
     * @since 1.2 (NY 2K meeting)
     */
    public void load() { regPopulator.load(); }


    /**
     * Loads the entries specified in the fileName
     * @param fileName the entries file name
     * @since 1.3 (SF 2K meeting)
     */
    public void load( String fileName ) { regPopulator.load( fileName ); }
    
    /**
     * @return an Enumeration of JposEntry objects
     * NOTE: need to overridde this method here because need to forward call
     *       to the regPopulator instance
     * @since 1.2 (NY 2K meeting)
     */
    public Enumeration getEntries() { return regPopulator.getEntries(); }

    /**
     * @return the URL pointing to the entries file loaded or saved
     * @since 1.2 (NY 2K meeting)
     */
    public URL getEntriesURL() { return regPopulator.getEntriesURL(); }

	/**
	 * @return the name of this populator.  This should be a short descriptive name
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getName() { return regPopulator.getName(); }

	/**
	 * @return the last exception (if any) during the last load or null if no exception occurred
	 * @since 2.0.0
	 */
	public Exception getLastLoadException() { return regPopulator.getLastLoadException(); }

    //--------------------------------------------------------------------------
    // Instance variables
    //

    private XmlRegPopulator regPopulator = new XercesRegPopulator();
}
