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

import java.io.Serializable;

/**
 * Defines constants for standard properties names and values used to create
 * JposEntries...
 * @since 1.3 (Berlin 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface JposEntryConst extends RS232Const, Serializable
{
    //-------------------------------------------------------------------------
    // Required properties array
    //

	/**
	 * Array of all required properties
	 * @since 1.3 (Washington 2001 meeting)
	 */
	public static final String[] REQUIRED_PROPS = 
	                               { 
	                               	 JposEntry.SI_FACTORY_CLASS_PROP_NAME,
                                     JposEntry.LOGICAL_NAME_PROP_NAME,
                                     JposEntry.SERVICE_CLASS_PROP_NAME,
                                     JposEntry.VENDOR_NAME_PROP_NAME,
                                     JposEntry.VENDOR_URL_PROP_NAME,
                                     JposEntry.DEVICE_CATEGORY_PROP_NAME,
                                     JposEntry.JPOS_VERSION_PROP_NAME,
                                     JposEntry.PRODUCT_NAME_PROP_NAME,
                                     JposEntry.PRODUCT_DESCRIPTION_PROP_NAME,
                                     JposEntry.PRODUCT_URL_PROP_NAME 
                                   };

    //-------------------------------------------------------------------------
    // Required properties default values
    //

	public static final String LOGICAL_NAME_DEFAULT_PROP_VALUE = 
	                             "UnknownDevice";
	                             
	public static final String SI_FACTORY_CLASS_DEFAULT_PROP_VALUE = 
	                             "UnknownServiceInstanceFactoryClass";
	                             
	public static final String SERVICE_CLASS_DEFAULT_PROP_VALUE = 
	                             "UnknownServiceClass";
	                             
	public static final String DEVICE_CATEGORY_DEFAULT_PROP_VALUE = 
								 "CashDrawer";
	
	public static final String JPOS_VERSION_DEFAULT_PROP_VALUE = "1.5";
	
	public static final String VENDOR_NAME_DEFAULT_PROP_VALUE = 
								 "Unknown Vendor Name";
	
	public static final String VENDOR_URL_DEFAULT_PROP_VALUE = 
								 "http://www.UnknownVerdorURL.com";
	
	public static final String PRODUCT_NAME_DEFAULT_PROP_VALUE = 
								 "Unknown Product Name";
	
	public static final String PRODUCT_URL_DEFAULT_PROP_VALUE = 
								 "http://www.UnknownProductURL.com";
	
	public static final String PRODUCT_DESCRIPTION_DEFAULT_PROP_VALUE = 
								 "Unknown Product Description";

	/** @return an array of all compatible JavaPOS version values */
	public static final String[] JPOS_VERSION_PROPS = 
								   { "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8" };

    //-------------------------------------------------------------------------
    // Standard properties name and values
    //

    //Property names

    /** Required property indicating the BUS used for this JposEntry */
    public static final String DEVICE_BUS_PROP_NAME = "deviceBus";

    //Property values

    /** Property value for deviceBus for RS232 */
    public static final String RS232_DEVICE_BUS = "RS232";

    /** Property value for deviceBus for standard Parallel ports */
    public static final String PARALLEL_DEVICE_BUS = "Parallel";

    /** Property value for deviceBus for USB */
    public static final String USB_DEVICE_BUS = "USB";

    /** Property value for deviceBus for RS485 (or SIO) */
    public static final String RS485_DEVICE_BUS = "RS485";

    /** Property value for deviceBus for HID (or Human Inferface Device) */
    public static final String HID_DEVICE_BUS = "HID";

    /** Property value for deviceBus for proprietary buses */
    public static final String PROPRIETARY_DEVICE_BUS = "Proprietary";

    /** Property value for deviceBus for other "Unknown" buses */
    public static final String UNKNOWN_DEVICE_BUS = "Unknown";

    /** Array of all the deviceBus property values */
    public static final String[] DEVICE_BUS_VALUES = 
                                   { 
                                   	 RS232_DEVICE_BUS, 
                                   	 PARALLEL_DEVICE_BUS,
									 USB_DEVICE_BUS, 
									 RS485_DEVICE_BUS, 
									 HID_DEVICE_BUS,
									 PROPRIETARY_DEVICE_BUS, 
									 UNKNOWN_DEVICE_BUS 
								   };
								   
	//-------------------------------------------------------------------------
	// Property types allowed
	//

	/** The default JposEntry property type */
	public static final Class DEFAULT_PROP_TYPE = String.class;

	/** Array of all the property types allowed for a JposEntry property */
	public static final Class[] PROP_TYPES = 
								  { 
								  	String.class, 
								  	Boolean.class, 
								  	Byte.class, 
								  	Character.class, 
								  	Double.class, 
								  	Float.class,
                                    Integer.class, 
                                    Long.class, 
                                    Short.class 
                                  };
	
	/** Array of all the property types allowed for a JposEntry property */
	public static final String[] PROP_TYPES_SHORT_NAMES = 
								   { 
								   	 "String", 
								   	 "Boolean", 
								   	 "Byte", 
								   	 "Character", 
							     	 "Double", 
							     	 "Float", 
							     	 "Integer", 
							     	 "Long", 
							     	 "Short" 
							       };
}