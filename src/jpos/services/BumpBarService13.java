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
// BumpBarService13
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Bump Bar for release 1.3.
//
// Modification history
// ------------------------------------------------------------------
// 98-04-20 JavaPOS Release 1.3                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface BumpBarService13 extends BaseService
{
    // Capabilities
    public int     getCapPowerReporting() throws JposException;
    public boolean getCapTone() throws JposException;

    // Properties
    public boolean getAsyncMode() throws JposException;
    public void    setAsyncMode(boolean asyncMode) throws JposException;
    public int     getAutoToneDuration() throws JposException;
    public void    setAutoToneDuration(int autoToneDuration) throws JposException;
    public int     getAutoToneFrequency() throws JposException;
    public void    setAutoToneFrequency(int autoToneFrequency) throws JposException;
    public int     getBumpBarDataCount() throws JposException;
    public int     getCurrentUnitID() throws JposException;
    public void    setCurrentUnitID(int currentUnitID) throws JposException;
    public int     getDataCount() throws JposException;
    public boolean getDataEventEnabled() throws JposException;
    public void    setDataEventEnabled(boolean dataEventEnabled) throws JposException;
    public String  getErrorString() throws JposException;
    public int     getErrorUnits() throws JposException;
    public String  getEventString() throws JposException;
    public int     getEventUnitID() throws JposException;
    public int     getEventUnits() throws JposException;
    public int     getKeys() throws JposException;
    public int     getOutputID() throws JposException;
    public int     getPowerNotify() throws JposException;
    public void    setPowerNotify(int powerNotify) throws JposException;
    public int     getPowerState() throws JposException;
    public int     getTimeout() throws JposException;
    public void    setTimeout(int timeout) throws JposException;
    public int     getUnitsOnline() throws JposException;

    // Methods
    public void    bumpBarSound(int units, int frequency, int duration,
                       int numberOfCycles, int interSoundWait)
                       throws JposException;
    public void    clearInput()  throws JposException;
    public void    clearOutput()  throws JposException;
    public void    setKeyTranslation(int units, int scanCode, int logicalKey)
                       throws JposException;
}