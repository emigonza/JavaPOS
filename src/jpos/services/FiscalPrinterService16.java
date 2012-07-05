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
// FiscalPrinterService16
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Fiscal Printer for release 1.6.
//
// Modification history
// ------------------------------------------------------------------
// 2001-Apr-18 JavaPOS Release 1.6                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface FiscalPrinterService16
  extends FiscalPrinterService15
{
    // Capabilities
    public boolean getCapAdditionalHeader() throws JposException;
    public boolean getCapAdditionalTrailer() throws JposException;
    public boolean getCapChangeDue() throws JposException;
    public boolean getCapEmptyReceiptIsVoidable() throws JposException;
    public boolean getCapFiscalReceiptStation() throws JposException;
    public boolean getCapFiscalReceiptType() throws JposException;
    public boolean getCapMultiContractor() throws JposException;
    public boolean getCapOnlyVoidLastItem() throws JposException;
    public boolean getCapPackageAdjustment() throws JposException;
    public boolean getCapPostPreLine() throws JposException;
    public boolean getCapSetCurrency() throws JposException;
    public boolean getCapTotalizerType() throws JposException;

    // Properties
    public int     getActualCurrency() throws JposException;
    public String  getAdditionalHeader() throws JposException;
    public void    setAdditionalHeader(String additionalHeader)
                       throws JposException;
    public String  getAdditionalTrailer() throws JposException;
    public void    setAdditionalTrailer(String additionalTrailer)
                       throws JposException;
    public String  getChangeDue() throws JposException;
    public void    setChangeDue(String changeDue) throws JposException;
    public int     getContractorId() throws JposException;
    public void    setContractorId(int contractorId) throws JposException;
    public int     getDateType() throws JposException;
    public void    setDateType(int dateType) throws JposException;
    public int     getFiscalReceiptStation() throws JposException;
    public void    setFiscalReceiptStation(int fiscalReceiptStation)
                       throws JposException;
    public int     getFiscalReceiptType() throws JposException;
    public void    setFiscalReceiptType(int fiscalReceiptType)
                       throws JposException;
    public int     getMessageType() throws JposException;
    public void    setMessageType(int messageType) throws JposException;
    public String  getPostLine() throws JposException;
    public void    setPostLine(String postLine) throws JposException;
    public String  getPreLine() throws JposException;
    public void    setPreLine(String preLine) throws JposException;
    public int     getTotalizerType() throws JposException;
    public void    setTotalizerType(int totalizerType) throws JposException;

    // Methods
    public void    setCurrency(int newCurrency) throws JposException;
    public void    printRecCash(long amount) throws JposException;
    public void    printRecItemFuel(String description, long price,
                       int quantity, int vatInfo, long unitPrice,
                       String unitName, long specialTax, String specialTaxName)
                       throws JposException;
    public void    printRecItemFuelVoid(String description, long price,
                       int vatInfo, long specialTax) throws JposException;
    public void    printRecPackageAdjustment(int adjustmentType,
                       String description, String vatAdjustment)
                       throws JposException;
    public void    printRecPackageAdjustVoid(int adjustmentType,
                       String vatAdjustment) throws JposException;
    public void    printRecRefundVoid(String description, long amount,
                       int vatInfo) throws JposException;
    public void    printRecSubtotalAdjustVoid(int adjustmentType, long amount)
                       throws JposException;
    public void    printRecTaxID(String taxID) throws JposException;
}