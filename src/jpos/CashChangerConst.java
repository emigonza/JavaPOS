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
// CashChangerConst
//
//   Cash Changer constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface CashChangerConst
{
    //###################################################################
    //#### Cash Changer Constants
    //###################################################################

    /////////////////////////////////////////////////////////////////////
    // "DeviceStatus" and "FullStatus" Property Constants
    // "StatusUpdateEvent" Event Constants
    /////////////////////////////////////////////////////////////////////

    public static final int CHAN_STATUS_OK       =  0; // DeviceStatus, FullStatus

    public static final int CHAN_STATUS_EMPTY    = 11; // DeviceStatus, StatusUpdateEvent
    public static final int CHAN_STATUS_NEAREMPTY= 12; // DeviceStatus, StatusUpdateEvent
    public static final int CHAN_STATUS_EMPTYOK  = 13; // StatusUpdateEvent

    public static final int CHAN_STATUS_FULL     = 21; // FullStatus, StatusUpdateEvent
    public static final int CHAN_STATUS_NEARFULL = 22; // FullStatus, StatusUpdateEvent
    public static final int CHAN_STATUS_FULLOK   = 23; // StatusUpdateEvent

    public static final int CHAN_STATUS_JAM      = 31; // DeviceStatus, StatusUpdateEvent
    public static final int CHAN_STATUS_JAMOK    = 32; // StatusUpdateEvent

    public static final int CHAN_STATUS_ASYNC    = 91; // StatusUpdateEvent


		/////////////////////////////////////////////////////////////////////
		// "DepositStatus" Property Constants
		/////////////////////////////////////////////////////////////////////

    public static final int CHAN_STATUS_DEPOSIT_START = 1;
    public static final int CHAN_STATUS_DEPOSIT_END   = 2;
    public static final int CHAN_STATUS_DEPOSIT_NONE  = 3;
    public static final int CHAN_STATUS_DEPOSIT_COUNT = 4;
    public static final int CHAN_STATUS_DEPOSIT_JAM   = 5;


		/////////////////////////////////////////////////////////////////////
		// "EndDeposit" Method: "Success" Parameter Constants
		/////////////////////////////////////////////////////////////////////

    public static final int CHAN_DEPOSIT_CHANGE   = 1;
    public static final int CHAN_DEPOSIT_NOCHANGE = 2;
    public static final int CHAN_DEPOSIT_REPAY    = 3;


		/////////////////////////////////////////////////////////////////////
		// "PauseDeposit" Method: "Control" Parameter Constants
		/////////////////////////////////////////////////////////////////////

    public static final int CHAN_DEPOSIT_PAUSE   = 11;
    public static final int CHAN_DEPOSIT_RESTART = 12;


    /////////////////////////////////////////////////////////////////////
    // "ResultCodeExtended" Property Constants for Cash Changer
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_ECHAN_OVERDISPENSE = 1 + JposConst.JPOSERREXT;
}