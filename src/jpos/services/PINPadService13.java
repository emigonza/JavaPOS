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
// PINPadService13
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to PIN Pad for release 1.3.
//
// Modification history
// ------------------------------------------------------------------
// 98-04-20 JavaPOS Release 1.3                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface PINPadService13 extends BaseService
{
    // Capabilities
    public int     getCapDisplay() throws JposException;
    public int     getCapLanguage() throws JposException;
    public boolean getCapKeyboard() throws JposException;
    public boolean getCapMACCalculation() throws JposException;
    public int     getCapPowerReporting() throws JposException;
    public boolean getCapTone() throws JposException;

    // Properties
    public String  getAccountNumber() throws JposException;
    public void    setAccountNumber(String accountNumber) throws JposException;
    public String  getAdditionalSecurityInformation() throws JposException;
    public long    getAmount() throws JposException;
    public void    setAmount(long amount) throws JposException;
    public String  getAvailableLanguagesList() throws JposException;
    public String  getAvailablePromptsList() throws JposException;
    public int     getDataCount() throws JposException;
    public boolean getDataEventEnabled() throws JposException;
    public void    setDataEventEnabled(boolean dataEventEnabled)
                       throws JposException;
    public String  getEncryptedPIN() throws JposException;
    public int     getMaximumPINLength() throws JposException;
    public void    setMaximumPINLength(int maximumPINLength) throws JposException;
    public String  getMerchantID() throws JposException;
    public void    setMerchantID(String merchantID) throws JposException;
    public int     getMinimumPINLength() throws JposException;
    public void    setMinimumPINLength(int minimumPINLength) throws JposException;
    public boolean getPINEntryEnabled() throws JposException;
    public int     getPowerNotify() throws JposException;
    public void    setPowerNotify(int powerNotify) throws JposException;
    public int     getPowerState() throws JposException;
    public int     getPrompt() throws JposException;
    public void    setPrompt(int propmpt) throws JposException;
    public String  getPromptLanguage() throws JposException;
    public void    setPromptLanguage(String promptLanguage) throws JposException;
    public String  getTerminalID() throws JposException;
    public void    setTerminalID(String terminalID) throws JposException;
    public byte[]  getTrack1Data() throws JposException;
    public void    setTrack1Data(byte[] track1Data) throws JposException;
    public byte[]  getTrack2Data() throws JposException;
    public void    setTrack2Data(byte[] track2Data) throws JposException;
    public byte[]  getTrack3Data() throws JposException;
    public void    setTrack3Data(byte[] track3Data) throws JposException;
    public int     getTransactionType() throws JposException;
    public void    setTransactionType(int transactionType) throws JposException;

    // Methods
    public void    beginEFTTransaction(String PINPadSystem, int transactionHost)
                       throws JposException;
    public void    clearInput() throws JposException;
    public void    computeMAC(String inMsg, String[] outMsg)
                       throws JposException;
    public void    enablePINEntry() throws JposException;
    public void    endEFTTransaction(int completionCode) throws JposException;
    public void    updateKey(int keyNum, String key) throws JposException;
    public void    verifyMAC(String message) throws JposException;
}