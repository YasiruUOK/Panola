/*
 * $Id: SearchFactory.java,v 1.12 2005/10/12 11:26:58 kleopatra Exp $
 *
 * Copyright 2004 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.jdesktop.swingx;

import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.plaf.LookAndFeelAddons;

/**
 * Factory to create, configure and show application consistent
 * search and find widgets.
 * 
 * Typically a shared JXFindBar is used for incremental search, while
 * a shared JXFindPanel is used for batch search. This implementation 
 * 
 * <ul>
 *  <li> JXFindBar - adds and shows it in the target's toplevel container's
 *    toolbar (assuming a JXRootPane)
 *  <li> JXFindPanel - creates a JXDialog, adds and shows the findPanel in the
 *    Dialog 
 * </ul>
 * 
 * 
 * PENDING: JW - update (?) views/wiring on focus change. Started brute force - 
 * stop searching. This looks extreme confusing for findBars added to ToolBars 
 * which are empty except for the findbar. Weird problem if triggered from 
 * menu - find widget disappears after having been shown for an instance. 
 * Where's the focus?
 * 
 * 
 * PENDING: add methods to return JXSearchPanels (for use by PatternMatchers).
 * 
 * @author Jeanette Winzenburg
 */
public class SearchFactory {
    // PENDING: rename methods to batch/incremental instead of dialog/toolbar

    static {
        // Hack to enforce loading of SwingX framework ResourceBundle
        LookAndFeelAddons.getAddon();
    }

    private static SearchFactory searchFactory;

   
    /** the shared find widget for batch-find. */
    protected JXFindPanel findPanel;
   
    /** the shared find widget for incremental-find. */
    protected JXFindBar findBar;

    private boolean useFindBar;

    private Point lastFindDialogLocation;

    private FindRemover findRemover;
    
    /** 
     * returns the shared SearchFactory.
     * 
     * @return
     */
    public static SearchFactory getInstance() {
          if (searchFactory == null) {
              searchFactory = new SearchFactory();
          }
          return searchFactory;
      }
    
    /**
     * sets the shared SearchFactory.
     * 
     * @param factory
     */
    public static void setInstance(SearchFactory factory) {
        searchFactory = factory;
    }
    
    /**
     * Shows an appropriate find widget targeted at the searchable.
     * This implementation opens a batch-find or incremental-find 
     * widget based on the showFindInToolBar property (which defaults
     * to false).
     *  
     *  
     * @param target - the component associated with the searchable
     * @param searchable - the object to search.
     */
    public void showFindInput(JComponent target, Searchable searchable) {
        if (isUseFindBar(target, searchable)) {
            showFindBar(target, searchable);
        } else {
            showFindDialog(target, searchable);
        }
    }

    /**
     * Show a incremental-find widget targeted at the searchable.
     * 
     * This implementation uses a JXFindBar and inserts it into the
     * target's toplevel container toolbar. 
     * 
     * PENDING: Nothing shown if there is no toolbar found. 
     * 
     * @param target - the component associated with the searchable
     * @param searchable - the object to search.
     */
    public void showFindBar(JComponent target, Searchable searchable) {
        if (target == null) return;
        removeFromParent(getSharedFindBar());
        Window topLevel = SwingUtilities.getWindowAncestor(target);
        if (topLevel instanceof JXFrame) {
            JXRootPane rootPane = ((JXFrame) topLevel).getRootPaneExt();
            JToolBar toolBar = rootPane.getToolBar();
            if (toolBar == null) {
                toolBar = new JToolBar();
                rootPane.setToolBar(toolBar);
            }
            toolBar.add(getSharedFindBar(), 0);
            rootPane.revalidate();
            KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent(getSharedFindBar());
            
        }
        target.putClientProperty(AbstractSearchable.MATCH_HIGHLIGHTER, Boolean.TRUE);
        installFindRemover(target, getSharedFindBar());
        getSharedFindBar().setSearchable(searchable);
    }

    protected void installFindRemover(Container target, Container findWidget) {
        if (target != null) {
            getFindRemover().addTarget(target);
        }
        getFindRemover().addTarget(findWidget);
    }
    private FindRemover getFindRemover() {
        if (findRemover == null) {
            findRemover = new FindRemover();
        }
        return findRemover;
    }

    /**
     * convenience method to remove a component from its parent
     * and revalidate the parent
     */
    protected void removeFromParent(JComponent component) {
        Container oldParent = component.getParent();
        if (oldParent != null) {
            oldParent.remove(component);
            if (oldParent instanceof JComponent) {
                ((JComponent) oldParent).revalidate();
            } else {
                // not sure... never have non-j comps
                oldParent.invalidate();
                oldParent.validate();
            }
        }
    }

    /**
     * returns the shared JXFindBar. Creates and configures on 
     * first call.
     * @return
     */
    public JXFindBar getSharedFindBar() {
        if (findBar == null) {
            findBar = createFindBar();
            configureSharedFindBar();
        }
        return findBar;
    }
    
    /**
     * called after creation of shared FindBar.
     * Subclasses can add configuration code. 
     * Here: registers a custom action to remove the 
     * findbar from its ancestor container.
     * 
     * PRE: findBar != null.
     *
     */
    protected void configureSharedFindBar() {
        Action removeAction = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                removeFromParent(findBar);
//                stopSearching();
                
            }
            
        };
        findBar.getActionMap().put(JXDialog.CLOSE_ACTION_COMMAND, removeAction);
    }

    /**
     * Factory method to create a JXFindBar.
     * 
     * @return
     */
    public JXFindBar createFindBar() {
        return new JXFindBar();
    }


    /**
     * returns the shared JXFindPanel. Creates and configures on 
     * first call.
     * @return
     */
    public JXFindPanel getSharedFindPanel() {
        if (findPanel == null) {
            findPanel = createFindPanel();
            configureSharedFindPanel();
        }
        return findPanel;
    }
    
    /**
     * called after creation of shared FindPanel.
     * Subclasses can add configuration code. 
     * Here: no-op
     * PRE: findPanel != null.
     *
     */
    protected void configureSharedFindPanel() {
    }

    /**
     * Factory method to create a JXFindPanel.
     * 
     * @return
     */
    public JXFindPanel createFindPanel() {
        return new JXFindPanel();
    }


    /**
     * Show a batch-find widget targeted at the given Searchable.
     * 
     * This implementation uses a shared JXFindPanel contained 
     * JXDialog.
     * 
     * @param target -
     *            the component associated with the searchable
     * @param searchable -
     *            the object to search.
     */
    public void showFindDialog(JComponent target, Searchable searchable) {
        Frame frame = JOptionPane.getRootFrame();
        if (target != null) {
            target.putClientProperty(AbstractSearchable.MATCH_HIGHLIGHTER, Boolean.FALSE);
            Window window = SwingUtilities.getWindowAncestor(target);
            if (window instanceof Frame) {
                frame = (Frame) window;
            }
        }
        JXDialog topLevel = getDialogForSharedFilePanel();
        JXDialog findDialog;
        if ((topLevel != null) && (topLevel.getOwner().equals(frame))) {
            findDialog = topLevel;
            KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent(findDialog);
        } else {
            Point location = hideSharedFilePanel();
            findDialog = new JXDialog(frame, getSharedFindPanel());
            findDialog.setAlwaysOnTop(true);
            findDialog.pack();
            if (location == null) {
                findDialog.setLocationRelativeTo(frame);
            } else {
                findDialog.setLocation(location);
            }
        } 
        
        findDialog.setVisible(true);
        installFindRemover(target, findDialog);
        getSharedFindPanel().setSearchable(searchable);
    }

    
    private JXDialog getDialogForSharedFilePanel() {
        if (findPanel == null) return null;
        Window window = SwingUtilities.getWindowAncestor(findPanel);
        return (window instanceof JXDialog) ? (JXDialog) window : null;
    }

    protected Point hideSharedFilePanel() {
        if (findPanel == null) return null;
        Window window = SwingUtilities.getWindowAncestor(findPanel);
        Point location = lastFindDialogLocation;
        if (window != null) {
            findPanel.getParent().remove(findPanel);
            if (window.isVisible()) {
                location = window.getLocationOnScreen();
            }
            window.dispose();
        }
        return location;
    }

    protected void stopSearching() {
        if (findPanel != null) {
            lastFindDialogLocation = hideSharedFilePanel();
            findPanel.setSearchable(null);
        }
        if (findBar != null) {
            removeFromParent(findBar);
            findBar.setSearchable(null);
        }
        
    }

    /**
     * Returns decision about using a batch- vs. incremental-find for the
     * searchable. This implementation returns the useFindBar property
     * directly.
     * 
     * @param target -
     *            the component associated with the searchable
     * @param searchable -
     *            the object to search.
     * @return true if a incremental-find should be used, false otherwise.
     */
    public boolean isUseFindBar(JComponent target, Searchable searchable) {
        return useFindBar;
    }
 
    /**
     * 
     * @param inToolBar
     */
    public void setUseFindBar(boolean inToolBar) {
        if (inToolBar == useFindBar) return;
        this.useFindBar = inToolBar;
        getFindRemover().endSearching();
    }

    public class FindRemover implements PropertyChangeListener {
        KeyboardFocusManager focusManager;
        Set<Container> targets;
        
        public FindRemover() {
            updateManager();
        }

        public void addTarget(Container target) {
            getTargets().add(target);
        }
        
        public void removeTarget(Container target) {
            getTargets().remove(target);
        }
        
        private Set<Container> getTargets() {
            if (targets == null) {
                targets = new HashSet<Container>();
            }
            return targets;
        }

        /**
         * 
         */
        private void updateManager() {
            if (focusManager != null) {
                focusManager.removePropertyChangeListener("permanentFocusOwner", this);
            }
            this.focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            focusManager.addPropertyChangeListener("permanentFocusOwner", this);
        }

        public void propertyChange(PropertyChangeEvent ev) {

            Component c = focusManager.getPermanentFocusOwner();
            if (c == null) return;
            for (Iterator<Container> iter = getTargets().iterator(); iter.hasNext();) {
                Container element = iter.next();
                if ((element == c) || (SwingUtilities.isDescendingFrom(c, element))) {
                    return;
                }
            }
            endSearching();
       }

        /**
         * 
         */
        public void endSearching() {
            getTargets().clear();
            stopSearching();
        }
    }

}
