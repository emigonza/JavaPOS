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
// ImageScannerConst
//
//   ImageScanner constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2007-Jan-04 JavaPOS Release 1.11                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface ImageScannerConst
{
  //###################################################################
  //#### ImageScanner Constants
  //###################################################################

  /////////////////////////////////////////////////////////////////////
  // "FrameType" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int IMG_FRAME_STILL              = 1;
  public static final int IMG_FRAME_VIDEO              = 2;


  /////////////////////////////////////////////////////////////////////
  // "ImageMode" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int IMG_ALL                      = 0xFF;
  public static final int IMG_DECODE_ONLY              = 0x01;
  public static final int IMG_STILL_ONLY               = 0x02;
  public static final int IMG_STILL_DECODE             = 0x03;
  public static final int IMG_VIDEO_DECODE             = 0x05;
  public static final int IMG_VIDEO_STILL              = 0x06;


/////////////////////////////////////////////////////////////////////
// "ImageQuality" Property Constants
/////////////////////////////////////////////////////////////////////

  public static final int IMG_QUAL_LOW                 = 0x01;
  public static final int IMG_QUAL_MED                 = 0x02;
  public static final int IMG_QUAL_HIGH                = 0x03;


  /////////////////////////////////////////////////////////////////////
  // "ImageType" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int IMG_TYP_BMP                  = 1;
  public static final int IMG_TYP_JPEG                 = 2;
  public static final int IMG_TYP_GIF                  = 3;
  public static final int IMG_TYP_PNG                  = 4;
  public static final int IMG_TYP_TIFF                 = 5;
}