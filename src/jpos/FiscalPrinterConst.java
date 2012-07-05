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
// FiscalPrinterConst
//
//   Fiscal Printer constants for JavaPOS Applications.
//
// Modification history
// ------------------------------------------------------------------
// 98-04-20    JavaPOS Release 1.3                                 BS
// 16-Apr-2003 Release 1.7.2: Added the missing constant           BS
//               FPTR_SC_EURO.
// 03-Jun-2003 JavaPOS Release 1.8                                 BS
//               Added new StatusUpdateEvent constants.
// 2007-Jan-04 JavaPOS Release 1.11                                BS
//   Added new ActualCurrency constants:
//       FPTR_AC_CZK
//       FPTR_AC_UAH
//       FPTR_AC_OTHER
//   Added new CountryCode constants:
//       FPTR_CC_CZECH_REPUBLIC
//       FPTR_CC_UKRAINE
//       FPTR_CC_OTHER
//   Added new DateType constant:
//       FPTR_DT_START
//   Added new FiscalReceiptType constant:
//       FPTR_RT_REFUND
//   Added new AdjustmentType constants:
//       FPTR_AT_COUPON_AMOUNT_DISCOUNT
//       FPTR_AT_COUPON_PERCENTAGE_DISCOUNT
//   Added new ReportType constant:
//       FPTR_RT_EOD_ORDINAL
//   Added new ErrorCodeExtended constant:
//       JPOS_EFPTR_DAY_END_REQUIRED
//
/////////////////////////////////////////////////////////////////////

package jpos;

public interface FiscalPrinterConst
{
    /////////////////////////////////////////////////////////////////////
    // Fiscal Printer Station Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_S_JOURNAL                   = 1;
    public static final int FPTR_S_RECEIPT                   = 2;
    public static final int FPTR_S_SLIP                      = 4;

    public static final int FPTR_S_JOURNAL_RECEIPT = FPTR_S_JOURNAL | FPTR_S_RECEIPT;


    /////////////////////////////////////////////////////////////////////
    // "ActualCurrency" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_AC_BRC                      =  1;
    public static final int FPTR_AC_BGL                      =  2;
    public static final int FPTR_AC_EUR                      =  3;
    public static final int FPTR_AC_GRD                      =  4;
    public static final int FPTR_AC_HUF                      =  5;
    public static final int FPTR_AC_ITL                      =  6;
    public static final int FPTR_AC_PLZ                      =  7;
    public static final int FPTR_AC_ROL                      =  8;
    public static final int FPTR_AC_RUR                      =  9;
    public static final int FPTR_AC_TRL                      =  10;
    public static final int FPTR_AC_CZK                      =  11; // 1.11
    public static final int FPTR_AC_UAH                      =  12; // 1.11
    public static final int FPTR_AC_OTHER                    = 200; // 1.11


    /////////////////////////////////////////////////////////////////////
    // "ContractorId" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_CID_FIRST                   =  1;
    public static final int FPTR_CID_SECOND                  =  2;
    public static final int FPTR_CID_SINGLE                  =  3;


    /////////////////////////////////////////////////////////////////////
    // "CountryCode" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_CC_BRAZIL                   = 0x00000001;
    public static final int FPTR_CC_GREECE                   = 0x00000002;
    public static final int FPTR_CC_HUNGARY                  = 0x00000004;
    public static final int FPTR_CC_ITALY                    = 0x00000008;
    public static final int FPTR_CC_POLAND                   = 0x00000010;
    public static final int FPTR_CC_TURKEY                   = 0x00000020;
    public static final int FPTR_CC_RUSSIA                   = 0x00000040;
    public static final int FPTR_CC_BULGARIA                 = 0x00000080;
    public static final int FPTR_CC_ROMANIA                  = 0x00000100;
    public static final int FPTR_CC_CZECH_REPUBLIC           = 0x00000200; // 1.11
    public static final int FPTR_CC_UKRAINE                  = 0x00000400; // 1.11
    public static final int FPTR_CC_OTHER                    = 0x40000000; // 1.11


    /////////////////////////////////////////////////////////////////////
    // "DateType" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_DT_CONF                     =  1;
    public static final int FPTR_DT_EOD                      =  2;
    public static final int FPTR_DT_RESET                    =  3;
    public static final int FPTR_DT_RTC                      =  4;
    public static final int FPTR_DT_VAT                      =  5;
    public static final int FPTR_DT_START                    =  6; // 1.11


    /////////////////////////////////////////////////////////////////////
    // "ErrorLevel" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_EL_NONE                     =  1;
    public static final int FPTR_EL_RECOVERABLE              =  2;
    public static final int FPTR_EL_FATAL                    =  3;
    public static final int FPTR_EL_BLOCKED                  =  4;


    /////////////////////////////////////////////////////////////////////
    // "ErrorState", "PrinterState" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_PS_MONITOR                  =  1;
    public static final int FPTR_PS_FISCAL_RECEIPT           =  2;
    public static final int FPTR_PS_FISCAL_RECEIPT_TOTAL     =  3;
    public static final int FPTR_PS_FISCAL_RECEIPT_ENDING    =  4;
    public static final int FPTR_PS_FISCAL_DOCUMENT          =  5;
    public static final int FPTR_PS_FIXED_OUTPUT             =  6;
    public static final int FPTR_PS_ITEM_LIST                =  7;
    public static final int FPTR_PS_LOCKED                   =  8;
    public static final int FPTR_PS_NONFISCAL                =  9;
    public static final int FPTR_PS_REPORT                   = 10;


    /////////////////////////////////////////////////////////////////////
    // "FiscalReceiptStation" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_RS_RECEIPT                  =  1;
    public static final int FPTR_RS_SLIP                     =  2;


    /////////////////////////////////////////////////////////////////////
    // "FiscalReceiptType" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_RT_CASH_IN                  =  1;
    public static final int FPTR_RT_CASH_OUT                 =  2;
    public static final int FPTR_RT_GENERIC                  =  3;
    public static final int FPTR_RT_SALES                    =  4;
    public static final int FPTR_RT_SERVICE                  =  5;
    public static final int FPTR_RT_SIMPLE_INVOICE           =  6;
    public static final int FPTR_RT_REFUND                   =  7; // 1.11


    /////////////////////////////////////////////////////////////////////
    // "MessageType" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_MT_ADVANCE                  =  1;
    public static final int FPTR_MT_ADVANCE_PAID             =  2;
    public static final int FPTR_MT_AMOUNT_TO_BE_PAID        =  3;
    public static final int FPTR_MT_AMOUNT_TO_BE_PAID_BACK   =  4;
    public static final int FPTR_MT_CARD                     =  5;
    public static final int FPTR_MT_CARD_NUMBER              =  6;
    public static final int FPTR_MT_CARD_TYPE                =  7;
    public static final int FPTR_MT_CASH                     =  8;
    public static final int FPTR_MT_CASHIER                  =  9;
    public static final int FPTR_MT_CASH_REGISTER_NUMBER     =  10;
    public static final int FPTR_MT_CHANGE                   =  11;
    public static final int FPTR_MT_CHEQUE                   =  12;
    public static final int FPTR_MT_CLIENT_NUMBER            =  13;
    public static final int FPTR_MT_CLIENT_SIGNATURE         =  14;
    public static final int FPTR_MT_COUNTER_STATE            =  15;
    public static final int FPTR_MT_CREDIT_CARD              =  16;
    public static final int FPTR_MT_CURRENCY                 =  17;
    public static final int FPTR_MT_CURRENCY_VALUE           =  18;
    public static final int FPTR_MT_DEPOSIT                  =  19;
    public static final int FPTR_MT_DEPOSIT_RETURNED         =  20;
    public static final int FPTR_MT_DOT_LINE                 =  21;
    public static final int FPTR_MT_DRIVER_NUMB              =  22;
    public static final int FPTR_MT_EMPTY_LINE               =  23;
    public static final int FPTR_MT_FREE_TEXT                =  24;
    public static final int FPTR_MT_FREE_TEXT_WITH_DAY_LIMIT =  25;
    public static final int FPTR_MT_GIVEN_DISCOUNT           =  26;
    public static final int FPTR_MT_LOCAL_CREDIT             =  27;
    public static final int FPTR_MT_MILEAGE_KM               =  28;
    public static final int FPTR_MT_NOTE                     =  29;
    public static final int FPTR_MT_PAID                     =  30;
    public static final int FPTR_MT_PAY_IN                   =  31;
    public static final int FPTR_MT_POINT_GRANTED            =  32;
    public static final int FPTR_MT_POINTS_BONUS             =  33;
    public static final int FPTR_MT_POINTS_RECEIPT           =  34;
    public static final int FPTR_MT_POINTS_TOTAL             =  35;
    public static final int FPTR_MT_PROFITED                 =  36;
    public static final int FPTR_MT_RATE                     =  37;
    public static final int FPTR_MT_REGISTER_NUMB            =  38;
    public static final int FPTR_MT_SHIFT_NUMBER             =  39;
    public static final int FPTR_MT_STATE_OF_AN_ACCOUNT      =  40;
    public static final int FPTR_MT_SUBSCRIPTION             =  41;
    public static final int FPTR_MT_TABLE                    =  42;
    public static final int FPTR_MT_THANK_YOU_FOR_LOYALTY    =  43;
    public static final int FPTR_MT_TRANSACTION_NUMB         =  44;
    public static final int FPTR_MT_VALID_TO                 =  45;
    public static final int FPTR_MT_VOUCHER                  =  46;
    public static final int FPTR_MT_VOUCHER_PAID             =  47;
    public static final int FPTR_MT_VOUCHER_VALUE            =  48;
    public static final int FPTR_MT_WITH_DISCOUNT            =  49;
    public static final int FPTR_MT_WITHOUT_UPLIFT           =  50;


    /////////////////////////////////////////////////////////////////////
    // "SlipSelection" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_SS_FULL_LENGTH              =  1;
    public static final int FPTR_SS_VALIDATION               =  2;


    /////////////////////////////////////////////////////////////////////
    // "TotalizerType" Property Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_TT_DOCUMENT                 =  1;
    public static final int FPTR_TT_DAY                      =  2;
    public static final int FPTR_TT_RECEIPT                  =  3;
    public static final int FPTR_TT_GRAND                    =  4;


    /////////////////////////////////////////////////////////////////////
    // "GetData" Method Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_GD_CURRENT_TOTAL            =  1;
    public static final int FPTR_GD_DAILY_TOTAL              =  2;
    public static final int FPTR_GD_RECEIPT_NUMBER           =  3;
    public static final int FPTR_GD_REFUND                   =  4;
    public static final int FPTR_GD_NOT_PAID                 =  5;
    public static final int FPTR_GD_MID_VOID                 =  6;
    public static final int FPTR_GD_Z_REPORT                 =  7;
    public static final int FPTR_GD_GRAND_TOTAL              =  8;
    public static final int FPTR_GD_PRINTER_ID               =  9;
    public static final int FPTR_GD_FIRMWARE                 = 10;
    public static final int FPTR_GD_RESTART                  = 11;
    public static final int FPTR_GD_REFUND_VOID              = 12;
    public static final int FPTR_GD_NUMB_CONFIG_BLOCK        = 13;
    public static final int FPTR_GD_NUMB_CURRENCY_BLOCK      = 14;
    public static final int FPTR_GD_NUMB_HDR_BLOCK           = 15;
    public static final int FPTR_GD_NUMB_RESET_BLOCK         = 16;
    public static final int FPTR_GD_NUMB_VAT_BLOCK           = 17;
    public static final int FPTR_GD_FISCAL_DOC               = 18;
    public static final int FPTR_GD_FISCAL_DOC_VOID          = 19;
    public static final int FPTR_GD_FISCAL_REC               = 20;
    public static final int FPTR_GD_FISCAL_REC_VOID          = 21;
    public static final int FPTR_GD_NONFISCAL_DOC            = 22;
    public static final int FPTR_GD_NONFISCAL_DOC_VOID       = 23;
    public static final int FPTR_GD_NONFISCAL_REC            = 24;
    public static final int FPTR_GD_SIMP_INVOICE             = 25;
    public static final int FPTR_GD_TENDER                   = 26;
    public static final int FPTR_GD_LINECOUNT                = 27;
    public static final int FPTR_GD_DESCRIPTION_LENGTH       = 28;

    public static final int FPTR_PDL_CASH                     =  1;
    public static final int FPTR_PDL_CHEQUE                   =  2;
    public static final int FPTR_PDL_CHITTY                   =  3;
    public static final int FPTR_PDL_COUPON                   =  4;
    public static final int FPTR_PDL_CURRENCY                 =  5;
    public static final int FPTR_PDL_DRIVEN_OFF               =  6;
    public static final int FPTR_PDL_EFT_IMPRINTER            =  7;
    public static final int FPTR_PDL_EFT_TERMINAL             =  8;
    public static final int FPTR_PDL_TERMINAL_IMPRINTER       =  9;
    public static final int FPTR_PDL_FREE_GIFT                = 10;
    public static final int FPTR_PDL_GIRO                     = 11;
    public static final int FPTR_PDL_HOME                     = 12;
    public static final int FPTR_PDL_IMPRINTER_WITH_ISSUER    = 13;
    public static final int FPTR_PDL_LOCAL_ACCOUNT            = 14;
    public static final int FPTR_PDL_LOCAL_ACCOUNT_CARD       = 15;
    public static final int FPTR_PDL_PAY_CARD                 = 16;
    public static final int FPTR_PDL_PAY_CARD_MANUAL          = 17;
    public static final int FPTR_PDL_PREPAY                   = 18;
    public static final int FPTR_PDL_PUMP_TEST                = 19;
    public static final int FPTR_PDL_SHORT_CREDIT             = 20;
    public static final int FPTR_PDL_STAFF                    = 21;
    public static final int FPTR_PDL_VOUCHER                  = 22;

    public static final int FPTR_LC_ITEM                      =  1;
    public static final int FPTR_LC_ITEM_VOID                 =  2;
    public static final int FPTR_LC_DISCOUNT                  =  3;
    public static final int FPTR_LC_DISCOUNT_VOID             =  4;
    public static final int FPTR_LC_SURCHARGE                 =  5;
    public static final int FPTR_LC_SURCHARGE_VOID            =  6;
    public static final int FPTR_LC_REFUND                    =  7;
    public static final int FPTR_LC_REFUND_VOID               =  8;
    public static final int FPTR_LC_SUBTOTAL_DISCOUNT         =  9;
    public static final int FPTR_LC_SUBTOTAL_DISCOUNT_VOID    = 10;
    public static final int FPTR_LC_SUBTOTAL_SURCHARGE        = 11;
    public static final int FPTR_LC_SUBTOTAL_SURCHARGE_VOID   = 12;
    public static final int FPTR_LC_COMMENT                   = 13;
    public static final int FPTR_LC_SUBTOTAL                  = 14;
    public static final int FPTR_LC_TOTAL                     = 15;

    public static final int FPTR_DL_ITEM                      =  1;
    public static final int FPTR_DL_ITEM_ADJUSTMENT           =  2;
    public static final int FPTR_DL_ITEM_FUEL                 =  3;
    public static final int FPTR_DL_ITEM_FUEL_VOID            =  4;
    public static final int FPTR_DL_NOT_PAID                  =  5;
    public static final int FPTR_DL_PACKAGE_ADJUSTMENT        =  6;
    public static final int FPTR_DL_REFUND                    =  7;
    public static final int FPTR_DL_REFUND_VOID               =  8;
    public static final int FPTR_DL_SUBTOTAL_ADJUSTMENT       =  9;
    public static final int FPTR_DL_TOTAL                     = 10;
    public static final int FPTR_DL_VOID                      = 11;
    public static final int FPTR_DL_VOID_ITEM                 = 12;


    /////////////////////////////////////////////////////////////////////
    // "GetTotalizer" Method Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_GT_GROSS                    =  1;
    public static final int FPTR_GT_NET                      =  2;
    public static final int FPTR_GT_DISCOUNT                 =  3;
    public static final int FPTR_GT_DISCOUNT_VOID            =  4;
    public static final int FPTR_GT_ITEM                     =  5;
    public static final int FPTR_GT_ITEM_VOID                =  6;
    public static final int FPTR_GT_NOT_PAID                 =  7;
    public static final int FPTR_GT_REFUND                   =  8;
    public static final int FPTR_GT_REFUND_VOID              =  9;
    public static final int FPTR_GT_SUBTOTAL_DISCOUNT        =  10;
    public static final int FPTR_GT_SUBTOTAL_DISCOUNT_VOID   =  11;
    public static final int FPTR_GT_SUBTOTAL_SURCHARGES      =  12;
    public static final int FPTR_GT_SUBTOTAL_SURCHARGES_VOID =  13;
    public static final int FPTR_GT_SURCHARGE                =  14;
    public static final int FPTR_GT_SURCHARGE_VOID           =  15;
    public static final int FPTR_GT_VAT                      =  16;
    public static final int FPTR_GT_VAT_CATEGORY             =  17;


    /////////////////////////////////////////////////////////////////////
    // "AdjustmentType" arguments in diverse methods
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_AT_AMOUNT_DISCOUNT            =  1;
    public static final int FPTR_AT_AMOUNT_SURCHARGE           =  2;
    public static final int FPTR_AT_PERCENTAGE_DISCOUNT        =  3;
    public static final int FPTR_AT_PERCENTAGE_SURCHARGE       =  4;
    public static final int FPTR_AT_COUPON_AMOUNT_DISCOUNT     =  5; // 1.11
    public static final int FPTR_AT_COUPON_PERCENTAGE_DISCOUNT =  6; // 1.11


    /////////////////////////////////////////////////////////////////////
    // "ReportType" argument in "PrintReport" method
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_RT_ORDINAL                  =  1;
    public static final int FPTR_RT_DATE                     =  2;
    public static final int FPTR_RT_EOD_ORDINAL              =  3; // 1.11


    /////////////////////////////////////////////////////////////////////
    // "NewCurrency" argument in "SetCurrency" method
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_SC_EURO                     =  1;


    /////////////////////////////////////////////////////////////////////
    // "StatusUpdateEvent" Event: "Data" Parameter Constants
    /////////////////////////////////////////////////////////////////////

    public static final int FPTR_SUE_COVER_OPEN              =  11;
    public static final int FPTR_SUE_COVER_OK                =  12;

    public static final int FPTR_SUE_JRN_EMPTY               =  21;
    public static final int FPTR_SUE_JRN_NEAREMPTY           =  22;
    public static final int FPTR_SUE_JRN_PAPEROK             =  23;

    public static final int FPTR_SUE_REC_EMPTY               =  24;
    public static final int FPTR_SUE_REC_NEAREMPTY           =  25;
    public static final int FPTR_SUE_REC_PAPEROK             =  26;

    public static final int FPTR_SUE_SLP_EMPTY               =  27;
    public static final int FPTR_SUE_SLP_NEAREMPTY           =  28;
    public static final int FPTR_SUE_SLP_PAPEROK             =  29;

    public static final int FPTR_SUE_IDLE                    =1001;

    // Added in Release 1.8
    public static final int FPTR_SUE_JRN_COVER_OPEN          =  60;
    public static final int FPTR_SUE_JRN_COVER_OK            =  61;
    public static final int FPTR_SUE_REC_COVER_OPEN          =  62;
    public static final int FPTR_SUE_REC_COVER_OK            =  63;
    public static final int FPTR_SUE_SLP_COVER_OPEN          =  64;
    public static final int FPTR_SUE_SLP_COVER_OK            =  65;


    /////////////////////////////////////////////////////////////////////
    // "ErrorCodeExtended" Property Constants for Fiscal Printer
    /////////////////////////////////////////////////////////////////////

    public static final int JPOS_EFPTR_COVER_OPEN = 1 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_JRN_EMPTY  = 2 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_REC_EMPTY  = 3 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_SLP_EMPTY  = 4 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_SLP_FORM   = 5 + JposConst.JPOSERREXT; // EndRemoval
    public static final int JPOS_EFPTR_MISSING_DEVICES            =
            6 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_WRONG_STATE                =
            7 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_TECHNICAL_ASSISTANCE       =
            8 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_CLOCK_ERROR                =
            9 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_FISCAL_MEMORY_FULL         =
            10 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_FISCAL_MEMORY_DISCONNECTED =
            11 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_FISCAL_TOTALS_ERROR        =
            12 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_BAD_ITEM_QUANTITY          =
            13 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_BAD_ITEM_AMOUNT            =
            14 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_BAD_ITEM_DESCRIPTION       =
            15 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_RECEIPT_TOTAL_OVERFLOW     =
            16 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_BAD_VAT                    =
            17 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_BAD_PRICE                  =
            18 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_BAD_DATE                   =
            19 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_NEGATIVE_TOTAL             =
            20 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_WORD_NOT_ALLOWED           =
            21 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_BAD_LENGTH                 =
            22 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_MISSING_SET_CURRENCY       =
            23 + JposConst.JPOSERREXT; // (Several)
    public static final int JPOS_EFPTR_DAY_END_REQUIRED           =
            24 + JposConst.JPOSERREXT; // (Several)                 // 1.11
}