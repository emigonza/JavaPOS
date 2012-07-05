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
// BiometricsService110
//
//   Interface definining all new capabilities, properties and
//   methods that are specific to Biometrics for release 1.10.
//
// Modification history
// ------------------------------------------------------------------
// 2006-Feb-10 JavaPOS Release 1.10                                BS
//
/////////////////////////////////////////////////////////////////////

package jpos.services;

import jpos.*;
import jpos.loader.*;

public interface BiometricsService110
  extends BaseService, JposServiceInstance
{
  // Capabilities
  public boolean getCapCompareFirmwareVersion() throws JposException;
  public int     getCapPowerReporting() throws JposException;
  public boolean getCapPrematchData() throws JposException;
  public boolean getCapRawSensorData() throws JposException;
  public boolean getCapRealTimeData() throws JposException;
  public int     getCapSensorColor() throws JposException;
  public int     getCapSensorOrientation() throws JposException;
  public int     getCapSensorType() throws JposException;
  public boolean getCapStatisticsReporting() throws JposException;
  public boolean getCapTemplateAdaptation() throws JposException;
  public boolean getCapUpdateFirmware() throws JposException;
  public boolean getCapUpdateStatistics() throws JposException;

  // Properties
  public int     getAlgorithm() throws JposException;
  public void    setAlgorithm(int algorithm) throws JposException;
  public String  getAlgorithmList() throws JposException;
  public boolean getAutoDisable() throws JposException;
  public void    setAutoDisable(boolean autoDisable) throws JposException;
  public byte[]  getBIR() throws JposException;
  public int     getDataCount() throws JposException;
  public boolean getDataEventEnabled() throws JposException;
  public void    setDataEventEnabled(boolean dataEventEnabled)
                     throws JposException;
  public int     getPowerNotify() throws JposException;
  public void    setPowerNotify(int powerNotify) throws JposException;
  public int     getPowerState() throws JposException;
  public byte[]  getRawSensorData() throws JposException;
  public boolean getRealTimeDataEnabled() throws JposException;
  public void    setRealTimeDataEnabled(boolean enabled) throws JposException;
  public int     getSensorBPP() throws JposException;
  public int     getSensorColor() throws JposException;
  public void    setSensorColor(int color) throws JposException;
  public int     getSensorHeight() throws JposException;
  public int     getSensorOrientation() throws JposException;
  public void    setSensorOrientation(int orientation) throws JposException;
  public int     getSensorType() throws JposException;
  public void    setSensorType(int type) throws JposException;
  public int     getSensorWidth() throws JposException;

  // Methods
  public void    beginEnrollCapture(byte[] referenceBIR,
                                    byte[] payload)
                     throws JposException;
  public void    beginVerifyCapture()
                     throws JposException;
  public void    clearInput()  throws JposException;
  public void    clearInputProperties()
                     throws JposException;
  public void    compareFirmwareVersion(String firmwareFileName,
                                        int[] result)
                     throws JposException;
  public void    endCapture()
                     throws JposException;
  public void    identify(int maxFARRequested,
                          int maxFRRRequested,
                          boolean FARPrecedence,
                          byte[][] referenceBIRPopulation,
                          int[][] candidateRanking,
                          int timeout)
                     throws JposException;
  public void    identifyMatch(int maxFARRequested,
                               int maxFRRRequested,
                               boolean FARPrecedence,
                               byte[] sampleBIR,
                               byte[][] referenceBIRPopulation,
                               int[][] candidateRanking)
                     throws JposException;
  public void    processPrematchData(byte[] capturedBIR,
                                     byte[] prematchDataBIR,
                                     byte[][] processedBIR)
                     throws JposException;
  public void    resetStatistics(String statisticsBuffer)
                     throws JposException;
  public void    retrieveStatistics(String[] statisticsBuffer)
                     throws JposException;
  public void    updateFirmware(String firmwareFileName)
                     throws JposException;
  public void    updateStatistics(String statisticsBuffer)
                     throws JposException;
  public void    verify(int maxFARRequested,
                        int maxFRRRequested,
                        boolean FARPrecedence,
                        byte[] referenceBIR,
                        byte[][] adaptedBIR,
                        boolean[] result,
                        int[] FARAchieved,
                        int[] FRRAchieved,
                        byte[][] payload,
                        int timeout)
                     throws JposException;
  public void    verifyMatch(int maxFARRequested,
                             int maxFRRRequested,
                             boolean FARPrecedence,
                             byte[] sampleBIR,
                             byte[] referenceBIR,
                             byte[][] adaptedBIR,
                             boolean[] result,
                             int[] FARAchieved,
                             int[] FRRAchieved,
                             byte[][] payload)
                     throws JposException;
}