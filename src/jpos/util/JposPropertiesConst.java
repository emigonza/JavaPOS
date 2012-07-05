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
///////////////////////////////////////////////////////////////////////////////

/**
 * Interface with all JposPropertiesConstants like property names and values
 * @since 1.3 (Washington DC 2001 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface JposPropertiesConst
{
    //-------------------------------------------------------------------------
    // Public constants (non-properties name)
    //

    /**
     * Constant defining the resource name for the "jpos.properties" file
     * @since 1.2 (NY 2K meeting)
     */
    public static final String JPOS_PROPERTIES_FILENAME = "jpos/res/jpos.properties";

    /**
     * The default name for the serialized file of JposEntry
     * @since 0.1 (Philly 99 meeting)
     */
    public static final String DEFAULT_ENTRIES_SER_FILE_NAME = "jpos.cfg";

    //-------------------------------------------------------------------------
    // Public constants (properties name)
    //

    /**
     * Constants defining the JavaPOS service manager class name Java property 
     * @since 0.1 (Philly 99 meeting)
     */
    public static final String JPOS_SERVICE_MANAGER_CLASS_PROP_NAME = "jpos.config.serviceManagerClass";

    /**
     * Constants defining the JavaPOS service manager class name Java property 
     * NOTE: this is the correct name to use to specify the class implementing the 
     * JposServiceManager interface since this interface was moved to the jpos.loader
     * package.  The JposServiceLoader will use both...
     * @since 1.2 (NY 2K meeting)
     */
    public static final String JPOS_SERVICE_MANAGER_CLASS_PROP_NAME2 = "jpos.loader.serviceManagerClass";

    /**
     * Constants defining the JavaPOS JposRegPopulator implementor class name Java property 
     * @since 1.2 (NY 2K meeting)
     */
    public static final String JPOS_REG_POPULATOR_CLASS_PROP_NAME = "jpos.config.regPopulatorClass";

    /**
     * Constants defining the JavaPOS local populator file Java property 
     * @since 1.2 (NY 2K meeting)
     */
    public static final String JPOS_POPULATOR_FILE_PROP_NAME = "jpos.config.populatorFile";


    /**
     * Constants defining the JavaPOS URL populator file Java property 
     * @since 1.2 (NY 2K meeting)
     */
    public static final String JPOS_POPULATOR_FILE_URL_PROP_NAME = "jpos.config.populatorFileURL";

    /**
     * Constants defining the JavaPOS tracing facility Java property 
     * @since 1.2 (NY 2K meeting)
     */
    public static final String JPOS_TRACING_PROP_NAME = "jpos.util.tracing";

    //-------------------------------------------------------------------------
    // Public constants (multi-properties name)
    //

    /**
     * Defines the base name for a multi-property constant used to define the multiple
	 * populator class name
     * @since 1.3 (Washington DC 2001 meeting)
     */
	public static final String JPOS_CONFIG_POPULATOR_CLASS_MULTIPROP_NAME = "jpos.config.populator.class";

    /**
     * Defines the base name for a multi-property constant used to define the multiple
	 * populator file (i.e. the file that the populator will use to load the entries.
     * @since 1.3 (Washington DC 2001 meeting)
     */
	public static final String JPOS_CONFIG_POPULATOR_FILE_MULTIPROP_NAME = "jpos.config.populator.file";

    //-------------------------------------------------------------------------
    // Public constants (properties value)
    //

    /**
     * Constants defining the JavaPOS tracing facility Java property value of ON
     * <b>NOTE</b>: either this or the JposProperties#JPOS_TRACING_TRUE_PROP_VALUE works
     * @since 1.2 (NY 2K meeting)
     */
    public static final String JPOS_TRACING_ON_PROP_VALUE = "ON";
    
    /**
     * Constants defining the JavaPOS tracing facility Java property of TRUE
     * <b>NOTE</b>: either this or the JposProperties#JPOS_TRACING_ON_PROP_VALUE works
     * @since 1.2 (NY 2K meeting)
     */
    public static final String JPOS_TRACING_TRUE_PROP_VALUE = "TRUE";

	//-------------------------------------------------------------------------
	// Public constants
	//

	/**
	 * String array of all property names
	 * @since 1.3 (Washington DC 2001)
	 */
	public static final String[] PROP_NAME_ARRAY = { JPOS_SERVICE_MANAGER_CLASS_PROP_NAME,
                                                     JPOS_SERVICE_MANAGER_CLASS_PROP_NAME2,
                                                     JPOS_REG_POPULATOR_CLASS_PROP_NAME,
                                                     JPOS_POPULATOR_FILE_PROP_NAME,
                                                     JPOS_POPULATOR_FILE_URL_PROP_NAME,
                                                     JPOS_TRACING_PROP_NAME,
                                                     JPOS_CONFIG_POPULATOR_CLASS_MULTIPROP_NAME,
                                                     JPOS_CONFIG_POPULATOR_FILE_MULTIPROP_NAME };
}
