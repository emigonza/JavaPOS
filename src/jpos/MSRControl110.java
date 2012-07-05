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
// MSRControl110
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to MSR for release 1.10.
//
// Modification history
// ------------------------------------------------------------------
// 2006-Feb-08 JavaPOS Release 1.10                                BS
// 2006-Oct-23 JavaPOS 1.10.2 Update                               BS
//   Fixed type of writeTracks data parameter to be byte[][] as
//   UnifiedPOS has corrected the type from "string" to
//   "array of binary".
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface MSRControl110 extends MSRControl19
{
  // Capabilities
  public int     getCapWritableTracks()
                     throws JposException;

  // Properties
  public int     getEncodingMaxLength()
                     throws JposException;
  public int     getTracksToWrite()
                     throws JposException;
  public void    setTracksToWrite(int tracks)
                     throws JposException;

  // Methods
  public void    clearInputProperties()
                     throws JposException;
  public void    writeTracks(byte[][] data, int timeout)
                     throws JposException;
}