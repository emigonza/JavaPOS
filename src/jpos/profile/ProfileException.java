package jpos.profile;

///////////////////////////////////////////////////////////////////////////////
//
// This software is provided "AS IS".  The JavaPOS working group (including
// each of the Corporate members, contributors and individuals)  MAKES NO
// REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
// EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED 
// WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
// NON-INFRINGEMENT. The JavaPOS working group shall not be liable for
// any damages suffered as a result of using, modifying or distributing this
// software or its derivatives. Permission to use, copy, modify, and distribute
// the software and its documentation for any purpose is hereby granted. 
//
// The JavaPOS Config/Loader (aka JCL) is now under the CPL license, which 
// is an OSS Apache-like license.  The complete license is located at:
//    http://oss.software.ibm.com/developerworks/opensource/license-cpl.html
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Defines an exception class for the jpos.profile sub-system
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class ProfileException extends Exception
{
	//-------------------------------------------------------------------------
	// Ctor(s)
	//

	/** 
	 * 1-arg ctor 
	 * @param msg the exception's message
	 */
	public ProfileException( String msg ) { super( msg ); }

	/** 
	 * 2 args ctor 
	 * @param msg the exception's message
	 * @param origException the original exception causing this one
	 */
	public ProfileException( String msg, Exception e ) { this( msg ); origException = e; }

	//-------------------------------------------------------------------------
	// Public methods
	//

	/** @return the original exception causing this one */
	public Exception getOrigException() { return origException; }

	//-------------------------------------------------------------------------
	// Private instance variables
	//

	private Exception origException = null;
}
