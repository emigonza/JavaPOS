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
// BillAcceptorConst
//
//   BillAcceptor constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2007-Jan-04 JavaPOS Release 1.11                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface BillAcceptorConst
{
  //###################################################################
  //#### BillAcceptor Constants
  //###################################################################

  /////////////////////////////////////////////////////////////////////
  // "FullStatus" Property Constants
  // "StatusUpdateEvent" Event Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BACC_STATUS_OK               = 0;  // FullStatus

  public static final int BACC_STATUS_FULL             = 21; // FullStatus, StatusUpdateEvent
  public static final int BACC_STATUS_NEARFULL         = 22; // FullStatus, StatusUpdateEvent
  public static final int BACC_STATUS_FULLOK           = 23; // StatusUpdateEvent

  public static final int BACC_STATUS_JAM              = 31; // StatusUpdateEvent
  public static final int BACC_STATUS_JAMOK            = 32; // StatusUpdateEvent


  /////////////////////////////////////////////////////////////////////
  // "DepositStatus" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BACC_STATUS_DEPOSIT_START    = 1;
  public static final int BACC_STATUS_DEPOSIT_END      = 2;
  public static final int BACC_STATUS_DEPOSIT_COUNT    = 4;
  public static final int BACC_STATUS_DEPOSIT_JAM      = 5;


  /////////////////////////////////////////////////////////////////////
  // "EndDeposit" Method Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BACC_DEPOSIT_COMPLETE        = 11;


  /////////////////////////////////////////////////////////////////////
  // "PauseDeposit" Method Constants
  /////////////////////////////////////////////////////////////////////

  public static final int BACC_DEPOSIT_PAUSE           = 11;
  public static final int BACC_DEPOSIT_RESTART         = 12;
}
