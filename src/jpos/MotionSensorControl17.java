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
// MotionSensorControl17
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Motion Sensor for release 1.7.
//
// Modification history
// ------------------------------------------------------------------
// 01-Jul-2002 JavaPOS Release 1.7                                 BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface MotionSensorControl17 extends BaseControl
{
  // Capabilities
  public int     getCapPowerReporting() throws JposException;

  // Properties
  public boolean getMotion() throws JposException;
  public int     getPowerNotify() throws JposException;
  public void    setPowerNotify(int powerNotify) throws JposException;
  public int     getPowerState() throws JposException;
  public int     getTimeout() throws JposException;
  public void    setTimeout(int timeout) throws JposException;

  // Methods
  public void    waitForMotion(int timeout) throws JposException;

  // Event listener methods
  public void    addDirectIOListener(DirectIOListener l);
  public void    removeDirectIOListener(DirectIOListener l);
  public void    addStatusUpdateListener(StatusUpdateListener l);
  public void    removeStatusUpdateListener(StatusUpdateListener l);
}