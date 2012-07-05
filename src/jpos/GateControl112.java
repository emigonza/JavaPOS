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
// GateControl112
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Gate for release 1.12.
//
// Modification history
// ------------------------------------------------------------------
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface GateControl112 extends BaseControl
{
  // Capabilities
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public boolean getCapGateStatus() throws JposException;
  public int     getCapPowerReporting() throws JposException;
  public boolean getCapRealTimeData() throws JposException;
  public boolean getCapStatisticsReporting() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;
  public boolean getCapUpdateStatistics() throws JposException;

  // Properties
  public int     getGetStatus() throws JposException;
  public int     getPowerNotify() throws JposException;
  public void    setPowerNotify(int powerNotify) throws JposException;
  public int     getPowerState() throws JposException;

  // Methods
  public void    compareFirmwareVersion(String firmwareFileName,
                                        int[] result)
                     throws JposException;
  public void    openGate()
                     throws JposException;
  public void    resetStatistics(String statisticsBuffer)
                     throws JposException;
  public void    retrieveStatistics(String[] statisticsBuffer)
                     throws JposException;
  public void    updateFirmware(String firmwareFileName)
                     throws JposException;
  public void    updateStatistics(String statisticsBuffer)
                     throws JposException;
  public void    waitForGateClose(int timeout)
                     throws JposException;

  // Event listener methods
  public void    addDirectIOListener(DirectIOListener l);
  public void    removeDirectIOListener(DirectIOListener l);
  public void    addStatusUpdateListener(StatusUpdateListener l);
  public void    removeStatusUpdateListener(StatusUpdateListener l);
}
