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
// MSRConst
//
//   MSR constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 1998-Feb-18 JavaPOS Release 1.2                                 BS
// 2006-Feb-10 JavaPOS Release 1.10                                BS
// 2008-Jan-14 JavaPOS Release 1.12                                BS
//   Added Property values:
//     MSR_DE_NONE
//     MSR_DE_3DEA_DUKPT
//     MSR_DA_NOT_SUPPORTED
//     MSR_DA_OPTIONAL
//     MSR_DA_REQUIRED
//     MSR_AP_NONE
//     MSR_AP_CHALLENGERESPONSE
//   Added Extended Error values:
//     MSR_SUE_DEVICE_AUTHENTICATED
//     MSR_SUE_DEVICE_DEAUTHENTICATED
//   Added Status Update Event values:
//     JPOS_EMSR_DEVICE_AUTHENTICATION_FAILED
//     JPOS_EMSR_DEVICE_DEAUTHENTICATION_FAILED
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface MSRConst
{
    //###################################################################
    //#### MSR Constants
    //###################################################################

    /////////////////////////////////////////////////////////////////////
    // "TracksToRead" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int MSR_TR_NONE      = 0;

    public static final int MSR_TR_1         = 1;
    public static final int MSR_TR_2         = 2;
    public static final int MSR_TR_3         = 4;
    public static final int MSR_TR_4         = 8;

    public static final int MSR_TR_1_2       = MSR_TR_1 | MSR_TR_2;
    public static final int MSR_TR_1_3       = MSR_TR_1 | MSR_TR_3;
    public static final int MSR_TR_1_4       = MSR_TR_1 | MSR_TR_4;
    public static final int MSR_TR_2_3       = MSR_TR_2 | MSR_TR_3;
    public static final int MSR_TR_2_4       = MSR_TR_2 | MSR_TR_4;
    public static final int MSR_TR_3_4       = MSR_TR_3 | MSR_TR_4;

    public static final int MSR_TR_1_2_3     = MSR_TR_1 | MSR_TR_2 | MSR_TR_3;
    public static final int MSR_TR_1_2_4     = MSR_TR_1 | MSR_TR_2 | MSR_TR_4;
    public static final int MSR_TR_1_3_4     = MSR_TR_1 | MSR_TR_3 | MSR_TR_4;
    public static final int MSR_TR_2_3_4     = MSR_TR_2 | MSR_TR_3 | MSR_TR_4;

    public static final int MSR_TR_1_2_3_4   = MSR_TR_1 | MSR_TR_2 |
                                               MSR_TR_3 | MSR_TR_4;


    /////////////////////////////////////////////////////////////////////
    // "ErrorReportingType" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int MSR_ERT_CARD         = 0;
    public static final int MSR_ERT_TRACK        = 1;


    /////////////////////////////////////////////////////////////////////
    // "CapDataEncryption", "DataEncryptionAlgorithm" Property Constants
    //   (added in 1.12)
    /////////////////////////////////////////////////////////////////////

    public static final int MSR_DE_NONE          = 0x00000001;
    public static final int MSR_DE_3DEA_DUKPT    = 0x00000002;
    // Note: Service-specific values begin at 0x01000000.


    /////////////////////////////////////////////////////////////////////
    // "CapDeviceAuthentication" Property Constants (added in 1.12)
    /////////////////////////////////////////////////////////////////////

    public static final int MSR_DA_NOT_SUPPORTED = 0;
    public static final int MSR_DA_OPTIONAL      = 1;
    public static final int MSR_DA_REQUIRED      = 2;


    /////////////////////////////////////////////////////////////////////
    // "DeviceAuthenticationProtocol" Property Constants (added in 1.12)
    /////////////////////////////////////////////////////////////////////

    public static final int MSR_AP_NONE              = 0;
    public static final int MSR_AP_CHALLENGERESPONSE = 1;


    /////////////////////////////////////////////////////////////////////
    // "CardType" Property Constants (added in 1.12)
    /////////////////////////////////////////////////////////////////////

    public static final String MSR_CT_AAMVA = "AAMVA";
    public static final String MSR_CT_BANK  = "BANK";


    /////////////////////////////////////////////////////////////////////
    // "retrieveCardProperty" Parameter Constants (added in 1.12)
    /////////////////////////////////////////////////////////////////////

    public static final String MSR_RCP_AccountNumber  = "AccountNumber";
    public static final String MSR_RCP_Address        = "Address";
    public static final String MSR_RCP_BirthDate      = "BirthDate";
    public static final String MSR_RCP_City           = "City";
    public static final String MSR_RCP_Class          = "Class";
    public static final String MSR_RCP_Endorsements   = "Endorsements";
    public static final String MSR_RCP_ExpirationDate = "ExpirationDate";
    public static final String MSR_RCP_EyeColor       = "EyeColor";
    public static final String MSR_RCP_FirstName      = "FirstName";
    public static final String MSR_RCP_Gender         = "Gender";
    public static final String MSR_RCP_HairColor      = "HairColor";
    public static final String MSR_RCP_Height         = "Height";
    public static final String MSR_RCP_LicenseNumber  = "LicenseNumber";
    public static final String MSR_RCP_MiddleInitial  = "MiddleInitial";
    public static final String MSR_RCP_PostalCode     = "PostalCode";
    public static final String MSR_RCP_Restrictions   = "Restrictions";
    public static final String MSR_RCP_ServiceCode    = "ServiceCode";
    public static final String MSR_RCP_State          = "State";
    public static final String MSR_RCP_Suffix         = "Suffix";
    public static final String MSR_RCP_Surname        = "Surname";
    public static final String MSR_RCP_Title          = "Title";
    public static final String MSR_RCP_Weight         = "Weight";


    /////////////////////////////////////////////////////////////////////
    // "StatusUpdateEvent" Event: "Data" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int MSR_SUE_DEVICE_AUTHENTICATED     =  11; // 1.12
    public static final int MSR_SUE_DEVICE_DEAUTHENTICATED   =  12; // 1.12


    /////////////////////////////////////////////////////////////////////
    // "ErrorEvent" Event: "ResultCodeExtended" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_EMSR_START      = 1 + JposConst.JPOSERREXT;
    public static final int JPOS_EMSR_END        = 2 + JposConst.JPOSERREXT;
    public static final int JPOS_EMSR_PARITY     = 3 + JposConst.JPOSERREXT;
    public static final int JPOS_EMSR_LRC        = 4 + JposConst.JPOSERREXT;
    public static final int JPOS_EMSR_DEVICE_AUTHENTICATION_FAILED   = 5 + JposConst.JPOSERREXT; // 1.12
    public static final int JPOS_EMSR_DEVICE_DEAUTHENTICATION_FAILED = 6 + JposConst.JPOSERREXT; // 1.12
}