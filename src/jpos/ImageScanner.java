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
// ImageScanner.java - A JavaPOS 1.13.0 device control
//
//------------------------------------------------------------------------------

package jpos;

import jpos.events.*;
import jpos.services.*;
import java.util.Vector;
import jpos.loader.*;

public class ImageScanner
  extends BaseJposControl
  implements ImageScannerControl113, JposConst
{
  //--------------------------------------------------------------------------
  // Variables
  //--------------------------------------------------------------------------

  protected ImageScannerService113 service113;


  //--------------------------------------------------------------------------
  // Constructor
  //--------------------------------------------------------------------------

  public ImageScanner()
  {
    // Initialize base class instance data
    deviceControlDescription = "JavaPOS ImageScanner Device Control";
    deviceControlVersion = deviceVersion113;

    // Initialize instance data. Initializations are commented out for
    // efficiency if the Java default is correct.
    //service113 = null;
  }


  //--------------------------------------------------------------------------
  // Framework Methods
  //--------------------------------------------------------------------------

  // Create an EventCallbacks interface implementation object for this Control
  protected EventCallbacks createEventCallbacks()
  {
    return new ImageScannerCallbacks();
  }

  // Store the reference to the Device Service
  protected void setDeviceService(BaseService service, int nServiceVersion)
    throws JposException
  {
    // Special case: service == null to free references
    if(service == null)
    {

      service113 = null;
    }
    else
    {
      // Make sure that the service actually conforms to the interfaces it
      // claims to.
      if(serviceVersion >= deviceVersion113)
      {
        try
        {
          service113 = (ImageScannerService113)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ImageScannerService113 interface",
                                  e);
        }
      }

    }
  }


  //--------------------------------------------------------------------------
  // EventCallbacks inner class
  //--------------------------------------------------------------------------

  protected class ImageScannerCallbacks
    implements EventCallbacks
  {
    public BaseControl getEventSource()
    {
      return (BaseControl)ImageScanner.this;
    }

    public void fireDataEvent(DataEvent e)
    {
    }

    public void fireDirectIOEvent(DirectIOEvent e)
    {
    }

    public void fireErrorEvent(ErrorEvent e)
    {
    }

    public void fireOutputCompleteEvent(OutputCompleteEvent e)
    {
    }

    public void fireStatusUpdateEvent(StatusUpdateEvent e)
    {
    }
  }
}
