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

import java.util.*;

/**
 * This is utility class to sort Comparable elements in Vector objects
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 * @version 1.1.x (JDK 1.1.x)
 */
public final class Sorter extends Object
{
    //-------------------------------------------------------------------------
    // Ctor
    //

    /** Make ctor private to prevent construction */
    private Sorter() {}

    //-------------------------------------------------------------------------
    // Class methods
    //

    /**
     * @return the smallest Comparable element in this Vector
     * <b>NOTE:</b>implements a simple one pass algorithm in O(n) time
     */
    public static Comparable min( Vector comparables )
    {
        Comparable smallest = null;
        Enumeration elements = comparables.elements();

        while( elements.hasMoreElements() )
        {
            Comparable element = (Comparable)elements.nextElement();

            if( smallest != null )
            {
                if( smallest.compareTo( element ) > 0 )
                    smallest = element;
            }
            else
                smallest = element;
        }

        return smallest;
    }

    /**
     * @return the greatest Comparable element in this Vector
     * <b>NOTE:</b>implements a simple one pass algorithm in O(n) time
     */
    public static Comparable max( Vector comparables )
    {
        Comparable greatest = null;
        Enumeration elements = comparables.elements();

        while( elements.hasMoreElements() )
        {
            Comparable element = (Comparable)elements.nextElement();

            if( greatest != null )
            {
                if( greatest.compareTo( element ) < 0 )
                    greatest = element;
            }
            else
                greatest = element;
        }

        return greatest;
    }

    /**
     * @return a Vector of sorted Comparable objects
     * <b>NOTE:</b>implements a simple Insertion Sort algorithm
     *         Sorts n element in place in O(n^2) worst-case time
     * @param elements a Vector with the initial Comparable objects
     */
    public static Vector insertionSort( Vector comparables )
    {
        Comparable min = min( comparables );

        comparables.removeElement( min );

        comparables.insertElementAt( min, 0 );

        for( int i = 2; i < comparables.size(); i++ )
        {
            Comparable temp = (Comparable)comparables.elementAt( i );
            int j = 0;
            for( j = i; j > 0 && temp.compareTo( (Comparable)comparables.elementAt( j - 1 ) ) < 0; --j )
                comparables.setElementAt( comparables.elementAt( j - 1 ), j );

            comparables.setElementAt( temp, j );
        }

        return comparables;
    }

    /**
     * @return a Vector of sorted Comparable objects
     * <b>NOTE:</b>implements the Merge Sort algorithm
     *         Sorts n element in O(nlgn) worst-case time
     * @param elements a Vector with the initial Comparable objects
     */
    public static Vector mergeSort( Vector comparables )
    {
        //<todo why="Proboby useful for large number of values since Merge-sort is O(nlgn)">
        throw new RuntimeException( "Not yet implemented!" );
        //</todo>
    }

    //-------------------------------------------------------------------------
    // Class variables
    //
}
