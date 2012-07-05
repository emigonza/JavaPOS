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
// POSPrinterService12
//
//   Interface definining all capabilities, properties and methods
//   that are specific to POS Printer for release 1.2.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface POSPrinterService12 extends BaseService
{
    // Capabilities
    public int     getCapCharacterSet() throws JposException;
    public boolean getCapConcurrentJrnRec() throws JposException;
    public boolean getCapConcurrentJrnSlp() throws JposException;
    public boolean getCapConcurrentRecSlp() throws JposException;
    public boolean getCapCoverSensor() throws JposException;
    public boolean getCapJrn2Color() throws JposException;
    public boolean getCapJrnBold() throws JposException;
    public boolean getCapJrnDhigh() throws JposException;
    public boolean getCapJrnDwide() throws JposException;
    public boolean getCapJrnDwideDhigh() throws JposException;
    public boolean getCapJrnEmptySensor() throws JposException;
    public boolean getCapJrnItalic() throws JposException;
    public boolean getCapJrnNearEndSensor() throws JposException;
    public boolean getCapJrnPresent() throws JposException;
    public boolean getCapJrnUnderline() throws JposException;
    public boolean getCapRec2Color() throws JposException;
    public boolean getCapRecBarCode() throws JposException;
    public boolean getCapRecBitmap() throws JposException;
    public boolean getCapRecBold() throws JposException;
    public boolean getCapRecDhigh() throws JposException;
    public boolean getCapRecDwide() throws JposException;
    public boolean getCapRecDwideDhigh() throws JposException;
    public boolean getCapRecEmptySensor() throws JposException;
    public boolean getCapRecItalic() throws JposException;
    public boolean getCapRecLeft90() throws JposException;
    public boolean getCapRecNearEndSensor() throws JposException;
    public boolean getCapRecPapercut() throws JposException;
    public boolean getCapRecPresent() throws JposException;
    public boolean getCapRecRight90() throws JposException;
    public boolean getCapRecRotate180() throws JposException;
    public boolean getCapRecStamp() throws JposException;
    public boolean getCapRecUnderline() throws JposException;
    public boolean getCapSlp2Color() throws JposException;
    public boolean getCapSlpBarCode() throws JposException;
    public boolean getCapSlpBitmap() throws JposException;
    public boolean getCapSlpBold() throws JposException;
    public boolean getCapSlpDhigh() throws JposException;
    public boolean getCapSlpDwide() throws JposException;
    public boolean getCapSlpDwideDhigh() throws JposException;
    public boolean getCapSlpEmptySensor() throws JposException;
    public boolean getCapSlpFullslip() throws JposException;
    public boolean getCapSlpItalic() throws JposException;
    public boolean getCapSlpLeft90() throws JposException;
    public boolean getCapSlpNearEndSensor() throws JposException;
    public boolean getCapSlpPresent() throws JposException;
    public boolean getCapSlpRight90() throws JposException;
    public boolean getCapSlpRotate180() throws JposException;
    public boolean getCapSlpUnderline() throws JposException;
    public boolean getCapTransaction() throws JposException;

    // Properties
    public boolean getAsyncMode() throws JposException;
    public void    setAsyncMode(boolean asyncMode) throws JposException;
    public int     getCharacterSet() throws JposException;
    public void    setCharacterSet(int characterSet) throws JposException;
    public String  getCharacterSetList() throws JposException;
    public boolean getCoverOpen() throws JposException;
    public int     getErrorLevel() throws JposException;
    public int     getErrorStation() throws JposException;
    public String  getErrorString() throws JposException;
    public boolean getFlagWhenIdle() throws JposException;
    public void    setFlagWhenIdle(boolean flagWhenIdle) throws JposException;
    public String  getFontTypefaceList() throws JposException;
    public boolean getJrnEmpty() throws JposException;
    public boolean getJrnLetterQuality() throws JposException;
    public void    setJrnLetterQuality(boolean jrnLetterQuality)
                       throws JposException;
    public int     getJrnLineChars() throws JposException;
    public void    setJrnLineChars(int jrnLineChars) throws JposException;
    public String  getJrnLineCharsList() throws JposException;
    public int     getJrnLineHeight() throws JposException;
    public void    setJrnLineHeight(int jrnLineHeight) throws JposException;
    public int     getJrnLineSpacing() throws JposException;
    public void    setJrnLineSpacing(int jrnLineSpacing) throws JposException;
    public int     getJrnLineWidth() throws JposException;
    public boolean getJrnNearEnd() throws JposException;
    public int     getMapMode() throws JposException;
    public void    setMapMode(int mapMode) throws JposException;
    public int     getOutputID() throws JposException;
    public String  getRecBarCodeRotationList() throws JposException;
    public boolean getRecEmpty() throws JposException;
    public boolean getRecLetterQuality() throws JposException;
    public void    setRecLetterQuality(boolean recLetterQuality)
                       throws JposException;
    public int     getRecLineChars() throws JposException;
    public void    setRecLineChars(int recLineChars) throws JposException;
    public String  getRecLineCharsList() throws JposException;
    public int     getRecLineHeight() throws JposException;
    public void    setRecLineHeight(int recLineHeight) throws JposException;
    public int     getRecLineSpacing() throws JposException;
    public void    setRecLineSpacing(int recLineSpacing) throws JposException;
    public int     getRecLinesToPaperCut() throws JposException;
    public int     getRecLineWidth() throws JposException;
    public boolean getRecNearEnd() throws JposException;
    public int     getRecSidewaysMaxChars() throws JposException;
    public int     getRecSidewaysMaxLines() throws JposException;
    public int     getRotateSpecial() throws JposException;
    public void    setRotateSpecial(int rotateSpecial) throws JposException;
    public String  getSlpBarCodeRotationList() throws JposException;
    public boolean getSlpEmpty() throws JposException;
    public boolean getSlpLetterQuality() throws JposException;
    public void    setSlpLetterQuality(boolean recLetterQuality)
                       throws JposException;
    public int     getSlpLineChars() throws JposException;
    public void    setSlpLineChars(int recLineChars) throws JposException;
    public String  getSlpLineCharsList() throws JposException;
    public int     getSlpLineHeight() throws JposException;
    public void    setSlpLineHeight(int recLineHeight) throws JposException;
    public int     getSlpLinesNearEndToEnd() throws JposException;
    public int     getSlpLineSpacing() throws JposException;
    public void    setSlpLineSpacing(int recLineSpacing) throws JposException;
    public int     getSlpLineWidth() throws JposException;
    public int     getSlpMaxLines() throws JposException;
    public boolean getSlpNearEnd() throws JposException;
    public int     getSlpSidewaysMaxChars() throws JposException;
    public int     getSlpSidewaysMaxLines() throws JposException;

    // Methods
    public void    beginInsertion(int timeout) throws JposException;
    public void    beginRemoval(int timeout) throws JposException;
    public void    clearOutput() throws JposException;
    public void    cutPaper(int percentage) throws JposException;
    public void    endInsertion() throws JposException;
    public void    endRemoval() throws JposException;
    public void    printBarCode(int station, String data, int symbology,
                                int height, int width, int alignment,
                                int textPosition) throws JposException;
    public void    printBitmap(int station, String fileName, int width,
                               int alignment) throws JposException;
    public void    printImmediate(int station, String data)
                       throws JposException;
    public void    printNormal(int station, String data) throws JposException;
    public void    printTwoNormal(int stations, String data1, String data2)
                       throws JposException;
    public void    rotatePrint(int station, int rotation) throws JposException;
    public void    setBitmap(int bitmapNumber, int station, String fileName,
                             int width, int alignment) throws JposException;
    public void    setLogo(int location, String data) throws JposException;
    public void    transactionPrint(int station, int control)
                       throws JposException;
    public void    validateData(int station, String data) throws JposException;
}