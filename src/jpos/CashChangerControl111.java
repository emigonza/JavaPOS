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
// CashChangerControl111
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Cash Changer for release 1.11.
//
// Modification history
// ------------------------------------------------------------------
// 2007-Jan-04 JavaPOS Release 1.11                                BS
// 2008-Jul-23 Corrected spelling mistake of setCurrentService     BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface CashChangerControl111 extends CashChangerControl110
{
  // Capabilities
  public boolean getCapJamSensor() throws JposException;
  public boolean getCapRealTimeData() throws JposException;

  // Properties
  public int     getCurrentService() throws JposException;
  public void    setCurrentService(int currentService) throws JposException;
  public boolean getRealTimeDataEnabled() throws JposException;
  public void    setRealTimeDataEnabled(boolean bEnabled) throws JposException;
  public int     getServiceCount() throws JposException;
  public int     getServiceIndex() throws JposException;

  // Methods
  public void    adjustCashCounts(String cashCounts)
                     throws JposException;
}