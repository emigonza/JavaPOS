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
// KeylockConst
//
//   Keylock constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 1998-Feb-18 JavaPOS Release 1.2                                 BS
// 2007-Jan-04 JavaPOS Release 1.11                                BS
//   Added new StatusUpdateEvent constant:
//       LOCK_KP_ELECTRONIC
//   Added new CapKeylockType constants:
//       LOCK_KT_STANDARD
//       LOCK_KT_ELECTRONIC
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface KeylockConst
{
    //###################################################################
    //#### Keylock Constants
    //###################################################################

    /////////////////////////////////////////////////////////////////////
    // "KeyPosition" Property Constants
    // "WaitForKeylockChange" Method: "KeyPosition" Parameter
    // "StatusUpdateEvent" Event: "status" Parameter
    /////////////////////////////////////////////////////////////////////

    public static final int LOCK_KP_ANY          = 0; // WaitForKeylockChange Only
    public static final int LOCK_KP_ELECTRONIC   = 0; // StatusUpdateEvent Only (1.11)
    public static final int LOCK_KP_LOCK         = 1;
    public static final int LOCK_KP_NORM         = 2;
    public static final int LOCK_KP_SUPR         = 3;


    /////////////////////////////////////////////////////////////////////
    // "CapKeylockType" Property Constants                  Added in 1.11
    /////////////////////////////////////////////////////////////////////

    public static final int LOCK_KT_STANDARD     = 1; // 1.11
    public static final int LOCK_KT_ELECTRONIC   = 2; // 1.11
}