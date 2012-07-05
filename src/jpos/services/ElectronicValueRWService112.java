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
// ElectronicValueRWService112
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Electronic Value RW for release 1.12.
//
// Modification history
// ------------------------------------------------------------------
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;
import jpos.loader.*;

public interface ElectronicValueRWService112
  extends BaseService, JposServiceInstance
{
  // Capabilities
  public boolean getCapActivateService() throws JposException;
  public boolean getCapAddValue() throws JposException;
  public boolean getCapCancelValue() throws JposException;
  public int     getCapCardSensor() throws JposException;
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public int     getCapDetectionControl() throws JposException;
  public boolean getCapElectronicMoney() throws JposException;
  public boolean getCapEnumerateCardServices() throws JposException;
  public boolean getCapIndirectTransactionLog() throws JposException;
  public boolean getCapLockTerminal() throws JposException;
  public boolean getCapLogStatus() throws JposException;
  public boolean getCapMediumID() throws JposException;
  public boolean getCapPoint() throws JposException;
  public int     getCapPowerReporting() throws JposException;
  public boolean getCapRealTimeData() throws JposException;
  public boolean getCapStatisticsReporting() throws JposException;
  public boolean getCapSubtractValue() throws JposException;
  public boolean getCapTransaction() throws JposException;
  public boolean getCapTransactionLog() throws JposException;
  public boolean getCapUnlockTerminal() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;
  public boolean getCapUpdateKey() throws JposException;
  public boolean getCapUpdateStatistics() throws JposException;
  public boolean getCapVoucher() throws JposException;
  public boolean getCapWriteValue() throws JposException;

  // Properties
  public String  getAccountNumber() throws JposException;
  public String  getAdditionalSecurityInformation() throws JposException;
  public void    setAdditionalSecurityInformation(String addSecInfo) throws JposException;
  public long    getAmount() throws JposException;
  public void    setAmount(long amount) throws JposException;
  public String  getApprovalCode() throws JposException;
  public void    setApprovalCode(String approvalCode) throws JposException;
  public boolean getAsyncMode() throws JposException;
  public void    setAsyncMode(boolean asyncMode) throws JposException;
  public boolean getAutoDisable() throws JposException;
  public void    setAutoDisable(boolean autoDisable) throws JposException;
  public long    getBalance() throws JposException;
  public long    getBalanceOfPoint() throws JposException;
  public String  getCardServiceList() throws JposException;
  public String  getCurrentService() throws JposException;
  public void    setCurrentService(String currentService) throws JposException;
  public int     getDataCount() throws JposException;
  public boolean getDataEventEnabled() throws JposException;
  public void    setDataEventEnabled(boolean dataEventEnabled)
                     throws JposException;
  public boolean getDetectionControl() throws JposException;
  public void    setDetectionControl(boolean detectionControl) throws JposException;
  public int     getDetectionStatus() throws JposException;
  public String  getExpirationDate() throws JposException;
  public String  getLastUsedDate() throws JposException;
  public int     getLogStatus() throws JposException;
  public String  getMediumID() throws JposException;
  public void    setMediumID(String mediumID) throws JposException;
  public int     getOutputID() throws JposException;
  public long    getPoint() throws JposException;
  public void    setPoint(long point) throws JposException;
  public int     getPowerNotify() throws JposException;
  public void    setPowerNotify(int powerNotify) throws JposException;
  public int     getPowerState() throws JposException;
  public String  getReaderWriterServiceList() throws JposException;
  public int     getSequenceNumber() throws JposException;
  public long    getSettledAmount() throws JposException;
  public long    getSettledPoint() throws JposException;
  public String  getTransactionLog() throws JposException;
  public String  getVoucherID() throws JposException;
  public void    setVoucherID(String voucherID) throws JposException;
  public String  getVoucherIDList() throws JposException;
  public void    setVoucherIDList(String voucherIDList) throws JposException;

  // Methods
  public void    accessLog(int sequenceNumber,
                           int type,
                           int timeout)
                     throws JposException;
  public void    activateService(int[] data,
                                 Object[] obj)
                     throws JposException;
  public void    addValue(int sequenceNumber, int timeout)
                     throws JposException;
  public void    beginDetection(int type,
                                int timeout)
                     throws JposException;
  public void    beginRemoval(int timeout)
                     throws JposException;
  public void    cancelValue(int sequenceNumber,
                             int timeout)
                     throws JposException;
  public void    captureCard()
                     throws JposException;
  public void    clearInput()
                     throws JposException;
  public void    clearInputProperties()
                     throws JposException;
  public void    clearOutput()
                     throws JposException;
  public void    compareFirmwareVersion(String firmwareFileName,
                                        int[] result)
                     throws JposException;
  public void    endDetection()
                     throws JposException;
  public void    endRemoval()
                     throws JposException;
  public void    enumerateCardServices()
                     throws JposException;
  public void    lockTerminal()
                     throws JposException;
  public void    readValue(int sequenceNumber,
                           int timeout)
                     throws JposException;
  public void    resetStatistics(String statisticsBuffer)
                     throws JposException;
  public void    retrieveStatistics(String[] statisticsBuffer)
                     throws JposException;
  public void    subtractValue(int sequenceNumber,
                               int timeout)
                     throws JposException;
  public void    transactionAccess(int control)
                     throws JposException;
  public void    unlockTerminal()
                     throws JposException;
  public void    updateFirmware(String firmwareFileName)
                     throws JposException;
  public void    updateKey(int[] data,
                           Object[] obj)
                     throws JposException;
  public void    updateStatistics(String statisticsBuffer)
                     throws JposException;
  public void    writeValue(int sequenceNumber,
                            int timeout)
                     throws JposException;
}
