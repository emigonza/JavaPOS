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
// ImageScannerControl111
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Image Scanner for release 1.11.
//
// Modification history
// ------------------------------------------------------------------
// 2007-Jan-04 JavaPOS Release 1.11                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface ImageScannerControl111 extends BaseControl
{
  // Capabilities
  public boolean getCapAim() throws JposException;
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public boolean getCapDecodeData() throws JposException;
  public boolean getCapHostTriggered() throws JposException;
  public boolean getCapIlluminate() throws JposException;
  public boolean getCapImageData() throws JposException;
  public boolean getCapImageQuality() throws JposException;
  public int     getCapPowerReporting() throws JposException;
  public boolean getCapStatisticsReporting() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;
  public boolean getCapUpdateStatistics() throws JposException;
  public boolean getCapVideoData() throws JposException;


  // Properties
  public boolean getAimMode() throws JposException;
  public void    setAimMode(boolean aimMode) throws JposException;
  public boolean getAutoDisable() throws JposException;
  public void    setAutoDisable(boolean autoDisable) throws JposException;
  public int     getBitsPerPixel() throws JposException;
  public int     getDataCount() throws JposException;
  public boolean getDataEventEnabled() throws JposException;
  public void    setDataEventEnabled(boolean dataEventEnabled)
                     throws JposException;
  public byte[]  getFrameData() throws JposException;
  public int     getFrameType() throws JposException;
  public boolean getIlluminateMode() throws JposException;
  public void    setIlluminateMode(boolean illuminateMode) throws JposException;
  public int     getImageHeight() throws JposException;
  public int     getImageLength() throws JposException;
  public int     getImageMode() throws JposException;
  public void    setImageMode(int imageMode) throws JposException;
  public int     getImageQuality() throws JposException;
  public void    setImageQuality(int imageQuality) throws JposException;
  public int     getImageType() throws JposException;
  public int     getImageWidth() throws JposException;
  public int     getPowerNotify() throws JposException;
  public void    setPowerNotify(int powerNotify) throws JposException;
  public int     getPowerState() throws JposException;
  public int     getVideoCount() throws JposException;
  public void    setVideoCount(int videoCount) throws JposException;
  public int     getVideoRate() throws JposException;
  public void    setVideoRate(int videoRate) throws JposException;

  // Methods
  public void    clearInput()
                     throws JposException;
  public void    clearInputProperties()
                     throws JposException;
  public void    compareFirmwareVersion(String firmwareFileName,
                                        int[] result)
                     throws JposException;
  public void    resetStatistics(String statisticsBuffer)
                     throws JposException;
  public void    retrieveStatistics(String[] statisticsBuffer)
                     throws JposException;
  public void    startSession()
                     throws JposException;
  public void    stopSession()
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
  public void    addStatusUpdateListener(StatusUpdateListener l);
  public void    removeStatusUpdateListener(StatusUpdateListener l);
}
