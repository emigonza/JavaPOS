//------------------------------------------------------------------------------
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
// CheckScanner.java - A JavaPOS 1.13.0 device control
//
//------------------------------------------------------------------------------

package jpos;

import jpos.events.*;
import jpos.services.*;
import java.util.Vector;
import jpos.loader.*;

public class CheckScanner
  extends BaseJposControl
  implements CheckScannerControl113, JposConst
{
  //--------------------------------------------------------------------------
  // Variables
  //--------------------------------------------------------------------------

  protected CheckScannerService17 service17;
  protected CheckScannerService18 service18;
  protected CheckScannerService19 service19;
  protected CheckScannerService110 service110;
  protected CheckScannerService111 service111;
  protected CheckScannerService112 service112;
  protected CheckScannerService113 service113;
  protected Vector dataListeners;
  protected Vector directIOListeners;
  protected Vector errorListeners;
  protected Vector statusUpdateListeners;


  //--------------------------------------------------------------------------
  // Constructor
  //--------------------------------------------------------------------------

  public CheckScanner()
  {
    // Initialize base class instance data
    deviceControlDescription = "JavaPOS CheckScanner Device Control";
    deviceControlVersion = deviceVersion113;

    // Initialize instance data. Initializations are commented out for
    // efficiency if the Java default is correct.
    //service17 = null;
    //service18 = null;
    //service19 = null;
    //service110 = null;
    //service111 = null;
    //service112 = null;
    //service113 = null;
    dataListeners = new Vector();
    directIOListeners = new Vector();
    errorListeners = new Vector();
    statusUpdateListeners = new Vector();
  }


  //--------------------------------------------------------------------------
  // Capabilities
  //--------------------------------------------------------------------------

  public boolean getCapAutoGenerateFileID()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapAutoGenerateFileID();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapAutoGenerateImageTagData()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapAutoGenerateImageTagData();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapAutoSize()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapAutoSize();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getCapColor()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapColor();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapConcurrentMICR()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapConcurrentMICR();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapDefineCropArea()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapDefineCropArea();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getCapImageFormat()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapImageFormat();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapImageTagData()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapImageTagData();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapMICRDevice()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapMICRDevice();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getCapPowerReporting()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapPowerReporting();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapStoreImageFiles()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapStoreImageFiles();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapValidationDevice()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCapValidationDevice();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapStatisticsReporting()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.8.0
    if(serviceVersion < deviceVersion18)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.8.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service18.getCapStatisticsReporting();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapUpdateStatistics()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.8.0
    if(serviceVersion < deviceVersion18)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.8.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service18.getCapUpdateStatistics();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapAutoContrast()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service19.getCapAutoContrast();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapCompareFirmwareVersion()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service19.getCapCompareFirmwareVersion();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapContrast()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service19.getCapContrast();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapUpdateFirmware()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service19.getCapUpdateFirmware();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }


  //--------------------------------------------------------------------------
  // Properties
  //--------------------------------------------------------------------------

  public boolean getAutoDisable()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getAutoDisable();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setAutoDisable(boolean autoDisable)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setAutoDisable(autoDisable);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getColor()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getColor();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setColor(int nColor)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setColor(nColor);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getConcurrentMICR()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getConcurrentMICR();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setConcurrentMICR(boolean bConcurrentMICR)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setConcurrentMICR(bConcurrentMICR);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getCropAreaCount()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getCropAreaCount();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getDataCount()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getDataCount();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getDataEventEnabled()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getDataEventEnabled();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setDataEventEnabled(boolean dataEventEnabled)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setDataEventEnabled(dataEventEnabled);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getDocumentHeight()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getDocumentHeight();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setDocumentHeight(int nDocumentHeight)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setDocumentHeight(nDocumentHeight);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getDocumentWidth()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getDocumentWidth();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setDocumentWidth(int nDocumentWidth)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setDocumentWidth(nDocumentWidth);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public String getFileID()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getFileID();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setFileID(String sFileID)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setFileID(sFileID);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getFileIndex()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getFileIndex();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setFileIndex(int nFileIndex)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setFileIndex(nFileIndex);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public byte[] getImageData()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getImageData();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getImageFormat()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getImageFormat();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setImageFormat(int nImageFormat)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setImageFormat(nImageFormat);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getImageMemoryStatus()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getImageMemoryStatus();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public String getImageTagData()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getImageTagData();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setImageTagData(String sImageTagData)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setImageTagData(sImageTagData);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getMapMode()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getMapMode();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setMapMode(int nMapMode)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setMapMode(nMapMode);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getMaxCropAreas()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getMaxCropAreas();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getPowerNotify()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getPowerNotify();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setPowerNotify(int powerNotify)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setPowerNotify(powerNotify);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getPowerState()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getPowerState();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getQuality()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getQuality();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setQuality(int nQuality)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.setQuality(nQuality);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public String getQualityList()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getQualityList();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getRemainingImagesEstimate()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service17.getRemainingImagesEstimate();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getContrast()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service19.getContrast();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setContrast(int contrast)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      service19.setContrast(contrast);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }


  //--------------------------------------------------------------------------
  // Methods
  //--------------------------------------------------------------------------

  public void beginInsertion(int timeout)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.beginInsertion(timeout);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void beginRemoval(int timeout)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.beginRemoval(timeout);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void clearImage(int by)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.clearImage(by);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void clearInput()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.clearInput();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void defineCropArea(int cropAreaID, int x, int y, int cx, int cy)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.defineCropArea(cropAreaID, x, y, cx, cy);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void endInsertion()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.endInsertion();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void endRemoval()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.endRemoval();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void retrieveImage(int cropAreaID)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.retrieveImage(cropAreaID);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void retrieveMemory(int by)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.retrieveMemory(by);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void storeImage(int by)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service17.storeImage(by);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void resetStatistics(String statisticsBuffer)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.8.0
    if(serviceVersion < deviceVersion18)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.8.0 compliant.");
    }

    // Perform the operation
    try
    {
      service18.resetStatistics(statisticsBuffer);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void retrieveStatistics(String[] statisticsBuffer)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.8.0
    if(serviceVersion < deviceVersion18)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.8.0 compliant.");
    }

    // Perform the operation
    try
    {
      service18.retrieveStatistics(statisticsBuffer);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void updateStatistics(String statisticsBuffer)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.8.0
    if(serviceVersion < deviceVersion18)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.8.0 compliant.");
    }

    // Perform the operation
    try
    {
      service18.updateStatistics(statisticsBuffer);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void compareFirmwareVersion(String firmwareFileName, int[] result)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      service19.compareFirmwareVersion(firmwareFileName, result);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void updateFirmware(String firmwareFileName)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      service19.updateFirmware(firmwareFileName);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void clearInputProperties()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.10.0
    if(serviceVersion < deviceVersion110)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.10.0 compliant.");
    }

    // Perform the operation
    try
    {
      service110.clearInputProperties();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }


  //--------------------------------------------------------------------------
  // Framework Methods
  //--------------------------------------------------------------------------

  // Create an EventCallbacks interface implementation object for this Control
  protected EventCallbacks createEventCallbacks()
  {
    return new CheckScannerCallbacks();
  }

  // Store the reference to the Device Service
  protected void setDeviceService(BaseService service, int nServiceVersion)
    throws JposException
  {
    // Special case: service == null to free references
    if(service == null)
    {

      service17 = null;
      service18 = null;
      service19 = null;
      service110 = null;
      service111 = null;
      service112 = null;
      service113 = null;
    }
    else
    {
      // Make sure that the service actually conforms to the interfaces it
      // claims to.
      if(serviceVersion >= deviceVersion17)
      {
        try
        {
          service17 = (CheckScannerService17)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement CheckScannerService17 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion18)
      {
        try
        {
          service18 = (CheckScannerService18)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement CheckScannerService18 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion19)
      {
        try
        {
          service19 = (CheckScannerService19)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement CheckScannerService19 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion110)
      {
        try
        {
          service110 = (CheckScannerService110)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement CheckScannerService110 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion111)
      {
        try
        {
          service111 = (CheckScannerService111)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement CheckScannerService111 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion112)
      {
        try
        {
          service112 = (CheckScannerService112)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement CheckScannerService112 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion113)
      {
        try
        {
          service113 = (CheckScannerService113)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement CheckScannerService113 interface",
                                  e);
        }
      }

    }
  }


  //--------------------------------------------------------------------------
  // Event Listener Methods
  //--------------------------------------------------------------------------

  public void addDataListener(DataListener l)
  {
    synchronized(dataListeners)
    {
      dataListeners.addElement(l);
    }
  }

  public void removeDataListener(DataListener l)
  {
    synchronized(dataListeners)
    {
      dataListeners.removeElement(l);
    }
  }

  public void addDirectIOListener(DirectIOListener l)
  {
    synchronized(directIOListeners)
    {
      directIOListeners.addElement(l);
    }
  }

  public void removeDirectIOListener(DirectIOListener l)
  {
    synchronized(directIOListeners)
    {
      directIOListeners.removeElement(l);
    }
  }

  public void addErrorListener(ErrorListener l)
  {
    synchronized(errorListeners)
    {
      errorListeners.addElement(l);
    }
  }

  public void removeErrorListener(ErrorListener l)
  {
    synchronized(errorListeners)
    {
      errorListeners.removeElement(l);
    }
  }

  public void addStatusUpdateListener(StatusUpdateListener l)
  {
    synchronized(statusUpdateListeners)
    {
      statusUpdateListeners.addElement(l);
    }
  }

  public void removeStatusUpdateListener(StatusUpdateListener l)
  {
    synchronized(statusUpdateListeners)
    {
      statusUpdateListeners.removeElement(l);
    }
  }


  //--------------------------------------------------------------------------
  // EventCallbacks inner class
  //--------------------------------------------------------------------------

  protected class CheckScannerCallbacks
    implements EventCallbacks
  {
    public BaseControl getEventSource()
    {
      return (BaseControl)CheckScanner.this;
    }

    public void fireDataEvent(DataEvent e)
    {
      synchronized(CheckScanner.this.dataListeners)
      {
        // deliver the event to all registered listeners
        for(int x = 0; x < dataListeners.size(); x++)
        {
          ((DataListener)dataListeners.elementAt(x)).dataOccurred(e);
        }
      }
    }

    public void fireDirectIOEvent(DirectIOEvent e)
    {
      synchronized(CheckScanner.this.directIOListeners)
      {
        // deliver the event to all registered listeners
        for(int x = 0; x < directIOListeners.size(); x++)
        {
          ((DirectIOListener)directIOListeners.elementAt(x)).directIOOccurred(e);
        }
      }
    }

    public void fireErrorEvent(ErrorEvent e)
    {
      synchronized(CheckScanner.this.errorListeners)
      {
        // deliver the event to all registered listeners
        for(int x = 0; x < errorListeners.size(); x++)
        {
          ((ErrorListener)errorListeners.elementAt(x)).errorOccurred(e);
        }
      }
    }

    public void fireOutputCompleteEvent(OutputCompleteEvent e)
    {
    }

    public void fireStatusUpdateEvent(StatusUpdateEvent e)
    {
      synchronized(CheckScanner.this.statusUpdateListeners)
      {
        // deliver the event to all registered listeners
        for(int x = 0; x < statusUpdateListeners.size(); x++)
        {
          ((StatusUpdateListener)statusUpdateListeners.elementAt(x)).statusUpdateOccurred(e);
        }
      }
    }
  }
}
