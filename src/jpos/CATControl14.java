///////////////////////////////////////////////////////////////////////////////
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
// CATControl14
//
//   Interface definining all capabilities, properties and methods that are
//   specific to the Credit Authorization Terminal for release 1.4.
//
// Modification history
// ---------------------------------------------------------------------------
// 98-11-02 JavaPOS Release 1.4                                           BS
//
//////////////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface CATControl14 extends BaseControl
{
    // Capabilities
    public boolean getCapAdditionalSecurityInformation() throws JposException;
    public boolean getCapAuthorizeCompletion() throws JposException;
    public boolean getCapAuthorizePreSales() throws JposException;
    public boolean getCapAuthorizeRefund() throws JposException;
    public boolean getCapAuthorizeVoid() throws JposException;
    public boolean getCapAuthorizeVoidPreSales() throws JposException;
    public boolean getCapCenterResultCode() throws JposException;
    public boolean getCapCheckCard() throws JposException;
    public int     getCapDailyLog() throws JposException;
    public boolean getCapInstallments() throws JposException;
    public boolean getCapPaymentDetail() throws JposException;
	  public int     getCapPowerReporting() throws JposException;
    public boolean getCapTaxOthers() throws JposException;
    public boolean getCapTransactionNumber() throws JposException;
    public boolean getCapTrainingMode() throws JposException;

    // Properties
    public String  getAccountNumber() throws JposException;
    public String  getAdditionalSecurityInformation() throws JposException;
    public void    setAdditionalSecurityInformation(String securityInfo)
                       throws JposException;
    public String  getApprovalCode() throws JposException;
    public boolean getAsyncMode() throws JposException;
    public void    setAsyncMode(boolean asyncMode) throws JposException;
    public String  getCardCompanyID() throws JposException;
    public String  getCenterResultCode() throws JposException;
    public String  getDailyLog() throws JposException;
    public int     getPaymentCondition() throws JposException;
    public String  getPaymentDetail() throws JposException;
		public int     getPowerNotify() throws JposException;
		public void    setPowerNotify(int powerNotify) throws JposException;
		public int     getPowerState() throws JposException;
    public int     getSequenceNumber() throws JposException;
    public String  getSlipNumber() throws JposException;
    public boolean getTrainingMode() throws JposException;
    public void    setTrainingMode(boolean trainingMode) throws JposException;
    public String  getTransactionNumber() throws JposException;
    public String  getTransactionType() throws JposException;

    // Methods
    public void    accessDailyLog(int sequenceNumber, int type, int timeout)
                       throws JposException;
    public void    authorizeCompletion(int sequenceNumber, long amount,
                       long taxOthers, int timeout) throws JposException;
    public void    authorizePreSales(int sequenceNumber, long amount,
                       long taxOthers, int timeout) throws JposException;
    public void    authorizeRefund(int sequenceNumber, long amount,
                       long taxOthers, int timeout) throws JposException;
    public void    authorizeSales(int sequenceNumber, long amount,
                       long taxOthers, int timeout) throws JposException;
    public void    authorizeVoid(int sequenceNumber, long amount,
                       long taxOthers, int timeout) throws JposException;
    public void    authorizeVoidPreSales(int sequenceNumber, long amount,
                       long taxOthers, int timeout) throws JposException;
    public void    checkCard(int sequenceNumber, int timeout)
                       throws JposException;
    public void    clearOutput() throws JposException;

    // Event listener methods
    public void    addDirectIOListener(DirectIOListener l);
    public void    removeDirectIOListener(DirectIOListener l);
    public void    addErrorListener(ErrorListener l);
    public void    removeErrorListener(ErrorListener l);
    public void    addOutputCompleteListener(OutputCompleteListener l);
    public void    removeOutputCompleteListener(OutputCompleteListener l);
    public void    addStatusUpdateListener(StatusUpdateListener l);
    public void    removeStatusUpdateListener(StatusUpdateListener l);
}