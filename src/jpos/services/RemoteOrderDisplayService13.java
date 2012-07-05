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
// RemoteOrderDisplayService13
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Remote Order Display for release
//   1.3.
//
// Modification history
// ------------------------------------------------------------------
// 98-04-20 JavaPOS Release 1.3                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface RemoteOrderDisplayService13 extends BaseService
{
    // Capabilities
    public int     getCapPowerReporting() throws JposException;
    public boolean getCapSelectCharacterSet() throws JposException;
    public boolean getCapTone() throws JposException;
    public boolean getCapTouch() throws JposException;
    public boolean getCapTransaction() throws JposException;

    // Properties
    public boolean getAsyncMode() throws JposException;
    public void    setAsyncMode(boolean asyncMode) throws JposException;
    public int     getAutoToneDuration() throws JposException;
    public void    setAutoToneDuration(int autoToneDuration)
                       throws JposException;
    public int     getAutoToneFrequency() throws JposException;
    public void    setAutoToneFrequency(int autoToneFrequency)
                       throws JposException;
    public int     getCharacterSet() throws JposException;
    public String  getCharacterSetList() throws JposException;
    public int     getClocks() throws JposException;
    public int     getCurrentUnitID() throws JposException;
    public void    setCurrentUnitID(int currentUnitID) throws JposException;
    public int     getDataCount() throws JposException;
    public boolean getDataEventEnabled() throws JposException;
    public void    setDataEventEnabled(boolean dataEventEnabled)
                       throws JposException;
    public String  getErrorString() throws JposException;
    public int     getErrorUnits() throws JposException;
    public String  getEventString() throws JposException;
    public int     getEventType() throws JposException;
    public void    setEventType(int eventType) throws JposException;
    public int     getEventUnitID() throws JposException;
    public int     getEventUnits() throws JposException;
    public int     getOutputID() throws JposException;
    public int     getPowerNotify() throws JposException;
    public void    setPowerNotify(int powerNotify) throws JposException;
    public int     getPowerState() throws JposException;
    public int     getSystemClocks() throws JposException;
    public int     getSystemVideoSaveBuffers() throws JposException;
    public int     getTimeout() throws JposException;
    public void    setTimeout(int timeout) throws JposException;
    public int     getUnitsOnline() throws JposException;
    public int     getVideoDataCount() throws JposException;
    public int     getVideoMode() throws JposException;
    public void    setVideoMode(int videoMode) throws JposException;
    public String  getVideoModesList() throws JposException;
    public int     getVideoSaveBuffers() throws JposException;

    // Methods
    public void    clearInput() throws JposException;
    public void    clearOutput() throws JposException;
    public void    clearVideo(int units, int attribute) throws JposException;
    public void    clearVideoRegion(int units, int row, int column, int height,
                       int width, int attribute) throws JposException;
    public void    controlClock(int units, int function, int clockId, int hour,
                       int min, int sec, int row, int column, int attribute,
                       int mode) throws JposException;
    public void    controlCursor(int units, int function) throws JposException;
    public void    copyVideoRegion(int units, int row, int column, int height,
                       int width, int targetRow, int targetColumn)
                       throws JposException;
    public void    displayData(int units, int row, int column, int attribute,
                       String data) throws JposException;
    public void    drawBox(int units, int row, int column, int height,
                       int width, int attribute, int borderType)
                       throws JposException;
    public void    freeVideoRegion(int units, int bufferId)
                       throws JposException;
    public void    resetVideo(int units) throws JposException;
    public void    restoreVideoRegion(int units, int targetRow,
                       int targetColumn, int bufferId) throws JposException;
    public void    saveVideoRegion(int units, int row, int column,
                       int height, int width, int bufferId)
                       throws JposException;
    public void    selectChararacterSet(int units, int characterSet)
                       throws JposException;
    public void    setCursor(int units, int row, int column)
                       throws JposException;
    public void    transactionDisplay(int units, int function)
                       throws JposException;
    public void    updateVideoRegionAttribute(int units, int function, int row,
                       int column, int height, int width, int attribute)
                       throws JposException;
    public void    videoSound(int units, int frequency, int duration,
                       int numberOfCycles, int interSoundWait)
                       throws JposException;
}