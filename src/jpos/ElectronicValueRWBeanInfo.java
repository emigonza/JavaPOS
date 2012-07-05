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
// ElectronicValueRWBeanInfo.java - Bean information for the JavaPOS ElectronicValueRW
//    device control
//
//------------------------------------------------------------------------------

package jpos;

import java.beans.*;
import java.lang.reflect.*;

public class ElectronicValueRWBeanInfo
  extends SimpleBeanInfo
{
  public BeanDescriptor getBeanDescriptor()
  {
    return new BeanDescriptor(jpos.ElectronicValueRW.class);
  }

  public PropertyDescriptor makeProperty(String propertyName)
    throws IntrospectionException
  {
    return new PropertyDescriptor(propertyName, jpos.ElectronicValueRW.class);
  }

  public PropertyDescriptor[] getPropertyDescriptors()
  {
    try
    {
      PropertyDescriptor[] properties =
      {
        // Capabilities
        makeProperty("CapActivateService"),
        makeProperty("CapAddValue"),
        makeProperty("CapCancelValue"),
        makeProperty("CapCardSensor"),
        makeProperty("CapCompareFirmwareVersion"),
        makeProperty("CapDetectionControl"),
        makeProperty("CapElectronicMoney"),
        makeProperty("CapEnumerateCardServices"),
        makeProperty("CapIndirectTransactionLog"),
        makeProperty("CapLockTerminal"),
        makeProperty("CapLogStatus"),
        makeProperty("CapMediumID"),
        makeProperty("CapPoint"),
        makeProperty("CapPowerReporting"),
        makeProperty("CapRealTimeData"),
        makeProperty("CapStatisticsReporting"),
        makeProperty("CapSubtractValue"),
        makeProperty("CapTransaction"),
        makeProperty("CapTransactionLog"),
        makeProperty("CapUnlockTerminal"),
        makeProperty("CapUpdateFirmware"),
        makeProperty("CapUpdateKey"),
        makeProperty("CapUpdateStatistics"),
        makeProperty("CapVoucher"),
        makeProperty("CapWriteValue"),

        // Properties
        makeProperty("AccountNumber"),
        makeProperty("AdditionalSecurityInformation"),
        makeProperty("Amount"),
        makeProperty("ApprovalCode"),
        makeProperty("AsyncMode"),
        makeProperty("AutoDisable"),
        makeProperty("Balance"),
        makeProperty("BalanceOfPoint"),
        makeProperty("CardServiceList"),
        makeProperty("CurrentService"),
        makeProperty("DataCount"),
        makeProperty("DataEventEnabled"),
        makeProperty("DetectionControl"),
        makeProperty("DetectionStatus"),
        makeProperty("ExpirationDate"),
        makeProperty("LastUsedDate"),
        makeProperty("LogStatus"),
        makeProperty("MediumID"),
        makeProperty("OutputID"),
        makeProperty("Point"),
        makeProperty("PowerNotify"),
        makeProperty("PowerState"),
        makeProperty("ReaderWriterServiceList"),
        makeProperty("SequenceNumber"),
        makeProperty("SettledAmount"),
        makeProperty("SettledPoint"),
        makeProperty("TransactionLog"),
        makeProperty("VoucherID"),
        makeProperty("VoucherIDList"),

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
    return new EventSetDescriptor(jpos.ElectronicValueRW.class,
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
