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
 * Defines a simple list of PropInfo objects
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface PropInfoList
{
	/** @return the current size of this list */
	public int getSize();

	/** @return true if this list is empty */
	public boolean isEmpty();

	/**
	 * Adds a new PropInfo to this list
	 * @param propInfo the propInfo to add
	 */
	public void add( PropInfo propInfo );

	/**
	 * Removes the PropInfo to this list
	 * @param propInfo the propInfo to remove
	 */
	public void remove( PropInfo propInfo );

	/** Removes all PropInfo in this list */
	public void removeAll();

	/**
	 * @return true if the PropInfo is already in the list
	 * @param propInfo the propInfo
	 */
	public boolean contains( PropInfo propInfo );

	/** @return an PropInfoList.Iterator object for this list */
	public PropInfoList.Iterator iterator();

	//-------------------------------------------------------------------------
	// Inner interfaces
	//

	/**
	 * Simple interface to iterate through the list
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 * @since 1.3 (SF 2K meeting)
	 */
	public interface Iterator
	{
		/** @return the next PropInfo in the iterator */
		public PropInfo next();

		/** @return true if there is a next PropInfo in the iterator */
		public boolean hasNext();
	}
}
