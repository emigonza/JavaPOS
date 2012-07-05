/////////////////////////////////////////////////////////////////////
//
// This software is provided "AS IS".  The JavaPOS working group (including
// each of the Corporate members, contributors and individuals)  MAKES NO
// REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
// EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
// WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NON-INFRINGEMENT. The JavaPOS working group shall not be liable for
// any damages suffered as a result of using, modifying or distributing this
// software or its derivatives.Permission to use, copy, modify, and distribute
// the software and its documentation for any purpose is hereby granted.
//
// RemoteOrderDisplayConst
//
//   Remote Order Display constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 1998-Apr-20 JavaPOS Release 1.3                                 BS
// 2005-Jan-16 JavaPOS Release 1.9                                 BS
//   Added the following missing constants:
//     ROD_CLK_SHORT
//     ROD_CLK_NORMAL
//     ROD_CLK_12_LONG
//     ROD_CLK_24_LONG
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface RemoteOrderDisplayConst
{
    /////////////////////////////////////////////////////////////////////
    // "CurrentUnitID" and "UnitsOnline" Properties
    //  and "Units" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int ROD_UID_1  = 0x00000001;
    public static final int ROD_UID_2  = 0x00000002;
    public static final int ROD_UID_3  = 0x00000004;
    public static final int ROD_UID_4  = 0x00000008;
    public static final int ROD_UID_5  = 0x00000010;
    public static final int ROD_UID_6  = 0x00000020;
    public static final int ROD_UID_7  = 0x00000040;
    public static final int ROD_UID_8  = 0x00000080;
    public static final int ROD_UID_9  = 0x00000100;
    public static final int ROD_UID_10 = 0x00000200;
    public static final int ROD_UID_11 = 0x00000400;
    public static final int ROD_UID_12 = 0x00000800;
    public static final int ROD_UID_13 = 0x00001000;
    public static final int ROD_UID_14 = 0x00002000;
    public static final int ROD_UID_15 = 0x00004000;
    public static final int ROD_UID_16 = 0x00008000;
    public static final int ROD_UID_17 = 0x00010000;
    public static final int ROD_UID_18 = 0x00020000;
    public static final int ROD_UID_19 = 0x00040000;
    public static final int ROD_UID_20 = 0x00080000;
    public static final int ROD_UID_21 = 0x00100000;
    public static final int ROD_UID_22 = 0x00200000;
    public static final int ROD_UID_23 = 0x00400000;
    public static final int ROD_UID_24 = 0x00800000;
    public static final int ROD_UID_25 = 0x01000000;
    public static final int ROD_UID_26 = 0x02000000;
    public static final int ROD_UID_27 = 0x04000000;
    public static final int ROD_UID_28 = 0x08000000;
    public static final int ROD_UID_29 = 0x10000000;
    public static final int ROD_UID_30 = 0x20000000;
    public static final int ROD_UID_31 = 0x40000000;
    public static final int ROD_UID_32 = 0x80000000;


    /////////////////////////////////////////////////////////////////////
    // Broadcast Methods: "Attribute" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int ROD_ATTR_BLINK       = 0x80;

    public static final int ROD_ATTR_BG_BLACK    = 0x00;
    public static final int ROD_ATTR_BG_BLUE     = 0x10;
    public static final int ROD_ATTR_BG_GREEN    = 0x20;
    public static final int ROD_ATTR_BG_CYAN     = 0x30;
    public static final int ROD_ATTR_BG_RED      = 0x40;
    public static final int ROD_ATTR_BG_MAGENTA  = 0x50;
    public static final int ROD_ATTR_BG_BROWN    = 0x60;
    public static final int ROD_ATTR_BG_GRAY     = 0x70;

    public static final int ROD_ATTR_INTENSITY   = 0x08;

    public static final int ROD_ATTR_FG_BLACK    = 0x00;
    public static final int ROD_ATTR_FG_BLUE     = 0x01;
    public static final int ROD_ATTR_FG_GREEN    = 0x02;
    public static final int ROD_ATTR_FG_CYAN     = 0x03;
    public static final int ROD_ATTR_FG_RED      = 0x04;
    public static final int ROD_ATTR_FG_MAGENTA  = 0x05;
    public static final int ROD_ATTR_FG_BROWN    = 0x06;
    public static final int ROD_ATTR_FG_GRAY     = 0x07;


    /////////////////////////////////////////////////////////////////////
    // "DrawBox" Method: "BorderType" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int ROD_BDR_SINGLE       = 1;
    public static final int ROD_BDR_DOUBLE       = 2;
    public static final int ROD_BDR_SOLID        = 3;


    /////////////////////////////////////////////////////////////////////
    // "ControlClock" Method: "Function" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int ROD_CLK_START        = 1;
    public static final int ROD_CLK_PAUSE        = 2;
    public static final int ROD_CLK_RESUME       = 3;
    public static final int ROD_CLK_MOVE         = 4;
    public static final int ROD_CLK_STOP         = 5;


    /////////////////////////////////////////////////////////////////////
    // "ControlClock" Method: "Mode" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int ROD_CLK_SHORT        = 1;
    public static final int ROD_CLK_NORMAL       = 2;
    public static final int ROD_CLK_12_LONG      = 3;
    public static final int ROD_CLK_24_LONG      = 4;


    /////////////////////////////////////////////////////////////////////
    // "ControlCursor" Method: "Function" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int ROD_CRS_LINE         = 1;
    public static final int ROD_CRS_LINE_BLINK   = 2;
    public static final int ROD_CRS_BLOCK        = 3;
    public static final int ROD_CRS_BLOCK_BLINK  = 4;
    public static final int ROD_CRS_OFF          = 5;


    /////////////////////////////////////////////////////////////////////
    // "SelectCharacterSet" Method: "CharacterSet" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int ROD_CS_UNICODE       = 997;
    public static final int ROD_CS_ASCII         = 998;
    public static final int ROD_CS_ANSI          = 999;


    /////////////////////////////////////////////////////////////////////
    // "TransactionDisplay" Method: "Function" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int ROD_TD_TRANSACTION   = 11;
    public static final int ROD_TD_NORMAL        = 12;


    /////////////////////////////////////////////////////////////////////
    // "UpdateVideoRegionAttribute" Method: "Function" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int ROD_UA_SET           = 1;
    public static final int ROD_UA_INTENSITY_ON  = 2;
    public static final int ROD_UA_INTENSITY_OFF = 3;
    public static final int ROD_UA_REVERSE_ON    = 4;
    public static final int ROD_UA_REVERSE_OFF   = 5;
    public static final int ROD_UA_BLINK_ON      = 6;
    public static final int ROD_UA_BLINK_OFF     = 7;


    /////////////////////////////////////////////////////////////////////
    // "EventTypes" Property and "DataEvent" Event: "Status" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int ROD_DE_TOUCH_UP      = 0x01;
    public static final int ROD_DE_TOUCH_DOWN    = 0x02;
    public static final int ROD_DE_TOUCH_MOVE    = 0x04;


    /////////////////////////////////////////////////////////////////////
    // "ResultCodeExtended" Property Constants for Remote Order Display
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_EROD_BADCLK     = 1 + JposConst.JPOSERREXT; // ControlClock
    public static final int JPOS_EROD_NOCLOCKS   = 2 + JposConst.JPOSERREXT; // ControlClock
    public static final int JPOS_EROD_NOREGION   = 3 + JposConst.JPOSERREXT; // RestoreVideo
                                                  //   Region
    public static final int JPOS_EROD_NOBUFFERS  = 4 + JposConst.JPOSERREXT; // SaveVideoRegion
    public static final int JPOS_EROD_NOROOM     = 5 + JposConst.JPOSERREXT; // SaveVideoRegion
}