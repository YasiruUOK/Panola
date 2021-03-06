/*
 * JXGlassBoxDemoPanel.java
 *
 * Created on April 18, 2005, 4:20 PM
 */

package org.jdesktop.demo.swingx;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import org.jdesktop.demo.DemoPanel;
import org.jdesktop.swingx.border.DropShadowBorder;

/**
 * Demonstrates the JXGlassBox component.
 *
 * @author  rbair
 */
public class JXGlassBoxDemoPanel extends DemoPanel {
    
    /** Creates new form JXGlassBoxDemoPanel */
    public JXGlassBoxDemoPanel() {
        setName("JXGlassBox Demo");
        initComponents();
    }

    public String getHtmlDescription() {
        return "<html>Click on the button to show the JXGlassBox, then click on the " +
                "glass box to dismiss it. This shows how a glass box can be used for a pop-up " +
                "message in your application.<br>This demo also showcases the DropShadowBorder.</html>";
    }

    public String getName() {
        return "Glass Boxes";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jXGlassBox1 = new org.jdesktop.swingx.JXGlassBox();
        jLabel1 = new javax.swing.JLabel();
        showGlassBoxBtn = new javax.swing.JButton();

        jXGlassBox1.setLayout(new java.awt.BorderLayout());

        JLabel lbl = new JLabel("<html><i>Please click to dismiss...</i></html>");
        jXGlassBox1.add(lbl);
        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html><c><i>Click to hide this panel (ie, dismiss)</c></i></html>");
        jLabel1.setOpaque(true);
        jXGlassBox1.add(jLabel1, java.awt.BorderLayout.CENTER);

        setLayout(new java.awt.GridBagLayout());

        showGlassBoxBtn.setText("Make GlassBox Visible");
        showGlassBoxBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGlassBoxBtnActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 11, 11);
        add(showGlassBoxBtn, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents

    private void showGlassBoxBtnActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGlassBoxBtnActionPerformed
        Container glassPane = (Container)getRootPane().getGlassPane();
        // Only allow one message box to be visible at a time so
        // pop down any visible message boxes
        Component glassPaneChildren[] = glassPane.getComponents();
        for(int i = 0; i < glassPaneChildren.length; i++) {
            glassPaneChildren[i].setVisible(false);
            glassPane.remove(glassPaneChildren[i]);
        }
        Point p = SwingUtilities.convertPoint(this, showGlassBoxBtn.getX(), showGlassBoxBtn.getY(), null);
        jXGlassBox1.setBorder(new DropShadowBorder());
        jXGlassBox1.showOnGlassPane(glassPane, p.x, p.y);
    }//GEN-LAST:event_showGlassBoxBtnActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private org.jdesktop.swingx.JXGlassBox jXGlassBox1;
    private javax.swing.JButton showGlassBoxBtn;
    // End of variables declaration//GEN-END:variables
    
}
