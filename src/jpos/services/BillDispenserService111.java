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
// BillDispenserService111
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Bill Dispenser for release 1.11.
//
// Modification history
// ------------------------------------------------------------------
// 2007-Jan-04 JavaPOS Release 1.11                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;
import jpos.loader.*;

public interface BillDispenserService111
  extends BaseService, JposServiceInstance
{
  // Capabilities
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public boolean getCapDiscrepancy() throws JposException;
  public boolean getCapEmptySensor() throws JposException;
  public boolean getCapJamSensor() throws JposException;
  public boolean getCapNearEmptySensor() throws JposException;
  public int     getCapPowerReporting() throws JposException;
  public boolean getCapStatisticsReporting() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;
  public boolean getCapUpdateStatistics() throws JposException;

  // Properties
  public boolean getAsyncMode() throws JposException;
  public void    setAsyncMode(boolean asyncMode) throws JposException;
  public int     getAsyncResultCode() throws JposException;
  public int     getAsyncResultCodeExtended() throws JposException;
  public String  getCurrencyCashList() throws JposException;
  public String  getCurrencyCode() throws JposException;
  public void    setCurrencyCode(String currencyCode) throws JposException;
  public String  getCurrencyCodeList() throws JposException;
  public int     getCurrentExit() throws JposException;
  public void    setCurrentExit(int currentExit) throws JposException;
  public int     getDeviceExits() throws JposException;
  public int     getDeviceStatus() throws JposException;
  public String  getExitCashList() throws JposException;
  public int     getPowerNotify() throws JposException;
  public void    setPowerNotify(int powerNotify) throws JposException;
  public int     getPowerState() throws JposException;


  // Methods
  public void    adjustCashCounts(String cashCounts)
                     throws JposException;
  public void    clearOutput()  throws JposException;
  public void    compareFirmwareVersion(String firmwareFileName,
                                        int[] result)
                     throws JposException;
  public void    dispenseCash(String cashCounts)
                     throws JposException;
  public void    readCashCounts(String[] cashCounts,
                                boolean[] discrepancy)
                     throws JposException;
  public void    resetStatistics(String statisticsBuffer)
                     throws JposException;
  public void    retrieveStatistics(String[] statisticsBuffer)
                     throws JposException;
  public void    updateFirmware(String firmwareFileName)
                     throws JposException;
  public void    updateStatistics(String statisticsBuffer)
                     throws JposException;
}
