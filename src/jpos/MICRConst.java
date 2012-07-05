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
// MICRConst
//
//   MICR constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
// 2009-Feb-23 JavaPOS Release 1.13                               BS
//   Added "CountryCode"constant:
//     MICR_CC_CMC7
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface MICRConst
{
    //###################################################################
    //#### MICR Constants
    //###################################################################

    /////////////////////////////////////////////////////////////////////
    // "CheckType" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int MICR_CT_PERSONAL     =  1;
    public static final int MICR_CT_BUSINESS     =  2;
    public static final int MICR_CT_UNKNOWN      = 99;


    /////////////////////////////////////////////////////////////////////
    // "CountryCode" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int MICR_CC_USA          =  1;
    public static final int MICR_CC_CANADA       =  2;
    public static final int MICR_CC_MEXICO       =  3;
    public static final int MICR_CC_CMC7         =  4; // Added in 1.13
    public static final int MICR_CC_UNKNOWN      = 99;



    /////////////////////////////////////////////////////////////////////
    // "ResultCodeExtended" Property Constants for MICR
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_EMICR_NOCHECK    = 1 + JposConst.JPOSERREXT; // EndInsertion
    public static final int JPOS_EMICR_CHECK      = 2 + JposConst.JPOSERREXT; // EndRemoval

    // The following were added in Release 1.7
    public static final int JPOS_EMICR_BADDATA    = 3 + JposConst.JPOSERREXT;
    public static final int JPOS_EMICR_NODATA     = 4 + JposConst.JPOSERREXT;
    public static final int JPOS_EMICR_BADSIZE    = 5 + JposConst.JPOSERREXT;
    public static final int JPOS_EMICR_JAM        = 6 + JposConst.JPOSERREXT;
    public static final int JPOS_EMICR_CHECKDIGIT = 7 + JposConst.JPOSERREXT;
    public static final int JPOS_EMICR_COVEROPEN  = 8 + JposConst.JPOSERREXT;
}
