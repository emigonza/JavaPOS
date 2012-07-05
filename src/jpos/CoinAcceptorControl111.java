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
// CoinAcceptorControl111
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Coin Acceptor for release 1.11.
//
// Modification history
// ------------------------------------------------------------------
// 2007-Jan-04 JavaPOS Release 1.11                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface CoinAcceptorControl111 extends BaseControl
{
  // Capabilities
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public boolean getCapDiscrepancy() throws JposException;
  public boolean getCapFullSensor() throws JposException;
  public boolean getCapJamSensor() throws JposException;
  public boolean getCapNearFullSensor() throws JposException;
  public boolean getCapPauseDeposit() throws JposException;
  public int     getCapPowerReporting() throws JposException;
  public boolean getCapRealTimeData() throws JposException;
  public boolean getCapStatisticsReporting() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;
  public boolean getCapUpdateStatistics() throws JposException;

  // Properties
  public String  getCurrencyCode() throws JposException;
  public void    setCurrencyCode(String currencyCode) throws JposException;
  public int     getDataCount() throws JposException;
  public boolean getDataEventEnabled() throws JposException;
  public void    setDataEventEnabled(boolean dataEventEnabled)
                     throws JposException;
  public int     getDepositAmount() throws JposException;
  public String  getDepositCashList() throws JposException;
  public String  getDepositCodeList() throws JposException;
  public String  getDepositCounts() throws JposException;
  public int     getDepositStatus() throws JposException;
  public int     getFullStatus() throws JposException;
  public int     getPowerNotify() throws JposException;
  public void    setPowerNotify(int powerNotify) throws JposException;
  public int     getPowerState() throws JposException;
  public boolean getRealTimeDataEnabled() throws JposException;
  public void    setRealTimeDataEnabled(boolean bEnabled) throws JposException;

  // Methods
  public void    adjustCashCounts(String cashCounts)
                     throws JposException;
  public void    beginDeposit()
                     throws JposException;
  public void    clearInput()  throws JposException;
  public void    compareFirmwareVersion(String firmwareFileName,
                                        int[] result)
                     throws JposException;
  public void    endDeposit(int success)
                     throws JposException;
  public void    fixDeposit()
                     throws JposException;
  public void    pauseDeposit(int control)
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

  // Event listener methods
  public void    addDataListener(DataListener l);
  public void    removeDataListener(DataListener l);
  public void    addDirectIOListener(DirectIOListener l);
  public void    removeDirectIOListener(DirectIOListener l);
  public void    addStatusUpdateListener(StatusUpdateListener l);
  public void    removeStatusUpdateListener(StatusUpdateListener l);
}
