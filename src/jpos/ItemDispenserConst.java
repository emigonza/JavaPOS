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
// ItemDispenserConst
//
//   ItemDispenser constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface ItemDispenserConst
{
  /////////////////////////////////////////////////////////////////////
  // "DispenserStatus" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int ITEM_DS_OK                   = 1;
  public static final int ITEM_DS_EMPTY                = 2;
  public static final int ITEM_DS_NEAREMPTY            = 3;
  public static final int ITEM_DS_JAM                  = 4;


  /////////////////////////////////////////////////////////////////////
  // "StatusUpdateEvent" Event: "Data" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int ITEM_SUE_OK                  = 11;
  public static final int ITEM_SUE_EMPTY               = 12;
  public static final int ITEM_SUE_NEAREMPTY           = 13;
  public static final int ITEM_SUE_JAM                 = 14;
}
