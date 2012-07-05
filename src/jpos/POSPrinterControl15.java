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
// POSPrinterControl15
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to POS Printer for release 1.5.
//
// Modification history
// ------------------------------------------------------------------
// 00-04-17 JavaPOS Release 1.5                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface POSPrinterControl15 extends POSPrinterControl14
{
    // Capabilities
    public int     getCapJrnCartridgeSensor() throws JposException;
    public int     getCapJrnColor() throws JposException;
    public int     getCapRecCartridgeSensor() throws JposException;
    public int     getCapRecColor() throws JposException;
    public int     getCapRecMarkFeed() throws JposException;
    public boolean getCapSlpBothSidesPrint() throws JposException;
    public int     getCapSlpCartridgeSensor() throws JposException;
    public int     getCapSlpColor() throws JposException;

    // Properties
    public int     getCartridgeNotify() throws JposException;
    public void    setCartridgeNotify(int notify) throws JposException;
    public int     getJrnCartridgeState() throws JposException;
    public int     getJrnCurrentCartridge() throws JposException;
    public void    setJrnCurrentCartridge(int cartridge) throws JposException;
    public int     getRecCartridgeState() throws JposException;
    public int     getRecCurrentCartridge() throws JposException;
    public void    setRecCurrentCartridge(int cartridge) throws JposException;
    public int     getSlpCartridgeState() throws JposException;
    public int     getSlpCurrentCartridge() throws JposException;
    public void    setSlpCurrentCartridge(int cartridge) throws JposException;
    public int     getSlpPrintSide() throws JposException;

    // Methods
    public void    changePrintSide(int side) throws JposException;
    public void    markFeed(int type) throws JposException;
}