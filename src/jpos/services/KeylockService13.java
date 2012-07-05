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
// KeylockService13
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Keylock for release 1.3.
//
// Modification history
// ------------------------------------------------------------------
// 98-04-20 JavaPOS Release 1.3                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface KeylockService13 extends KeylockService12
{
    // Capabilities
    public int     getCapPowerReporting() throws JposException;

    // Properties
    public int     getPowerNotify() throws JposException;
    public void    setPowerNotify(int powerNotify) throws JposException;
    public int     getPowerState() throws JposException;
}