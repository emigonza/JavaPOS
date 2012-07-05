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
// LineDisplayBeanInfo.java - Bean information for the JavaPOS LineDisplay
//    device control
//
//------------------------------------------------------------------------------

package jpos;

import java.beans.*;
import java.lang.reflect.*;

public class LineDisplayBeanInfo
  extends SimpleBeanInfo
{
  public BeanDescriptor getBeanDescriptor()
  {
    return new BeanDescriptor(jpos.LineDisplay.class);
  }

  public PropertyDescriptor makeProperty(String propertyName)
    throws IntrospectionException
  {
    return new PropertyDescriptor(propertyName, jpos.LineDisplay.class);
  }

  public PropertyDescriptor[] getPropertyDescriptors()
  {
    try
    {
      PropertyDescriptor[] properties =
      {
        // Capabilities
        makeProperty("CapBlink"),
        makeProperty("CapBrightness"),
        makeProperty("CapCharacterSet"),
        makeProperty("CapDescriptors"),
        makeProperty("CapHMarquee"),
        makeProperty("CapICharWait"),
        makeProperty("CapVMarquee"),
        makeProperty("CapPowerReporting"),
        makeProperty("CapBlinkRate"),
        makeProperty("CapCursorType"),
        makeProperty("CapCustomGlyph"),
        makeProperty("CapReadBack"),
        makeProperty("CapReverse"),
        makeProperty("CapBitmap"),
        makeProperty("CapMapCharacterSet"),
        makeProperty("CapScreenMode"),
        makeProperty("CapStatisticsReporting"),
        makeProperty("CapUpdateStatistics"),
        makeProperty("CapCompareFirmwareVersion"),
        makeProperty("CapUpdateFirmware"),

        // Properties
        makeProperty("CharacterSet"),
        makeProperty("CharacterSetList"),
        makeProperty("Columns"),
        makeProperty("CurrentWindow"),
        makeProperty("CursorColumn"),
        makeProperty("CursorRow"),
        makeProperty("CursorUpdate"),
        makeProperty("DeviceBrightness"),
        makeProperty("DeviceColumns"),
        makeProperty("DeviceDescriptors"),
        makeProperty("DeviceRows"),
        makeProperty("DeviceWindows"),
        makeProperty("InterCharacterWait"),
        makeProperty("MarqueeFormat"),
        makeProperty("MarqueeRepeatWait"),
        makeProperty("MarqueeType"),
        makeProperty("MarqueeUnitWait"),
        makeProperty("Rows"),
        makeProperty("PowerNotify"),
        makeProperty("PowerState"),
        makeProperty("BlinkRate"),
        makeProperty("CursorType"),
        makeProperty("CustomGlyphList"),
        makeProperty("GlyphHeight"),
        makeProperty("GlyphWidth"),
        makeProperty("MapCharacterSet"),
        makeProperty("MaximumX"),
        makeProperty("MaximumY"),
        makeProperty("ScreenMode"),
        makeProperty("ScreenModeList")
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
    return new EventSetDescriptor(jpos.LineDisplay.class,
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
