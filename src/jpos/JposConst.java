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
// JposConst
//
//   General constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 1998-Feb-18 JavaPOS Release 1.2                                 BS
// 1998-Apr-20 JavaPOS Release 1.3                                 BS
//   Add CapPowerReporting, PowerState, and PowerNotify values.
//   Add power reporting values for StatusUpdateEvent.
// 2005-Jan-16 JavaPOS Release 1.9                                 BS
// 2006-Feb-10 JavaPOS Release 1.10                                BS
// 2007-Jan-04 JavaPOS Release 1.11                                BS
//   Added the JPOS_E_DEPRECATED ErrorCode value
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface JposConst
{
    //###################################################################
    //#### General JavaPOS Constants
    //###################################################################

    /////////////////////////////////////////////////////////////////////
    // "State" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_S_CLOSED        = 1;
    public static final int JPOS_S_IDLE          = 2;
    public static final int JPOS_S_BUSY          = 3;
    public static final int JPOS_S_ERROR         = 4;

    /////////////////////////////////////////////////////////////////////
    // "ErrorCode" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOSERR    = 100;
    public static final int JPOSERREXT = 200;

    public static final int JPOS_SUCCESS         =  0;
    public static final int JPOS_E_CLOSED        =  1 + JPOSERR;
    public static final int JPOS_E_CLAIMED       =  2 + JPOSERR;
    public static final int JPOS_E_NOTCLAIMED    =  3 + JPOSERR;
    public static final int JPOS_E_NOSERVICE     =  4 + JPOSERR;
    public static final int JPOS_E_DISABLED      =  5 + JPOSERR;
    public static final int JPOS_E_ILLEGAL       =  6 + JPOSERR;
    public static final int JPOS_E_NOHARDWARE    =  7 + JPOSERR;
    public static final int JPOS_E_OFFLINE       =  8 + JPOSERR;
    public static final int JPOS_E_NOEXIST       =  9 + JPOSERR;
    public static final int JPOS_E_EXISTS        = 10 + JPOSERR;
    public static final int JPOS_E_FAILURE       = 11 + JPOSERR;
    public static final int JPOS_E_TIMEOUT       = 12 + JPOSERR;
    public static final int JPOS_E_BUSY          = 13 + JPOSERR;
    public static final int JPOS_E_EXTENDED      = 14 + JPOSERR;
    public static final int JPOS_E_DEPRECATED    = 15 + JPOSERR; // 1.11


    /////////////////////////////////////////////////////////////////////
    // "ErrorCodeExtended" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_ESTATS_ERROR       = 80 + JPOSERREXT;
    public static final int JPOS_EFIRMWARE_BAD_FILE = 81 + JPOSERREXT;
    public static final int JPOS_ESTATS_DEPENDENCY  = 82 + JPOSERREXT;


    /////////////////////////////////////////////////////////////////////
    // OPOS "BinaryConversion" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_BC_NONE         = 0;
    public static final int JPOS_BC_NIBBLE       = 1;
    public static final int JPOS_BC_DECIMAL      = 2;


    /////////////////////////////////////////////////////////////////////
    // "CheckHealth" Method: "Level" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_CH_INTERNAL     = 1;
    public static final int JPOS_CH_EXTERNAL     = 2;
    public static final int JPOS_CH_INTERACTIVE  = 3;


    /////////////////////////////////////////////////////////////////////
    // "CapPowerReporting", "PowerState", "PowerNotify" Property
    //   Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_PR_NONE         = 0;
    public static final int JPOS_PR_STANDARD     = 1;
    public static final int JPOS_PR_ADVANCED     = 2;

    public static final int JPOS_PN_DISABLED     = 0;
    public static final int JPOS_PN_ENABLED      = 1;

    public static final int JPOS_PS_UNKNOWN      = 2000;
    public static final int JPOS_PS_ONLINE       = 2001;
    public static final int JPOS_PS_OFF          = 2002;
    public static final int JPOS_PS_OFFLINE      = 2003;
    public static final int JPOS_PS_OFF_OFFLINE  = 2004;


    /////////////////////////////////////////////////////////////////////
    // "compareFirmwareVersion" Method: "result" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_CFV_FIRMWARE_OLDER     = 1;
    public static final int JPOS_CFV_FIRMWARE_SAME      = 2;
    public static final int JPOS_CFV_FIRMWARE_NEWER     = 3;
    public static final int JPOS_CFV_FIRMWARE_DIFFERENT = 4;
    public static final int JPOS_CFV_FIRMWARE_UNKNOWN   = 5;


    /////////////////////////////////////////////////////////////////////
    // "ErrorEvent" Event: "ErrorLocus" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_EL_OUTPUT       = 1;
    public static final int JPOS_EL_INPUT        = 2;
    public static final int JPOS_EL_INPUT_DATA   = 3;


    /////////////////////////////////////////////////////////////////////
    // "ErrorEvent" Event: "ErrorResponse" Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_ER_RETRY        = 11;
    public static final int JPOS_ER_CLEAR        = 12;
    public static final int JPOS_ER_CONTINUEINPUT= 13;


    /////////////////////////////////////////////////////////////////////
    // "StatusUpdateEvent" Event: Common "Status" Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_SUE_POWER_ONLINE                 = 2001;
    public static final int JPOS_SUE_POWER_OFF                    = 2002;
    public static final int JPOS_SUE_POWER_OFFLINE                = 2003;
    public static final int JPOS_SUE_POWER_OFF_OFFLINE            = 2004;

    public static final int JPOS_SUE_UF_PROGRESS                  = 2100;
    public static final int JPOS_SUE_UF_COMPLETE                  = 2200; // JPOS_SUE_UF_PROGRESS + 100
    public static final int JPOS_SUE_UF_FAILED_DEV_OK             = 2201;
    public static final int JPOS_SUE_UF_FAILED_DEV_UNRECOVERABLE  = 2202;
    public static final int JPOS_SUE_UF_FAILED_DEV_NEEDS_FIRMWARE = 2203;
    public static final int JPOS_SUE_UF_FAILED_DEV_UNKNOWN        = 2204;
    public static final int JPOS_SUE_UF_COMPLETE_DEV_NOT_RESTORED = 2205;


    /////////////////////////////////////////////////////////////////////
    // General Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_FOREVER         = -1;
}