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
 * Defines a simple list of DevCatInfo objects
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public interface DevCatInfoList
{
	/** @return the current size of this list */
	public int getSize();

	/** @return true if this list is empty */
	public boolean isEmpty();

	/**
	 * Adds a new DevCatInfo to this list
	 * @param devCatInfo the devCatInfo to add
	 */
	public void add( DevCatInfo devCatInfo );

	/**
	 * Removes the DevCatInfo to this list
	 * @param devCatInfo the devCatInfo to remove
	 */
	public void remove( DevCatInfo devCatInfo );

	/** Removes all DevCatInfo in this list */
	public void removeAll();

	/**
	 * @return true if the DevCatInfo is already in the list
	 * @param devCatInfo the devCatInfo
	 */
	public boolean contains( DevCatInfo devCatInfo );

	/** @return an DevCatInfoList.Iterator object for this list */
	public DevCatInfoList.Iterator iterator();

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
		/** @return the next DevCatInfo in the iterator */
		public DevCatInfo next();

		/** @return true if there is a next DevCatInfo in the iterator */
		public boolean hasNext();
	}
}
