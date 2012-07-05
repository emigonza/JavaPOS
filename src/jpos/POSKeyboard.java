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
// POSKeyboard.java - A JavaPOS 1.13.0 device control
//
//------------------------------------------------------------------------------

package jpos;

import jpos.events.*;
import jpos.services.*;
import java.util.Vector;
import jpos.loader.*;

public class POSKeyboard
  extends BaseJposControl
  implements POSKeyboardControl113, JposConst
{
  //--------------------------------------------------------------------------
  // Variables
  //--------------------------------------------------------------------------

  protected POSKeyboardService12 service12;
  protected POSKeyboardService13 service13;
  protected POSKeyboardService14 service14;
  protected POSKeyboardService15 service15;
  protected POSKeyboardService16 service16;
  protected POSKeyboardService17 service17;
  protected POSKeyboardService18 service18;
  protected POSKeyboardService19 service19;
  protected POSKeyboardService110 service110;
  protected POSKeyboardService111 service111;
  protected POSKeyboardService112 service112;
  protected POSKeyboardService113 service113;
  protected Vector dataListeners;
  protected Vector directIOListeners;
  protected Vector errorListeners;
  protected Vector statusUpdateListeners;


  //--------------------------------------------------------------------------
  // Constructor
  //--------------------------------------------------------------------------

  public POSKeyboard()
  {
    // Initialize base class instance data
    deviceControlDescription = "JavaPOS POSKeyboard Device Control";
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
    dataListeners = new Vector();
    directIOListeners = new Vector();
    errorListeners = new Vector();
    statusUpdateListeners = new Vector();
  }


  //--------------------------------------------------------------------------
  // Capabilities
  //--------------------------------------------------------------------------

  public boolean getCapKeyUp()
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
      return service12.getCapKeyUp();
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
      return service12.getAutoDisable();
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
      service12.setAutoDisable(autoDisable);
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
      return service12.getDataCount();
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
      return service12.getDataEventEnabled();
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
      service12.setDataEventEnabled(dataEventEnabled);
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

  public int getEventTypes()
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
      return service12.getEventTypes();
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

  public void setEventTypes(int eventTypes)
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
      service12.setEventTypes(eventTypes);
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

  public int getPOSKeyData()
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
      return service12.getPOSKeyData();
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

  public int getPOSKeyEventType()
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
      return service12.getPOSKeyEventType();
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


  //--------------------------------------------------------------------------
  // Methods
  //--------------------------------------------------------------------------

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
      service12.clearInput();
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
    return new POSKeyboardCallbacks();
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
          service12 = (POSKeyboardService12)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService12 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion13)
      {
        try
        {
          service13 = (POSKeyboardService13)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService13 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion14)
      {
        try
        {
          service14 = (POSKeyboardService14)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService14 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion15)
      {
        try
        {
          service15 = (POSKeyboardService15)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService15 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion16)
      {
        try
        {
          service16 = (POSKeyboardService16)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService16 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion17)
      {
        try
        {
          service17 = (POSKeyboardService17)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService17 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion18)
      {
        try
        {
          service18 = (POSKeyboardService18)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService18 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion19)
      {
        try
        {
          service19 = (POSKeyboardService19)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService19 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion110)
      {
        try
        {
          service110 = (POSKeyboardService110)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService110 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion111)
      {
        try
        {
          service111 = (POSKeyboardService111)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService111 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion112)
      {
        try
        {
          service112 = (POSKeyboardService112)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService112 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion113)
      {
        try
        {
          service113 = (POSKeyboardService113)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement POSKeyboardService113 interface",
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

  protected class POSKeyboardCallbacks
    implements EventCallbacks
  {
    public BaseControl getEventSource()
    {
      return (BaseControl)POSKeyboard.this;
    }

    public void fireDataEvent(DataEvent e)
    {
      synchronized(POSKeyboard.this.dataListeners)
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
      synchronized(POSKeyboard.this.directIOListeners)
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
      synchronized(POSKeyboard.this.errorListeners)
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
      synchronized(POSKeyboard.this.statusUpdateListeners)
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
