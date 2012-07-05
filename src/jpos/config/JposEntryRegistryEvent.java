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
 * Event class for the JposEntryRegistry
 * @since 0.1 (Philly 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class JposEntryRegistryEvent extends EventObject
{
    /**
     * Creates a new event
     * @param source the source of this event
     * @param entry the JposEntry associated with the event
     * @since 0.1 (Philly 99 meeting)
     */
    public JposEntryRegistryEvent( Object source, JposEntry entry )
    {
        super( source );
        jposEntry = entry;
    }

    /**
     * @return the JposEntry for this event
     * @since 0.1 (Philly 99 meeting)
     */
    public JposEntry getJposEntry() { return jposEntry; }

    //--------------------------------------------------------------------------
    // Instance variables
    //

    private JposEntry jposEntry = null;
}
