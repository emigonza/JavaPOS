package jpos.util;

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
 * Default implementation of the Comparable interface
 * <b>NOTE:</b> uses the Object's toString() method as the mean of comparison
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 * @version 1.2.0 (JDK 1.1.x)
 */
public class DefaultComparableElement extends Object implements Comparable
{
    //-------------------------------------------------------------------------
    // Ctor
    //

    /**
     * Default 1-argument ctor
     * @param obj the element's Object
     */
    public DefaultComparableElement( Object obj ) { object = obj; }

    //-------------------------------------------------------------------------
    // Public instance methods
    //

    /**
     * Compares this and other arguments for order
     * @param other object to compare to
     */
    public int compareTo( Object other ) { return object.toString().compareTo( other.toString() ); }

    /**
     * Indicates this object is "equal to" the other 
     * @param other object to compare to
     */
    public boolean equals( Object other ) { return object.toString().equals( other.toString() ); }

    /** @return the Object of this Comparable element */
    public Object getObject() { return object; }

    //-------------------------------------------------------------------------
    // Public overridden methods
    //

    /** @return a String description of this Comparable */
    public String toString() { return object.toString(); }

    //-------------------------------------------------------------------------
    // Instance variables
    //

    private Object object = null;
}
