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
// BeltConst
//
//   Belt constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface BeltConst
{
  /////////////////////////////////////////////////////////////////////
  // "MotionStatus" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BELT_MT_FORWARD              = 1;
  public static final int BELT_MT_BACKWARD             = 2;
  public static final int BELT_MT_STOPPED              = 3;
  public static final int BELT_MT_EMERGENCY            = 4;
  public static final int BELT_MT_MOTOR_FAULT          = 5;


  /////////////////////////////////////////////////////////////////////
  // "adjustItemCount" Method: "Direction" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BELT_AIC_BACKWARD            = 1;
  public static final int BELT_AIC_FORWARD             = 2;


  /////////////////////////////////////////////////////////////////////
  // "resetItemCount" Method: "Direction" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BELT_RIC_BACKWARD            = 1;
  public static final int BELT_RIC_FORWARD             = 2;


  /////////////////////////////////////////////////////////////////////
  // "StatusUpdateEvent" Event: "Data" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BELT_SUE_AUTO_STOP                           = 11;
  public static final int BELT_SUE_EMERGENCY_STOP                      = 12;
  public static final int BELT_SUE_SAFETY_STOP                         = 13;
  public static final int BELT_SUE_TIMEOUT_STOP                        = 14;
  public static final int BELT_SUE_MOTOR_OVERHEATING                   = 15;
  public static final int BELT_SUE_MOTOR_FUSE_DEFECT                   = 16;
  public static final int BELT_SUE_LIGHT_BARRIER_BACKWARD_INTERRUPTED  = 17;
  public static final int BELT_SUE_LIGHT_BARRIER_BACKWARD_OK           = 18;
  public static final int BELT_SUE_LIGHT_BARRIER_FORWARD_INTERRUPTED   = 19;
  public static final int BELT_SUE_LIGHT_BARRIER_FORWARD_OK            = 20;
  public static final int BELT_SUE_SECURITY_FLAP_BACKWARD_OPENED       = 21;
  public static final int BELT_SUE_SECURITY_FLAP_BACKWARD_CLOSED       = 22;
  public static final int BELT_SUE_SECURITY_FLAP_FORWARD_OPENED        = 23;
  public static final int BELT_SUE_SECURITY_FLAP_FORWARD_CLOSED        = 24;
}
