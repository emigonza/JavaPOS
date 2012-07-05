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
// HardTotalsConst
//
//   Hard Totals constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface HardTotalsConst
{
    //###################################################################
    //#### Hard Totals Constants
    //###################################################################

    /////////////////////////////////////////////////////////////////////
    // "ResultCodeExtended" Property Constants for Hard Totals
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_ETOT_NOROOM     = 1 + JposConst.JPOSERREXT; // Create, Write
    public static final int JPOS_ETOT_VALIDATION = 2 + JposConst.JPOSERREXT; // Read, Write
}