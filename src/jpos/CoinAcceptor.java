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
// CoinAcceptor.java - A JavaPOS 1.13.0 device control
//
//------------------------------------------------------------------------------

package jpos;

import jpos.events.*;
import jpos.services.*;
import java.util.Vector;
import jpos.loader.*;

public class CoinAcceptor
  extends BaseJposControl
  implements CoinAcceptorControl113, JposConst
{
  //--------------------------------------------------------------------------
  // Variables
  //--------------------------------------------------------------------------

  protected CoinAcceptorService111 service111;
  protected CoinAcceptorService112 service112;
  protected CoinAcceptorService113 service113;
  protected Vector dataListeners;
  protected Vector directIOListeners;
  protected Vector statusUpdateListeners;


  //--------------------------------------------------------------------------
  // Constructor
  //--------------------------------------------------------------------------

  public CoinAcceptor()
  {
    // Initialize base class instance data
    deviceControlDescription = "JavaPOS CoinAcceptor Device Control";
    deviceControlVersion = deviceVersion113;

    // Initialize instance data. Initializations are commented out for
    // efficiency if the Java default is correct.
    //service111 = null;
    //service112 = null;
    //service113 = null;
    dataListeners = new Vector();
    directIOListeners = new Vector();
    statusUpdateListeners = new Vector();
  }


  //--------------------------------------------------------------------------
  // Capabilities
  //--------------------------------------------------------------------------

  public boolean getCapCompareFirmwareVersion()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCapCompareFirmwareVersion();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapDiscrepancy()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCapDiscrepancy();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapFullSensor()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCapFullSensor();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapJamSensor()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCapJamSensor();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapNearFullSensor()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCapNearFullSensor();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapPauseDeposit()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCapPauseDeposit();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getCapPowerReporting()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCapPowerReporting();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapRealTimeData()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCapRealTimeData();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapStatisticsReporting()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCapStatisticsReporting();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapUpdateFirmware()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCapUpdateFirmware();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapUpdateStatistics()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCapUpdateStatistics();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }


  //--------------------------------------------------------------------------
  // Properties
  //--------------------------------------------------------------------------

  public String getCurrencyCode()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getCurrencyCode();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setCurrencyCode(String currencyCode)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.setCurrencyCode(currencyCode);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getDataCount()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getDataCount();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getDataEventEnabled()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getDataEventEnabled();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setDataEventEnabled(boolean dataEventEnabled)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.setDataEventEnabled(dataEventEnabled);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getDepositAmount()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getDepositAmount();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public String getDepositCashList()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getDepositCashList();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public String getDepositCodeList()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getDepositCodeList();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public String getDepositCounts()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getDepositCounts();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getDepositStatus()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getDepositStatus();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getFullStatus()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getFullStatus();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getPowerNotify()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getPowerNotify();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setPowerNotify(int powerNotify)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.setPowerNotify(powerNotify);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getPowerState()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getPowerState();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getRealTimeDataEnabled()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service111.getRealTimeDataEnabled();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setRealTimeDataEnabled(boolean bEnabled)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.setRealTimeDataEnabled(bEnabled);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }


  //--------------------------------------------------------------------------
  // Methods
  //--------------------------------------------------------------------------

  public void adjustCashCounts(String cashCounts)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.adjustCashCounts(cashCounts);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void beginDeposit()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.beginDeposit();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void clearInput()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.clearInput();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void compareFirmwareVersion(String firmwareFileName, int[] result)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.compareFirmwareVersion(firmwareFileName, result);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void endDeposit(int success)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.endDeposit(success);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void fixDeposit()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.fixDeposit();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void pauseDeposit(int control)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.pauseDeposit(control);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void readCashCounts(String[] cashCounts, boolean[] discrepancy)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.readCashCounts(cashCounts, discrepancy);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void resetStatistics(String statisticsBuffer)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.resetStatistics(statisticsBuffer);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void retrieveStatistics(String[] statisticsBuffer)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.retrieveStatistics(statisticsBuffer);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void updateFirmware(String firmwareFileName)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.updateFirmware(firmwareFileName);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void updateStatistics(String statisticsBuffer)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service111.updateStatistics(statisticsBuffer);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }


  //--------------------------------------------------------------------------
  // Framework Methods
  //--------------------------------------------------------------------------

  // Create an EventCallbacks interface implementation object for this Control
  protected EventCallbacks createEventCallbacks()
  {
    return new CoinAcceptorCallbacks();
  }

  // Store the reference to the Device Service
  protected void setDeviceService(BaseService service, int nServiceVersion)
    throws JposException
  {
    // Special case: service == null to free references
    if(service == null)
    {

      service111 = null;
      service112 = null;
      service113 = null;
    }
    else
    {
      // Make sure that the service actually conforms to the interfaces it
      // claims to.
      if(serviceVersion >= deviceVersion111)
      {
        try
        {
          service111 = (CoinAcceptorService111)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement CoinAcceptorService111 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion112)
      {
        try
        {
          service112 = (CoinAcceptorService112)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement CoinAcceptorService112 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion113)
      {
        try
        {
          service113 = (CoinAcceptorService113)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement CoinAcceptorService113 interface",
                                  e);
        }
      }

    }
  }


  //--------------------------------------------------------------------------
  // Event Listener Methods
  //--------------------------------------------------------------------------

  public void addDataListener(DataListener l)
  {
    synchronized(dataListeners)
    {
      dataListeners.addElement(l);
    }
  }

  public void removeDataListener(DataListener l)
  {
    synchronized(dataListeners)
    {
      dataListeners.removeElement(l);
    }
  }

  public void addDirectIOListener(DirectIOListener l)
  {
    synchronized(directIOListeners)
    {
      directIOListeners.addElement(l);
    }
  }

  public void removeDirectIOListener(DirectIOListener l)
  {
    synchronized(directIOListeners)
    {
      directIOListeners.removeElement(l);
    }
  }

  public void addStatusUpdateListener(StatusUpdateListener l)
  {
    synchronized(statusUpdateListeners)
    {
      statusUpdateListeners.addElement(l);
    }
  }

  public void removeStatusUpdateListener(StatusUpdateListener l)
  {
    synchronized(statusUpdateListeners)
    {
      statusUpdateListeners.removeElement(l);
    }
  }


  //--------------------------------------------------------------------------
  // EventCallbacks inner class
  //--------------------------------------------------------------------------

  protected class CoinAcceptorCallbacks
    implements EventCallbacks
  {
    public BaseControl getEventSource()
    {
      return (BaseControl)CoinAcceptor.this;
    }

    public void fireDataEvent(DataEvent e)
    {
      synchronized(CoinAcceptor.this.dataListeners)
      {
        // deliver the event to all registered listeners
        for(int x = 0; x < dataListeners.size(); x++)
        {
          ((DataListener)dataListeners.elementAt(x)).dataOccurred(e);
        }
      }
    }

    public void fireDirectIOEvent(DirectIOEvent e)
    {
      synchronized(CoinAcceptor.this.directIOListeners)
      {
        // deliver the event to all registered listeners
        for(int x = 0; x < directIOListeners.size(); x++)
        {
          ((DirectIOListener)directIOListeners.elementAt(x)).directIOOccurred(e);
        }
      }
    }

    public void fireErrorEvent(ErrorEvent e)
    {
    }

    public void fireOutputCompleteEvent(OutputCompleteEvent e)
    {
    }

    public void fireStatusUpdateEvent(StatusUpdateEvent e)
    {
      synchronized(CoinAcceptor.this.statusUpdateListeners)
      {
        // deliver the event to all registered listeners
        for(int x = 0; x < statusUpdateListeners.size(); x++)
        {
          ((StatusUpdateListener)statusUpdateListeners.elementAt(x)).statusUpdateOccurred(e);
        }
      }
    }
  }
}
