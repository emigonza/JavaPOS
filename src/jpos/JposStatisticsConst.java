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
// JposStatisticsConst
//
//   Statistic name constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 2004-Jul-14 JavaPOS Release 1.8.1                               BS
//   New file to define constants for Device Statistic names.
// 2007-Jan-04 JavaPOS Release 1.11                                BS
//   Added constants for new device classes.
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   Added constants for statistics new to Release 1.12.
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface JposStatisticsConst
{
  public static final String JPOS_STAT_HoursPoweredCount = "HoursPoweredCount";
  public static final String JPOS_STAT_CommunicationErrorCount = "CommunicationErrorCount";
  public static final String JPOS_STAT_SuccessfulMatchCount = "SuccessfulMatchCount";
  public static final String JPOS_STAT_UnsuccessfulMatchCount = "UnsuccessfulMatchCount";
  public static final String JPOS_STAT_AverageFAR = "AverageFAR";
  public static final String JPOS_STAT_AverageFRR = "AverageFRR";
  public static final String JPOS_STAT_BumpCount = "BumpCount";
  public static final String JPOS_STAT_DrawerGoodOpenCount = "DrawerGoodOpenCount";
  public static final String JPOS_STAT_DrawerFailedOpenCount = "DrawerFailedOpenCount";
  public static final String JPOS_STAT_ChecksScannedCount = "ChecksScannedCount";
  public static final String JPOS_STAT_WriteCount = "WriteCount";
  public static final String JPOS_STAT_FailedWriteCount = "FailedWriteCount";
  public static final String JPOS_STAT_EraseCount = "EraseCount";
  public static final String JPOS_STAT_MediumRemovedCount = "MediumRemovedCount";
  public static final String JPOS_STAT_MediumSize = "MediumSize";
  public static final String JPOS_STAT_MediumFreeSpace = "MediumFreeSpace";
  public static final String JPOS_STAT_BarcodePrintedCount = "BarcodePrintedCount";
  public static final String JPOS_STAT_FormInsertionCount = "FormInsertionCount";
  public static final String JPOS_STAT_HomeErrorCount = "HomeErrorCount";
  public static final String JPOS_STAT_JournalCharacterPrintedCount = "JournalCharacterPrintedCount";
  public static final String JPOS_STAT_JournalLinePrintedCount = "JournalLinePrintedCount";
  public static final String JPOS_STAT_MaximumTempReachedCount = "MaximumTempReachedCount";
  public static final String JPOS_STAT_NVRAMWriteCount = "NVRAMWriteCount";
  public static final String JPOS_STAT_PaperCutCount = "PaperCutCount";
  public static final String JPOS_STAT_FailedPaperCutCount = "FailedPaperCutCount";
  public static final String JPOS_STAT_PrinterFaultCount = "PrinterFaultCount";
  public static final String JPOS_STAT_PrintSideChangeCount = "PrintSideChangeCount";
  public static final String JPOS_STAT_FailedPrintSideChangeCount = "FailedPrintSideChangeCount";
  public static final String JPOS_STAT_ReceiptCharacterPrintedCount = "ReceiptCharacterPrintedCount";
  public static final String JPOS_STAT_ReceiptCoverOpenCount = "ReceiptCoverOpenCount";
  public static final String JPOS_STAT_ReceiptLineFeedCount = "ReceiptLineFeedCount";
  public static final String JPOS_STAT_ReceiptLinePrintedCount = "ReceiptLinePrintedCount";
  public static final String JPOS_STAT_SlipCharacterPrintedCount = "SlipCharacterPrintedCount";
  public static final String JPOS_STAT_SlipCoverOpenCount = "SlipCoverOpenCount";
  public static final String JPOS_STAT_SlipLineFeedCount = "SlipLineFeedCount";
  public static final String JPOS_STAT_SlipLinePrintedCount = "SlipLinePrintedCount";
  public static final String JPOS_STAT_StampFiredCount = "StampFiredCount";
  public static final String JPOS_STAT_GoodReadCount = "GoodReadCount";
  public static final String JPOS_STAT_NoReadCount = "NoReadCount";
  public static final String JPOS_STAT_SessionCount = "SessionCount";
  public static final String JPOS_STAT_LockPositionChangeCount = "LockPositionChangeCount";
  public static final String JPOS_STAT_OnlineTransitionCount = "OnlineTransitionCount";
  public static final String JPOS_STAT_FailedDataParseCount = "FailedDataParseCount";
  public static final String JPOS_STAT_UnreadableCardCount = "UnreadableCardCount";
  public static final String JPOS_STAT_GoodWriteCount = "GoodWriteCount";
  public static final String JPOS_STAT_MissingStartSentinelTrack1Count = "MissingStartSentinelTrack1Count";
  public static final String JPOS_STAT_ParityLRCErrorTrack1Count = "ParityLRCErrorTrack1Count";
  public static final String JPOS_STAT_MissingStartSentinelTrack2Count = "MissingStartSentinelTrack2Count";
  public static final String JPOS_STAT_ParityLRCErrorTrack2Count = "ParityLRCErrorTrack2Count";
  public static final String JPOS_STAT_MissingStartSentinelTrack3Count = "MissingStartSentinelTrack3Count";
  public static final String JPOS_STAT_ParityLRCErrorTrack3Count = "ParityLRCErrorTrack3Count";
  public static final String JPOS_STAT_MissingStartSentinelTrack4Count = "MissingStartSentinelTrack4Count";
  public static final String JPOS_STAT_ParityLRCErrorTrack4Count = "ParityLRCErrorTrack4Count";
  public static final String JPOS_STAT_GoodCardAuthenticationDataCount = "GoodCardAuthenticationDataCount";
  public static final String JPOS_STAT_FailedCardAuthenticationDataCount = "FailedCardAuthenticationDataCount";
  public static final String JPOS_STAT_ChallengeRequestCount = "ChallengeRequestCount";
  public static final String JPOS_STAT_GoodDeviceAuthenticationCount = "GoodDeviceAuthenticationCount";
  public static final String JPOS_STAT_FailedDeviceAuthenticationCount = "FailedDeviceAuthenticationCount";
  public static final String JPOS_STAT_FailedReadCount = "FailedReadCount";
  public static final String JPOS_STAT_MotionEventCount = "MotionEventCount";
  public static final String JPOS_STAT_ValidPINEntryCount = "ValidPINEntryCount";
  public static final String JPOS_STAT_InvalidPINEntryCount = "InvalidPINEntryCount";
  public static final String JPOS_STAT_KeyPressedCount = "KeyPressedCount";
  public static final String JPOS_STAT_TagReadCount = "TagReadCount";
  public static final String JPOS_STAT_GoodTagWriteCount = "GoodTagWriteCount";
  public static final String JPOS_STAT_FailedTagWriteCount = "FailedTagWriteCount";
  public static final String JPOS_STAT_GoodTagLockCount = "GoodTagLockCount";
  public static final String JPOS_STAT_FailedTagLockCount = "FailedTagLockCount";
  public static final String JPOS_STAT_GoodTagDisableCount = "GoodTagDisableCount";
  public static final String JPOS_STAT_FailedTagDisableCount = "FailedTagDisableCount";
  public static final String JPOS_STAT_GoodWeightReadCount = "GoodWeightReadCount";
  public static final String JPOS_STAT_GoodScanCount = "GoodScanCount";
  public static final String JPOS_STAT_GoodSignatureReadCount = "GoodSignatureReadCount";
  public static final String JPOS_STAT_FailedSignatureReadCount = "FailedSignatureReadCount";
  public static final String JPOS_STAT_ToneSoundedCount = "ToneSoundedCount";
}

