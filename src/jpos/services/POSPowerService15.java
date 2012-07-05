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
// POSPowerService15
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to POSPower for release 1.5.
//
// Modification history
// ------------------------------------------------------------------
// 2000-Apr-17 JavaPOS Release 1.5                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;
import jpos.loader.*;

public interface POSPowerService15
  extends BaseService, JposServiceInstance
{
    // Capabilities
    public boolean getCapFanAlarm() throws JposException;
    public boolean getCapHeatAlarm() throws JposException;
    public int     getCapPowerReporting() throws JposException;
    public boolean getCapQuickCharge() throws JposException;
    public boolean getCapShutdownPOS() throws JposException;
    public int     getCapUPSChargeState() throws JposException;

    // Properties
    public int     getEnforcedShutdownDelayTime() throws JposException;
    public void    setEnforcedShutdownDelayTime(int delay)
                       throws JposException;
    public int     getPowerFailDelayTime() throws JposException;
    public int     getPowerNotify() throws JposException;
    public void    setPowerNotify(int powerNotify) throws JposException;
    public int     getPowerState() throws JposException;
    public boolean getQuickChargeMode() throws JposException;
    public int     getQuickChargeTime() throws JposException;
    public int     getUPSChargeState() throws JposException;

    // Methods
    public void    shutdownPOS() throws JposException;
}