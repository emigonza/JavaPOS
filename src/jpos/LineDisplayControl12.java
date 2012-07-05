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
// LineDisplayControl12
//
//   Interface definining all capabilities, properties and methods
//   that are specific to Line Display for release 1.2.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface LineDisplayControl12 extends BaseControl
{
    // Capabilities
    public int     getCapBlink() throws JposException;
    public boolean getCapBrightness() throws JposException;
    public int     getCapCharacterSet() throws JposException;
    public boolean getCapDescriptors() throws JposException;
    public boolean getCapHMarquee() throws JposException;
    public boolean getCapICharWait() throws JposException;
    public boolean getCapVMarquee() throws JposException;

    // Properties
    public int     getCharacterSet() throws JposException;
    public void    setCharacterSet(int characterSet) throws JposException;
    public String  getCharacterSetList() throws JposException;
    public int     getColumns() throws JposException;
    public int     getCurrentWindow() throws JposException;
    public void    setCurrentWindow(int currentWindow) throws JposException;
    public int     getCursorColumn() throws JposException;
    public void    setCursorColumn(int cursorColumn) throws JposException;
    public int     getCursorRow() throws JposException;
    public void    setCursorRow(int cursorRow) throws JposException;
    public boolean getCursorUpdate() throws JposException;
    public void    setCursorUpdate(boolean cursorUpdate) throws JposException;
    public int     getDeviceBrightness() throws JposException;
    public void    setDeviceBrightness(int deviceBrightness)
                       throws JposException;
    public int     getDeviceColumns() throws JposException;
    public int     getDeviceDescriptors() throws JposException;
    public int     getDeviceRows() throws JposException;
    public int     getDeviceWindows() throws JposException;
    public int     getInterCharacterWait() throws JposException;
    public void    setInterCharacterWait(int interCharacterWait)
                       throws JposException;
    public int     getMarqueeFormat() throws JposException;
    public void    setMarqueeFormat(int marqueeFormat) throws JposException;
    public int     getMarqueeRepeatWait() throws JposException;
    public void    setMarqueeRepeatWait(int marqueeRepeatWait)
                       throws JposException;
    public int     getMarqueeType() throws JposException;
    public void    setMarqueeType(int marqueeType) throws JposException;
    public int     getMarqueeUnitWait() throws JposException;
    public void    setMarqueeUnitWait(int marqueeUnitWait)
                       throws JposException;
    public int     getRows() throws JposException;

    // Methods
    public void    clearDescriptors() throws JposException;
    public void    clearText() throws JposException;
    public void    createWindow(int viewportRow, int viewportColumn,
                       int viewportHeight, int viewportWidth, int windowHeight,
                       int windowWidth) throws JposException;
    public void    destroyWindow() throws JposException;
    public void    displayText(String data, int attribute)
                       throws JposException;
    public void    displayTextAt(int row, int column, String data,
                       int attribute) throws JposException;
    public void    refreshWindow(int window) throws JposException;
    public void    scrollText(int direction, int units) throws JposException;
    public void    setDescriptor(int descriptor, int attribute)
                       throws JposException;

    // Event listener methods
    public void    addDirectIOListener(DirectIOListener l);
    public void    removeDirectIOListener(DirectIOListener l);
}