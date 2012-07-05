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
// RFIDScannerConst
//
//   RFIDScanner constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   New device category.
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface RFIDScannerConst
{
  /////////////////////////////////////////////////////////////////////
  // "CapWriteTag" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int RFID_CWT_NONE                        = 0;
  public static final int RFID_CWT_ID                          = 1;
  public static final int RFID_CWT_USERDATA                    = 2;
  public static final int RFID_CWT_ALL                         = 3;


  /////////////////////////////////////////////////////////////////////
  // "CapMultipleProtocols", "CurrentTagProtocol", and
  // "ProtocolMask" Property Constants
  /////////////////////////////////////////////////////////////////////

  public static final int RFID_PR_EPC0                         = 0x00000001;
  public static final int RFID_PR_0PLUS                        = 0x00000002;
  public static final int RFID_PR_EPC1                         = 0x00000004;
  public static final int RFID_PR_EPC1G2                       = 0x00000008;
  public static final int RFID_PR_EPC2                         = 0x00000010;
  public static final int RFID_PR_ISO14443A                    = 0x00001000;
  public static final int RFID_PR_ISO14443B                    = 0x00002000;
  public static final int RFID_PR_ISO15693                     = 0x00003000;
  public static final int RFID_PR_ISO180006B                   = 0x00004000;
  public static final int RFID_PR_OTHER                        = 0x01000000;
  public static final int RFID_PR_ALL                          = 0x40000000; // (ProtocolMask only)


  /////////////////////////////////////////////////////////////////////
  // "readTags" and "startReadTags" Methods: "Cmd" Parameter Constants
  /////////////////////////////////////////////////////////////////////

  public static final int RFID_RT_ID                           = 0x10;
  public static final int RFID_RT_FULLUSERDATA                 = 0x01;
  public static final int RFID_RT_PARTIALUSERDATA              = 0x02;
  public static final int RFID_RT_ID_FULLUSERDATA              = 0x11;
  public static final int RFID_RT_ID_PARTIALUSERDATA           = 0x12;
}
