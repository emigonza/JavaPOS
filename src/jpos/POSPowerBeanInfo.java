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
// POSPowerBeanInfo.java - Bean information for the JavaPOS POSPower
//    device control
//
//------------------------------------------------------------------------------

package jpos;

import java.beans.*;
import java.lang.reflect.*;

public class POSPowerBeanInfo
  extends SimpleBeanInfo
{
  public BeanDescriptor getBeanDescriptor()
  {
    return new BeanDescriptor(jpos.POSPower.class);
  }

  public PropertyDescriptor makeProperty(String propertyName)
    throws IntrospectionException
  {
    return new PropertyDescriptor(propertyName, jpos.POSPower.class);
  }

  public PropertyDescriptor[] getPropertyDescriptors()
  {
    try
    {
      PropertyDescriptor[] properties =
      {
        // Capabilities
        makeProperty("CapFanAlarm"),
        makeProperty("CapHeatAlarm"),
        makeProperty("CapPowerReporting"),
        makeProperty("CapQuickCharge"),
        makeProperty("CapShutdownPOS"),
        makeProperty("CapUPSChargeState"),
        makeProperty("CapStatisticsReporting"),
        makeProperty("CapUpdateStatistics"),
        makeProperty("CapBatteryCapacityRemaining"),
        makeProperty("CapCompareFirmwareVersion"),
        makeProperty("CapRestartPOS"),
        makeProperty("CapStandbyPOS"),
        makeProperty("CapSuspendPOS"),
        makeProperty("CapUpdateFirmware"),
        makeProperty("CapVariableBatteryCriticallyLowThreshold"),
        makeProperty("CapVariableBatteryLowThreshold"),

        // Properties
        makeProperty("EnforcedShutdownDelayTime"),
        makeProperty("PowerFailDelayTime"),
        makeProperty("PowerNotify"),
        makeProperty("PowerState"),
        makeProperty("QuickChargeMode"),
        makeProperty("QuickChargeTime"),
        makeProperty("UPSChargeState"),
        makeProperty("BatteryCapacityRemaining"),
        makeProperty("BatteryCriticallyLowThreshold"),
        makeProperty("BatteryLowThreshold"),
        makeProperty("PowerSource")
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
    return new EventSetDescriptor(jpos.POSPower.class,
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
        makeEvent("DirectIO"),
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
