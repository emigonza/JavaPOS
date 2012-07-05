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
// SmartCardRWConst
//
//   Smart Card constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 03-Jun-2003 JavaPOS Release 1.8                                BS
/////////////////////////////////////////////////////////////////////

package jpos;

public interface SmartCardRWConst
{
  //###################################################################
  //#### Smart Card Constants
  //###################################################################

  /////////////////////////////////////////////////////////////////////
  // "CapInterfaceMode", "InterfaceMode" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int SC_CMODE_TRANS = 1;  // Simple Transaction Command and Data Mode.
  public static final int SC_CMODE_BLOCK = 2;  // Block Data Mode.
  public static final int SC_CMODE_APDU  = 4;  // Same as Block Data Mode except APDU Standard Commands are used.
  public static final int SC_CMODE_XML   = 8;  // XML Block Data Mode.


  /////////////////////////////////////////////////////////////////////
  // "CapIsoEmvMode" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int SC_CMODE_ISO = 1;  // APDU messaging format conforms to the ISO standard.
  public static final int SC_CMODE_EMV = 2;  // APDU messaging format conforms to the EMV standard.


  /////////////////////////////////////////////////////////////////////
  // "CapTransmissionProtocol" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int SC_CTRANS_PROTOCOL_T0 = 1;  // Asynchronous, Half Duplex, Character, Transmission Protocol Mode.
  public static final int SC_CTRANS_PROTOCOL_T1 = 2;  // Asynchronous, Half Duplex, Block Transmission Protocol Mode.


  /////////////////////////////////////////////////////////////////////
  // "InterfaceMode" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int SC_MODE_TRANS = 1;  // Simple Transaction Command and Data Mode.
  public static final int SC_MODE_BLOCK = 2;  // Block Data Mode.
  public static final int SC_MODE_APDU  = 4;  // Same as Block Data Mode except APDU Standard Defines the Commands and data.
  public static final int SC_MODE_XML   = 8;  // XML Block Data Mode.


  /////////////////////////////////////////////////////////////////////
  // "IsoEmvMode" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int SC_MODE_ISO = 1;  // APDU messaging format currently in use conforms to the ISO standard.
  public static final int SC_MODE_EMV = 2;  // APDU messaging format currently in use conforms to the EMV standard.


  /////////////////////////////////////////////////////////////////////
  // "TransmissionProtocol" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int SC_TRANS_PROTOCOL_T0 = 1;  // Asynchronous, Half Duplex, Character, Transmission Protocol Mode.
  public static final int SC_TRANS_PROTOCOL_T1 = 2;  // Asynchronous, Half Duplex, Block Transmission Protocol Mode.


  /////////////////////////////////////////////////////////////////////
  // "readData" Method, "action" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int SC_READ_DATA             = 11;
  public static final int SC_READ_PROGRAM          = 12;
  public static final int SC_EXECUTE_AND_READ_DATA = 13;
  public static final int SC_XML_READ_BLOCK_DATA   = 14;


  /////////////////////////////////////////////////////////////////////
  // "writeData" Method, "action" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int SC_STORE_DATA     = 21;
  public static final int SC_STORE_PROGRAM  = 22;
  public static final int SC_EXECUTE_DATA   = 23;
  public static final int SC_XML_BLOCK_DATA = 24;
  public static final int SC_SECURITY_FUSE  = 25;
  public static final int SC_RESET          = 26;


  /////////////////////////////////////////////////////////////////////
  // "StatusUpdateEvent" "Status" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int SC_SUE_NO_CARD      = 1;  // No card detected in the SCR/W Device.
  public static final int SC_SUE_CARD_PRESENT = 2;  // There is a card in the device.


  /////////////////////////////////////////////////////////////////////
  // "ErrorEvent" "ErrorCodeExtended" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int JPOS_ESC_READ    = 201;  // There was a read error.
  public static final int JPOS_ESC_WRITE   = 202;  // There was a write error.
  public static final int JPOS_ESC_TORN    = 203;  // The smart card was prematurely removed from the SCR/W unexpectedly. Note: CapCardErrorDetection capability must be true before this can be set.
  public static final int JPOS_ESC_NO_CARD = 204;  // There is no card detected in the SCR/W but a card was expected.
}