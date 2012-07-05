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
// CoinDispenserConst
//
//   Coin Dispenser constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface CoinDispenserConst
{
    //###################################################################
    //#### Coin Dispenser Constants
    //###################################################################

    /////////////////////////////////////////////////////////////////////
    // "DispenserStatus" Property Constants
    // "StatusUpdateEvent" Event: "status" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int COIN_STATUS_OK       = 1;
    public static final int COIN_STATUS_EMPTY    = 2;
    public static final int COIN_STATUS_NEAREMPTY= 3;
    public static final int COIN_STATUS_JAM      = 4;
}