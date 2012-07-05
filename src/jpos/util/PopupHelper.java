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

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

/**
 * utility class that enables and controls showing of popupMenus
 * @author Manuel M Monserrate
 * @since 1.3 (SF 2K meeting)
 */
public class PopupHelper 
{ 
    static Dictionary dictionary = new Hashtable(); 
    
    static MouseListener popupMouseListener = new java.awt.event.MouseAdapter() 
        { 
             
            void tryPopup( MouseEvent evt ) { 
                
                if ( !evt.isPopupTrigger() ) 
                    return; 
                
                Component mouseEvtComp = evt.getComponent(); 
                
                Object o[] = (Object [])dictionary.get( mouseEvtComp ); 
                
                if ( o == null ) 
                    return; 
                
                JPopupMenu popupMenu = (JPopupMenu)o[0]; 
                
                PopupListener popupListener = (PopupListener)o[1]; 

                int x = evt.getX(), y = evt.getY(); 
                                         
                boolean go = true; 
                                         
                if ( popupListener != null ) 
                    go = popupListener.startPopup( x, y ); 
                                         
                if ( go ) 
                    popupMenu.show( mouseEvtComp, x - 20, y - 10 ); 
            } 
                                                 
            public void mousePressed( MouseEvent evt ) { tryPopup( evt ); } 
            
            public void mouseReleased( MouseEvent evt ) { tryPopup( evt ); } 
        }; 
                                 

    /**
     * registers a component to listen to mouse events for the popupMenu, does not use
     * the PopupListener to do extra setting up for the menu
     * @since 1.3 (SF 2K meeting)
     */
    public static void setPopup( JComponent mouseEvtComp, JPopupMenu popupMenu ) { setPopup( mouseEvtComp, popupMenu, null ); } 

    /**
     * registers a component to listen to mouse events for the popupMenu, uses
     * the PopupListener to do extra setting up for the menu when mouse is clicked
     * @since 1.3 (SF 2K meeting)
     */
    public static void setPopup( JComponent mouseEvtComp, JPopupMenu popupMenu, PopupListener popupListener )
    { 
        Object o[] = { popupMenu, popupListener }; 
        
        dictionary.put( mouseEvtComp, o ); 
        
        mouseEvtComp.addMouseListener( popupMouseListener ); 
    } 
        
    /**
     * unregisters a component from listen to mouse events for the popupMenu
     * @since 1.3 (SF 2K meeting)
     */
    public static void removePopup( JComponent mouseEvtComp ) { dictionary.remove( mouseEvtComp ); } 
}
