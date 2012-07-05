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
// JposException
//
//   Exception class used to report all JavaPOS errors.
//
// Modification history
// ------------------------------------------------------------------
// 98-02-18 JavaPOS Release 1.2                                   BS
//
/////////////////////////////////////////////////////////////////////

package jpos;

public class JposException extends java.lang.Exception
{
    public JposException(int errorCode)
    {
        this(errorCode, 0, "" + errorCode, null);
    }

    public JposException(int errorCode, int errorCodeExtended)
    {
        this(errorCode, errorCodeExtended,
             "" + errorCode + ", " + errorCodeExtended, null);
    }

    public JposException(int errorCode, String description)
    {
        this(errorCode, 0, description, null);
    }

    public JposException(int errorCode, int errorCodeExtended,
        String description)
    {
        this(errorCode, errorCodeExtended, description, null);
    }

    public JposException(int errorCode, String description,
        Exception origException)
    {
        this(errorCode, 0, description, origException);
    }

    public JposException(int errorCode, int errorCodeExtended,
        String description, Exception origException)
    {
        super(description);
        this.errorCode = errorCode;
        this.errorCodeExtended = errorCodeExtended;
        this.origException = origException;
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public int getErrorCodeExtended()
    {
        return errorCodeExtended;
    }

    public Exception getOrigException()
    {
        return origException;
    }

    protected int errorCode;
    protected int errorCodeExtended;
    private Exception origException;
}