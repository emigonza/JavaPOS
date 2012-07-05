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
// Scale.java - A JavaPOS 1.13.0 device control
//
//------------------------------------------------------------------------------

package jpos;

import jpos.events.*;
import jpos.services.*;
import java.util.Vector;
import jpos.loader.*;

public class Scale
  extends BaseJposControl
  implements ScaleControl113, JposConst
{
  //--------------------------------------------------------------------------
  // Variables
  //--------------------------------------------------------------------------

  protected ScaleService12 service12;
  protected ScaleService13 service13;
  protected ScaleService14 service14;
  protected ScaleService15 service15;
  protected ScaleService16 service16;
  protected ScaleService17 service17;
  protected ScaleService18 service18;
  protected ScaleService19 service19;
  protected ScaleService110 service110;
  protected ScaleService111 service111;
  protected ScaleService112 service112;
  protected ScaleService113 service113;
  protected Vector directIOListeners;
  protected Vector dataListeners;
  protected Vector errorListeners;
  protected Vector statusUpdateListeners;


  //--------------------------------------------------------------------------
  // Constructor
  //--------------------------------------------------------------------------

  public Scale()
  {
    // Initialize base class instance data
    deviceControlDescription = "JavaPOS Scale Device Control";
    deviceControlVersion = deviceVersion113;

    // Initialize instance data. Initializations are commented out for
    // efficiency if the Java default is correct.
    //service12 = null;
    //service13 = null;
    //service14 = null;
    //service15 = null;
    //service16 = null;
    //service17 = null;
    //service18 = null;
    //service19 = null;
    //service110 = null;
    //service111 = null;
    //service112 = null;
    //service113 = null;
    directIOListeners = new Vector();
    dataListeners = new Vector();
    errorListeners = new Vector();
    statusUpdateListeners = new Vector();
  }


  //--------------------------------------------------------------------------
  // Capabilities
  //--------------------------------------------------------------------------

  public boolean getCapDisplay()
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
      return service12.getCapDisplay();
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

  public boolean getCapDisplayText()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getCapDisplayText();
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

  public boolean getCapPriceCalculating()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getCapPriceCalculating();
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

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getCapPowerReporting();
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

  public boolean getCapTareWeight()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getCapTareWeight();
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

  public boolean getCapZeroScale()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getCapZeroScale();
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

  public boolean getCapStatusUpdate()
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
      return service19.getCapStatusUpdate();
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

  public int getMaximumWeight()
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
      return service12.getMaximumWeight();
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

  public int getWeightUnit()
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
      return service12.getWeightUnit();
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

  public boolean getAsyncMode()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getAsyncMode();
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

  public void setAsyncMode(boolean asyncMode)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      service13.setAsyncMode(asyncMode);
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

  public boolean getAutoDisable()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getAutoDisable();
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

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      service13.setAutoDisable(autoDisable);
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

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getDataCount();
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

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getDataEventEnabled();
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

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      service13.setDataEventEnabled(dataEventEnabled);
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

  public int getMaxDisplayTextChars()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getMaxDisplayTextChars();
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

  public long getSalesPrice()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getSalesPrice();
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

  public int getTareWeight()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getTareWeight();
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

  public void setTareWeight(int tareWeight)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      service13.setTareWeight(tareWeight);
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

  public long getUnitPrice()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getUnitPrice();
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

  public void setUnitPrice(long unitPrice)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      service13.setUnitPrice(unitPrice);
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

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getPowerNotify();
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

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      service13.setPowerNotify(powerNotify);
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

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getPowerState();
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

  public int getScaleLiveWeight()
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
      return service19.getScaleLiveWeight();
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

  public int getStatusNotify()
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
      return service19.getStatusNotify();
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

  public void setStatusNotify(int statusNotify)
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
      service19.setStatusNotify(statusNotify);
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

  public boolean getZeroValid()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.13.0
    if(serviceVersion < deviceVersion113)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.13.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service113.getZeroValid();
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

  public void setZeroValid(boolean zeroValid)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.13.0
    if(serviceVersion < deviceVersion113)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.13.0 compliant.");
    }

    // Perform the operation
    try
    {
      service113.setZeroValid(zeroValid);
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

  public void readWeight(int[] weightData, int timeout)
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
      service12.readWeight(weightData, timeout);
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

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      service13.clearInput();
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

  public void displayText(String data)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      service13.displayText(data);
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

  public void zeroScale()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      service13.zeroScale();
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


  //--------------------------------------------------------------------------
  // Framework Methods
  //--------------------------------------------------------------------------

  // Create an EventCallbacks interface implementation object for this Control
  protected EventCallbacks createEventCallbacks()
  {
    return new ScaleCallbacks();
  }

  // Store the reference to the Device Service
  protected void setDeviceService(BaseService service, int nServiceVersion)
    throws JposException
  {
    // Special case: service == null to free references
    if(service == null)
    {

      service12 = null;
      service13 = null;
      service14 = null;
      service15 = null;
      service16 = null;
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
      if(serviceVersion >= deviceVersion12)
      {
        try
        {
          service12 = (ScaleService12)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService12 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion13)
      {
        try
        {
          service13 = (ScaleService13)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService13 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion14)
      {
        try
        {
          service14 = (ScaleService14)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService14 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion15)
      {
        try
        {
          service15 = (ScaleService15)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService15 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion16)
      {
        try
        {
          service16 = (ScaleService16)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService16 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion17)
      {
        try
        {
          service17 = (ScaleService17)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService17 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion18)
      {
        try
        {
          service18 = (ScaleService18)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService18 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion19)
      {
        try
        {
          service19 = (ScaleService19)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService19 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion110)
      {
        try
        {
          service110 = (ScaleService110)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService110 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion111)
      {
        try
        {
          service111 = (ScaleService111)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService111 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion112)
      {
        try
        {
          service112 = (ScaleService112)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService112 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion113)
      {
        try
        {
          service113 = (ScaleService113)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ScaleService113 interface",
                                  e);
        }
      }

    }
  }


  //--------------------------------------------------------------------------
  // Event Listener Methods
  //--------------------------------------------------------------------------

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

  protected class ScaleCallbacks
    implements EventCallbacks
  {
    public BaseControl getEventSource()
    {
      return (BaseControl)Scale.this;
    }

    public void fireDataEvent(DataEvent e)
    {
      synchronized(Scale.this.dataListeners)
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
      synchronized(Scale.this.directIOListeners)
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
      synchronized(Scale.this.errorListeners)
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
      synchronized(Scale.this.statusUpdateListeners)
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
