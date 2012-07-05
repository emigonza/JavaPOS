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
// POSPrinterService18
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to POS Printer for release 1.8.
//
// Modification history
// ------------------------------------------------------------------
// 2004-Apr-01 JavaPOS Release 1.8                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface POSPrinterService18
  extends POSPrinterService17
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