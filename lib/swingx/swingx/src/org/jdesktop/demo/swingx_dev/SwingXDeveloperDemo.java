/*
 * $Id: SwingXDeveloperDemo.java,v 1.13 2005/06/24 13:20:03 kleopatra Exp $
 *
 * Copyright 2004 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 */

package org.jdesktop.demo.swingx_dev;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jdesktop.demo.DemoPanel;
import org.jdesktop.demo.MainWindow;
import org.jdesktop.demo.swingx.DecoratorDemoPanel;
import org.jdesktop.demo.swingx.JXHyperlinkDemoPanel;
import org.jdesktop.demo.swingx.JXTableDemoPanel;

import com.jgoodies.looks.LookUtils;


/**
 * A JPanel that demonstrates the use of various SwingX components, intended for
 * developers, as some components may not work correctly or may be used in experimental
 * contexts. Each SwingX Component is shown in its own independent panel, and the user
 * can navigate between the different demos from a list.
 *
 * @author  rbair
 */
public class SwingXDeveloperDemo extends DemoPanel {
    private Logger LOG = Logger.getLogger(SwingXDeveloperDemo.class.getName());
    
    /** A List of each component we're demonstrating--all of which are DemoPanel
     * instances. */
    private List<DemoPanel> demoPanels = new ArrayList<DemoPanel>();
    
    /**
     * Creates new form SwingXDemo
     */
    public SwingXDeveloperDemo() {
        demoPanels.add(new JXChooserDemoPanel());
        demoPanels.add(new DevDropShadowBorderPanel());
        demoPanels.add(new JXPanelTranslucencyDemoPanel());
        
        demoPanels.add(new JXHyperlinkDemoPanel());
        demoPanels.add(new DecoratorDemoPanel());
        demoPanels.add(new JXTableDemoPanel());
        initComponents();
        
        // JGoodies: next line is necessary if running in webstart
        UIManager.put("ClassLoader", LookUtils.class.getClassLoader());
        
        LinkedHashMap lnf = new LinkedHashMap();
        lnf.put("Metal", "javax.swing.plaf.metal.MetalLookAndFeel");
        lnf.put("Motif", "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        lnf.put("Windows", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
  //      lnf.put("Synth - GTK", "javax.swing.plaf.synth.SynthLookAndFeel");
        lnf.put("Ocean", "plasticxp");
        lnf.put("{platform}", UIManager.getSystemLookAndFeelClassName());
        lnf.put("{cross-platform}", UIManager.getCrossPlatformLookAndFeelClassName());
        
        lnf.put("JGoodies Windows", "com.jgoodies.looks.windows.WindowsLookAndFeel");
        lnf.put("JGoodies Plastic", "com.jgoodies.looks.plastic.PlasticLookAndFeel");
        lnf.put("JGoodies Plastic XP", "com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
        lnf.put("JGoodies Plastic 3D", "com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
        lnf.put("Kunststoff", "com.incors.plaf.kunststoff.KunststoffLookAndFeel");
        lnf.put("Liquid", "com.birosoft.liquid.LiquidLookAndFeel");
        lnf.put("Napkin", "napkin.NapkinLookAndFeel");
        lnf.put("Substance", "org.jvnet.substance.SubstanceLookAndFeel");
        lnfList.setModel(new MappedComboBoxModel(lnf));
        lnfList.setSelectedItem("{platform}");
        changePLAF();
    }
    
    private static Logger getLogger() { return Logger.getLogger(SwingXDeveloperDemo.class.getName()); }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionPane = new javax.swing.JEditorPane();
        demoContainer = new org.jdesktop.swingx.JXTitledPanel();
        jXTitledPanel3 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        demoList = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lnfList = new javax.swing.JComboBox();
        applyLnF = new javax.swing.JButton();
        priorPLAF = new javax.swing.JButton();
        nextPLAF = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(200);
        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(175);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jXTitledPanel1.getContentContainer().setLayout(new java.awt.BorderLayout());

        jXTitledPanel1.setTitle("Information");
        jScrollPane2.setBorder(null);
        descriptionPane.setEditable(false);
        descriptionPane.setContentType("text/html");
        jScrollPane2.setViewportView(descriptionPane);

        jXTitledPanel1.getContentContainer().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitPane2.setLeftComponent(jXTitledPanel1);

        demoContainer.getContentContainer().setLayout(new java.awt.CardLayout());

        demoContainer.setTitle("Demo");
        jSplitPane2.setRightComponent(demoContainer);

        jSplitPane1.setRightComponent(jSplitPane2);

        jXTitledPanel3.getContentContainer().setLayout(new java.awt.BorderLayout());

        jXTitledPanel3.setTitle("Table of Contents");
        jScrollPane1.setBorder(null);
        demoList.setModel(new AbstractListModel() {
            public Object getElementAt(int index) {
                return demoPanels.get(index).getName();
            }

            public int getSize() {
                return demoPanels.size();
            }
        });
        demoList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        demoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                demoListValueChanged(evt);
            }
        });

        jScrollPane1.setViewportView(demoList);

        jXTitledPanel3.getContentContainer().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jXTitledPanel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 17, 11);
        add(jSplitPane1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("Look and Feel:");
        jPanel1.add(jLabel1);

        jPanel1.add(lnfList);

        applyLnF.setMnemonic('A');
        applyLnF.setText("Apply");
        applyLnF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyLnFActionPerformed(evt);
            }
        });

        jPanel1.add(applyLnF);

        priorPLAF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/navigation/Back16.gif")));
        priorPLAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priorPLAFActionPerformed(evt);
            }
        });

        jPanel1.add(priorPLAF);

        nextPLAF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/navigation/Forward16.gif")));
        nextPLAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPLAFActionPerformed(evt);
            }
        });

        jPanel1.add(nextPLAF);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(jPanel1, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents
    
    private void priorPLAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorPLAFActionPerformed
        int prior = lnfList.getSelectedIndex() - 1;
        prior = ( prior < 0 ? lnfList.getItemCount() - 1 : prior );
        lnfList.setSelectedIndex(prior);
        changePLAF();
    }//GEN-LAST:event_priorPLAFActionPerformed
    
    private void nextPLAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPLAFActionPerformed
        int next = lnfList.getSelectedIndex() + 1;
        next = ( next == lnfList.getItemCount() ? 0 : next );
        lnfList.setSelectedIndex(next);
        changePLAF();
    }//GEN-LAST:event_nextPLAFActionPerformed
    
    private void applyLnFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyLnFActionPerformed
        changePLAF();
    }//GEN-LAST:event_applyLnFActionPerformed
    
    private void changePLAF() {
        MappedComboBoxModel map = (MappedComboBoxModel)lnfList.getModel();
        String newLNF = (String)map.getValueForSelection();
        
        try {
            UIManager.setLookAndFeel(newLNF);
            JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(this);
            if ( frame != null ) {
                SwingUtilities.updateComponentTreeUI(frame);
                LOG.info("Look and feel changed to " + newLNF);
            }
        } catch ( Exception x ) {
            LOG.warning("Could not change look and feel to '" + newLNF + "': " + x.getMessage());
        }
    }
    
    private void demoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_demoListValueChanged
        DemoPanel dp = demoPanels.get(demoList.getSelectedIndex());
        descriptionPane.setText(dp.getHtmlDescription());
        demoContainer.setContentContainer(dp.getContent());
        SwingUtilities.updateComponentTreeUI(dp.getContent());
        demoContainer.revalidate();
        demoContainer.repaint();
        
        // In the regular SwingX demo, the right component is a titled panel, and
        // we just set contents on that panel--but that doesn't work if we also want
        // to change the plaf dynamically--looks like a titled panel bug (PW 12/05/05)
//        jSplitPane2.setRightComponent(dp.getContents());
//        SwingUtilities.updateComponentTreeUI(dp.getContents());
//        jSplitPane2.resetToPreferredSizes();
        
    }//GEN-LAST:event_demoListValueChanged
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])  {
        try {
            MainWindow.main(new String[]{"-d", SwingXDeveloperDemo.class.getName()});
        } catch ( Exception e ) {
            SwingXDeveloperDemo.getLogger().log(Level.WARNING, "Could not launch demo window and pluggable panel.", e);
        }
    }
    
    public java.io.File getSourceRootDir() {
        try {
            LOG.info("Source root directory: " + getClass().getResource("/sources"));
            return new File(getClass().getResource("/sources").toURI());
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Could not determine source code root directory", e);
            return null;
        }
    }
    
    public javax.swing.Icon getIcon() {
        return null;
    }
    
    public java.awt.Container getContent() {
        return this;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyLnF;
    private org.jdesktop.swingx.JXTitledPanel demoContainer;
    private javax.swing.JList demoList;
    private javax.swing.JEditorPane descriptionPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel3;
    private javax.swing.JComboBox lnfList;
    private javax.swing.JButton nextPLAF;
    private javax.swing.JButton priorPLAF;
    // End of variables declaration//GEN-END:variables
    
    class MappedComboBoxModel extends DefaultComboBoxModel {
        private LinkedHashMap data;
        
        MappedComboBoxModel(LinkedHashMap data) {
            super(new Vector(data.keySet()));
            this.data = data;
        }
        
        public Object getValueForSelection() {
            return data.get(getSelectedItem());
        }
    }
}

