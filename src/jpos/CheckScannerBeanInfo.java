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
// CheckScannerBeanInfo.java - Bean information for the JavaPOS CheckScanner
//    device control
//
//------------------------------------------------------------------------------

package jpos;

import java.beans.*;
import java.lang.reflect.*;

public class CheckScannerBeanInfo
  extends SimpleBeanInfo
{
  public BeanDescriptor getBeanDescriptor()
  {
    return new BeanDescriptor(jpos.CheckScanner.class);
  }

  public PropertyDescriptor makeProperty(String propertyName)
    throws IntrospectionException
  {
    return new PropertyDescriptor(propertyName, jpos.CheckScanner.class);
  }

  public PropertyDescriptor[] getPropertyDescriptors()
  {
    try
    {
      PropertyDescriptor[] properties =
      {
        // Capabilities
        makeProperty("CapAutoGenerateFileID"),
        makeProperty("CapAutoGenerateImageTagData"),
        makeProperty("CapAutoSize"),
        makeProperty("CapColor"),
        makeProperty("CapConcurrentMICR"),
        makeProperty("CapDefineCropArea"),
        makeProperty("CapImageFormat"),
        makeProperty("CapImageTagData"),
        makeProperty("CapMICRDevice"),
        makeProperty("CapPowerReporting"),
        makeProperty("CapStoreImageFiles"),
        makeProperty("CapValidationDevice"),
        makeProperty("CapStatisticsReporting"),
        makeProperty("CapUpdateStatistics"),
        makeProperty("CapAutoContrast"),
        makeProperty("CapCompareFirmwareVersion"),
        makeProperty("CapContrast"),
        makeProperty("CapUpdateFirmware"),

        // Properties
        makeProperty("AutoDisable"),
        makeProperty("Color"),
        makeProperty("ConcurrentMICR"),
        makeProperty("CropAreaCount"),
        makeProperty("DataCount"),
        makeProperty("DataEventEnabled"),
        makeProperty("DocumentHeight"),
        makeProperty("DocumentWidth"),
        makeProperty("FileID"),
        makeProperty("FileIndex"),
        makeProperty("ImageData"),
        makeProperty("ImageFormat"),
        makeProperty("ImageMemoryStatus"),
        makeProperty("ImageTagData"),
        makeProperty("MapMode"),
        makeProperty("MaxCropAreas"),
        makeProperty("PowerNotify"),
        makeProperty("PowerState"),
        makeProperty("Quality"),
        makeProperty("QualityList"),
        makeProperty("RemainingImagesEstimate"),
        makeProperty("Contrast"),

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
    return new EventSetDescriptor(jpos.CheckScanner.class,
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
