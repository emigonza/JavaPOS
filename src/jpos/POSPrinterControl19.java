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
// POSPrinterControl19
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to POS Printer for release 1.9.
//
// Modification history
// ------------------------------------------------------------------
// 2005-Jan-16 JavaPOS release 1.9                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface POSPrinterControl19 extends POSPrinterControl18
{
  // Capabilities
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public boolean getCapConcurrentPageMode() throws JposException;
  public boolean getCapRecPageMode() throws JposException;
  public boolean getCapSlpPageMode() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;

  // Properties
  public String  getPageModeArea() throws JposException;
  public int     getPageModeDescriptor() throws JposException;
  public int     getPageModeHorizontalPosition() throws JposException;
  public void    setPageModeHorizontalPosition(int position) throws JposException;
  public String  getPageModePrintArea() throws JposException;
  public void    setPageModePrintArea(String area) throws JposException;
  public int     getPageModePrintDirection() throws JposException;
  public void    setPageModePrintDirection(int direction) throws JposException;
  public int     getPageModeStation() throws JposException;
  public void    setPageModeStation(int station) throws JposException;
  public int     getPageModeVerticalPosition() throws JposException;
  public void    setPageModeVerticalPosition(int position) throws JposException;

  // Methods
  public void    clearPrintArea()
                     throws JposException;
  public void    compareFirmwareVersion(String firmwareFileName, int[] result)
                     throws JposException;
  public void    pageModePrint(int control)
                     throws JposException;
  public void    updateFirmware(String firmwareFileName)
                     throws JposException;
}