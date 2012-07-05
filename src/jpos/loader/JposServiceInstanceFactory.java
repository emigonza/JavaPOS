package jpos.loader;

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

import jpos.JposException;
import jpos.config.JposEntry;

/**
 * Defines the ServiceInstanceFactory.  Service providers must provide
 * a class that implements this interface and that has a default ctor.
 * The jpos.config implementation will use reflection to create an 
 * instance of that class as the factory class and call its createInstance
 * method to create the services
 * @since 0.1 (Philly 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface JposServiceInstanceFactory
{
    /**
     * @return a JposServiceInstance using the logicalName and the entry provided
     * @param logicalName the logicalName for the service
     * @param entry the JposEntry instance containing info necessary for creating the service
     * @since 0.1 (Philly 99 meeting)
     * @throws jpos.JposException if any error occurs
     */
    public JposServiceInstance createInstance( String logicalName, JposEntry entry ) throws JposException;
}
