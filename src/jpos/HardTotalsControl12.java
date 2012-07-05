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
// HardTotalsControl12
//
//   Interface definining all capabilities, properties and methods
//   that are specific to Hard Totals for release 1.2.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

import jpos.events.*;

public interface HardTotalsControl12 extends BaseControl
{
    // Capabilities
    public boolean getCapErrorDetection() throws JposException;
    public boolean getCapSingleFile() throws JposException;
    public boolean getCapTransactions() throws JposException;

    // Properties
    public int     getFreeData() throws JposException;
    public int     getNumberOfFiles() throws JposException;
    public int     getTotalsSize() throws JposException;
    public boolean getTransactionInProgress() throws JposException;

    // Methods
    public void    beginTrans() throws JposException;
    public void    claimFile(int hTotalsFile, int timeout)
                       throws JposException;
    public void    commitTrans() throws JposException;
    public void    create(String fileName, int[] hTotalsFile, int size,
                       boolean errorDetection) throws JposException;
    public void    delete(String fileName) throws JposException;
    public void    find(String fileName, int[] hTotalsFile, int[] size)
                       throws JposException;
    public void    findByIndex(int index, String[] fileName)
                       throws JposException;
    public void    read(int hTotalsFile, byte[] data, int offset,
                       int count) throws JposException;
    public void    recalculateValidationData(int hTotalsFile)
                       throws JposException;
    public void    releaseFile(int hTotalsFile) throws JposException;
    public void    rename(int hTotalsFile, String fileName)
                       throws JposException;
    public void    rollback() throws JposException;
    public void    setAll(int hTotalsFile, byte value) throws JposException;
    public void    validateData(int hTotalsFile) throws JposException;
    public void    write(int hTotalsFile, byte[] data, int offset, int count)
                       throws JposException;

    // Event listener methods
    public void    addDirectIOListener(DirectIOListener l);
    public void    removeDirectIOListener(DirectIOListener l);
}