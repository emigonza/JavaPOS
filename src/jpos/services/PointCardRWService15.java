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
// PointCardRWService15
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to the Point Card Reader Wwriter for
//   release 1.5.
//
// Modification history
// ------------------------------------------------------------------
// 2000-Apr-17 JavaPOS Release 1.5                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;
import jpos.loader.*;

public interface PointCardRWService15
  extends BaseService, JposServiceInstance
{
    // Capabilities
    public boolean getCapBold() throws JposException;
    public int     getCapCardEntranceSensor() throws JposException;
    public int     getCapCharacterSet() throws JposException;
    public boolean getCapCleanCard() throws JposException;
    public boolean getCapClearPrint() throws JposException;
    public boolean getCapDhigh() throws JposException;
    public boolean getCapDwide() throws JposException;
    public boolean getCapDwideDhigh() throws JposException;
    public boolean getCapItalic() throws JposException;
    public boolean getCapLeft90() throws JposException;
    public int     getCapPowerReporting() throws JposException;
    public boolean getCapPrint() throws JposException;
    public boolean getCapPrintMode() throws JposException;
    public boolean getCapRight90() throws JposException;
    public boolean getCapRotate180() throws JposException;
    public int     getCapTracksToRead() throws JposException;
    public int     getCapTracksToWrite() throws JposException;

    // Properties
    public int     getCardState() throws JposException;
    public int     getCharacterSet() throws JposException;
    public void    setCharacterSet(int charSet) throws JposException;
    public String  getCharacterSetList() throws JposException;
    public int     getDataCount() throws JposException;
    public boolean getDataEventEnabled() throws JposException;
    public void    setDataEventEnabled(boolean dataEventEnabled)
                       throws JposException;
    public String  getFontTypeFaceList() throws JposException;
    public int     getLineChars() throws JposException;
    public void    setLineChars(int lineChars) throws JposException;
    public String  getLineCharsList() throws JposException;
    public int     getLineHeight() throws JposException;
    public void    setLineHeight(int lineHeight) throws JposException;
    public int     getLineSpacing() throws JposException;
    public void    setLineSpacing(int lineSpacing) throws JposException;
    public int     getLineWidth() throws JposException;
    public int     getMapMode() throws JposException;
    public void    setMapMode(int mapMode) throws JposException;
    public int     getMaxLines() throws JposException;
    public int     getOutputID() throws JposException;
    public int     getPowerNotify() throws JposException;
    public void    setPowerNotify(int powerNotify) throws JposException;
    public int     getPowerState() throws JposException;
    public int     getPrintHeight() throws JposException;
    public int     getReadState1() throws JposException;
    public int     getReadState2() throws JposException;
    public int     getRecvLength1() throws JposException;
    public int     getRecvLength2() throws JposException;
    public int     getSidewaysMaxChars() throws JposException;
    public int     getSidewaysMaxLines() throws JposException;
    public int     getTracksToRead() throws JposException;
    public void    setTracksToRead(int tracksToRead) throws JposException;
    public int     getTracksToWrite() throws JposException;
    public void    setTracksToWrite(int tracksToWrite) throws JposException;
    public String  getTrack1Data() throws JposException;
    public String  getTrack2Data() throws JposException;
    public String  getTrack3Data() throws JposException;
    public String  getTrack4Data() throws JposException;
    public String  getTrack5Data() throws JposException;
    public String  getTrack6Data() throws JposException;
    public int     getWriteState1() throws JposException;
    public int     getWriteState2() throws JposException;
    public String  getWrite1Data() throws JposException;
    public void    setWrite1Data(String data) throws JposException;
    public String  getWrite2Data() throws JposException;
    public void    setWrite2Data(String data) throws JposException;
    public String  getWrite3Data() throws JposException;
    public void    setWrite3Data(String data) throws JposException;
    public String  getWrite4Data() throws JposException;
    public void    setWrite4Data(String data) throws JposException;
    public String  getWrite5Data() throws JposException;
    public void    setWrite5Data(String data) throws JposException;
    public String  getWrite6Data() throws JposException;
    public void    setWrite6Data(String data) throws JposException;

    // Methods
    public void    beginInsertion(int timeout) throws JposException;
    public void    beginRemoval(int timeout) throws JposException;
    public void    cleanCard() throws JposException;
    public void    clearInput() throws JposException;
    public void    clearOutput() throws JposException;
    public void    clearPrintWrite(int kind, int hPosition, int vPosition,
                                   int width, int height) throws JposException;
    public void    endInsertion() throws JposException;
    public void    endRemoval() throws JposException;
    public void    printWrite(int kind, int hPosition, int vPosition,
                              String data) throws JposException;
    public void    rotatePrint(int rotation) throws JposException;
    public void    validateData(String data) throws JposException;
}