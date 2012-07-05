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
// CheckScannerControl19
//
//   Interface definining all new capabilities, properties and
//                                Check Scanner
// Modification history
// ------------------------------------------------------------------
// 2005-Jan-16 JavaPOS release 1.9                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface CheckScannerControl19 extends CheckScannerControl18
{
  // Capabilities
  public boolean getCapAutoContrast() throws JposException;
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public boolean getCapContrast() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;

  // Properties
  public int     getContrast() throws JposException;
  public void    setContrast(int contrast) throws JposException;

  // Methods
  public void    compareFirmwareVersion(String firmwareFileName, int[] result)
                     throws JposException;
  public void    updateFirmware(String firmwareFileName)
                     throws JposException;
}