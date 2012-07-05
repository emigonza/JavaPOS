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
// BaseControl
//
//   Interface definining all capabilities, properties and methods
//   that are common to all JavaPOS device controls.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface BaseControl
{
    // Properties
    public String  getCheckHealthText() throws JposException;
    public boolean getClaimed() throws JposException;
    public String  getDeviceControlDescription();
    public int     getDeviceControlVersion();
    public boolean getDeviceEnabled() throws JposException;
    public void    setDeviceEnabled(boolean deviceEnabled)
                       throws JposException;
    public String  getDeviceServiceDescription() throws JposException;
    public int     getDeviceServiceVersion() throws JposException;
    public boolean getFreezeEvents() throws JposException;
    public void    setFreezeEvents(boolean freezeEvents) throws JposException;
    public String  getPhysicalDeviceDescription() throws JposException;
    public String  getPhysicalDeviceName() throws JposException;
    public int     getState();

    // Methods
    public void    claim(int timeout) throws JposException;
    public void    close() throws JposException;
    public void    checkHealth(int level) throws JposException;
    public void    directIO(int command, int[] data, Object object)
                       throws JposException;
    public void    open(String logicalDeviceName) throws JposException;
    public void    release() throws JposException;
}