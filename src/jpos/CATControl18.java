///////////////////////////////////////////////////////////////////////////////
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
// CATControl18
//
//   Interface definining all capabilities, properties and methods that are
//   specific to the Credit Authorization Terminal for release 1.8.
//
// Modification history
// ---------------------------------------------------------------------------
// 03-Jun-2003 JavaPOS Release 1.8                                          BS
//
//////////////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface CATControl18 extends CATControl17
{
	// Capabilities
	public boolean getCapStatisticsReporting() throws JposException;
	public boolean getCapUpdateStatistics() throws JposException;

	// Methods
	public void    resetStatistics(String statisticsBuffer)
										 throws JposException;
	public void    retrieveStatistics(String[] statisticsBuffer)
										 throws JposException;
	public void    updateStatistics(String statisticsBuffer)
										 throws JposException;
}