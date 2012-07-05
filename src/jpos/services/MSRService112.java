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
// MSRService112
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to MSR for release 1.12.
//
// Modification history
// ------------------------------------------------------------------
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;

public interface MSRService112 extends MSRService111
{
  // Capabilities
  public String  getCapCardAuthentication() throws JposException;
  public int     getCapDataEncryption() throws JposException;
  public int     getCapDeviceAuthentication() throws JposException;
  public boolean getCapTrackDataMasking() throws JposException;

  // Properties
  public byte[]  getAdditionalSecurityInformation() throws JposException;
  public byte[]  getCardAuthenticationData() throws JposException;
  public int     getCardAuthenticationDataLength() throws JposException;
  public String  getCardPropertyList() throws JposException;
  public String  getCardType() throws JposException;
  public String  getCardTypeList() throws JposException;
  public int     getDataEncryptionAlgorithm() throws JposException;
  public void    setDataEncryptionAlgorithm(int encryptAlgorithm) throws JposException;
  public boolean getDeviceAuthenticated() throws JposException;
  public int     getDeviceAuthenticationProtocol() throws JposException;
  public byte[]  getTrack1EncryptedData() throws JposException;
  public int     getTrack1EncryptedDataLength() throws JposException;
  public byte[]  getTrack2EncryptedData() throws JposException;
  public int     getTrack2EncryptedDataLength() throws JposException;
  public byte[]  getTrack3EncryptedData() throws JposException;
  public int     getTrack3EncryptedDataLength() throws JposException;
  public byte[]  getTrack4EncryptedData() throws JposException;
  public int     getTrack4EncryptedDataLength() throws JposException;
  public String  getWriteCardType() throws JposException;
  public void    setWriteCardType(String cardType) throws JposException;

  // Methods
  public void    authenticateDevice(byte[] response)
                     throws JposException;
  public void    deauthenticateDevice(byte[] response)
                     throws JposException;
  public void    retrieveCardProperty(String name,
                                      String[] value)
                     throws JposException;
  public void    retrieveDeviceAuthenticationData(byte[] challenge)
                     throws JposException;
  public void    updateKey(String key,
                           String keyName)
                     throws JposException;
}