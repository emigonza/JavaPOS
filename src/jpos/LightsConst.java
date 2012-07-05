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
// LightsConst
//
//   Lights constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface LightsConst
{
  /////////////////////////////////////////////////////////////////////
  // "CapAlarm" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int LGT_ALARM_NOALARM                    = 0x00000001;
  public static final int LGT_ALARM_SLOW                       = 0x00000010;
  public static final int LGT_ALARM_MEDIUM                     = 0x00000020;
  public static final int LGT_ALARM_FAST                       = 0x00000040;
  public static final int LGT_ALARM_CUSTOM1                    = 0x00010000;
  public static final int LGT_ALARM_CUSTOM2                    = 0x00020000;


  /////////////////////////////////////////////////////////////////////
  // "CapColor" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int LGT_COLOR_PRIMARY                    = 0x00000001;
  public static final int LGT_COLOR_CUSTOM1                    = 0x00010000;
  public static final int LGT_COLOR_CUSTOM2                    = 0x00020000;
  public static final int LGT_COLOR_CUSTOM3                    = 0x00040000;
  public static final int LGT_COLOR_CUSTOM4                    = 0x00080000;
  public static final int LGT_COLOR_CUSTOM5                    = 0x00100000;
}
