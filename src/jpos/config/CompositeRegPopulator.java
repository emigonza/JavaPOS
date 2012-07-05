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

/**
 * Defines a composite interface collecting many JposRegPopulator objects
 * See GoF Composite pattern for explanation on Composite classes/objects
 * @since 1.3 (Washington DC 2001 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface CompositeRegPopulator extends JposRegPopulator
{
    //-------------------------------------------------------------------------
    // Public methods
    //

	/** @return the default JposRegPopulator */
	public JposRegPopulator getDefaultPopulator();

	/**
	 * Adds this JposRegPopulator to the composite
	 * @param populator adds the populator to the composite reg populator.  Does nothing
	 * if the popualator already is in the composite
	 */
	public void add( JposRegPopulator populator );

	/**
	 * Removes this JposRegPopulator from the composite
	 * @param populator removes the populator to the composite reg populator
	 */
	public void remove( JposRegPopulator populator );

	/** @return an iterator over all populators in this composite */
	public Iterator getPopulators();

	/** 
	 * @return the populator with unique ID passed
	 * @param uniqueId the populator unique ID
	 * @see jpos.config.JposRegPopulator#getUniqueId()
	 */
	public JposRegPopulator getPopulator( String uniqueId );

	/** @return the number of populator in this composite */
	public int size();

	//-------------------------------------------------------------------------
	// Constants
	//

	/** The default name for the CompositeRegPopulator */
	public static final String COMPOSITE_REG_POPULATOR_STRING = "JCL Composite Entries Populator";
}
