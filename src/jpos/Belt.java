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
// Belt.java - A JavaPOS 1.13.0 device control
//
//------------------------------------------------------------------------------

package jpos;

import jpos.events.*;
import jpos.services.*;
import java.util.Vector;
import jpos.loader.*;

public class Belt
  extends BaseJposControl
  implements BeltControl113, JposConst
{
  //--------------------------------------------------------------------------
  // Variables
  //--------------------------------------------------------------------------

  protected BeltService112 service112;
  protected BeltService113 service113;
  protected Vector directIOListeners;
  protected Vector statusUpdateListeners;


  //--------------------------------------------------------------------------
  // Constructor
  //--------------------------------------------------------------------------

  public Belt()
  {
    // Initialize base class instance data
    deviceControlDescription = "JavaPOS Belt Device Control";
    deviceControlVersion = deviceVersion113;

    // Initialize instance data. Initializations are commented out for
    // efficiency if the Java default is correct.
    //service112 = null;
    //service113 = null;
    directIOListeners = new Vector();
    statusUpdateListeners = new Vector();
  }


  //--------------------------------------------------------------------------
  // Capabilities
  //--------------------------------------------------------------------------

  public boolean getCapAutoStopBackward()
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
      return service112.getCapAutoStopBackward();
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

  public boolean getCapAutoStopBackwardItemCount()
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
      return service112.getCapAutoStopBackwardItemCount();
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

  public boolean getCapAutoStopForward()
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
      return service112.getCapAutoStopForward();
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

  public boolean getCapAutoStopForwardItemCount()
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
      return service112.getCapAutoStopForwardItemCount();
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

    // Perform the operation
    try
    {
      return service112.getCapCompareFirmwareVersion();
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

  public boolean getCapLightBarrierBackward()
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
      return service112.getCapLightBarrierBackward();
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

  public boolean getCapLightBarrierForward()
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
      return service112.getCapLightBarrierForward();
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

  public boolean getCapMoveBackward()
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
      return service112.getCapMoveBackward();
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
      return service112.getCapPowerReporting();
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

  public boolean getCapRealTimeData()
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
      return service112.getCapRealTimeData();
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

  public boolean getCapSecurityFlapBackward()
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
      return service112.getCapSecurityFlapBackward();
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

  public boolean getCapSecurityFlapForward()
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
      return service112.getCapSecurityFlapForward();
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

  public boolean getCapSpeedStepsBackward()
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
      return service112.getCapSpeedStepsBackward();
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

  public boolean getCapSpeedStepsForward()
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
      return service112.getCapSpeedStepsForward();
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

    // Perform the operation
    try
    {
      return service112.getCapStatisticsReporting();
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

    // Perform the operation
    try
    {
      return service112.getCapUpdateFirmware();
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

    // Perform the operation
    try
    {
      return service112.getCapUpdateStatistics();
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

  public boolean getAutoStopBackward()
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
      return service112.getAutoStopBackward();
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

  public void setAutoStopBackward(boolean autoStop)
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
      service112.setAutoStopBackward(autoStop);
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

  public int getAutoStopBackwardDelayTime()
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
      return service112.getAutoStopBackwardDelayTime();
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

  public void setAutoStopBackwardDelayTime(int delayTime)
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
      service112.setAutoStopBackwardDelayTime(delayTime);
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

  public int getAutoStopBackwardItemCount()
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
      return service112.getAutoStopBackwardItemCount();
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

  public boolean getAutoStopForward()
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
      return service112.getAutoStopForward();
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

  public void setAutoStopForward(boolean autoStop)
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
      service112.setAutoStopForward(autoStop);
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

  public int getAutoStopForwardDelayTime()
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
      return service112.getAutoStopForwardDelayTime();
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

  public void setAutoStopForwardDelayTime(int delayTime)
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
      service112.setAutoStopForwardDelayTime(delayTime);
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

  public int getAutoStopForwardItemCount()
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
      return service112.getAutoStopForwardItemCount();
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

  public boolean getLightBarrierBackwardInterrupted()
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
      return service112.getLightBarrierBackwardInterrupted();
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

  public boolean getLightBarrierForwardInterrupted()
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
      return service112.getLightBarrierForwardInterrupted();
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

  public int getMotionStatus()
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
      return service112.getMotionStatus();
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
      return service112.getPowerNotify();
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
      service112.setPowerNotify(powerNotify);
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
      return service112.getPowerState();
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

  public boolean getSecurityFlapBackwardOpened()
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
      return service112.getSecurityFlapBackwardOpened();
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

  public boolean getSecurityFlapForwardOpened()
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
      return service112.getSecurityFlapForwardOpened();
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

  public void adjustItemCount(int direction, int count)
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
      service112.adjustItemCount(direction, count);
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

    // Perform the operation
    try
    {
      service112.compareFirmwareVersion(firmwareFileName, result);
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

  public void moveBackward(int speed)
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
      service112.moveBackward(speed);
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

  public void moveForward(int speed)
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
      service112.moveForward(speed);
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

  public void resetBelt()
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
      service112.resetBelt();
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

  public void resetItemCount(int direction)
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
      service112.resetItemCount(direction);
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

    // Perform the operation
    try
    {
      service112.resetStatistics(statisticsBuffer);
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

    // Perform the operation
    try
    {
      service112.retrieveStatistics(statisticsBuffer);
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

  public void stopBelt()
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
      service112.stopBelt();
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

    // Perform the operation
    try
    {
      service112.updateFirmware(firmwareFileName);
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

    // Perform the operation
    try
    {
      service112.updateStatistics(statisticsBuffer);
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
    return new BeltCallbacks();
  }

  // Store the reference to the Device Service
  protected void setDeviceService(BaseService service, int nServiceVersion)
    throws JposException
  {
    // Special case: service == null to free references
    if(service == null)
    {

      service112 = null;
      service113 = null;
    }
    else
    {
      // Make sure that the service actually conforms to the interfaces it
      // claims to.
      if(serviceVersion >= deviceVersion112)
      {
        try
        {
          service112 = (BeltService112)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement BeltService112 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion113)
      {
        try
        {
          service113 = (BeltService113)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement BeltService113 interface",
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

  protected class BeltCallbacks
    implements EventCallbacks
  {
    public BaseControl getEventSource()
    {
      return (BaseControl)Belt.this;
    }

    public void fireDataEvent(DataEvent e)
    {
    }

    public void fireDirectIOEvent(DirectIOEvent e)
    {
      synchronized(Belt.this.directIOListeners)
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
    }

    public void fireOutputCompleteEvent(OutputCompleteEvent e)
    {
    }

    public void fireStatusUpdateEvent(StatusUpdateEvent e)
    {
      synchronized(Belt.this.statusUpdateListeners)
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
