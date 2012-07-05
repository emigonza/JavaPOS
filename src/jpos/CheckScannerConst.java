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
// CheckScannerConst
//
//   Check Scanner constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2002-Jul-01 JavaPOS Release 1.7                                 BS
// 2005-Jan-16 JavaPOS Release 1.9                                 BS
//   Added the following constants:
//     CHK_AUTOMATIC_CONTRAST
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface CheckScannerConst
{
    //###################################################################
    //#### Check Scanner Constants
    //###################################################################

    /////////////////////////////////////////////////////////////////////
    // "CapColor" Capability Constants
    /////////////////////////////////////////////////////////////////////

    public static final int CHK_CCL_MONO      = 0x00000001;
    public static final int CHK_CCL_GRAYSCALE = 0x00000002;
    public static final int CHK_CCL_16        = 0x00000004;
    public static final int CHK_CCL_256       = 0x00000008;
    public static final int CHK_CCL_FULL      = 0x00000010;

    /////////////////////////////////////////////////////////////////////
    // "CapImageFormat" Capability Constants
    /////////////////////////////////////////////////////////////////////

    public static final int CHK_CIF_NATIVE = 0x00000001;
    public static final int CHK_CIF_TIFF   = 0x00000002;
    public static final int CHK_CIF_BMP    = 0x00000004;
    public static final int CHK_CIF_JPEG   = 0x00000008;
    public static final int CHK_CIF_GIF    = 0x00000010;

    /////////////////////////////////////////////////////////////////////
    // "Color" Capability Constants
    /////////////////////////////////////////////////////////////////////

    public static final int CHK_CL_MONO      = 1;
    public static final int CHK_CL_GRAYSCALE = 2;
    public static final int CHK_CL_16        = 3;
    public static final int CHK_CL_256       = 4;
    public static final int CHK_CL_FULL      = 5;

    /////////////////////////////////////////////////////////////////////
    // "constrast" Property Constants:
    /////////////////////////////////////////////////////////////////////

    public static final int CHK_AUTOMATIC_CONTRAST = -1;

    /////////////////////////////////////////////////////////////////////
    // "ImageFormat" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int CHK_IF_NATIVE = 1;
    public static final int CHK_IF_TIFF   = 2;
    public static final int CHK_IF_BMP    = 3;
    public static final int CHK_IF_JPEG   = 4;
    public static final int CHK_IF_GIF    = 5;

    /////////////////////////////////////////////////////////////////////
    // "ImageMemoryStatus" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int CHK_IMS_EMPTY = 1;
    public static final int CHK_IMS_OK    = 2;
    public static final int CHK_IMS_FULL  = 3;

    /////////////////////////////////////////////////////////////////////
    // "MapMode" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int CHK_MM_DOTS          = 1;
    public static final int CHK_MM_TWIPS         = 2;
    public static final int CHK_MM_ENGLISH       = 3;
    public static final int CHK_MM_METRIC        = 4;

    /////////////////////////////////////////////////////////////////////
    // "clearImage" Method Constants:
    /////////////////////////////////////////////////////////////////////

    //   "by" Parameter
    public static final int CHK_CLR_ALL             = 1;
    public static final int CHK_CLR_BY_FILEID       = 2;
    public static final int CHK_CLR_BY_FILEINDEX    = 3;
    public static final int CHK_CLR_BY_IMAGETAGDATA = 4;

    /////////////////////////////////////////////////////////////////////
    // "defineCropArea" Method Constants:
    /////////////////////////////////////////////////////////////////////

    // "cropAreaID" Parameter or index number
    public static final int CHK_CROP_AREA_ENTIRE_IMAGE = -1;
    public static final int CHK_CROP_AREA_RESET_ALL    = -2;

    // "cx" Parameter or integer width
    public static final int CHK_CROP_AREA_RIGHT        = -1;

    // "cy" Parameter or integer height
    public static final int CHK_CROP_AREA_BOTTOM       = -1;

    /////////////////////////////////////////////////////////////////////
    // "retrieveMemory" Method Constants:
    /////////////////////////////////////////////////////////////////////

    // "by" Parameter
    public static final int CHK_LOCATE_BY_FILEID       = 1;
    public static final int CHK_LOCATE_BY_FILEINDEX    = 2;
    public static final int CHK_LOCATE_BY_IMAGETAGDATA = 3;

    /////////////////////////////////////////////////////////////////////
    // "RetrieveImage" and "StoreImage" Method Constant:
    /////////////////////////////////////////////////////////////////////

    // "CropAreaID" Parameter or index number
    //public static final int CHK_CROP_AREA_ENTIRE_IMAGE = -1; (Defined above)

    /////////////////////////////////////////////////////////////////////
    // "ErrorCodeExtended" Property Constants for Check Scanner
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_ECHK_NOCHECK = 1 + JposConst.JPOSERREXT; // endInsertion
    public static final int JPOS_ECHK_CHECK   = 2 + JposConst.JPOSERREXT; // endRemoval
    public static final int JPOS_ECHK_NOROOM  = 3 + JposConst.JPOSERREXT; // storeImage

    /////////////////////////////////////////////////////////////////////
    // "StatusUpdateEvent" Event: "status" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int CHK_SUE_SCANCOMPLETE = 11;
}