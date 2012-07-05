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
// LineDisplayService17
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Line Display for release 1.7.
//
// Modification history
// ------------------------------------------------------------------
// 01-Jul-2002 JavaPOS Release 1.7                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface LineDisplayService17
  extends LineDisplayService16
{
  // Capabilities
  public boolean getCapBitmap() throws JposException;
  public boolean getCapScreenMode() throws JposException;
  public boolean getCapMapCharacterSet() throws JposException;

  // Properties
  public boolean getMapCharacterSet() throws JposException;
  public void    setMapCharacterSet(boolean mapCharacterSet)
                   throws JposException;
  public int     getMaximumX() throws JposException;
  public int     getMaximumY() throws JposException;
  public int     getScreenMode() throws JposException;
  public void    setScreenMode(int screenMode) throws JposException;
  public String  getScreenModeList() throws JposException;

  // Methods
  public void    displayBitmap(String fileName, int width, int alignmentX,
                               int alignmentY) throws JposException;
  public void    setBitmap(int bitmapNumber, String fileName, int width,
                           int alignmentX, int alignmentY) throws JposException;
}