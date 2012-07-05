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
// LineDisplayConst
//
//   Line Display constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
// 16-Apr-2003 Release 1.7.2: Added the missing constant          BS
//               DISP_CCT_NONE.
// 03-Jun-2003 JavaPOS Release 1.8                                BS
//    Added constants DISP_CCT_BLINK and DISP_CT_BLINK
// 15-Sep-2004 JavaPOS Release 1.8.2                              BS
//    Added missing constants EDISP_TOOBIG and EDISP_BADFORMAT.
/////////////////////////////////////////////////////////////////////

package jpos;

public interface LineDisplayConst
{
    //###################################################################
    //#### Line Display Constants
    //###################################################################

    /////////////////////////////////////////////////////////////////////
    // "CapBlink" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_CB_NOBLINK      = 0;
    public static final int DISP_CB_BLINKALL     = 1;
    public static final int DISP_CB_BLINKEACH    = 2;


    /////////////////////////////////////////////////////////////////////
    // "CapCharacterSet" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_CCS_NUMERIC     =   0;
    public static final int DISP_CCS_ALPHA       =   1;
    public static final int DISP_CCS_ASCII       = 998;
    public static final int DISP_CCS_KANA        =  10;
    public static final int DISP_CCS_KANJI       =  11;
    public static final int DISP_CCS_UNICODE     = 997;


    /////////////////////////////////////////////////////////////////////
    // "CapCursorType" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_CCT_NONE        =   0x00000000;
    public static final int DISP_CCT_FIXED       =   0x00000001;
    public static final int DISP_CCT_BLOCK       =   0x00000002;
    public static final int DISP_CCT_HALFBLOCK   =   0x00000004;
    public static final int DISP_CCT_UNDERLINE   =   0x00000008;
    public static final int DISP_CCT_REVERSE     =   0x00000010;
    public static final int DISP_CCT_OTHER       =   0x00000020;

    // Added in Release 1.8
    public static final int DISP_CCT_BLINK       =   0x00000040;


    /////////////////////////////////////////////////////////////////////
    // "CapReadBack" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_CRB_NONE        =   0x00000000;
    public static final int DISP_CRB_SINGLE      =   0x00000001;


    /////////////////////////////////////////////////////////////////////
    // "CapReverse" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_CR_NONE          =   0x00000000;
    public static final int DISP_CR_REVERSEALL    =   0x00000001;
    public static final int DISP_CR_REVERSEEACH   =   0x00000002;


    /////////////////////////////////////////////////////////////////////
    // "CharacterSet" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_CS_UNICODE      = 997;
    public static final int DISP_CS_ASCII        = 998;
    public static final int DISP_CS_ANSI         = 999;


    /////////////////////////////////////////////////////////////////////
    // "CursorType" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_CT_NONE        =   0;
    public static final int DISP_CT_FIXED       =   1;
    public static final int DISP_CT_BLOCK       =   2;
    public static final int DISP_CT_HALFBLOCK   =   3;
    public static final int DISP_CT_UNDERLINE   =   4;
    public static final int DISP_CT_REVERSE     =   5;
    public static final int DISP_CT_OTHER       =   6;

    // Added in Release 1.8
    public static final int DISP_CT_BLINK       =   0x10000000;


    /////////////////////////////////////////////////////////////////////
    // "MarqueeType" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_MT_NONE         = 0;
    public static final int DISP_MT_UP           = 1;
    public static final int DISP_MT_DOWN         = 2;
    public static final int DISP_MT_LEFT         = 3;
    public static final int DISP_MT_RIGHT        = 4;
    public static final int DISP_MT_INIT         = 5;


    /////////////////////////////////////////////////////////////////////
    // "MarqueeFormat" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_MF_WALK         = 0;
    public static final int DISP_MF_PLACE        = 1;


    /////////////////////////////////////////////////////////////////////
    // "DefineGlyph" Method: "GlyphType" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_GT_SINGLE       = 1;


    /////////////////////////////////////////////////////////////////////
    // "DisplayText" Method: "Attribute" Property Constants
    // "DisplayTextAt" Method: "Attribute" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_DT_NORMAL        = 0;
    public static final int DISP_DT_BLINK         = 1;
    public static final int DISP_DT_REVERSE       = 2;
    public static final int DISP_DT_BLINK_REVERSE = 3;


    /////////////////////////////////////////////////////////////////////
    // "ScrollText" Method: "Direction" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_ST_UP           = 1;
    public static final int DISP_ST_DOWN         = 2;
    public static final int DISP_ST_LEFT         = 3;
    public static final int DISP_ST_RIGHT        = 4;


    /////////////////////////////////////////////////////////////////////
    // "SetDescriptor" Method: "Attribute" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int DISP_SD_OFF          = 0;
    public static final int DISP_SD_ON           = 1;
    public static final int DISP_SD_BLINK        = 2;


    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    // The following were added in Release 1.7
    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////
    // "displayBitmap" and "setBitmap" Method Constants:
    /////////////////////////////////////////////////////////////////////

    //   "Width" Parameter

    public static final int DISP_BM_ASIS          = -11;

    //   "AlignmentX" Parameter

    public static final int DISP_BM_LEFT          = -1;
    public static final int DISP_BM_CENTER        = -2;
    public static final int DISP_BM_RIGHT         = -3;

    //   "AlignmentY" Parameter

    public static final int DISP_BM_TOP           = -1;
    //public static final int DISP_BM_CENTER      = -2;
    public static final int DISP_BM_BOTTOM        = -3;


    /////////////////////////////////////////////////////////////////////
    // "ErrorCodeExtended" Property Constants for Line Display
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_EDISP_TOOBIG    = 1 + JposConst.JPOSERREXT; // DisplayBitmap
    public static final int JPOS_EDISP_BADFORMAT = 2 + JposConst.JPOSERREXT; // DisplayBitmap
}