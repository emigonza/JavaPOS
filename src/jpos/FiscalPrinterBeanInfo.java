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
// FiscalPrinterBeanInfo.java - Bean information for the JavaPOS FiscalPrinter
//    device control
//
//------------------------------------------------------------------------------

package jpos;

import java.beans.*;
import java.lang.reflect.*;

public class FiscalPrinterBeanInfo
  extends SimpleBeanInfo
{
  public BeanDescriptor getBeanDescriptor()
  {
    return new BeanDescriptor(jpos.FiscalPrinter.class);
  }

  public PropertyDescriptor makeProperty(String propertyName)
    throws IntrospectionException
  {
    return new PropertyDescriptor(propertyName, jpos.FiscalPrinter.class);
  }

  public PropertyDescriptor[] getPropertyDescriptors()
  {
    try
    {
      PropertyDescriptor[] properties =
      {
        // Capabilities
        makeProperty("CapAdditionalLines"),
        makeProperty("CapAmountAdjustment"),
        makeProperty("CapAmountNotPaid"),
        makeProperty("CapCheckTotal"),
        makeProperty("CapCoverSensor"),
        makeProperty("CapDoubleWidth"),
        makeProperty("CapDuplicateReceipt"),
        makeProperty("CapFixedOutput"),
        makeProperty("CapHasVatTable"),
        makeProperty("CapIndependentHeader"),
        makeProperty("CapItemList"),
        makeProperty("CapJrnEmptySensor"),
        makeProperty("CapJrnNearEndSensor"),
        makeProperty("CapJrnPresent"),
        makeProperty("CapNonFiscalMode"),
        makeProperty("CapOrderAdjustmentFirst"),
        makeProperty("CapPercentAdjustment"),
        makeProperty("CapPositiveAdjustment"),
        makeProperty("CapPowerLossReport"),
        makeProperty("CapPowerReporting"),
        makeProperty("CapPredefinedPaymentLines"),
        makeProperty("CapReceiptNotPaid"),
        makeProperty("CapRecEmptySensor"),
        makeProperty("CapRecNearEndSensor"),
        makeProperty("CapRecPresent"),
        makeProperty("CapRemainingFiscalMemory"),
        makeProperty("CapReservedWord"),
        makeProperty("CapSetHeader"),
        makeProperty("CapSetPOSID"),
        makeProperty("CapSetStoreFiscalID"),
        makeProperty("CapSetTrailer"),
        makeProperty("CapSetVatTable"),
        makeProperty("CapSlpEmptySensor"),
        makeProperty("CapSlpFiscalDocument"),
        makeProperty("CapSlpFullSlip"),
        makeProperty("CapSlpNearEndSensor"),
        makeProperty("CapSlpPresent"),
        makeProperty("CapSlpValidation"),
        makeProperty("CapSubAmountAdjustment"),
        makeProperty("CapSubPercentAdjustment"),
        makeProperty("CapSubtotal"),
        makeProperty("CapTrainingMode"),
        makeProperty("CapValidateJournal"),
        makeProperty("CapXReport"),
        makeProperty("CapAdditionalHeader"),
        makeProperty("CapAdditionalTrailer"),
        makeProperty("CapChangeDue"),
        makeProperty("CapEmptyReceiptIsVoidable"),
        makeProperty("CapFiscalReceiptStation"),
        makeProperty("CapFiscalReceiptType"),
        makeProperty("CapMultiContractor"),
        makeProperty("CapOnlyVoidLastItem"),
        makeProperty("CapPackageAdjustment"),
        makeProperty("CapPostPreLine"),
        makeProperty("CapSetCurrency"),
        makeProperty("CapTotalizerType"),
        makeProperty("CapStatisticsReporting"),
        makeProperty("CapUpdateStatistics"),
        makeProperty("CapCompareFirmwareVersion"),
        makeProperty("CapUpdateFirmware"),
        makeProperty("CapPositiveSubtotalAdjustment"),

        // Properties
        makeProperty("AmountDecimalPlace"),
        makeProperty("AsyncMode"),
        makeProperty("CheckTotal"),
        makeProperty("CountryCode"),
        makeProperty("CoverOpen"),
        makeProperty("DayOpened"),
        makeProperty("DescriptionLength"),
        makeProperty("DuplicateReceipt"),
        makeProperty("ErrorLevel"),
        makeProperty("ErrorOutID"),
        makeProperty("ErrorState"),
        makeProperty("ErrorStation"),
        makeProperty("ErrorString"),
        makeProperty("FlagWhenIdle"),
        makeProperty("JrnEmpty"),
        makeProperty("JrnNearEnd"),
        makeProperty("MessageLength"),
        makeProperty("NumHeaderLines"),
        makeProperty("NumTrailerLines"),
        makeProperty("NumVatRates"),
        makeProperty("OutputID"),
        makeProperty("PowerNotify"),
        makeProperty("PowerState"),
        makeProperty("PredefinedPaymentLines"),
        makeProperty("PrinterState"),
        makeProperty("QuantityDecimalPlaces"),
        makeProperty("QuantityLength"),
        makeProperty("RecEmpty"),
        makeProperty("RecNearEnd"),
        makeProperty("RemainingFiscalMemory"),
        makeProperty("ReservedWord"),
        makeProperty("SlpEmpty"),
        makeProperty("SlpNearEnd"),
        makeProperty("SlipSelection"),
        makeProperty("TrainingModeActive"),
        makeProperty("ActualCurrency"),
        makeProperty("AdditionalHeader"),
        makeProperty("AdditionalTrailer"),
        makeProperty("ChangeDue"),
        makeProperty("ContractorId"),
        makeProperty("DateType"),
        makeProperty("FiscalReceiptStation"),
        makeProperty("FiscalReceiptType"),
        makeProperty("MessageType"),
        makeProperty("PostLine"),
        makeProperty("PreLine"),
        makeProperty("TotalizerType"),
        makeProperty("AmountDecimalPlaces")
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
    return new EventSetDescriptor(jpos.FiscalPrinter.class,
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
