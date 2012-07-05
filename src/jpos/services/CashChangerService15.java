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
// CashChangerService15
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Cash Changer for release 1.5.
//
// Modification history
// ------------------------------------------------------------------
// 2000-Apr-17 JavaPOS Release 1.5                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;
import jpos.loader.*;

public interface CashChangerService15
  extends CashChangerService14, JposServiceInstance
{
    // Capabilities
    public boolean getCapDeposit() throws JposException;
    public boolean getCapDepositDataEvent() throws JposException;
    public boolean getCapPauseDeposit() throws JposException;
    public boolean getCapRepayDeposit() throws JposException;

    // Properties
    public int     getDataCount() throws JposException;
    public boolean getDataEventEnabled() throws JposException;
    public void    setDataEventEnabled(boolean dataEventEnabled)
                       throws JposException;
    public int     getDepositAmount() throws JposException;
    public String  getDepositCashList() throws JposException;
    public String  getDepositCodeList() throws JposException;
    public String  getDepositCounts() throws JposException;
    public int     getDepositStatus() throws JposException;

    // Methods
    public void    beginDeposit() throws JposException;
    public void    clearInput() throws JposException;
    public void    endDeposit(int success) throws JposException;
    public void    fixDeposit() throws JposException;
    public void    pauseDeposit(int control) throws JposException;
}