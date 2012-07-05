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
// EventCallbacks
//
//   Interface definining callback methods in a JavaPOS device
//   control that are callable by a JavaPOS device service.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;
import jpos.events.*;

public interface EventCallbacks
{
    public void fireDataEvent(DataEvent e);
    public void fireDirectIOEvent(DirectIOEvent e);
    public void fireErrorEvent(ErrorEvent e);
    public void fireOutputCompleteEvent(OutputCompleteEvent e);
    public void fireStatusUpdateEvent(StatusUpdateEvent e);

    public BaseControl getEventSource();
}