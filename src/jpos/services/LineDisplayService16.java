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
// LineDisplayService16
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Line Display for release 1.6.
//
// Modification history
// ------------------------------------------------------------------
// 2001-Apr-18 JavaPOS Release 1.6                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface LineDisplayService16
  extends LineDisplayService15
{
    // Capabilities
    public boolean getCapBlinkRate() throws JposException;
    public int     getCapCursorType() throws JposException;
    public boolean getCapCustomGlyph() throws JposException;
    public int     getCapReadBack() throws JposException;
    public int     getCapReverse() throws JposException;

    // Properties
    public int     getBlinkRate() throws JposException;
    public void    setBlinkRate(int blinkRate) throws JposException;
    public int     getCursorType() throws JposException;
    public void    setCursorType(int cursorType) throws JposException;
    public String  getCustomGlyphList() throws JposException;
    public int     getGlyphHeight() throws JposException;
    public int     getGlyphWidth() throws JposException;

    // Methods
    public void    defineGlyph(int glyphCode, byte[] glyph)
                       throws JposException;
    public void    readCharacterAtCursor(int[] aChar) throws JposException;
}