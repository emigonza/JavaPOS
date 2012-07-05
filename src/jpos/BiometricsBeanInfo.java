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
// BiometricsBeanInfo.java - Bean information for the JavaPOS Biometrics
//    device control
//
//------------------------------------------------------------------------------

package jpos;

import java.beans.*;
import java.lang.reflect.*;

public class BiometricsBeanInfo
  extends SimpleBeanInfo
{
  public BeanDescriptor getBeanDescriptor()
  {
    return new BeanDescriptor(jpos.Biometrics.class);
  }

  public PropertyDescriptor makeProperty(String propertyName)
    throws IntrospectionException
  {
    return new PropertyDescriptor(propertyName, jpos.Biometrics.class);
  }

  public PropertyDescriptor[] getPropertyDescriptors()
  {
    try
    {
      PropertyDescriptor[] properties =
      {
        // Capabilities
        makeProperty("CapCompareFirmwareVersion"),
        makeProperty("CapPowerReporting"),
        makeProperty("CapPrematchData"),
        makeProperty("CapRawSensorData"),
        makeProperty("CapRealTimeData"),
        makeProperty("CapSensorColor"),
        makeProperty("CapSensorOrientation"),
        makeProperty("CapSensorType"),
        makeProperty("CapStatisticsReporting"),
        makeProperty("CapTemplateAdaptation"),
        makeProperty("CapUpdateFirmware"),
        makeProperty("CapUpdateStatistics"),

        // Properties
        makeProperty("Algorithm"),
        makeProperty("AlgorithmList"),
        makeProperty("AutoDisable"),
        makeProperty("BIR"),
        makeProperty("DataCount"),
        makeProperty("DataEventEnabled"),
        makeProperty("PowerNotify"),
        makeProperty("PowerState"),
        makeProperty("RawSensorData"),
        makeProperty("RealTimeDataEnabled"),
        makeProperty("SensorBPP"),
        makeProperty("SensorColor"),
        makeProperty("SensorHeight"),
        makeProperty("SensorOrientation"),
        makeProperty("SensorType"),
        makeProperty("SensorWidth")
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
    return new EventSetDescriptor(jpos.Biometrics.class,
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
