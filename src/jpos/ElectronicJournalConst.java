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
// ElectronicJournalConst
//
//   Electronic Journal constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2006-Feb-10 JavaPOS Release 1.10                                BS
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   Added new StatusUpdateEvent constant:
//       EJ_SUE_IDLE
// 2008-Apr-21 JavaPOS Release 1.12.1                              BS
//   Change value of EJ_SUE_IDLE to be the same value as used for
//   printer idle SUEs (1001).
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface ElectronicJournalConst
{
  //###################################################################
  //#### Electronic Journal Constants
  //###################################################################

  /////////////////////////////////////////////////////////////////////
  // "CapStation", "Station" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int EJ_S_RECEIPT = 0x00000001;
  public static final int EJ_S_SLIP    = 0x00000002;
  public static final int EJ_S_JOURNAL = 0x00000004;


  /////////////////////////////////////////////////////////////////////
  // "retrieveCurrentMarker" Method, "markerType" Parameter Constants
  // "retrieveMarker" Method, "markerType" Parameter Constants
  // "retrieveMarkerByDateTime" Method, "markerType" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int EJ_MT_SESSION_BEG = 1;
  public static final int EJ_MT_SESSION_END = 2;
  public static final int EJ_MT_DOCUMENT    = 3;
  public static final int EJ_MT_HEAD        = 4;
  public static final int EJ_MT_TAIL        = 5;


  /////////////////////////////////////////////////////////////////////
  // "ErrorEvent" "ErrorCodeExtended" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int JPOS_EEJ_EXISTING             = 1 + JposConst.JPOSERREXT;
  public static final int JPOS_EEJ_MEDIUM_FULL          = 2 + JposConst.JPOSERREXT;
  public static final int JPOS_EEJ_MULTIPLE_MARKER      = 3 + JposConst.JPOSERREXT;
  public static final int JPOS_EEJ_UNINITIALIZED_MEDIUM = 4 + JposConst.JPOSERREXT;
  public static final int JPOS_EEJ_CORRUPTED_MEDIUM     = 5 + JposConst.JPOSERREXT;
  public static final int JPOS_EEJ_UNKNOWN_DATAFORMAT   = 6 + JposConst.JPOSERREXT;
  public static final int JPOS_EEJ_NOT_ENOUGH_SPACE     = 7 + JposConst.JPOSERREXT;
  public static final int JPOS_EEJ_MULTIPLE_MARKERS     = 8 + JposConst.JPOSERREXT;


  /////////////////////////////////////////////////////////////////////
  // "StatusUpdateEvent" "Status" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int EJ_SUE_MEDIUM_NEAR_FULL =    1;
  public static final int EJ_SUE_MEDIUM_FULL      =    2;
  public static final int EJ_SUE_MEDIUM_REMOVED   =    3;
  public static final int EJ_SUE_MEDIUM_INSERTED  =    4;
  public static final int EJ_SUE_SUSPENDED        =    5;
  public static final int EJ_SUE_IDLE             = 1001; // 1.12.1
}