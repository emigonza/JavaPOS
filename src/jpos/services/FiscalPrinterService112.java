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
// FiscalPrinterService112
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Fiscal Printer for release 1.12.
//
// Modification history
// ------------------------------------------------------------------
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface FiscalPrinterService112 extends FiscalPrinterService111
{
  // Methods
  public void    printRecItemRefund(String description,
                                    long amount,
                                    int quantity,
                                    int vatInfo,
                                    long unitAmount,
                                    String unitName)
                     throws JposException;
  public void    printRecItemRefundVoid(String description,
                                        long amount,
                                        int quantity,
                                        int vatInfo,
                                        long unitAmount,
                                        String unitName)
                     throws JposException;
}