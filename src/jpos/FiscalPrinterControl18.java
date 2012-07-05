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
// FiscalPrinterControl18
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Fiscal Printer for release 1.8.
//
// Modification history
// ------------------------------------------------------------------
// 2004-Apr-01 JavaPOS Release 1.8                                 BS
// 16-Apr-2003 Release 1.8.2: Added getAmountDecimalPlaces to      BS
//               correct a spelling error present since release
//               1.3.
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface FiscalPrinterControl18 extends FiscalPrinterControl17
{
  // Capabilities
  public boolean getCapStatisticsReporting() throws JposException;
  public boolean getCapUpdateStatistics() throws JposException;

  // Methods
  public void    resetStatistics(String statisticsBuffer)
                     throws JposException;
  public void    retrieveStatistics(String[] statisticsBuffer)
                     throws JposException;
  public void    updateStatistics(String statisticsBuffer)
                     throws JposException;
}