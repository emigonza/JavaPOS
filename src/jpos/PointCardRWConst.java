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
// PointCardRWConst
//
//   PointCardRW constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2000-Apr-18 JavaPOS Release 1.5                                 BS
// 2005-Jan-16 JavaPOS Release 1.9                                 BS
//   Added the following constants (misnamed originally) :
//     PCRW_SUE_NOCARD
//     PCRW_SUE_REMAINING
//     PCRW_SUE_INRW
//   Removed the following constant which was included incorrectly:
//     PCRW_RP_NORMAL_ASYNC
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface PointCardRWConst
{
    /////////////////////////////////////////////////////////////////////
    // "CapCharacterSet" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int PCRW_CCS_ALPHA        =   1;
    public static final int PCRW_CCS_ASCII        = 998;
    public static final int PCRW_CCS_KANA         =  10;
    public static final int PCRW_CCS_KANJI        =  11;
    public static final int PCRW_CCS_UNICODE      = 997;


    /////////////////////////////////////////////////////////////////////
    // "CharacterSet" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int PCRW_CS_UNICODE       = 997;
    public static final int PCRW_CS_ASCII         = 998;
    public static final int PCRW_CS_ANSI          = 999;


    /////////////////////////////////////////////////////////////////////
    // "CardState" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int PCRW_STATE_NOCARD     = 1;
    public static final int PCRW_STATE_REMAINING  = 2;
    public static final int PCRW_STATE_INRW       = 3;


    /////////////////////////////////////////////////////////////////////
    // CapTrackToRead and TrackToWrite Property constants
    /////////////////////////////////////////////////////////////////////

    public static final int PCRW_TRACK1   = 0x0001;
    public static final int PCRW_TRACK2   = 0x0002;
    public static final int PCRW_TRACK3   = 0x0004;
    public static final int PCRW_TRACK4   = 0x0008;
    public static final int PCRW_TRACK5   = 0x0010;
    public static final int PCRW_TRACK6   = 0x0020;


    /////////////////////////////////////////////////////////////////////
    // "MapMode" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int PCRW_MM_DOTS          = 1;
    public static final int PCRW_MM_TWIPS         = 2;
    public static final int PCRW_MM_ENGLISH       = 3;
    public static final int PCRW_MM_METRIC        = 4;


    /////////////////////////////////////////////////////////////////////
    // "RotatePrint" Method: "Rotation" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int PCRW_RP_NORMAL        = 0x0001;
    // In drafts of spec, but not in final - should never have been defined.
    //public static final int PCRW_RP_NORMAL_ASYNC  = 0x0002;

    public static final int PCRW_RP_RIGHT90       = 0x0101;
    public static final int PCRW_RP_LEFT90        = 0x0102;
    public static final int PCRW_RP_ROTATE180     = 0x0103;


    /////////////////////////////////////////////////////////////////////
    // Status Update Event: "Status" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int PCRW_SUE_STATE_NOCARD     = 1;
    public static final int PCRW_SUE_STATE_REMAINING  = 2;
    public static final int PCRW_SUE_STATE_INRW       = 3;

    public static final int PCRW_SUE_NOCARD           = 1;
    public static final int PCRW_SUE_REMAINING        = 2;
    public static final int PCRW_SUE_INRW             = 3;


    /////////////////////////////////////////////////////////////////////
    // "ErrorCodeExtended" Property (ErrorEvent) Constants for PintCardRW
    //   Also used in "ReaseStateX" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_EPCRW_READ    =  1 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_WRITE   =  2 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_JAM     =  3 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_MOTOR   =  4 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_COVER   =  5 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_PRINTER =  6 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_RELEASE =  7 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_DISPLAY =  8 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_NOCARD  =  9 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_START   = 10 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_END     = 11 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_PARITY  = 12 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_ENCODE  = 13 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_LRC     = 14 + JposConst.JPOSERREXT;
    public static final int JPOS_EPCRW_VERIFY  = 15 + JposConst.JPOSERREXT;
}