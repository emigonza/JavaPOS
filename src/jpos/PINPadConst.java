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
// PINPadConst
//
//   PIN Pad constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 98-04-20 JavaPOS Release 1.3                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface PINPadConst
{
    /////////////////////////////////////////////////////////////////////
    // "CapDisplay" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int PPAD_DISP_UNRESTRICTED          = 1;
    public static final int PPAD_DISP_PINRESTRICTED         = 2;
    public static final int PPAD_DISP_RESTRICTED_LIST       = 3;
    public static final int PPAD_DISP_RESTRICTED_ORDER      = 4;
    public static final int PPAD_DISP_NONE                  = 5;


    /////////////////////////////////////////////////////////////////////
    // "AvailablePromptsList" and "Prompt" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int PPAD_MSG_ENTERPIN               = 1;
    public static final int PPAD_MSG_PLEASEWAIT             = 2;
    public static final int PPAD_MSG_ENTERVALIDPIN          = 3;
    public static final int PPAD_MSG_RETRIESEXCEEDED        = 4;
    public static final int PPAD_MSG_APPROVED               = 5;
    public static final int PPAD_MSG_DECLINED               = 6;
    public static final int PPAD_MSG_CANCELED               = 7;
    public static final int PPAD_MSG_AMOUNTOK               = 8;
    public static final int PPAD_MSG_NOTREADY               = 9;
    public static final int PPAD_MSG_IDLE                   = 10;
    public static final int PPAD_MSG_SLIDE_CARD             = 11;
    public static final int PPAD_MSG_INSERTCARD             = 12;
    public static final int PPAD_MSG_SELECTCARDTYPE         = 13;


    /////////////////////////////////////////////////////////////////////
    // "CapLanguage" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int PPAD_LANG_NONE                  = 1;
    public static final int PPAD_LANG_ONE                   = 2;
    public static final int PPAD_LANG_PINRESTRICTED         = 3;
    public static final int PPAD_LANG_UNRESTRICTED          = 4;

    /////////////////////////////////////////////////////////////////////
    // "TransactionType" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int PPAD_TRANS_DEBIT                = 1;
    public static final int PPAD_TRANS_CREDIT               = 2;
    public static final int PPAD_TRANS_INQ                  = 3;
    public static final int PPAD_TRANS_RECONCILE            = 4;
    public static final int PPAD_TRANS_ADMIN                = 5;


    /////////////////////////////////////////////////////////////////////
    // "EndEFTTransaction" Method Completion Code Constants
    /////////////////////////////////////////////////////////////////////

    public static final int PPAD_EFT_NORMAL                 = 1;
    public static final int PPAD_EFT_ABNORMAL               = 2;


    /////////////////////////////////////////////////////////////////////
    // "DataEvent" Event Status Constants
    /////////////////////////////////////////////////////////////////////
    public static final int PPAD_SUCCESS                    = 1;
    public static final int PPAD_CANCEL                     = 2;


		/////////////////////////////////////////////////////////////////////
		// "ErrorCodeExtended" Property Constants for PINPad
		/////////////////////////////////////////////////////////////////////

    public static final int JPOS_EPPAD_BAD_KEY   = 1 + JposConst.JPOSERREXT;
}