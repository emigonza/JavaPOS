/////////////////////////////////////////////////////////////////////
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
// CashChangerControl12
//
//   Interface definining all capabilities, properties and methods
//   that are specific to Cash Changer for release 1.2.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface CashChangerControl12 extends BaseControl
{
    // Capabilities
    public boolean getCapDiscrepancy() throws JposException;
    public boolean getCapEmptySensor() throws JposException;
    public boolean getCapFullSensor() throws JposException;
    public boolean getCapNearEmptySensor() throws JposException;
    public boolean getCapNearFullSensor() throws JposException;

    // Properties
    public boolean getAsyncMode() throws JposException;
    public void    setAsyncMode(boolean asyncMode) throws JposException;
    public int     getAsyncResultCode() throws JposException;
    public int     getAsyncResultCodeExtended() throws JposException;
    public String  getCurrencyCashList() throws JposException;
    public String  getCurrencyCode() throws JposException;
    public void    setCurrencyCode(String currencyCode) throws JposException;
    public String  getCurrencyCodeList() throws JposException;
    public int     getCurrentExit() throws JposException;
    public void    setCurrentExit(int currentExit) throws JposException;
    public int     getDeviceExits() throws JposException;
    public int     getDeviceStatus() throws JposException;
    public String  getExitCashList() throws JposException;
    public int     getFullStatus() throws JposException;

    // Methods
    public void    dispenseCash(String cashCounts) throws JposException;
    public void    dispenseChange(int amount) throws JposException;
    public void    readCashCounts(String[] cashCounts,
                       boolean[] discrepancy) throws JposException;

    // Event listener methods
    public void    addDirectIOListener(DirectIOListener l);
    public void    removeDirectIOListener(DirectIOListener l);
    public void    addStatusUpdateListener(StatusUpdateListener l);
    public void    removeStatusUpdateListener(StatusUpdateListener l);
}