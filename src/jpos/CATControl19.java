///////////////////////////////////////////////////////////////////////////////
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
// CATControl19
//
//   Interface definining all capabilities, properties and methods that are
//   specific to the Credit Authorization Terminal for release 1.9.
//
// Modification history
// ------------------------------------------------------------------
// 2005-Jan-16 JavaPOS release 1.9                                 BS
//
//////////////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface CATControl19 extends CATControl18
{
  // Capabilities
  public boolean getCapCashDeposit() throws JposException;
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public boolean getCapLockTerminal() throws JposException;
  public boolean getCapLogStatus() throws JposException;
  public boolean getCapUnlockTerminal() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;

  // Properties
  public long    getBalance() throws JposException;
  public int     getLogStatus() throws JposException;
  public long    getSettledAmount() throws JposException;

  // Methods
  public void    cashDeposit(int sequenceNumber, long amount, int timeout)
                     throws JposException;
  public void    compareFirmwareVersion(String firmwareFileName, int[] result)
                     throws JposException;
  public void    lockTerminal()
                     throws JposException;
  public void    unlockTerminal()
                     throws JposException;
  public void    updateFirmware(String firmwareFileName)
                     throws JposException;
}