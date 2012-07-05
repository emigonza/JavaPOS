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
// FiscalPrinterService13
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Fiscal Printer for release 1.3.
//
// Modification history
// ------------------------------------------------------------------
// 98-04-20 JavaPOS Release 1.3                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface FiscalPrinterService13 extends BaseService
{
    // Capabilities
    public boolean getCapAdditionalLines() throws JposException;
    public boolean getCapAmountAdjustment() throws JposException;
    public boolean getCapAmountNotPaid() throws JposException;
    public boolean getCapCheckTotal() throws JposException;
    public boolean getCapCoverSensor() throws JposException;
    public boolean getCapDoubleWidth() throws JposException;
    public boolean getCapDuplicateReceipt() throws JposException;
    public void    setDuplicateReceipt(boolean duplicateReceipt) throws JposException;
    public boolean getCapFixedOutput() throws JposException;
    public boolean getCapHasVatTable() throws JposException;
    public boolean getCapIndependentHeader() throws JposException;
    public boolean getCapItemList() throws JposException;
    public boolean getCapJrnEmptySensor() throws JposException;
    public boolean getCapJrnNearEndSensor() throws JposException;
    public boolean getCapJrnPresent() throws JposException;
    public boolean getCapNonFiscalMode() throws JposException;
    public boolean getCapOrderAdjustmentFirst() throws JposException;
    public boolean getCapPercentAdjustment() throws JposException;
    public boolean getCapPositiveAdjustment() throws JposException;
    public boolean getCapPowerLossReport() throws JposException;
    public int     getCapPowerReporting() throws JposException;
    public boolean getCapPredefinedPaymentLines() throws JposException;
    public boolean getCapReceiptNotPaid() throws JposException;
    public boolean getCapRecEmptySensor() throws JposException;
    public boolean getCapRecNearEndSensor() throws JposException;
    public boolean getCapRecPresent() throws JposException;
    public boolean getCapRemainingFiscalMemory() throws JposException;
    public boolean getCapReservedWord() throws JposException;
    public boolean getCapSetHeader() throws JposException;
    public boolean getCapSetPOSID() throws JposException;
    public boolean getCapSetStoreFiscalID() throws JposException;
    public boolean getCapSetTrailer() throws JposException;
    public boolean getCapSetVatTable() throws JposException;
    public boolean getCapSlpEmptySensor() throws JposException;
    public boolean getCapSlpFiscalDocument() throws JposException;
    public boolean getCapSlpFullSlip() throws JposException;
    public boolean getCapSlpNearEndSensor() throws JposException;
    public boolean getCapSlpPresent() throws JposException;
    public boolean getCapSlpValidation() throws JposException;
    public boolean getCapSubAmountAdjustment() throws JposException;
    public boolean getCapSubPercentAdjustment() throws JposException;
    public boolean getCapSubtotal() throws JposException;
    public boolean getCapTrainingMode() throws JposException;
    public boolean getCapValidateJournal() throws JposException;
    public boolean getCapXReport() throws JposException;

    // Properties
    public int     getOutputID() throws JposException;
    public int     getPowerNotify() throws JposException;
    public void    setPowerNotify(int powerNotify) throws JposException;
    public int     getPowerState() throws JposException;

    public int     getAmountDecimalPlace() throws JposException;
    public boolean getAsyncMode() throws JposException;
    public void    setAsyncMode(boolean asyncMode) throws JposException;
    public boolean getCheckTotal() throws JposException;
    public void    setCheckTotal(boolean checkTotal) throws JposException;
    public int     getCountryCode() throws JposException;
    public boolean getCoverOpen() throws JposException;
    public boolean getDayOpened() throws JposException;
    public int     getDescriptionLength() throws JposException;
    public boolean getDuplicateReceipt() throws JposException;
    public int     getErrorLevel() throws JposException;
    public int     getErrorOutID() throws JposException;
    public int     getErrorState() throws JposException;
    public int     getErrorStation() throws JposException;
    public String  getErrorString() throws JposException;
    public boolean getFlagWhenIdle() throws JposException;
    public void    setFlagWhenIdle(boolean flagWhenIdle) throws JposException;
    public boolean getJrnEmpty() throws JposException;
    public boolean getJrnNearEnd() throws JposException;
    public int     getMessageLength() throws JposException;
    public int     getNumHeaderLines() throws JposException;
    public int     getNumTrailerLines() throws JposException;
    public int     getNumVatRates() throws JposException;
    public String  getPredefinedPaymentLines() throws JposException;
    public int     getPrinterState() throws JposException;
    public int     getQuantityDecimalPlaces() throws JposException;
    public int     getQuantityLength() throws JposException;
    public boolean getRecEmpty() throws JposException;
    public boolean getRecNearEnd() throws JposException;
    public int     getRemainingFiscalMemory() throws JposException;
    public String  getReservedWord() throws JposException;
    public boolean getSlpEmpty() throws JposException;
    public boolean getSlpNearEnd() throws JposException;
    public int     getSlipSelection() throws JposException;
    public void    setSlipSelection(int slipSelection) throws JposException;
    public boolean getTrainingModeActive() throws JposException;

    // Methods
    public void    beginFiscalDocument(int documentAmount)
                       throws JposException;
    public void    beginFiscalReceipt(boolean printHeader)
                       throws JposException;
    public void    beginFixedOutput(int station, int documentType)
                       throws JposException;
    public void    beginInsertion(int timeout) throws JposException;
    public void    beginItemList(int vatID) throws JposException;
    public void    beginNonFiscal() throws JposException;
    public void    beginRemoval(int timeout) throws JposException;
    public void    beginTraining() throws JposException;
    public void    clearError() throws JposException;
    public void    clearOutput() throws JposException;
    public void    endFiscalDocument() throws JposException;
    public void    endFiscalReceipt(boolean printHeader) throws JposException;
    public void    endFixedOutput() throws JposException;
    public void    endInsertion() throws JposException;
    public void    endItemList() throws JposException;
    public void    endNonFiscal() throws JposException;
    public void    endRemoval() throws JposException;
    public void    endTraining() throws JposException;
    public void    getData(int dataItem, int[] optArgs, String[] data)
                       throws JposException;
    public void    getDate(String[] Date) throws JposException;
    public void    getTotalizer(int vatID, int optArgs, String[] data)
                       throws JposException;
    public void    getVatEntry(int vatID, int optArgs, int[] vatRate)
                       throws JposException;
    public void    printDuplicateReceipt() throws JposException;
    public void    printFiscalDocumentLine(String documentLine)
                       throws JposException;
    public void    printFixedOutput(int documentType, int lineNumber,
                       String data) throws JposException;
    public void    printNormal(int station, String data) throws JposException;
    public void    printPeriodicTotalsReport(String date1, String date2)
                       throws JposException;
    public void    printPowerLossReport() throws JposException;
    public void    printRecItem(String description, long price, int quantity,
                       int vatInfo, long unitPrice, String unitName)
                       throws JposException;
    public void    printRecItemAdjustment(int adjustmentType,
                       String description, long amount, int vatInfo)
                       throws JposException;
    public void    printRecMessage(String message) throws JposException;
    public void    printRecNotPaid(String description, long amount)
                       throws JposException;
    public void    printRecRefund(String description, long amount, int vatInfo)
                       throws JposException;
    public void    printRecSubtotal(long amount) throws JposException;
    public void    printRecSubtotalAdjustment(int adjustmentType,
                       String description, long amount) throws JposException;
    public void    printRecTotal(long total, long payment, String description)
                       throws JposException;
    public void    printRecVoid(String description) throws JposException;
    public void    printRecVoidItem(String description, long amount,
                       int quantity, int adjustmentType, long adjustment,
                       int vatInfo) throws JposException;
    public void    printReport(int reportType, String startNum, String endNum)
                       throws JposException;
    public void    printXReport() throws JposException;
    public void    printZReport() throws JposException;
    public void    resetPrinter() throws JposException;
    public void    setDate(String date) throws JposException;
    public void    setHeaderLine(int lineNumber, String text,
                       boolean doubleWidth) throws JposException;
    public void    setPOSID(String POSID, String cashierID)
                       throws JposException;
    public void    setStoreFiscalID(String ID) throws JposException;
    public void    setTrailerLine(int lineNumber, String text,
                       boolean doubleWidth) throws JposException;
    public void    setVatTable() throws JposException;
    public void    setVatValue(int vatID, String vatValue)
                       throws JposException;
    public void    verifyItem(String itemName, int vatID) throws JposException;
}