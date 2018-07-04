/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.View;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.Popup;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXLabel;
import panola.Controller.SubjectController;
import panola.Controller.TeacherController;
import panola.Controller.TimeTableController;
import panola.model.Timetable;
import panola.other.Methods;

/**
 *
 * @author Yasiru
 */
public class UpdateSubjectDetails extends javax.swing.JFrame {
    DefaultTableModel dtm;    /**
     * Creates new form UserLogin
     */
    public UpdateSubjectDetails() {
        initComponents();
        //ImageIcon imageIcon=new ImageIcon("./src/panola/images/insegnare-assistente-italiano-estero-austria-vienna (Custom).png");
        //jXImagePanel1.setImage(imageIcon.getImage());
        setDateAndTime();
        try {
            Methods.fillBatchCombo(batchCombo);
            Methods.fillSubjectCombo(subjectNameCombo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fillTable();
            fillClassFeeText();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
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

        studentPopupMenu = new javax.swing.JPopupMenu();
        newStudent = new javax.swing.JMenuItem();
        viewStudent = new javax.swing.JMenuItem();
        subjectPopupMenu = new javax.swing.JPopupMenu();
        newSubject = new javax.swing.JMenuItem();
        viewSubject = new javax.swing.JMenuItem();
        jXImagePanel1 = new org.jdesktop.swingx.JXImagePanel();
        jLabel2 = new javax.swing.JLabel();
        TimeLable = new javax.swing.JLabel();
        dateLable = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        subjectNameCombo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        batchCombo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        categoryCombo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dayCombo = new javax.swing.JComboBox();
        timeCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        classFeeText = new javax.swing.JTextField();
        changeClassFeeButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        dissmissButton = new javax.swing.JButton();

        studentPopupMenu.setAlignmentX(1000.0F);
        studentPopupMenu.setAlignmentY(1000.0F);
        studentPopupMenu.setEnabled(false);

        newStudent.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        newStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panola/images/1417001539_add_48 (Custom).png"))); // NOI18N
        newStudent.setText("New");
        newStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newStudentMouseClicked(evt);
            }
        });
        newStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStudentActionPerformed(evt);
            }
        });
        studentPopupMenu.add(newStudent);

        viewStudent.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        viewStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panola/images/1417001562_search_48 (Custom).png"))); // NOI18N
        viewStudent.setText("View Details");
        viewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStudentActionPerformed(evt);
            }
        });
        studentPopupMenu.add(viewStudent);

        subjectPopupMenu.setAlignmentX(-1000.0F);
        subjectPopupMenu.setAlignmentY(-1000.0F);

        newSubject.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panola/images/1417001539_add_48 (Custom).png"))); // NOI18N
        newSubject.setText("New");
        subjectPopupMenu.add(newSubject);

        viewSubject.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        viewSubject.setText("View");
        subjectPopupMenu.add(viewSubject);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Panola Institute Of Education");

        jXImagePanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel2.setText("Update Subject Details");

        TimeLable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TimeLable.setText("jLabel4");

        dateLable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateLable.setText("jLabel4");

        jSeparator1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Subject Name");

        subjectNameCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        subjectNameCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                subjectNameComboItemStateChanged(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Batch", "Category", "Day", "Time"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(204, 0, 204))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Batch");

        batchCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        batchCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Category");

        categoryCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        categoryCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Revision", "Group" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Day");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Time");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Add to Time Table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        dayCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dayCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));

        timeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00 AM", "08:30 AM", "09:00 AM", "09:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "01:00 PM", "01:30 PM", "02:00 PM", "02:30 PM", "03:00 PM", "03:30 PM", "04:00 PM", "04:30 PM", "05:00 PM" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Class Fee");

        classFeeText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        classFeeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classFeeTextActionPerformed(evt);
            }
        });
        classFeeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                classFeeTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                classFeeTextKeyReleased(evt);
            }
        });

        changeClassFeeButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        changeClassFeeButton.setText("Change Class Fee");
        changeClassFeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeClassFeeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(batchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(changeClassFeeButton)
                .addGap(730, 730, 730))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(267, 267, 267))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(batchCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dayCombo, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(timeCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(classFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(changeClassFeeButton)
                        .addContainerGap())))
        );

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panola/images/home (Custom).jpg"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        dissmissButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dissmissButton.setText("Dismiss");
        dissmissButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dissmissButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel1Layout = new javax.swing.GroupLayout(jXImagePanel1);
        jXImagePanel1.setLayout(jXImagePanel1Layout);
        jXImagePanel1Layout.setHorizontalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLable, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dissmissButton)
                .addGap(557, 557, 557))
            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(subjectNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jXImagePanel1Layout.setVerticalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dissmissButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addComponent(TimeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLable, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newStudentMouseClicked
     
    }//GEN-LAST:event_newStudentMouseClicked

    private void newStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStudentActionPerformed
        AddAStudent addAStudent=new AddAStudent();
        addAStudent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newStudentActionPerformed

    private void viewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStudentActionPerformed
        ViewStudentDetails viewStudentDetails=new ViewStudentDetails();
        viewStudentDetails.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewStudentActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MainWindow mainWindow=new MainWindow();
        mainWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void subjectNameComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_subjectNameComboItemStateChanged
        try {
            fillTable();
            fillClassFeeText();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_subjectNameComboItemStateChanged

    private void classFeeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classFeeTextActionPerformed
        changeClassFeeButton.doClick();
    }//GEN-LAST:event_classFeeTextActionPerformed

    private void classFeeTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_classFeeTextKeyPressed
        Methods.DigitsOnly(classFeeText);
    }//GEN-LAST:event_classFeeTextKeyPressed

    private void changeClassFeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeClassFeeButtonActionPerformed
        try {
            String SubjectID=SubjectController.getSubjectID(subjectNameCombo.getSelectedItem().toString());
            String Fee=classFeeText.getText();
            int res=SubjectController.changeFee(SubjectID,Fee);
            if(res>0){
                JOptionPane.showMessageDialog(this, "Class Fee Changed");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_changeClassFeeButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Batch=batchCombo.getSelectedItem().toString();
        String Category=categoryCombo.getSelectedItem().toString();
        String Day=dayCombo.getSelectedItem().toString();
        String Time=timeCombo.getSelectedItem().toString();
        /*Object[] rawData={Batch,Category,Day,Time};
        dtm.addRow(rawData);*/
        try {
            String TeacherID=TeacherController.getTeacherID(subjectNameCombo.getSelectedItem().toString());
            Timetable timetable=new Timetable(SubjectController.getSubjectID(subjectNameCombo.getSelectedItem().toString()), TeacherID, Batch, Category, Day, Time);
            int res=TimeTableController.addDetails(timetable);
            if(res>0){
                JOptionPane.showMessageDialog(this, "Added Success");
                fillTable();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "This is added Erlier");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dissmissButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dissmissButtonActionPerformed
        dtm=(DefaultTableModel) table.getModel();
        if(table.getSelectedRow()!=-1){
            try {
                String SubjectID=SubjectController.getSubjectID(subjectNameCombo.getSelectedItem().toString());
                String Year=(String) table.getValueAt(table.getSelectedRow(), 0);
                String Category=(String) table.getValueAt(table.getSelectedRow(), 1);
                String Day=(String) table.getValueAt(table.getSelectedRow(), 2);
                String Time=(String) table.getValueAt(table.getSelectedRow(),3);
                int res=TimeTableController.delectDetails(SubjectID, Year, Day, Category, Time);
                if(res>0){
                    JOptionPane.showMessageDialog(this, "Delect Success");
                    fillTable();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Please Select a Raw");
        }
    }//GEN-LAST:event_dissmissButtonActionPerformed

    private void classFeeTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_classFeeTextKeyReleased
        Methods.DigitsOnly(classFeeText);
    }//GEN-LAST:event_classFeeTextKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateSubjectDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateSubjectDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateSubjectDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateSubjectDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateSubjectDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TimeLable;
    private javax.swing.JComboBox batchCombo;
    private javax.swing.JComboBox categoryCombo;
    private javax.swing.JButton changeClassFeeButton;
    private javax.swing.JTextField classFeeText;
    private javax.swing.JLabel dateLable;
    private javax.swing.JComboBox dayCombo;
    private javax.swing.JButton dissmissButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel1;
    private javax.swing.JMenuItem newStudent;
    private javax.swing.JMenuItem newSubject;
    private javax.swing.JPopupMenu studentPopupMenu;
    private javax.swing.JComboBox subjectNameCombo;
    private javax.swing.JPopupMenu subjectPopupMenu;
    private javax.swing.JTable table;
    private javax.swing.JComboBox timeCombo;
    private javax.swing.JMenuItem viewStudent;
    private javax.swing.JMenuItem viewSubject;
    // End of variables declaration//GEN-END:variables

    private void setDateAndTime() {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
        String formetedDate=simpleDateFormat.format(date);
        dateLable.setText(formetedDate);
        
        Thread t1=new Thread(){

            @Override
            public void run() {
                while(true){
                    Date date=new Date();
                    SimpleDateFormat simpleTimeFormat=new SimpleDateFormat("hh:mm:ss a");
                    String formatedTime=simpleTimeFormat.format(date);
                    TimeLable.setText(formatedTime);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UpdateSubjectDetails.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        };
        t1.start();
    }

    private void setBackgroundColourMouseEnter(JXLabel Label) {
        Label.setBackground(Color.white);
    }

    private void setBackgroundColourMouseExit(JXLabel Label) {
        Label.setBackgroundPainter(null);
    }

    private void showPopupMenu(MouseEvent evt) {
        studentPopupMenu.show(this, evt.getX(), evt.getY());
    }

    private void formMousePressed(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            showPopupMenu(evt);
        }
    }

    private void formMouseReleased(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            showPopupMenu(evt);
        }
    }

    private void showTimeTabelPopupMenu(MouseEvent evt) {
        subjectPopupMenu.show(this, evt.getX(), evt.getY());
    }

    private void fillTable() throws ClassNotFoundException, SQLException {
        ArrayList<Timetable> timeTables=TimeTableController.getSubjectDetails(subjectNameCombo.getSelectedItem().toString());
        dtm=(DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        for (Timetable timeTable : timeTables) {
            Object[] ob={timeTable.getYear(),timeTable.getCategory(),timeTable.getDate(),timeTable.getTime()};
            dtm.addRow(ob);
        }
    }

    private void fillClassFeeText() throws ClassNotFoundException, SQLException {
        String classfee=SubjectController.getClassFee(SubjectController.getSubjectID(subjectNameCombo.getSelectedItem().toString()));
        if(classfee!=null){
            classFeeText.setText(classfee);
        }else{
            JOptionPane.showMessageDialog(this, "No Such Subject");
        }
    }
}
