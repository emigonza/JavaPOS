//------------------------------------------------------------------------------
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
// ToneIndicator.java - A JavaPOS 1.13.0 device control
//
//------------------------------------------------------------------------------

package jpos;

import jpos.events.*;
import jpos.services.*;
import java.util.Vector;
import jpos.loader.*;

public class ToneIndicator
  extends BaseJposControl
  implements ToneIndicatorControl113, JposConst
{
  //--------------------------------------------------------------------------
  // Variables
  //--------------------------------------------------------------------------

  protected ToneIndicatorService12 service12;
  protected ToneIndicatorService13 service13;
  protected ToneIndicatorService14 service14;
  protected ToneIndicatorService15 service15;
  protected ToneIndicatorService16 service16;
  protected ToneIndicatorService17 service17;
  protected ToneIndicatorService18 service18;
  protected ToneIndicatorService19 service19;
  protected ToneIndicatorService110 service110;
  protected ToneIndicatorService111 service111;
  protected ToneIndicatorService112 service112;
  protected ToneIndicatorService113 service113;
  protected Vector directIOListeners;
  protected Vector errorListeners;
  protected Vector outputCompleteListeners;
  protected Vector statusUpdateListeners;


  //--------------------------------------------------------------------------
  // Constructor
  //--------------------------------------------------------------------------

  public ToneIndicator()
  {
    // Initialize base class instance data
    deviceControlDescription = "JavaPOS ToneIndicator Device Control";
    deviceControlVersion = deviceVersion113;

    // Initialize instance data. Initializations are commented out for
    // efficiency if the Java default is correct.
    //service12 = null;
    //service13 = null;
    //service14 = null;
    //service15 = null;
    //service16 = null;
    //service17 = null;
    //service18 = null;
    //service19 = null;
    //service110 = null;
    //service111 = null;
    //service112 = null;
    //service113 = null;
    directIOListeners = new Vector();
    errorListeners = new Vector();
    outputCompleteListeners = new Vector();
    statusUpdateListeners = new Vector();
  }


  //--------------------------------------------------------------------------
  // Capabilities
  //--------------------------------------------------------------------------

  public boolean getCapPitch()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service12.getCapPitch();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapVolume()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service12.getCapVolume();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getCapPowerReporting()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getCapPowerReporting();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapStatisticsReporting()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.8.0
    if(serviceVersion < deviceVersion18)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.8.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service18.getCapStatisticsReporting();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapUpdateStatistics()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.8.0
    if(serviceVersion < deviceVersion18)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.8.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service18.getCapUpdateStatistics();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapCompareFirmwareVersion()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service19.getCapCompareFirmwareVersion();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public boolean getCapUpdateFirmware()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service19.getCapUpdateFirmware();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getCapMelody()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.13.0
    if(serviceVersion < deviceVersion113)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.13.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service113.getCapMelody();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }


  //--------------------------------------------------------------------------
  // Properties
  //--------------------------------------------------------------------------

  public boolean getAsyncMode()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service12.getAsyncMode();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setAsyncMode(boolean asyncMode)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service12.setAsyncMode(asyncMode);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getInterToneWait()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service12.getInterToneWait();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setInterToneWait(int interToneWait)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service12.setInterToneWait(interToneWait);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getOutputID()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service12.getOutputID();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getTone1Duration()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service12.getTone1Duration();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setTone1Duration(int tone1Duration)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service12.setTone1Duration(tone1Duration);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getTone1Pitch()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service12.getTone1Pitch();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setTone1Pitch(int tone1Pitch)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service12.setTone1Pitch(tone1Pitch);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getTone1Volume()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service12.getTone1Volume();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setTone1Volume(int tone1Volume)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service12.setTone1Volume(tone1Volume);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getTone2Duration()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service12.getTone2Duration();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setTone2Duration(int tone2Duration)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service12.setTone2Duration(tone2Duration);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getTone2Pitch()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service12.getTone2Pitch();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setTone2Pitch(int tone2Pitch)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service12.setTone2Pitch(tone2Pitch);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getTone2Volume()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      return service12.getTone2Volume();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setTone2Volume(int tone2Volume)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service12.setTone2Volume(tone2Volume);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getPowerNotify()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getPowerNotify();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setPowerNotify(int powerNotify)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      service13.setPowerNotify(powerNotify);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getPowerState()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.3.0
    if(serviceVersion < deviceVersion13)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.3.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service13.getPowerState();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getMelodyType()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.13.0
    if(serviceVersion < deviceVersion113)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.13.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service113.getMelodyType();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setMelodyType(int melodyType)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.13.0
    if(serviceVersion < deviceVersion113)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.13.0 compliant.");
    }

    // Perform the operation
    try
    {
      service113.setMelodyType(melodyType);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public int getMelodyVolume()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.13.0
    if(serviceVersion < deviceVersion113)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.13.0 compliant.");
    }

    // Perform the operation
    try
    {
      return service113.getMelodyVolume();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void setMelodyVolume(int melodyVolume)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.13.0
    if(serviceVersion < deviceVersion113)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.13.0 compliant.");
    }

    // Perform the operation
    try
    {
      service113.setMelodyVolume(melodyVolume);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }


  //--------------------------------------------------------------------------
  // Methods
  //--------------------------------------------------------------------------

  public void clearOutput()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service12.clearOutput();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void sound(int numberOfCycles, int interSoundWait)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service12.sound(numberOfCycles, interSoundWait);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void soundImmediate()
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Perform the operation
    try
    {
      service12.soundImmediate();
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void resetStatistics(String statisticsBuffer)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.8.0
    if(serviceVersion < deviceVersion18)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.8.0 compliant.");
    }

    // Perform the operation
    try
    {
      service18.resetStatistics(statisticsBuffer);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void retrieveStatistics(String[] statisticsBuffer)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.8.0
    if(serviceVersion < deviceVersion18)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.8.0 compliant.");
    }

    // Perform the operation
    try
    {
      service18.retrieveStatistics(statisticsBuffer);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void updateStatistics(String statisticsBuffer)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.8.0
    if(serviceVersion < deviceVersion18)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.8.0 compliant.");
    }

    // Perform the operation
    try
    {
      service18.updateStatistics(statisticsBuffer);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void compareFirmwareVersion(String firmwareFileName, int[] result)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      service19.compareFirmwareVersion(firmwareFileName, result);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }

  public void updateFirmware(String firmwareFileName)
    throws JposException
  {
    // Make sure control is opened
    if(!bOpen)
    {
      throw new JposException(JPOS_E_CLOSED, "Control not opened");
    }

    // Make sure service supports at least version 1.9.0
    if(serviceVersion < deviceVersion19)
    {
      throw new JposException(JPOS_E_NOSERVICE,
                              "Device Service is not 1.9.0 compliant.");
    }

    // Perform the operation
    try
    {
      service19.updateFirmware(firmwareFileName);
    }
    catch(JposException je)
    {
      throw je;
    }
    catch(Exception e)
    {
      throw new JposException(JPOS_E_FAILURE,
                              "Unhandled exception from Device Service", e);
    }
  }


  //--------------------------------------------------------------------------
  // Framework Methods
  //--------------------------------------------------------------------------

  // Create an EventCallbacks interface implementation object for this Control
  protected EventCallbacks createEventCallbacks()
  {
    return new ToneIndicatorCallbacks();
  }

  // Store the reference to the Device Service
  protected void setDeviceService(BaseService service, int nServiceVersion)
    throws JposException
  {
    // Special case: service == null to free references
    if(service == null)
    {

      service12 = null;
      service13 = null;
      service14 = null;
      service15 = null;
      service16 = null;
      service17 = null;
      service18 = null;
      service19 = null;
      service110 = null;
      service111 = null;
      service112 = null;
      service113 = null;
    }
    else
    {
      // Make sure that the service actually conforms to the interfaces it
      // claims to.
      if(serviceVersion >= deviceVersion12)
      {
        try
        {
          service12 = (ToneIndicatorService12)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService12 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion13)
      {
        try
        {
          service13 = (ToneIndicatorService13)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService13 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion14)
      {
        try
        {
          service14 = (ToneIndicatorService14)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService14 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion15)
      {
        try
        {
          service15 = (ToneIndicatorService15)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService15 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion16)
      {
        try
        {
          service16 = (ToneIndicatorService16)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService16 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion17)
      {
        try
        {
          service17 = (ToneIndicatorService17)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService17 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion18)
      {
        try
        {
          service18 = (ToneIndicatorService18)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService18 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion19)
      {
        try
        {
          service19 = (ToneIndicatorService19)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService19 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion110)
      {
        try
        {
          service110 = (ToneIndicatorService110)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService110 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion111)
      {
        try
        {
          service111 = (ToneIndicatorService111)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService111 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion112)
      {
        try
        {
          service112 = (ToneIndicatorService112)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService112 interface",
                                  e);
        }
      }

      if(serviceVersion >= deviceVersion113)
      {
        try
        {
          service113 = (ToneIndicatorService113)service;
        }
        catch(Exception e)
        {
          throw new JposException(JPOS_E_NOSERVICE,
                                  "Service does not fully implement ToneIndicatorService113 interface",
                                  e);
        }
      }

    }
  }


  //--------------------------------------------------------------------------
  // Event Listener Methods
  //--------------------------------------------------------------------------

  public void addDirectIOListener(DirectIOListener l)
  {
    synchronized(directIOListeners)
    {
      directIOListeners.addElement(l);
    }
  }

  public void removeDirectIOListener(DirectIOListener l)
  {
    synchronized(directIOListeners)
    {
      directIOListeners.removeElement(l);
    }
  }

  public void addErrorListener(ErrorListener l)
  {
    synchronized(errorListeners)
    {
      errorListeners.addElement(l);
    }
  }

  public void removeErrorListener(ErrorListener l)
  {
    synchronized(errorListeners)
    {
      errorListeners.removeElement(l);
    }
  }

  public void addOutputCompleteListener(OutputCompleteListener l)
  {
    synchronized(outputCompleteListeners)
    {
      outputCompleteListeners.addElement(l);
    }
  }

  public void removeOutputCompleteListener(OutputCompleteListener l)
  {
    synchronized(outputCompleteListeners)
    {
      outputCompleteListeners.removeElement(l);
    }
  }

  public void addStatusUpdateListener(StatusUpdateListener l)
  {
    synchronized(statusUpdateListeners)
    {
      statusUpdateListeners.addElement(l);
    }
  }

  public void removeStatusUpdateListener(StatusUpdateListener l)
  {
    synchronized(statusUpdateListeners)
    {
      statusUpdateListeners.removeElement(l);
    }
  }


  //--------------------------------------------------------------------------
  // EventCallbacks inner class
  //--------------------------------------------------------------------------

  protected class ToneIndicatorCallbacks
    implements EventCallbacks
  {
    public BaseControl getEventSource()
    {
      return (BaseControl)ToneIndicator.this;
    }

    public void fireDataEvent(DataEvent e)
    {
    }

    public void fireDirectIOEvent(DirectIOEvent e)
    {
      synchronized(ToneIndicator.this.directIOListeners)
      {
        // deliver the event to all registered listeners
        for(int x = 0; x < directIOListeners.size(); x++)
        {
          ((DirectIOListener)directIOListeners.elementAt(x)).directIOOccurred(e);
        }
      }
    }

    public void fireErrorEvent(ErrorEvent e)
    {
      synchronized(ToneIndicator.this.errorListeners)
      {
        // deliver the event to all registered listeners
        for(int x = 0; x < errorListeners.size(); x++)
        {
          ((ErrorListener)errorListeners.elementAt(x)).errorOccurred(e);
        }
      }
    }

    public void fireOutputCompleteEvent(OutputCompleteEvent e)
    {
      synchronized(ToneIndicator.this.outputCompleteListeners)
      {
        // deliver the event to all registered listeners
        for(int x = 0; x < outputCompleteListeners.size(); x++)
        {
          ((OutputCompleteListener)outputCompleteListeners.elementAt(x)).outputCompleteOccurred(e);
        }
      }
    }

    public void fireStatusUpdateEvent(StatusUpdateEvent e)
    {
      synchronized(ToneIndicator.this.statusUpdateListeners)
      {
        // deliver the event to all registered listeners
        for(int x = 0; x < statusUpdateListeners.size(); x++)
        {
          ((StatusUpdateListener)statusUpdateListeners.elementAt(x)).statusUpdateOccurred(e);
        }
      }
    }
  }
}
