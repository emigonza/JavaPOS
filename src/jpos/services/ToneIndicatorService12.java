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
// ToneIndicatorService12
//
//   Interface definining all capabilities, properties and methods
//   that are specific to Tone Indicator for release 1.2.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface ToneIndicatorService12 extends BaseService
{
    // Capabilities
    public boolean getCapPitch() throws JposException;
    public boolean getCapVolume() throws JposException;

    // Properties
    public boolean getAsyncMode() throws JposException;
    public void    setAsyncMode(boolean asyncMode) throws JposException;
    public int     getInterToneWait() throws JposException;
    public void    setInterToneWait(int interToneWait) throws JposException;
    public int     getOutputID() throws JposException;
    public int     getTone1Duration() throws JposException;
    public void    setTone1Duration(int tone1Duration) throws JposException;
    public int     getTone1Pitch() throws JposException;
    public void    setTone1Pitch(int tone1Pitch) throws JposException;
    public int     getTone1Volume() throws JposException;
    public void    setTone1Volume(int tone1Volume) throws JposException;
    public int     getTone2Duration() throws JposException;
    public void    setTone2Duration(int tone2Duration) throws JposException;
    public int     getTone2Pitch() throws JposException;
    public void    setTone2Pitch(int tone2Pitch) throws JposException;
    public int     getTone2Volume() throws JposException;
    public void    setTone2Volume(int tone2Volume) throws JposException;

    // Methods
    public void    clearOutput() throws JposException;
    public void    sound(int numberOfCycles, int interSoundWait)
                       throws JposException;
    public void    soundImmediate() throws JposException;
}