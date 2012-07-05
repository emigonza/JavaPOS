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
// CoinDispenserService12
//
//   Interface definining all capabilities, properties and methods
//   that are specific to Coin Dispenser for release 1.2.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface CoinDispenserService12 extends BaseService
{
    // Capabilities
    public boolean getCapEmptySensor() throws JposException;
    public boolean getCapJamSensor() throws JposException;
    public boolean getCapNearEmptySensor() throws JposException;

    // Properties
    public int     getDispenserStatus() throws JposException;

    // Methods
    public void    dispenseChange(int amount) throws JposException;
}