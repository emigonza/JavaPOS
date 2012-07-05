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
// BeltService112
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Belt for release 1.12.
//
// Modification history
// ------------------------------------------------------------------
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;
import jpos.loader.*;

public interface BeltService112
  extends BaseService, JposServiceInstance
{
  // Capabilities
  public boolean getCapAutoStopBackward() throws JposException;
  public boolean getCapAutoStopBackwardItemCount() throws JposException;
  public boolean getCapAutoStopForward() throws JposException;
  public boolean getCapAutoStopForwardItemCount() throws JposException;
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public boolean getCapLightBarrierBackward() throws JposException;
  public boolean getCapLightBarrierForward() throws JposException;
  public boolean getCapMoveBackward() throws JposException;
  public int     getCapPowerReporting() throws JposException;
  public boolean getCapRealTimeData() throws JposException;
  public boolean getCapSecurityFlapBackward() throws JposException;
  public boolean getCapSecurityFlapForward() throws JposException;
  public boolean getCapSpeedStepsBackward() throws JposException;
  public boolean getCapSpeedStepsForward() throws JposException;
  public boolean getCapStatisticsReporting() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;
  public boolean getCapUpdateStatistics() throws JposException;

  // Properties
  public boolean getAutoStopBackward() throws JposException;
  public void    setAutoStopBackward(boolean autoStop) throws JposException;
  public int     getAutoStopBackwardDelayTime() throws JposException;
  public void    setAutoStopBackwardDelayTime(int delayTime) throws JposException;
  public int     getAutoStopBackwardItemCount() throws JposException;
  public boolean getAutoStopForward() throws JposException;
  public void    setAutoStopForward(boolean autoStop) throws JposException;
  public int     getAutoStopForwardDelayTime() throws JposException;
  public void    setAutoStopForwardDelayTime(int delayTime) throws JposException;
  public int     getAutoStopForwardItemCount() throws JposException;
  public boolean getLightBarrierBackwardInterrupted() throws JposException;
  public boolean getLightBarrierForwardInterrupted() throws JposException;
  public int     getMotionStatus() throws JposException;
  public int     getPowerNotify() throws JposException;
  public void    setPowerNotify(int powerNotify) throws JposException;
  public int     getPowerState() throws JposException;
  public boolean getSecurityFlapBackwardOpened() throws JposException;
  public boolean getSecurityFlapForwardOpened() throws JposException;

  // Methods
  public void    adjustItemCount(int direction,
                                 int count)
                     throws JposException;
  public void    compareFirmwareVersion(String firmwareFileName,
                                        int[] result)
                     throws JposException;
  public void    moveBackward(int speed)
                     throws JposException;
  public void    moveForward(int speed)
                     throws JposException;
  public void    resetBelt()
                     throws JposException;
  public void    resetItemCount(int direction)
                     throws JposException;
  public void    resetStatistics(String statisticsBuffer)
                     throws JposException;
  public void    retrieveStatistics(String[] statisticsBuffer)
                     throws JposException;
  public void    stopBelt()
                     throws JposException;
  public void    updateFirmware(String firmwareFileName)
                     throws JposException;
  public void    updateStatistics(String statisticsBuffer)
                     throws JposException;
}
