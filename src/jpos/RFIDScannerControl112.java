/////////////////////////////////////////////////////////////////////
//
// This software is provided "AS IS".  The JavaPOS working group(including
// each of the Corporate members, contributors and individuals)  MAKES NO
// REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
// EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
// WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NON-INFRINGEMENT. The JavaPOS working group shall not be liable for
// any damages suffered as a result of using, modifying or distributing this
// software or its derivatives.Permission to use, copy, modify, and distribute
// the software and its documentation for any purpose is hereby granted.
//
// RFIDScannerControl112
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to RFID Scanner for release 1.12.
//
// Modification history
// ------------------------------------------------------------------
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface RFIDScannerControl112 extends BaseControl
{
  // Capabilities
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public boolean getCapContinuousRead() throws JposException;
  public boolean getCapDisableTag() throws JposException;
  public boolean getCapLockTag() throws JposException;
  public int     getCapMultipleProtocols() throws JposException;
  public int     getCapPowerReporting() throws JposException;
  public boolean getCapReadTimer() throws JposException;
  public boolean getCapRealTimeData() throws JposException;
  public boolean getCapStatisticsReporting() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;
  public boolean getCapUpdateStatistics() throws JposException;
  public int     getCapWriteTag() throws JposException;

  // Properties
  public boolean getAutoDisable() throws JposException;
  public void    setAutoDisable(boolean autoDisable) throws JposException;
  public boolean getContinuousReadMode() throws JposException;
  public byte[]  getCurrentTagID() throws JposException;
  public int     getCurrentTagProtocol() throws JposException;
  public byte[]  getCurrentTagUserData() throws JposException;
  public int     getDataCount() throws JposException;
  public boolean getDataEventEnabled() throws JposException;
  public void    setDataEventEnabled(boolean dataEventEnabled)
                     throws JposException;
  public int     getOutputID() throws JposException;
  public int     getPowerNotify() throws JposException;
  public void    setPowerNotify(int powerNotify) throws JposException;
  public int     getPowerState() throws JposException;
  public int     getProtocolMask() throws JposException;
  public void    setProtocolMask(int protocolMask) throws JposException;
  public int     getReadTimerInterval() throws JposException;
  public void    setReadTimerInterval(int readTimerInterval) throws JposException;
  public int     getTagCount() throws JposException;

  // Methods
  public void    clearInput()
                     throws JposException;
  public void    clearInputProperties()
                     throws JposException;
  public void    clearOutput()
                     throws JposException;
  public void    compareFirmwareVersion(String firmwareFileName,
                                        int[] result)
                     throws JposException;
  public void    disableTag(byte[] tagID,
                            int timeout,
                            byte[] password)
                     throws JposException;
  public void    firstTag()
                     throws JposException;
  public void    lockTag(byte[] tagID,
                         int timeout,
                         byte[] password)
                     throws JposException;
  public void    nextTag()
                     throws JposException;
  public void    previousTag()
                     throws JposException;
  public void    readTags(int cmd,
                          byte[] filterID,
                          byte[] filtermask,
                          int start,
                          int length,
                          int timeout,
                          byte[] password)
                     throws JposException;
  public void    resetStatistics(String statisticsBuffer)
                     throws JposException;
  public void    retrieveStatistics(String[] statisticsBuffer)
                     throws JposException;
  public void    startReadTags(int cmd,
                               byte[] filterID,
                               byte[] filtermask,
                               int start,
                               int length,
                               byte[] password)
                     throws JposException;
  public void    stopReadTags(byte[] password)
                     throws JposException;
  public void    updateFirmware(String firmwareFileName)
                     throws JposException;
  public void    updateStatistics(String statisticsBuffer)
                     throws JposException;
  public void    writeTagData(byte[] tagID,
                              byte[] userdata,
                              int start,
                              int timeout,
                              byte[] password)
                     throws JposException;
  public void    writeTagID(byte[] sourceID,
                            byte[] destID,
                            int timeout,
                            byte[] password)
                     throws JposException;

  // Event listener methods
  public void    addDataListener(DataListener l);
  public void    removeDataListener(DataListener l);
  public void    addDirectIOListener(DirectIOListener l);
  public void    removeDirectIOListener(DirectIOListener l);
  public void    addErrorListener(ErrorListener l);
  public void    removeErrorListener(ErrorListener l);
  public void    addOutputCompleteListener(OutputCompleteListener l);
  public void    removeOutputCompleteListener(OutputCompleteListener l);
  public void    addStatusUpdateListener(StatusUpdateListener l);
  public void    removeStatusUpdateListener(StatusUpdateListener l);
}
