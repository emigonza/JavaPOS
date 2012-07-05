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
// ElectronicJournalBeanInfo.java - Bean information for the JavaPOS ElectronicJournal
//    device control
//
//------------------------------------------------------------------------------

package jpos;

import java.beans.*;
import java.lang.reflect.*;

public class ElectronicJournalBeanInfo
  extends SimpleBeanInfo
{
  public BeanDescriptor getBeanDescriptor()
  {
    return new BeanDescriptor(jpos.ElectronicJournal.class);
  }

  public PropertyDescriptor makeProperty(String propertyName)
    throws IntrospectionException
  {
    return new PropertyDescriptor(propertyName, jpos.ElectronicJournal.class);
  }

  public PropertyDescriptor[] getPropertyDescriptors()
  {
    try
    {
      PropertyDescriptor[] properties =
      {
        // Capabilities
        makeProperty("CapAddMarker"),
        makeProperty("CapCompareFirmwareVersion"),
        makeProperty("CapErasableMedium"),
        makeProperty("CapInitializeMedium"),
        makeProperty("CapMediumIsAvailable"),
        makeProperty("CapPowerReporting"),
        makeProperty("CapPrintContent"),
        makeProperty("CapPrintContentFile"),
        makeProperty("CapRetrieveCurrentMarker"),
        makeProperty("CapRetrieveMarker"),
        makeProperty("CapRetrieveMarkerByDateTime"),
        makeProperty("CapRetrieveMarkersDateTime"),
        makeProperty("CapStation"),
        makeProperty("CapStatisticsReporting"),
        makeProperty("CapStorageEnabled"),
        makeProperty("CapSuspendPrintContent"),
        makeProperty("CapSuspendQueryContent"),
        makeProperty("CapUpdateFirmware"),
        makeProperty("CapUpdateStatistics"),
        makeProperty("CapWaterMark"),

        // Properties
        makeProperty("AsyncMode"),
        makeProperty("AutoDisable"),
        makeProperty("DataCount"),
        makeProperty("DataEventEnabled"),
        makeProperty("FlagWhenIdle"),
        makeProperty("MediumFreeSpace"),
        makeProperty("MediumID"),
        makeProperty("MediumIsAvailable"),
        makeProperty("MediumSize"),
        makeProperty("OutputID"),
        makeProperty("PowerNotify"),
        makeProperty("PowerState"),
        makeProperty("Station"),
        makeProperty("StorageEnabled"),
        makeProperty("Suspended"),
        makeProperty("WaterMark"),

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
    return new EventSetDescriptor(jpos.ElectronicJournal.class,
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
        makeEvent("OutputComplete"),
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
