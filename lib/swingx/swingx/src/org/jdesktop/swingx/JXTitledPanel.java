/*
 * $Id: JXTitledPanel.java,v 1.17 2005/10/12 11:26:53 kleopatra Exp $
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import org.jdesktop.swingx.plaf.JXTitledPanelAddon;
import org.jdesktop.swingx.plaf.LookAndFeelAddons;
import org.jdesktop.swingx.plaf.TitledPanelUI;

/**
 * A special type of Panel that has a Title section and a Content section.<br>
 * The following 3 properties can be set with the UIManager to change the look
 * and feel of the JXTitledPanel:
 * <ul>
 * <li>JXTitledPanel.title.foreground</li>
 * <li>JXTitledPanel.title.background</li>
 * <li>JXTitledPanel.title.font</li>
 * </ul>
 * 
 * @author Richard Bair
 * @author Nicola Ken Barozzi
 * @author Jeanette Winzenburg
 */
public class JXTitledPanel extends JXPanel {

    /**
     * @see #getUIClassID // *
     * @see #readObject
     */
    static public final String uiClassID = "TitledPanelUI";

    public static final String LEFT_DECORATION = "JXTitledPanel.leftDecoration";

    public static final String RIGHT_DECORATION = "JXTitledPanel.rightDecoration";

    /**
     * Initialization that would ideally be moved into various look and feel
     * classes.
     */
    static {
        LookAndFeelAddons.contribute(new JXTitledPanelAddon());
    }

    /**
     * The text to use for the title
     */
    private String title = "";

    /**
     * The Font to use for the Title
     */
    private Font titleFont;

    /**
     * For the gradient, this is the background color to use for the dark part
     * of the gradient
     */
    private Color titleDarkBackground;

    /**
     * For the gradient, this is the light color to use for the light part of
     * the gradient
     */
    private Color titleLightBackground;

    /**
     * The forground color to use for the Title (particularly for the text)
     */
    private Color titleForeground;

    /**
     * The ContentPanel. Whatever this container is will be displayed in the
     * Content section
     */
    private Container contentPanel;

    /**
     * Create a new JTitledPanel with an empty string for the title.
     */
    public JXTitledPanel() {
        this("");
    }

    /**
     * Create a new JTitledPanel with the given title as the title for the
     * panel.
     * 
     * @param title
     */
    public JXTitledPanel(String title) {
        this(title, new JXPanel());
    }

    /**
     * Create a new JTitledPanel with the given String as the title, and the
     * given Container as the content panel.
     * 
     * @param title
     * @param content
     */
    public JXTitledPanel(String title, Container content) {
        setTitle(title);
        setContentContainer(content);
    }

    /**
     * Returns the look and feel (L&F) object that renders this component.
     * 
     * @return the TitledPanelUI object that renders this component
     * @since 1.4
     */
    public TitledPanelUI getUI() {
        return (TitledPanelUI) ui;
    }

    /**
     * Sets the look and feel (L&F) object that renders this component.
     * 
     * @param ui
     *            the TitledPanelUI L&F object
     * @see javax.swing.UIDefaults#getUI
     * @since 1.4
     * @beaninfo bound: true hidden: true attribute: visualUpdate true
     *           description: The UI object that implements the Component's
     *           LookAndFeel.
     */
    public void setUI(TitledPanelUI ui) {
        super.setUI(ui);
    }

    /**
     * Returns a string that specifies the name of the L&F class that renders
     * this component.
     * 
     * @return "TitledPanelUI"
     * @see JComponent#getUIClassID
     * @see javax.swing.UIDefaults#getUI
     * @beaninfo expert: true description: A string that specifies the name of
     *           the L&F class.
     */
    public String getUIClassID() {
        return uiClassID;
    }

    /**
     * Notification from the <code>UIManager</code> that the L&F has changed.
     * Replaces the current UI object with the latest version from the
     * <code>UIManager</code>.
     * 
     * @see javax.swing.JComponent#updateUI
     */
    public void updateUI() {
        setUI((TitledPanelUI) LookAndFeelAddons
                .getUI(this, TitledPanelUI.class));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = (title == null ? "" : title);
        // JW: fix swingx #9 - missing/incorrect notification
        // let standard notification handle
        // NOTE - "getting" the new property in the fire method is
        // intentional: there's no way of missing any transformations
        // on the parameter to set (like above: setting a
        // value depending on whether the input is null).
        firePropertyChange("title", oldTitle, getTitle());
    }

    public Container getContentContainer() {
        if (contentPanel == null) {
            contentPanel = new JXPanel();
            ((JXPanel) contentPanel).setBorder(BorderFactory
                    .createEmptyBorder());
            this.add(contentPanel, BorderLayout.CENTER);
        }
        return contentPanel;
    }

    public void setContentContainer(Container contentPanel) {
        if (this.contentPanel != null) {
            remove(this.contentPanel);
        }
        add(contentPanel, BorderLayout.CENTER);
        this.contentPanel = contentPanel;
    }

    /**
     * Adds the given JComponent as a decoration on the right of the title
     * 
     * @param decoration
     */
    public void addRightDecoration(JComponent decoration) {
        getUI().addRightDecoration(decoration);
    }

    /**
     * Adds the given JComponent as a decoration on the left of the title
     * 
     * @param decoration
     */
    public void addLeftDecoration(JComponent decoration) {
        getUI().addLeftDecoration(decoration);
    }

    public Font getTitleFont() {
        return titleFont;
    }

    public void setTitleFont(Font titleFont) {
        Font old = getTitleFont();
        this.titleFont = titleFont;
        firePropertyChange("titleFont", old, getTitleFont());
    }

    public Color getTitleDarkBackground() {
        return titleDarkBackground;
    }

    public void setTitleDarkBackground(Color titleDarkBackground) {
        Color old = getTitleDarkBackground();
        this.titleDarkBackground = titleDarkBackground;
        firePropertyChange("titleDarkBackground", old, getTitleDarkBackground());
    }

    public Color getTitleLightBackground() {
        return titleLightBackground;
    }

    public void setTitleLightBackground(Color titleLightBackground) {
        Color old = getTitleLightBackground();
        this.titleLightBackground = titleLightBackground;
        firePropertyChange("titleLightBackground", old,
                getTitleLightBackground());
    }

    public Color getTitleForeground() {
        return titleForeground;
    }

    public void setTitleForeground(Color titleForeground) {
        Color old = getTitleForeground();
        this.titleForeground = titleForeground;
        firePropertyChange("titleForeground", old, getTitleForeground());
    }

}