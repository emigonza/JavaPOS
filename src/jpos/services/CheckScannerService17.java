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
// CheckScannerService17
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Check Scanner for release 1.7.
//
// Modification history
// ------------------------------------------------------------------
// 01-Jul-2002 JavaPOS Release 1.7                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;
import jpos.loader.*;

public interface CheckScannerService17
  extends BaseService, JposServiceInstance
{
  // Capabilities
  public boolean getCapAutoGenerateFileID() throws JposException;
  public boolean getCapAutoGenerateImageTagData() throws JposException;
  public boolean getCapAutoSize() throws JposException;
  public int     getCapColor() throws JposException;
  public boolean getCapConcurrentMICR() throws JposException;
  public boolean getCapDefineCropArea() throws JposException;
  public int     getCapImageFormat() throws JposException;
  public boolean getCapImageTagData() throws JposException;
  public boolean getCapMICRDevice() throws JposException;
  public int     getCapPowerReporting() throws JposException;
  public boolean getCapStoreImageFiles() throws JposException;
  public boolean getCapValidationDevice() throws JposException;

  // Properties
  public boolean getAutoDisable() throws JposException;
  public void    setAutoDisable(boolean autoDisable) throws JposException;
  public int     getColor() throws JposException;
  public void    setColor(int nColor) throws JposException;
  public boolean getConcurrentMICR() throws JposException;
  public void    setConcurrentMICR(boolean bConcurrentMICR) throws JposException;
  public int     getCropAreaCount() throws JposException;
  public int     getDataCount() throws JposException;
  public boolean getDataEventEnabled() throws JposException;
  public void    setDataEventEnabled(boolean dataEventEnabled)
                     throws JposException;
  public int     getDocumentHeight() throws JposException;
  public void    setDocumentHeight(int nDocumentHeight) throws JposException;
  public int     getDocumentWidth() throws JposException;
  public void    setDocumentWidth(int nDocumentWidth) throws JposException;
  public String  getFileID() throws JposException;
  public void    setFileID(String sFileID) throws JposException;
  public int     getFileIndex() throws JposException;
  public void    setFileIndex(int nFileIndex) throws JposException;
  public byte[]  getImageData() throws JposException;
  public int     getImageFormat() throws JposException;
  public void    setImageFormat(int nImageFormat) throws JposException;
  public int     getImageMemoryStatus() throws JposException;
  public String  getImageTagData() throws JposException;
  public void    setImageTagData(String sImageTagData) throws JposException;
  public int     getMapMode() throws JposException;
  public void    setMapMode(int nMapMode) throws JposException;
  public int     getMaxCropAreas() throws JposException;
  public int     getPowerNotify() throws JposException;
  public void    setPowerNotify(int powerNotify) throws JposException;
  public int     getPowerState() throws JposException;
  public int     getQuality() throws JposException;
  public void    setQuality(int nQuality) throws JposException;
  public String  getQualityList() throws JposException;
  public int     getRemainingImagesEstimate() throws JposException;

  // Methods
  public void    beginInsertion(int timeout) throws JposException;
  public void    beginRemoval(int timeout) throws JposException;
  public void    clearImage(int by) throws JposException;
  public void    clearInput() throws JposException;
  public void    defineCropArea(int cropAreaID, int x, int y, int cx, int cy)
                   throws JposException;
  public void    endInsertion() throws JposException;
  public void    endRemoval() throws JposException;
  public void    retrieveImage(int cropAreaID) throws JposException;
  public void    retrieveMemory(int by) throws JposException;
  public void    storeImage(int by) throws JposException;
}