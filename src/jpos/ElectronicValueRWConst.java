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
// ElectronicValueRWConst
//
//   ElectronicValueRW constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface ElectronicValueRWConst
{
  /////////////////////////////////////////////////////////////////////
  // "CapCardSensor" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int EVRW_CCS_ENTRY               = 0x00000001;
  public static final int EVRW_CCS_DETECT              = 0x00000002;
  public static final int EVRW_CCS_CAPTURE             = 0x00000004;


  /////////////////////////////////////////////////////////////////////
  // "CapDetectionControl" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int EVRW_CDC_RWCONTROL           = 0x00000001;
  public static final int EVRW_CDC_APPLICATIONCONTROL  = 0x00000002;


  /////////////////////////////////////////////////////////////////////
  // "DetectionStatus" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int EVRW_DS_NOCARD               = 1;
  public static final int EVRW_DS_DETECTED             = 2;
  public static final int EVRW_DS_ENTERED              = 3;
  public static final int EVRW_DS_CAPTURED             = 4;


  /////////////////////////////////////////////////////////////////////
  // "LogStatus" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int EVRW_LS_OK                   = 1;
  public static final int EVRW_LS_NEARFULL             = 2;
  public static final int EVRW_LS_FULL                 = 3;


  /////////////////////////////////////////////////////////////////////
  // "accessLog" Method: "Type" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int EVRW_AL_REPORTING            = 1;
  public static final int EVRW_AL_SETTLEMENT           = 2;


  /////////////////////////////////////////////////////////////////////
  // "beginDetection" Method: "Type" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int EVRW_BD_ANY                  = 1;
  public static final int EVRW_BD_SPECIFIC             = 2;


  /////////////////////////////////////////////////////////////////////
  // "transactionAccess" Method: "Control" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int EVRW_TA_TRANSACTION          = 11;
  public static final int EVRW_TA_NORMAL               = 12;


  /////////////////////////////////////////////////////////////////////
  // "StatusUpdateEvent" Event: "Data" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int EVRW_SUE_LS_OK                  = 11;
  public static final int EVRW_SUE_LS_NEARFULL            = 12;
  public static final int EVRW_SUE_LS_FULL                = 13;
  public static final int EVRW_SUE_DS_NOCARD              = 21;
  public static final int EVRW_SUE_DS_DETECTED            = 22;
  public static final int EVRW_SUE_DS_ENTERED             = 23;
  public static final int EVRW_SUE_DS_CAPTURED            = 24;


  /////////////////////////////////////////////////////////////////////
  // "ResultCodeExtended" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int OPOS_EVRW_NOCARD                = 201;
  public static final int OPOS_EVRW_RELEASE               = 202;
  public static final int OPOS_EVRW_CENTERERROR           = 203;
  public static final int OPOS_EVRW_COMMANDERROR          = 204;
  public static final int OPOS_EVRW_RESET                 = 205;
  public static final int OPOS_EVRW_COMMUNICATIONERROR    = 206;
  public static final int OPOS_EVRW_LOGOVERFLOW           = 207;
  public static final int OPOS_EVRW_DAILYLOGOVERFLOW      = 208;
  public static final int OPOS_EVRW_DEFICIENT             = 209;
  public static final int OPOS_EVRW_OVERDEPOSIT           = 210;
}
