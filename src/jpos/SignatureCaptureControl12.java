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
// Signature CaptureControl12
//
//   Interface definining all capabilities, properties and methods
//   that are specific to Signature Capture for release 1.2.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface SignatureCaptureControl12 extends BaseControl
{
    // Capabilities
    public boolean getCapDisplay() throws JposException;
    public boolean getCapRealTimeData() throws JposException;
    public boolean getCapUserTerminated() throws JposException;

    // Properties
    public boolean getAutoDisable() throws JposException;
    public void    setAutoDisable(boolean autoDisable) throws JposException;
    public int     getDataCount() throws JposException;
    public boolean getDataEventEnabled() throws JposException;
    public void    setDataEventEnabled(boolean dataEventEnabled)
                       throws JposException;
    public int     getMaximumX() throws JposException;
    public int     getMaximumY() throws JposException;
    public java.awt.Point[]
                   getPointArray() throws JposException;
    public byte[]  getRawData() throws JposException;
    public boolean getRealTimeDataEnabled() throws JposException;
    public void    setRealTimeDataEnabled(boolean realTimeDataEnabled)
                       throws JposException;

    // Methods
    public void    beginCapture(String formName) throws JposException;
    public void    clearInput() throws JposException;
    public void    endCapture() throws JposException;

    // Event listener methods
    public void    addDataListener(DataListener l);
    public void    removeDataListener(DataListener l);
    public void    addDirectIOListener(DirectIOListener l);
    public void    removeDirectIOListener(DirectIOListener l);
    public void    addErrorListener(ErrorListener l);
    public void    removeErrorListener(ErrorListener l);
}