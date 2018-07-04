/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.View;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import panola.Controller.SubjectController;
import panola.Controller.TeacherController;
import panola.Controller.TimeTableController;
import panola.model.Timetable;
import panola.other.Methods;

/**
 *
 * @author Yasiru
 */
public class TimeTableInternal extends javax.swing.JInternalFrame {

    DefaultTableModel dtm;

    /**
     * Creates new form TimeTableInternal
     */
    public TimeTableInternal() {
        initComponents();
        try {
            Methods.fillBatchCombo(batchCombo);
            fillTimeTableOfDay();
            fillTimeTableOfAll();
            Methods.fillBatchCombo(batchCombo1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeTableInternal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TimeTableInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        timeTableOfDay = new javax.swing.JTable();
        addToTimeTableButton = new javax.swing.JButton();
        dayComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        batchCombo = new javax.swing.JComboBox();
        categoryCobo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        timeCombo = new javax.swing.JComboBox();
        removeButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        timeTableAllTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        dayComboBox1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        batchCombo1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        categoryCobo1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        timeCombo1 = new javax.swing.JComboBox();
        removeButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Day");

        timeTableOfDay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Batch", "Subject Name", "Category", "Teacher Name", "Starting Time"
            }
        ));
        jScrollPane1.setViewportView(timeTableOfDay);

        addToTimeTableButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addToTimeTableButton.setText("Add to Time Table");
        addToTimeTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToTimeTableButtonActionPerformed(evt);
            }
        });

        dayComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        dayComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dayComboBoxItemStateChanged(evt);
            }
        });
        dayComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Batch");

        batchCombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        categoryCobo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        categoryCobo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theory", "Revision" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Category");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Strating Time");

        timeCombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        timeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00 AM", "08:30 AM", "09:00 AM", "09:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "01:00 PM", "01:30 PM", "02:00 PM", "02:30 PM", "03:00 PM", "03:30 PM", "04:00 PM", "04:30 PM", "05:00 PM" }));

        removeButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryCobo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(timeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(addToTimeTableButton)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(removeButton)
                        .addGap(104, 104, 104))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(batchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(categoryCobo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(addToTimeTableButton)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeButton)
                .addGap(325, 325, 325))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("   Date    ", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        timeTableAllTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Batch", "Subject Name", "Category", "Teacher Name", "Day", "Starting Time"
            }
        ));
        jScrollPane3.setViewportView(timeTableAllTable);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("Add to Time Table");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Day");

        dayComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dayComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        dayComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dayComboBox1ItemStateChanged(evt);
            }
        });
        dayComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayComboBox1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Batch");

        batchCombo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Category");

        categoryCobo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        categoryCobo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theory", "Revision" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Strating Time");

        timeCombo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        timeCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00 AM", "08:30 AM", "09:00 AM", "09:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "01:00 PM", "01:30 PM", "02:00 PM", "02:30 PM", "03:00 PM", "03:30 PM", "04:00 PM", "04:30 PM", "05:00 PM" }));

        removeButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        removeButton1.setText("Remove");
        removeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(batchCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categoryCobo1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dayComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(timeCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(removeButton1)
                        .addGap(65, 65, 65))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batchCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryCobo1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButton4)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(removeButton1)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("    All    ", jPanel3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Select type to search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addToTimeTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToTimeTableButtonActionPerformed
        
        String Batch = batchCombo.getSelectedItem().toString();
        String category = categoryCobo.getSelectedItem().toString();
        String Time = timeCombo.getSelectedItem().toString();
        String day = dayComboBox.getSelectedItem().toString();
        String TeacherID;
        try {
            String SubjectID = SubjectController.getSubjectID(AddASubject.subjectNametext.getText());
            TeacherID = TeacherController.getID(AddASubject.teacherNameCombo.getSelectedItem().toString());
            dtm = (DefaultTableModel) timeTableOfDay.getModel();
            Object[] ob = {Batch, SubjectController.getSubjectName(SubjectID), category, TeacherController.getTeachername(TeacherID), Time};
            dtm.addRow(ob);
            addTimeTableTable(SubjectID, TeacherID, Batch, category, day, Time);
            fillTimeTableOfAll();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeTableInternal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Please Add Subject First");
        }


    }//GEN-LAST:event_addToTimeTableButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (dtm.getRowCount() != -1) {
            String Day = dayComboBox.getSelectedItem().toString();
                String SubjectID;
            try {
                SubjectID = SubjectController.getSubjectID((String) timeTableOfDay.getValueAt(timeTableOfDay.getSelectedRow(), 1));
                String Batch = (String) timeTableOfDay.getValueAt(timeTableOfDay.getSelectedRow(), 0);
                String Category = (String) timeTableOfDay.getValueAt(timeTableOfDay.getSelectedRow(), 2);
                String time = (String) timeTableOfDay.getValueAt(timeTableOfDay.getSelectedRow(), 4);
                int res = TimeTableController.delectDetails(SubjectID, Batch, Day, Category, time);
                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "Deleted Sucsses");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TimeTableInternal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TimeTableInternal.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            dtm.removeRow(timeTableOfDay.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(this, "Please Se;ect a Raw");
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void dayComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayComboBoxActionPerformed

    private void dayComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dayComboBoxItemStateChanged
        try {
            fillTimeTableOfDay();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeTableInternal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TimeTableInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dayComboBoxItemStateChanged

    private void dayComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dayComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dayComboBox1ItemStateChanged

    private void dayComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String Year = batchCombo1.getSelectedItem().toString();
        
        String Category = categoryCobo1.getSelectedItem().toString();
        String TeacherID;
        try {
            String SubjectID = SubjectController.getSubjectID(AddASubject.subjectNametext.getText());
            TeacherID = TeacherController.getID(AddASubject.teacherNameCombo.getSelectedItem().toString());
            String Day = dayComboBox1.getSelectedItem().toString();
            String Time = timeCombo1.getSelectedItem().toString();
            dtm = (DefaultTableModel) timeTableAllTable.getModel();
            Object[] ob = {Year, SubjectID, Category, TeacherID, Day, Time, 0};
            dtm.addRow(ob);
            addTimeTableTable(SubjectID, TeacherID, Year, Category, Day, Time);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeTableInternal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TimeTableInternal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void removeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButton1ActionPerformed
        if (dtm.getRowCount() != -1) {
            String Day = (String) timeTableAllTable.getValueAt(timeTableAllTable.getSelectedRow(), 0);
            try {
                String SubjectID = SubjectController.getSubjectID((String) timeTableAllTable.getValueAt(timeTableAllTable.getSelectedRow(), 1));
                String Batch = (String) timeTableAllTable.getValueAt(timeTableAllTable.getSelectedRow(), 3);
                String Category = (String) timeTableAllTable.getValueAt(timeTableAllTable.getSelectedRow(), 4);
                String time = (String) timeTableAllTable.getValueAt(timeTableAllTable.getSelectedRow(), 5);
                int res = TimeTableController.delectDetails(SubjectID, Batch, Day, Category, time);
                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "Deleted Sucsses");
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
            }
            dtm.removeRow(timeTableAllTable.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(this, "Please Se;ect a Raw");
        }
    }//GEN-LAST:event_removeButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToTimeTableButton;
    private javax.swing.JComboBox batchCombo;
    private javax.swing.JComboBox batchCombo1;
    private javax.swing.JComboBox categoryCobo;
    private javax.swing.JComboBox categoryCobo1;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JComboBox dayComboBox1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton removeButton1;
    private javax.swing.JComboBox timeCombo;
    private javax.swing.JComboBox timeCombo1;
    private javax.swing.JTable timeTableAllTable;
    private javax.swing.JTable timeTableOfDay;
    // End of variables declaration//GEN-END:variables

    private void fillTimeTableOfDay() throws ClassNotFoundException, SQLException {
        String Day = dayComboBox.getSelectedItem().toString();
        ArrayList<Timetable> timeTableDetails = TimeTableController.getDateDetails(Day);
        dtm = (DefaultTableModel) timeTableOfDay.getModel();
        dtm.setRowCount(0);
        for (Timetable timeTable : timeTableDetails) {
            Object[] ob = {timeTable.getSubjectID(), timeTable.getTeacherID(), timeTable.getYear(), timeTable.getCategory(), timeTable.getTime()};
            dtm.addRow(ob);
        }
    }

    private void fillTimeTableOfAll() throws ClassNotFoundException, SQLException {
        ArrayList<Timetable> timetableDetails = TimeTableController.getAllDetails();
        dtm = (DefaultTableModel) timeTableAllTable.getModel();
        dtm.setRowCount(0);
        for (Timetable timeTable : timetableDetails) {
            Object[] ob = {timeTable.getSubjectID(), timeTable.getTeacherID(), timeTable.getYear(), timeTable.getCategory(), timeTable.getDate(), timeTable.getTime()};
            dtm.addRow(ob);
        }
    }

    private void addTimeTableTable(String SubjectName, String TeacherName, String Batch, String category, String day, String Time) {
        Timetable timetable = new Timetable(SubjectName, TeacherName, Batch, category, day, Time);
        try {
            int res = TimeTableController.addDetails(timetable);
            if (res > 0) {
                JOptionPane.showMessageDialog(this, "Add Details Successfully");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeTableInternal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TimeTableInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}