//----------------------------------------------------------------------------
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
// BaseJposControl.java - Abstract base class for all JavaPOS Device Controls.
//
//-----------------------------------------------------------------------------

package jpos;

import jpos.events.*;
import jpos.services.*;
import java.util.Vector;
import jpos.loader.*;

public abstract class BaseJposControl
 implements BaseControl
{
  //--------------------------------------------------------------------------
  // Constants
  //--------------------------------------------------------------------------

  protected static final int deviceVersion12  = 1002000; // 1.2.0
  protected static final int deviceVersion13  = 1003000; // 1.3.0
  protected static final int deviceVersion14  = 1004000; // 1.4.0
  protected static final int deviceVersion15  = 1005000; // 1.5.0
  protected static final int deviceVersion16  = 1006000; // 1.6.0
  protected static final int deviceVersion17  = 1007000; // 1.7.0
  protected static final int deviceVersion18  = 1008000; // 1.8.0
  protected static final int deviceVersion19  = 1009000; // 1.9.0
  protected static final int deviceVersion110 = 1010000; // 1.10.0
  protected static final int deviceVersion111 = 1011000; // 1.11.0
  protected static final int deviceVersion112 = 1012000; // 1.12.0
  protected static final int deviceVersion113 = 1013000; // 1.13.0


  //--------------------------------------------------------------------------
  // Variables
  //--------------------------------------------------------------------------

  // Instance Data Set in Derived Class
  protected String                deviceControlDescription;
  protected int                   deviceControlVersion;

  // Instance Data Set in Base Class
  protected JposServiceConnection serviceConnection;
  protected int                   serviceVersion;
  protected boolean               bOpen;
  protected BaseService           service;


  //--------------------------------------------------------------------------
  // Constructor
  //--------------------------------------------------------------------------

  public BaseJposControl()
  {
    // Initialize instance data. Initializations are commented out for
    // efficiency if the Java default is correct.
    //serviceConnection = null;
    //serviceVersion = 0;
    //bOpen = false;
  }


  //--------------------------------------------------------------------------
  // Properties
  //--------------------------------------------------------------------------

  public String getCheckHealthText()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    try
    {
      return service.getCheckHealthText();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getClaimed()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    try
    {
      return service.getClaimed();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public String getDeviceControlDescription()
  {
    return deviceControlDescription;
  }

  public int getDeviceControlVersion()
  {
    return deviceControlVersion;
  }

  public boolean getDeviceEnabled()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    try
    {
      return service.getDeviceEnabled();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setDeviceEnabled(boolean deviceEnabled)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    try
    {
      service.setDeviceEnabled(deviceEnabled);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public String getDeviceServiceDescription()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    try
    {
      return service.getDeviceServiceDescription();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getDeviceServiceVersion()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    try
    {
      return service.getDeviceServiceVersion();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getFreezeEvents()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    try
    {
      return service.getFreezeEvents();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setFreezeEvents(boolean freezeEvents)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    try
    {
      service.setFreezeEvents(freezeEvents);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public String getPhysicalDeviceDescription()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    try
    {
      return service.getPhysicalDeviceDescription();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public String getPhysicalDeviceName()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    try
    {
      return service.getPhysicalDeviceName();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getState()
  {
    // Preset result to JposConst.JPOS_S_CLOSED
    int nState = JposConst.JPOS_S_CLOSED;

    // If control is opened, get state from Device Service
    if(bOpen)
    {
      try
      {
        nState = service.getState();
      }
      catch(Exception e)
      {
      }
    }

    return nState;
  }


  //--------------------------------------------------------------------------
  // Methods
  //--------------------------------------------------------------------------

  public void claim(int timeout)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service.claim(timeout);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public synchronized void close()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }
    else
    {
      // Perform the operation
      try
      {
        service.close();
      }
      catch(JposException je)
      {
        throw je;
      }
      catch(Exception e)
      {
        throw new JposException(JposConst.JPOS_E_FAILURE,
                                "Unhandled exception from Device Service", e);
      }

      try
      {
        serviceConnection.disconnect();
      }
      catch(Exception e)
      {
          throw new JposException(JposConst.JPOS_E_NOSERVICE,
                                  "Unable to free service connection",
                                  e);
      }
      finally
      {
        setDeviceService(null, 0);
        serviceConnection = null;
        service = null;
        serviceVersion = 0;
        bOpen = false;
      }
    }
  }

  public void checkHealth(int level)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service.checkHealth(level);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void directIO(int command, int[] data, Object object)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service.directIO(command, data, object);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public synchronized void open(String logicalDeviceName)
    throws JposException
  {
    // Make sure the control is not already open
    if(bOpen)
    {
      throw new JposException(JposConst.JPOS_E_ILLEGAL, "Device Control already open");
    }

    // Use JCL to get a connection to the device service
    try
    {
      serviceConnection = JposServiceLoader.findService(logicalDeviceName);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_NOEXIST,
                              "Device profile not found", e);
    }

    try
    {
      serviceConnection.connect();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_NOSERVICE,
                              "Could not connect to service", e);
    }

    // Get an instance of the BaseService interface
    try
    {
      service = (BaseService)serviceConnection.getService();
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_NOSERVICE,
                              "Could not get service instance", e);
    }

    // Now attempt to process the open command
    JposException jposException = null;
    boolean bRealOpenSucceeded = false;
    try
    {
      // Create callback subclass and attach it to the device service
      EventCallbacks callbacks = createEventCallbacks();
      service.open(logicalDeviceName, callbacks);

      // If we got this far, the real open call succeeded
      bRealOpenSucceeded = true;

      // If the open succeeds, remember the service instance and determine
      // the actual service version
      serviceVersion = service.getDeviceServiceVersion();
      setDeviceService(service, serviceVersion);

      // If everything worked to this point, the open has succeeded.
      bOpen = true;
    }
    catch(JposException je)
    {
      jposException = je;
    }
    catch(Exception e)
    {
      jposException = new JposException(JposConst.JPOS_E_FAILURE,
                                        "Unhandled exception from Device Service",
                                        e);
    }

    // If the overall open failed, clean up then throw the specified exception
    if(!bOpen)
    {
      // If the Device Service open call succeeded, close it
      try
      {
        service.close();
      }
      catch(Exception e)
      {
        // Eat any exceptions - we're trying to clean up as best we can
      }

      // Attenpt to disconnect the service instance
      try
      {
        serviceConnection.disconnect();
      }
      catch(Exception e)
      {
        // Eat any exceptions - we're trying to clean up as best we can
      }

      // Reset instance data to allow for another open attempt later
      serviceConnection = null;
      serviceVersion = 0;

      // Now that we've cleaned up, throw the exception that caused all this
      throw jposException;
    }
  }

  public void release()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JposConst.JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service.release();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JposConst.JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }


  //--------------------------------------------------------------------------
  // Framework Methods
  //--------------------------------------------------------------------------

  // Create an EventCallbacks interface implementation object for this Control
  abstract protected EventCallbacks createEventCallbacks();

  // Store the reference to the Device Service
  abstract protected void setDeviceService(BaseService service, int nServiceVersion)
    throws JposException;
}
