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
// SmartCardRWControl110
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Smart Card for release 1.10.
//
// Modification history
// ------------------------------------------------------------------
// 2006-Feb-10 JavaPOS Release 1.10                                BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface SmartCardRWControl110 extends SmartCardRWControl19
{
  // Methods
  public void    clearInputProperties()
                     throws JposException;
}