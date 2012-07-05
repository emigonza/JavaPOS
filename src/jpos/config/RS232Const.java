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

/**
 * Defines constants for RS232 buses
 * @since 1.3 (Washington DC 2001 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface RS232Const
{
    //-------------------------------------------------------------------------
    // RS232 properties name and values
    //

    //Property names

    /** The RS232 "portName" property (type == String) */
    public static final String RS232_PORT_NAME_PROP_NAME = "portName";
    
    /** The RS232 "baudRate" property (type == int [...]) */
    public static final String RS232_BAUD_RATE_PROP_NAME = "baudRate";

    /** The RS232 "dataBits" property (type == int list [4, 5, 6, 7, 8])  */
    public static final String RS232_DATA_BITS_PROP_NAME = "dataBits";

    /** The RS232 "parity" property (type == String list [Even, Odd, None, Mark, Space]) */
    public static final String RS232_PARITY_PROP_NAME = "parity";

    /** The RS232 "stopBits" property (type == String list [1, 1.5, 2])  */
    public static final String RS232_STOP_BITS_PROP_NAME = "stopBits";

    /** The RS232 "flowControl" property (type == String list [Xon/Xoff, Hardware, None]) */
    public static final String RS232_FLOW_CONTROL_PROP_NAME = "flowControl";

	/**
	 * Array of all RS232 properties
	 * @since 1.3 (Washington 2001 meeting)
	 */
	public static final String[] RS232_PROPS = { RS232_PORT_NAME_PROP_NAME,
                                                 RS232_BAUD_RATE_PROP_NAME,
                                                 RS232_DATA_BITS_PROP_NAME,
                                                 RS232_PARITY_PROP_NAME,
                                                 RS232_STOP_BITS_PROP_NAME,
                                                 RS232_FLOW_CONTROL_PROP_NAME };

    //Property values

    /** The RS232 "baudRate" property values as Integer objects (typical values) */
    public static final String[] RS232_BAUD_RATE_VALUES = { "2400", "4800", "7200",  "9600",
                                                            "14400", "19200", "38400", "57600",
                                                            "115200", "75", "110", "134", "150",
															"300", "600", "1200", "1800" };
	
	/** The RS232 "dataBits" property value of 4 */
    public static final String RS232_DATA_BITS_4 = "4";

    /** The RS232 "dataBits" property value of 5 */
    public static final String RS232_DATA_BITS_5 = "5";

    /** The RS232 "dataBits" property value of 6 */
    public static final String RS232_DATA_BITS_6 = "6";

    /** The RS232 "dataBits" property value of 7 */
    public static final String RS232_DATA_BITS_7 = "7";

    /** The RS232 "dataBits" property value of 8 */
    public static final String RS232_DATA_BITS_8 = "8";

    /** The RS232 "dataBits" property values as Integer objects */
    public static final String[] RS232_DATA_BITS_VALUES = { RS232_DATA_BITS_8,
                                                            RS232_DATA_BITS_7,
                                                            RS232_DATA_BITS_6,
                                                            RS232_DATA_BITS_5,
                                                            RS232_DATA_BITS_4 };

    /** The RS232 "parity" property value of "Even" */
    public static final String RS232_PARITY_EVEN = "Even";

    /** The RS232 "parity" property value of "Odd" */
    public static final String RS232_PARITY_ODD = "Odd";

    /** The RS232 "parity" property value of "None" */
    public static final String RS232_PARITY_NONE = "None";

    /** The RS232 "parity" property value of "Mark" */
    public static final String RS232_PARITY_MARK = "Mark";

    /** The RS232 "parity" property value of "Space" */
    public static final String RS232_PARITY_SPACE = "Space";

    /** The RS232 "parity" property values as String objects */
    public static final String[] RS232_PARITY_VALUES = { RS232_PARITY_NONE, RS232_PARITY_EVEN, 
														 RS232_PARITY_ODD, RS232_PARITY_MARK,
                                                         RS232_PARITY_SPACE };

    /** The RS232 "stopBits" property value of 1 */
    public static final String RS232_STOP_BITS_1 = "1";

    /** The RS232 "stopBits" property value of 1.5 */
    public static final String RS232_STOP_BITS_1_5 = "1.5";

    /** The RS232 "stopBits" property value of 2 */
    public static final String RS232_STOP_BITS_2 = "2";

    /** The RS232 "stopBits" property values as Strin objects */
    public static final String[] RS232_STOP_BITS_VALUES = { RS232_STOP_BITS_1, RS232_STOP_BITS_1_5,
                                                            RS232_STOP_BITS_2 };

    /** The RS232 "flowControl" property value of "Xon/Xoff" */
    public static final String RS232_FLOW_CONTROL_XON_XOFF = "Xon/Xoff";

    /** The RS232 "flowControl" property value of "Hardware" */
    public static final String RS232_FLOW_CONTROL_HARDWARE = "Hardware";

    /** The RS232 "flowControl" property value of "None" */
    public static final String RS232_FLOW_CONTROL_NONE = "None";

    /** The RS232 "flowControl" property values as Strin objects */
    public static final String[] RS232_FLOW_CONTROL_VALUES = { RS232_FLOW_CONTROL_NONE,
															   RS232_FLOW_CONTROL_XON_XOFF,
                                                               RS232_FLOW_CONTROL_HARDWARE };
	//Default RS232 property values
	
	/** The RS232 "portName" property default value */
	public static final String DEFAULT_RS232_PORT_NAME_VALUE = "";

	/** The RS232 "baudRate" property default value (type == int [...]) */
	public static final String DEFAULT_RS232_BAUD_RATE_VALUE = "9600";

	/** The RS232 "dataBits" property default value (type == int list [4, 5, 6, 7, 8])  */
	public static final String DEFAULT_RS232_DATA_BITS_VALUE= "8";

	/** The RS232 "parity" property default value (type == String list [Even, Odd, None, Mark, Space]) */
	public static final String DEFAULT_RS232_PARITY_VALUE = RS232_FLOW_CONTROL_NONE;

	/** The RS232 "stopBits" property default value (type == String list [1, 1.5, 2])  */
	public static final String DEFAULT_RS232_STOP_BITS_VALUE = RS232_STOP_BITS_1;

	/** The RS232 "flowControl" property default value (type == String list [Xon/Xoff, Hardware, None]) */
	public static final String DEFAULT_RS232_FLOW_CONTROL_VALUE = RS232_FLOW_CONTROL_XON_XOFF;
}
