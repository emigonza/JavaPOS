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
// MSRService12
//
//   Interface definining all capabilities, properties and methods
//   that are specific to MSR for release 1.2.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface MSRService12 extends BaseService
{
    // Capabilities
    public boolean getCapISO() throws JposException;
    public boolean getCapJISOne() throws JposException;
    public boolean getCapJISTwo() throws JposException;

    // Properties
    public String  getAccountNumber() throws JposException;
    public boolean getAutoDisable() throws JposException;
    public void    setAutoDisable(boolean autoDisable) throws JposException;
    public int     getDataCount() throws JposException;
    public boolean getDataEventEnabled() throws JposException;
    public void    setDataEventEnabled(boolean dataEventEnabled)
                       throws JposException;
    public boolean getDecodeData() throws JposException;
    public void    setDecodeData(boolean decodeData) throws JposException;
    public int     getErrorReportingType() throws JposException;
    public void    setErrorReportingType(int errorReportingType)
                       throws JposException;
    public String  getExpirationDate() throws JposException;
    public String  getFirstName() throws JposException;
    public String  getMiddleInitial() throws JposException;
    public boolean getParseDecodeData() throws JposException;
    public void    setParseDecodeData(boolean parseDecodeData)
                       throws JposException;
    public String  getServiceCode() throws JposException;
    public String  getSuffix() throws JposException;
    public String  getSurname() throws JposException;
    public String  getTitle() throws JposException;
    public byte[]  getTrack1Data() throws JposException;
    public byte[]  getTrack1DiscretionaryData() throws JposException;
    public byte[]  getTrack2Data() throws JposException;
    public byte[]  getTrack2DiscretionaryData() throws JposException;
    public byte[]  getTrack3Data() throws JposException;
    public int     getTracksToRead() throws JposException;
    public void    setTracksToRead(int tracksToRead) throws JposException;

    // Methods
    public void    clearInput() throws JposException;
}