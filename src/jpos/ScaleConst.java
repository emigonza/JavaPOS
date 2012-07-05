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
// ScaleConst
//
//   Scale constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 1998-Feb-18 JavaPOS Release 1.2                                 BS
// 2005-Jan-16 JavaPOS Release 1.9                                 BS
//   Added the following constants:
//     SCAL_SN_DISABLED
//     SCAL_SN_ENABLED
//     JPOS_ESCAL_UNDER_ZERO
//     JPOS_ESCAL_SAME_WEIGHT
//     SCL_SUE_STABLE_WEIGHT
//     SCL_SUE_WEIGHT_UNSTABLE
//     SCL_SUE_WEIGHT_ZERO
//     SCL_SUE_WEIGHT_OVERWEIGHT
//     SCL_SUE_NOT_READY
//     SCL_SUE_WEIGHT_UNDER_ZERO
// 2006-Feb-10 JavaPOS Release 1.10                                BS
//   Added duplicate SUE constants to match names used in the spec.
//     (i.e. SCAL_SUE_STABLE_WEIGHT instead of SCL_SUE_STABLE_WEIGHT)
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface ScaleConst
{
    //###################################################################
    //#### Scale Constants
    //###################################################################

    /////////////////////////////////////////////////////////////////////
    // "WeightUnit" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int SCAL_WU_GRAM         = 1;
    public static final int SCAL_WU_KILOGRAM     = 2;
    public static final int SCAL_WU_OUNCE        = 3;
    public static final int SCAL_WU_POUND        = 4;


    /////////////////////////////////////////////////////////////////////
    // "StatusNotify" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int SCAL_SN_DISABLED = 1;
    public static final int SCAL_SN_ENABLED  = 2;


    /////////////////////////////////////////////////////////////////////
    // "StatusUpdateEvent" "Status" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int SCL_SUE_STABLE_WEIGHT     = 11;
    public static final int SCL_SUE_WEIGHT_UNSTABLE   = 12;
    public static final int SCL_SUE_WEIGHT_ZERO       = 13;
    public static final int SCL_SUE_WEIGHT_OVERWEIGHT = 14;
    public static final int SCL_SUE_NOT_READY         = 15;
    public static final int SCL_SUE_WEIGHT_UNDER_ZERO = 16;

    // 1.10 Correction: new names that actually match the UnifiedPOS
    //   specification
    public static final int SCAL_SUE_STABLE_WEIGHT     = 11;
    public static final int SCAL_SUE_WEIGHT_UNSTABLE   = 12;
    public static final int SCAL_SUE_WEIGHT_ZERO       = 13;
    public static final int SCAL_SUE_WEIGHT_OVERWEIGHT = 14;
    public static final int SCAL_SUE_NOT_READY         = 15;
    public static final int SCAL_SUE_WEIGHT_UNDER_ZERO = 16;


    /////////////////////////////////////////////////////////////////////
    // "ResultCodeExtended" Property Constants for Scale
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_ESCAL_OVERWEIGHT  = 1 + JposConst.JPOSERREXT; // ReadWeight
    public static final int JPOS_ESCAL_UNDER_ZERO  = 2 + JposConst.JPOSERREXT; // ReadWeight
    public static final int JPOS_ESCAL_SAME_WEIGHT = 3 + JposConst.JPOSERREXT; // ReadWeight
}