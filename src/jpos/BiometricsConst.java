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
// BiometricsConst
//
//   Biometrics constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2006-Feb-10 JavaPOS Release 1.10                                BS
// 2006-Aug-11 JavaPOS Release 1.10.2                              BS
//   - Added missing constants:
//       BIO_FAR_PRECEDENCE
//       BIO_FRR_PRECEDENCE
// 2007-Jan-04 JavaPOS Release 1.11                                BS
//   Added new StatusUpdateEvent constants:
//       BIO_SUE_MOVE_SLOWER
//       BIO_SUE_MOVE_FASTER
//       BIO_SUE_SENSOR_DIRTY
//   Fixed incorrect spelling of constants:
//       BIO_CST_KEYSTROKE_DYNAMICS
//       BIO_ST_KEYSTROKE_DYNAMICS
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   Added new StatusUpdateEvent constant:
//       BIO_SUE_FAILED_READ
// 2009-Feb-23 JavaPOS Release 1.13                                BS
//   Added new StatusUpdateEvent constants:
//       BIO_SUE_SENSOR_READY
//       BIO_SUE_SENSOR_COMPLETE
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface BiometricsConst
{
  //###################################################################
  //#### Biometrics Constants
  //###################################################################

  /////////////////////////////////////////////////////////////////////
  // "CapSensorColor" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BIO_CSC_MONO      = 0x00000001;
  public static final int BIO_CSC_GRAYSCALE = 0x00000002;
  public static final int BIO_CSC_16        = 0x00000004;
  public static final int BIO_CSC_256       = 0x00000008;
  public static final int BIO_CSC_FULL      = 0x00000010;


  /////////////////////////////////////////////////////////////////////
  // "CapSensorOrientation" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BIO_CSO_NORMAL    = 0x00000001;
  public static final int BIO_CSO_RIGHT     = 0x00000002;
  public static final int BIO_CSO_INVERTED  = 0x00000004;
  public static final int BIO_CSO_LEFT      = 0x00000008;


  /////////////////////////////////////////////////////////////////////
  // "CapSensorType" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BIO_CST_FACIAL_FEATURES    = 0x00000001;
  public static final int BIO_CST_VOICE              = 0x00000002;
  public static final int BIO_CST_FINGERPRINT        = 0x00000004;
  public static final int BIO_CST_IRIS               = 0x00000008;
  public static final int BIO_CST_RETINA             = 0x00000010;
  public static final int BIO_CST_HAND_GEOMETRY      = 0x00000020;
  public static final int BIO_CST_SIGNATURE_DYNAMICS = 0x00000040;
  public static final int BIO_CST_KEYSTROKE_DYNAMICS = 0x00000080;
  public static final int BIO_CST_LIP_MOVEMENT       = 0x00000100;
  public static final int BIO_CST_THERMAL_FACE_IMAGE = 0x00000200;
  public static final int BIO_CST_THERMAL_HAND_IMAGE = 0x00000400;
  public static final int BIO_CST_GAIT               = 0x00000800;
  public static final int BIO_CST_PASSWORD           = 0x00001000;


  /////////////////////////////////////////////////////////////////////
  // "SensorColor" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BIO_SC_MONO      = 1;
  public static final int BIO_SC_GRAYSCALE = 2;
  public static final int BIO_SC_16        = 3;
  public static final int BIO_SC_256       = 4;
  public static final int BIO_SC_FULL      = 5;


  /////////////////////////////////////////////////////////////////////
  // "SensorOrientation" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BIO_SO_NORMAL    = 1;
  public static final int BIO_SO_RIGHT     = 2;
  public static final int BIO_SO_INVERTED  = 3;
  public static final int BIO_SO_LEFT      = 4;


  /////////////////////////////////////////////////////////////////////
  // "SensorType" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BIO_ST_FACIAL_FEATURES     =  1;
  public static final int BIO_ST_VOICE               =  2;
  public static final int BIO_ST_FINGERPRINT         =  3;
  public static final int BIO_ST_IRIS                =  4;
  public static final int BIO_ST_RETINA              =  5;
  public static final int BIO_ST_HAND_GEOMETRY       =  6;
  public static final int BIO_ST_SIGNATURE_DYNAMICS  =  7;
  public static final int BIO_ST_KEYSTROKE_DYNAMICS  =  8;
  public static final int BIO_ST_LIP_MOVEMENT        =  9;
  public static final int BIO_ST_THERMAL_FACE_IMAGE  = 10;
  public static final int BIO_ST_THERMAL_HAND_IMAGE  = 11;
  public static final int BIO_ST_GAIT                = 12;
  public static final int BIO_ST_PASSWORD            = 13;


  /////////////////////////////////////////////////////////////////////
  // "identify", "identifyMatch, "verify", and "verifyMatch"
  // "FARPrecedence" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final boolean BIO_FAR_PRECEDENCE = true;
  public static final boolean BIO_FRR_PRECEDENCE = false;


  /////////////////////////////////////////////////////////////////////
  // "DataEvent" "Status" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BIO_DATA_ENROLL = 1;
  public static final int BIO_DATA_VERIFY = 2;


  /////////////////////////////////////////////////////////////////////
  // "StatusUpdateEvent" "Status" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BIO_SUE_RAW_DATA        =  1;
  public static final int BIO_SUE_MOVE_LEFT       =  2;
  public static final int BIO_SUE_MOVE_RIGHT      =  3;
  public static final int BIO_SUE_MOVE_DOWN       =  4;
  public static final int BIO_SUE_MOVE_UP         =  5;
  public static final int BIO_SUE_MOVE_CLOSER     =  6;
  public static final int BIO_SUE_MOVE_AWAY       =  7;
  public static final int BIO_SUE_MOVE_BACKWARD   =  8;
  public static final int BIO_SUE_MOVE_FORWARD    =  9;
  public static final int BIO_SUE_MOVE_SLOWER     = 10; // 1.11
  public static final int BIO_SUE_MOVE_FASTER     = 11; // 1.11
  public static final int BIO_SUE_SENSOR_DIRTY    = 12; // 1.11
  public static final int BIO_SUE_FAILED_READ     = 13; // 1.12
  public static final int BIO_SUE_SENSOR_READY    = 14; // 1.13
  public static final int BIO_SUE_SENSOR_COMPLETE = 15; // 1.13
  public static final int BIO_CST_KEYSTOKE_DYNAMICS = 0;// Added by Ergio
}