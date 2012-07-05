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
// ScaleControl12
//
//   Interface definining all capabilities, properties and methods
//   that are specific to Scale for release 1.2.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface ScaleControl12 extends BaseControl
{
    // Capabilities
    public boolean getCapDisplay() throws JposException;

    // Properties
    public int     getMaximumWeight() throws JposException;
    public int     getWeightUnit() throws JposException;

    // Methods
    public void    readWeight(int[] weightData, int timeout)
                       throws JposException;

    // Event listener methods
    public void    addDirectIOListener(DirectIOListener l);
    public void    removeDirectIOListener(DirectIOListener l);
}