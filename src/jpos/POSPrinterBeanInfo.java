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
// POSPrinterBeanInfo.java - Bean information for the JavaPOS POSPrinter
//    device control
//
//------------------------------------------------------------------------------

package jpos;

import java.beans.*;
import java.lang.reflect.*;

public class POSPrinterBeanInfo
  extends SimpleBeanInfo
{
  public BeanDescriptor getBeanDescriptor()
  {
    return new BeanDescriptor(jpos.POSPrinter.class);
  }

  public PropertyDescriptor makeProperty(String propertyName)
    throws IntrospectionException
  {
    return new PropertyDescriptor(propertyName, jpos.POSPrinter.class);
  }

  public PropertyDescriptor[] getPropertyDescriptors()
  {
    try
    {
      PropertyDescriptor[] properties =
      {
        // Capabilities
        makeProperty("CapCharacterSet"),
        makeProperty("CapConcurrentJrnRec"),
        makeProperty("CapConcurrentJrnSlp"),
        makeProperty("CapConcurrentRecSlp"),
        makeProperty("CapCoverSensor"),
        makeProperty("CapJrn2Color"),
        makeProperty("CapJrnBold"),
        makeProperty("CapJrnDhigh"),
        makeProperty("CapJrnDwide"),
        makeProperty("CapJrnDwideDhigh"),
        makeProperty("CapJrnEmptySensor"),
        makeProperty("CapJrnItalic"),
        makeProperty("CapJrnNearEndSensor"),
        makeProperty("CapJrnPresent"),
        makeProperty("CapJrnUnderline"),
        makeProperty("CapRec2Color"),
        makeProperty("CapRecBarCode"),
        makeProperty("CapRecBitmap"),
        makeProperty("CapRecBold"),
        makeProperty("CapRecDhigh"),
        makeProperty("CapRecDwide"),
        makeProperty("CapRecDwideDhigh"),
        makeProperty("CapRecEmptySensor"),
        makeProperty("CapRecItalic"),
        makeProperty("CapRecLeft90"),
        makeProperty("CapRecNearEndSensor"),
        makeProperty("CapRecPapercut"),
        makeProperty("CapRecPresent"),
        makeProperty("CapRecRight90"),
        makeProperty("CapRecRotate180"),
        makeProperty("CapRecStamp"),
        makeProperty("CapRecUnderline"),
        makeProperty("CapSlp2Color"),
        makeProperty("CapSlpBarCode"),
        makeProperty("CapSlpBitmap"),
        makeProperty("CapSlpBold"),
        makeProperty("CapSlpDhigh"),
        makeProperty("CapSlpDwide"),
        makeProperty("CapSlpDwideDhigh"),
        makeProperty("CapSlpEmptySensor"),
        makeProperty("CapSlpFullslip"),
        makeProperty("CapSlpItalic"),
        makeProperty("CapSlpLeft90"),
        makeProperty("CapSlpNearEndSensor"),
        makeProperty("CapSlpPresent"),
        makeProperty("CapSlpRight90"),
        makeProperty("CapSlpRotate180"),
        makeProperty("CapSlpUnderline"),
        makeProperty("CapTransaction"),
        makeProperty("CapPowerReporting"),
        makeProperty("CapJrnCartridgeSensor"),
        makeProperty("CapJrnColor"),
        makeProperty("CapRecCartridgeSensor"),
        makeProperty("CapRecColor"),
        makeProperty("CapRecMarkFeed"),
        makeProperty("CapSlpBothSidesPrint"),
        makeProperty("CapSlpCartridgeSensor"),
        makeProperty("CapSlpColor"),
        makeProperty("CapMapCharacterSet"),
        makeProperty("CapStatisticsReporting"),
        makeProperty("CapUpdateStatistics"),
        makeProperty("CapCompareFirmwareVersion"),
        makeProperty("CapConcurrentPageMode"),
        makeProperty("CapRecPageMode"),
        makeProperty("CapSlpPageMode"),
        makeProperty("CapUpdateFirmware"),
        makeProperty("CapRecRuledLine"),
        makeProperty("CapSlpRuledLine"),

        // Properties
        makeProperty("AsyncMode"),
        makeProperty("CharacterSet"),
        makeProperty("CharacterSetList"),
        makeProperty("CoverOpen"),
        makeProperty("ErrorLevel"),
        makeProperty("ErrorStation"),
        makeProperty("ErrorString"),
        makeProperty("FlagWhenIdle"),
        makeProperty("FontTypefaceList"),
        makeProperty("JrnEmpty"),
        makeProperty("JrnLetterQuality"),
        makeProperty("JrnLineChars"),
        makeProperty("JrnLineCharsList"),
        makeProperty("JrnLineHeight"),
        makeProperty("JrnLineSpacing"),
        makeProperty("JrnLineWidth"),
        makeProperty("JrnNearEnd"),
        makeProperty("MapMode"),
        makeProperty("OutputID"),
        makeProperty("RecBarCodeRotationList"),
        makeProperty("RecEmpty"),
        makeProperty("RecLetterQuality"),
        makeProperty("RecLineChars"),
        makeProperty("RecLineCharsList"),
        makeProperty("RecLineHeight"),
        makeProperty("RecLineSpacing"),
        makeProperty("RecLinesToPaperCut"),
        makeProperty("RecLineWidth"),
        makeProperty("RecNearEnd"),
        makeProperty("RecSidewaysMaxChars"),
        makeProperty("RecSidewaysMaxLines"),
        makeProperty("RotateSpecial"),
        makeProperty("SlpBarCodeRotationList"),
        makeProperty("SlpEmpty"),
        makeProperty("SlpLetterQuality"),
        makeProperty("SlpLineChars"),
        makeProperty("SlpLineCharsList"),
        makeProperty("SlpLineHeight"),
        makeProperty("SlpLinesNearEndToEnd"),
        makeProperty("SlpLineSpacing"),
        makeProperty("SlpLineWidth"),
        makeProperty("SlpMaxLines"),
        makeProperty("SlpNearEnd"),
        makeProperty("SlpSidewaysMaxChars"),
        makeProperty("SlpSidewaysMaxLines"),
        makeProperty("PowerNotify"),
        makeProperty("PowerState"),
        makeProperty("CartridgeNotify"),
        makeProperty("JrnCartridgeState"),
        makeProperty("JrnCurrentCartridge"),
        makeProperty("RecCartridgeState"),
        makeProperty("RecCurrentCartridge"),
        makeProperty("SlpCartridgeState"),
        makeProperty("SlpCurrentCartridge"),
        makeProperty("SlpPrintSide"),
        makeProperty("MapCharacterSet"),
        makeProperty("RecBitmapRotationList"),
        makeProperty("SlpBitmapRotationList"),
        makeProperty("PageModeArea"),
        makeProperty("PageModeDescriptor"),
        makeProperty("PageModeHorizontalPosition"),
        makeProperty("PageModePrintArea"),
        makeProperty("PageModePrintDirection"),
        makeProperty("PageModeStation"),
        makeProperty("PageModeVerticalPosition"),

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
    return new EventSetDescriptor(jpos.POSPrinter.class,
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
