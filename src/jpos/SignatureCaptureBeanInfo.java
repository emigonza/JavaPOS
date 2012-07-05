//------------------------------------------------------------------------------
//
// THIS SOFTWARE IS PROVIDED AS IS. THE JAVAPOS WORKING GROUP MAKES NO
// REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
// EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
// WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR
// NON-INFRINGEMENT.  INDIVIDUAL OR CORPORATE MEMBERS OF THE JAVAPOS
// WORKING GROUP SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED AS A RESULT
// OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// SignatureCaptureBeanInfo.java - Bean information for the JavaPOS SignatureCapture
//    device control
//
//------------------------------------------------------------------------------

package jpos;

import java.beans.*;
import java.lang.reflect.*;

public class SignatureCaptureBeanInfo
  extends SimpleBeanInfo
{
  public BeanDescriptor getBeanDescriptor()
  {
    return new BeanDescriptor(jpos.SignatureCapture.class);
  }

  public PropertyDescriptor makeProperty(String propertyName)
    throws IntrospectionException
  {
    return new PropertyDescriptor(propertyName, jpos.SignatureCapture.class);
  }

  public PropertyDescriptor[] getPropertyDescriptors()
  {
    try
    {
      PropertyDescriptor[] properties =
      {
        // Capabilities
        makeProperty("CapDisplay"),
        makeProperty("CapRealTimeData"),
        makeProperty("CapUserTerminated"),
        makeProperty("CapPowerReporting"),
        makeProperty("CapStatisticsReporting"),
        makeProperty("CapUpdateStatistics"),
        makeProperty("CapCompareFirmwareVersion"),
        makeProperty("CapUpdateFirmware"),

        // Properties
        makeProperty("AutoDisable"),
        makeProperty("DataCount"),
        makeProperty("DataEventEnabled"),
        makeProperty("MaximumX"),
        makeProperty("MaximumY"),
        makeProperty("PointArray"),
        makeProperty("RawData"),
        makeProperty("RealTimeDataEnabled"),
        makeProperty("PowerNotify"),
        makeProperty("PowerState")
      };

      return properties;
    }
    catch(Exception e)
    {
      return super.getPropertyDescriptors();
    }
  }

  public EventSetDescriptor makeEvent(String eventName)
    throws IntrospectionException, ClassNotFoundException
  {
    String listener = "jpos.events." + eventName + "Listener";
    return new EventSetDescriptor(jpos.SignatureCapture.class,
                                  eventName,
                                  Class.forName(listener),
                                  eventName + "Occurred");
  }

  public EventSetDescriptor[] getEventSetDescriptors()
  {
    try
    {
      EventSetDescriptor[] events =
      {
        makeEvent("Data"),
        makeEvent("DirectIO"),
        makeEvent("Error"),
        makeEvent("StatusUpdate")
      };

      return events;
    }
    catch(Exception e)
    {
      return super.getEventSetDescriptors();
    }
  }
}
