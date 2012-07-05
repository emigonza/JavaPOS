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
// POSKeyboardService12
//
//   Interface definining all capabilities, properties and methods
//   that are specific to POS Keyboard for release 1.2.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface POSKeyboardService12 extends BaseService
{
    // Capabilities
    public boolean getCapKeyUp() throws JposException;

    // Properties
    public boolean getAutoDisable() throws JposException;
    public void    setAutoDisable(boolean autoDisable) throws JposException;
    public int     getDataCount() throws JposException;
    public boolean getDataEventEnabled() throws JposException;
    public void    setDataEventEnabled(boolean dataEventEnabled)
                       throws JposException;
    public int     getEventTypes() throws JposException;
    public void    setEventTypes(int eventTypes) throws JposException;
    public int     getPOSKeyData() throws JposException;
    public int     getPOSKeyEventType() throws JposException;

    // Methods
    public void    clearInput() throws JposException;
}