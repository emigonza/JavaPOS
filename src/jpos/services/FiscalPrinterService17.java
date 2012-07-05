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
// FiscalPrinterService17
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Fiscal Printer for release 1.7.
//
// Modification history
// ------------------------------------------------------------------
// 01-Jul-2002 JavaPOS Release 1.7                                 BS
// 16-Apr-2003 Release 1.7.2: Added getAmountDecimalPlaces to      BS
//               correct a spelling error present since release
//               1.3.
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface FiscalPrinterService17
  extends FiscalPrinterService16
{
	// The AmountDecimalPlaces property was incorrectly spelled
	// AmountDecimalPlace since version 1.3.  In version 1.7.2 and later,
	// the correct spelling is supported. The old version is left for
	// Application and Device Service compatibility. The implementations
	// of getAmountDecimalPlaces and getAmountDecimalPlace should be
	// identical.

	// Properties
	public int     getAmountDecimalPlaces() throws JposException;
}