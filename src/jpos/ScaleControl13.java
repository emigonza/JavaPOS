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
// ScaleControl13
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Scale for release 1.3.
//
// Modification history
// ------------------------------------------------------------------
// 98-04-20 JavaPOS Release 1.3                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface ScaleControl13 extends ScaleControl12
{
    // Capabilities
    public boolean getCapDisplayText() throws JposException;
    public boolean getCapPriceCalculating() throws JposException;
    public int     getCapPowerReporting() throws JposException;
    public boolean getCapTareWeight() throws JposException;
    public boolean getCapZeroScale()  throws JposException;

    // Properties
    public boolean getAsyncMode() throws JposException;
    public void    setAsyncMode(boolean asyncMode) throws JposException;
    public boolean getAutoDisable() throws JposException;
    public void    setAutoDisable(boolean autoDisable) throws JposException;
    public int     getDataCount() throws JposException;
    public boolean getDataEventEnabled() throws JposException;
    public void    setDataEventEnabled(boolean dataEventEnabled) throws JposException;
    public int     getMaxDisplayTextChars() throws JposException;
    public long    getSalesPrice() throws JposException;
    public int     getTareWeight() throws JposException;
    public void    setTareWeight(int tareWeight) throws JposException;
    public long    getUnitPrice() throws JposException;
    public void    setUnitPrice(long unitPrice) throws JposException;
    public int     getPowerNotify() throws JposException;
    public void    setPowerNotify(int powerNotify) throws JposException;
    public int     getPowerState() throws JposException;

    // Methods
    public void    clearInput() throws JposException;
    public void    displayText(String data) throws JposException;
    public void    zeroScale() throws JposException;

    // Event listener methods
    public void    addDataListener(DataListener l);
    public void    removeDataListener(DataListener l);
    public void    addErrorListener(ErrorListener l);
    public void    removeErrorListener(ErrorListener l);
    public void    addStatusUpdateListener(StatusUpdateListener l);
    public void    removeStatusUpdateListener(StatusUpdateListener l);
}