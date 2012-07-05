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
// POSPowerControl19
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to POSPower for release 1.9.
//
// Modification history
// ------------------------------------------------------------------
// 2005-Jan-16 JavaPOS release 1.9                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface POSPowerControl19 extends POSPowerControl18
{
  // Capabilities
  public boolean getCapBatteryCapacityRemaining() throws JposException;
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public boolean getCapRestartPOS() throws JposException;
  public boolean getCapStandbyPOS() throws JposException;
  public boolean getCapSuspendPOS() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;
  public boolean getCapVariableBatteryCriticallyLowThreshold() throws JposException;
  public boolean getCapVariableBatteryLowThreshold() throws JposException;

  // Properties
  public int     getBatteryCapacityRemaining() throws JposException;
  public int     getBatteryCriticallyLowThreshold() throws JposException;
  public void    setBatteryCriticallyLowThreshold(int threshold) throws JposException;
  public int     getBatteryLowThreshold() throws JposException;
  public void    setBatteryLowThreshold(int threshold) throws JposException;
  public int     getPowerSource() throws JposException;

  // Methods
  public void    compareFirmwareVersion(String firmwareFileName, int[] result)
                     throws JposException;
  public void    restartPOS()
                     throws JposException;
  public void    standbyPOS(int reason)
                     throws JposException;
  public void    suspendPOS(int reason)
                     throws JposException;
  public void    updateFirmware(String firmwareFileName)
                     throws JposException;
}