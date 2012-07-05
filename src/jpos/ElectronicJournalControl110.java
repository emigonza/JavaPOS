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
// ElectronicJournalControl110
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Electronic Journal for release
//   1.10.
//
// Modification history
// ------------------------------------------------------------------
// 2006-Feb-10 JavaPOS Release 1.10                                BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface ElectronicJournalControl110 extends BaseControl
{
  // Capabilities
  public boolean getCapAddMarker() throws JposException;
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public boolean getCapErasableMedium() throws JposException;
  public boolean getCapInitializeMedium() throws JposException;
  public boolean getCapMediumIsAvailable() throws JposException;
  public int     getCapPowerReporting() throws JposException;
  public boolean getCapPrintContent() throws JposException;
  public boolean getCapPrintContentFile() throws JposException;
  public boolean getCapRetrieveCurrentMarker() throws JposException;
  public boolean getCapRetrieveMarker() throws JposException;
  public boolean getCapRetrieveMarkerByDateTime() throws JposException;
  public boolean getCapRetrieveMarkersDateTime() throws JposException;
  public int     getCapStation() throws JposException;
  public boolean getCapStatisticsReporting() throws JposException;
  public boolean getCapStorageEnabled() throws JposException;
  public boolean getCapSuspendPrintContent() throws JposException;
  public boolean getCapSuspendQueryContent() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;
  public boolean getCapUpdateStatistics() throws JposException;
  public boolean getCapWaterMark() throws JposException;

  // Properties
  public boolean getAsyncMode() throws JposException;
  public void    setAsyncMode(boolean asyncMode) throws JposException;
  public boolean getAutoDisable() throws JposException;
  public void    setAutoDisable(boolean autoDisable) throws JposException;
  public int     getDataCount() throws JposException;
  public boolean getDataEventEnabled() throws JposException;
  public void    setDataEventEnabled(boolean dataEventEnabled)
                     throws JposException;
  public boolean getFlagWhenIdle() throws JposException;
  public void    setFlagWhenIdle(boolean flagWhenIdle) throws JposException;
  public long    getMediumFreeSpace() throws JposException;
  public String  getMediumID() throws JposException;
  public boolean getMediumIsAvailable() throws JposException;
  public long    getMediumSize() throws JposException;
  public int     getOutputID() throws JposException;
  public int     getPowerNotify() throws JposException;
  public void    setPowerNotify(int powerNotify) throws JposException;
  public int     getPowerState() throws JposException;
  public int     getStation() throws JposException;
  public void    setStation(int station) throws JposException;
  public boolean getStorageEnabled() throws JposException;
  public void    setStorageEnabled(boolean enabled) throws JposException;
  public boolean getSuspended() throws JposException;
  public boolean getWaterMark() throws JposException;
  public void    setWaterMark(boolean waterMark) throws JposException;

  // Methods
  public void    addMarker(String marker)
                     throws JposException;
  public void    cancelPrintContent()
                     throws JposException;
  public void    cancelQueryContent()
                     throws JposException;
  public void    clearInput() throws JposException;
  public void    clearOutput() throws JposException;
  public void    compareFirmwareVersion(String firmwareFileName, int[] result)
                     throws JposException;
  public void    eraseMedium()
                     throws JposException;
  public void    initializeMedium(String mediumID)
                     throws JposException;
  public void    printContent(String fromMarker,
                              String toMarker)
                     throws JposException;
  public void    printContentFile(String fileName)
                     throws JposException;
  public void    queryContent(String fileName,
                              String fromMarker,
                              String toMarker)
                     throws JposException;
  public void    resetStatistics(String statisticsBuffer)
                     throws JposException;
  public void    resumePrintContent()
                     throws JposException;
  public void    resumeQueryContent()
                     throws JposException;
  public void    retrieveCurrentMarker(int markerType,
                                       String[] marker)
                     throws JposException;
  public void    retrieveMarker(int markerType,
                                int sessionNumber,
                                int documentNumber,
                                String[] marker)
                     throws JposException;
  public void    retrieveMarkerByDateTime(int markerType,
                                          String dateTime,
                                          String markerNumber,
                                          String[] marker)
                     throws JposException;
  public void    retrieveMarkersDateTime(String marker,
                                         String[] dateTime)
                     throws JposException;
  public void    retrieveStatistics(String[] statisticsBuffer)
                     throws JposException;
  public void    suspendPrintContent()
                     throws JposException;
  public void    suspendQueryContent()
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
  public void    addErrorListener(ErrorListener l);
  public void    removeErrorListener(ErrorListener l);
  public void    addOutputCompleteListener(OutputCompleteListener l);
  public void    removeOutputCompleteListener(OutputCompleteListener l);
  public void    addStatusUpdateListener(StatusUpdateListener l);
  public void    removeStatusUpdateListener(StatusUpdateListener l);
}