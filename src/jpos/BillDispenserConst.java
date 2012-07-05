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
// BillDispenserConst
//
//   BillDispenser constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2007-Jan-04 JavaPOS Release 1.11                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface BillDispenserConst
{
  //###################################################################
  //#### BillDispenser Constants
  //###################################################################

  /////////////////////////////////////////////////////////////////////
  // "DeviceStatus" Property Constants
  // "StatusUpdateEvent" Event Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BDSP_STATUS_OK               = 0;  // DeviceStatus

  public static final int BDSP_STATUS_EMPTY            = 11; // DeviceStatus, StatusUpdateEvent
  public static final int BDSP_STATUS_NEAREMPTY        = 12; // DeviceStatus, StatusUpdateEvent
  public static final int BDSP_STATUS_EMPTYOK          = 13; // StatusUpdateEvent

  public static final int BDSP_STATUS_JAM              = 31; // DeviceStatus, StatusUpdateEvent
  public static final int BDSP_STATUS_JAMOK            = 32; // StatusUpdateEvent

  public static final int BDSP_STATUS_ASYNC            = 91; // StatusUpdateEvent


  /////////////////////////////////////////////////////////////////////
  // "ResultCodeExtended" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int JPOS_EBDSP_OVERDISPENSE      = 201; // DispenseCash
}