/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.View;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Popup;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.JXLabel;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import panola.Controller.AddmitionController;
import panola.Controller.BatchController;
import panola.Controller.BatchYearController;
import panola.Controller.NICController;
import panola.Controller.PaymentController;
import panola.Controller.SchoolController;
import panola.Controller.StudentAddmissionPaymentController;
import panola.Controller.StudentClassFeeController;
import panola.Controller.StudentController;
import panola.Controller.StudentSubjectBatchDetailsController;
import panola.Controller.SubjectController;
import panola.Controller.TeacherController;
import panola.model.Year;
import panola.model.BatchYear;
import panola.model.NIC;
import panola.model.Payment;
import panola.model.School;
import panola.model.Student;
import panola.model.StudentAddmissionPayment;
import panola.model.StudentBatchSubjectDetails;
import panola.model.StudentClassFeePayment;
import panola.model.StudentSubjectBatch;
import panola.model.Subject;
import panola.other.IDGenarator;
import panola.other.Methods;
import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import panola.Controller.IDController;
import panola.Controller.StudentImageController;
import panola.db.DBConnection;
import panola.model.StudentImage;
import sun.java2d.pipe.DrawImage;

/**
 *
 * @author Yasiru
 */
public class AddAStudent extends javax.swing.JFrame {

    String subjectID1;

    private DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;

    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    BufferedImage buff;
    private Object myImageView;

    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                            Highgui.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

                            buff = (BufferedImage) im;
                            Graphics g = jXImagePanel2.getGraphics();
                            //buff.getWidth(), buff.getHeight()
                            if (g.drawImage(buff, 0, 0, 400, 400 - 150, 0, 0, 800, 800, null)) {
                                if (runnable == false) {
                                    System.out.println("Going to wait()");
                                    this.wait();
                                }
                            }
                        } catch (Exception ex) {
                            // System.out.println("Error");
                        }
                    }
                }
            }
        }
    }

    /**
     * Creates new form UserLogin
     */
    public AddAStudent() {
        initComponents();
        //ImageIcon imageIcon = new ImageIcon("./src/panola/images/insegnare-assistente-italiano-estero-austria-vienna (Custom).png");
        //jXImagePanel1.setImage(imageIcon.getImage());
        setDateAndTime();
        captureButton.setBorder(null);
        captureButton.setBorderPainted(false);
        captureButton.setContentAreaFilled(false);
        captureButton.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        captureButton.setDoubleBuffered(true);
        captureButton.setFocusPainted(false);
        try {
            Methods.fillBatchCombo(batchCombo);
            Methods.fillSubjectCombo(subjectCombo);
            fillTeacherText();
            fillStudentID();
            fillAdmissionFee();
            fillClassFee();
            fillTotalAmount();
            fillRegFeeText();
            fillschoolCombo(schoolCombo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            AddNewBatch addNewBatch = new AddNewBatch();
            addNewBatch.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please add a Subject first");
        }
        /*IDText.setBackground(new Color(0, 0, 0, 65));
        studentIDText.setBackground(new Color(0, 0, 0, 65));
        studentNameText.setBackground(new Color(0, 0, 0, 65));
        addressText.setBackground(new Color(0, 0, 0, 65));
        schoolCombo.setBackground(new Color(0, 0, 0, 65));
        phoneNumberText.setBackground(new Color(0, 0, 0, 65));
        batchCombo.setBackground(new Color(0, 0, 0, 65));
        subjectCombo.setBackground(new Color(0, 0, 0, 65));
        // mediumCombo.setBackground(new Color(0, 0, 0, 65));
        teacherNameText.setBackground(new Color(0, 0, 0, 65));
        regFeeText.setBackground(new Color(0, 0, 0, 65));
        classFeeText.setBackground(new Color(0, 0, 0, 65));
        totalAmountText.setBackground(new Color(0, 0, 0, 65));
        balanceText.setBackground(new Color(0, 0, 0, 65));
        paidAmountText.setBackground(new Color(0, 0, 0, 65));
        saveButton.setBackground(new Color(0, 0, 0, 65));
        cancelButton.setBackground(new Color(0, 0, 0, 65));
        schoolCombo.setBackground(new Color(0, 0, 0, 65));*/
        setSaveButtonEnable();
        //pane.setBackground(new Color(0, 0, 0, 65));

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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        timeTabelPopupMenu = new javax.swing.JPopupMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        category = new javax.swing.ButtonGroup();
        jXImagePanel1 = new org.jdesktop.swingx.JXImagePanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TimeLable = new javax.swing.JLabel();
        dateLable = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        studentIDText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressText = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        phoneNumberText = new javax.swing.JTextField();
        Revision = new javax.swing.JRadioButton();
        Theory = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        regFeeText = new javax.swing.JTextField();
        classFeeText = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        paidAmountText = new javax.swing.JTextField();
        balanceText = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        studentNameText = new javax.swing.JTextField();
        captureButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        batchCombo = new javax.swing.JComboBox();
        subjectCombo = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        totalAmountText = new javax.swing.JTextField();
        teacherNameText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        IDText = new javax.swing.JTextField();
        schoolCombo = new javax.swing.JComboBox();
        jXImagePanel2 = new org.jdesktop.swingx.JXImagePanel();
        pane = new javax.swing.JPanel();
        printButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        studentPopupMenu.setAlignmentX(1000.0F);
        studentPopupMenu.setAlignmentY(1000.0F);
        studentPopupMenu.setEnabled(false);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem1.setText("Mark Attendance");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        studentPopupMenu.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem2.setText("Add A Student");
        studentPopupMenu.add(jMenuItem2);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem7.setText("Update Student Details");
        studentPopupMenu.add(jMenuItem7);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem3.setText("Deactivated Students");
        studentPopupMenu.add(jMenuItem3);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem5.setText("Remove A Student");
        studentPopupMenu.add(jMenuItem5);

        timeTabelPopupMenu.setAlignmentX(-1000.0F);
        timeTabelPopupMenu.setAlignmentY(-1000.0F);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem6.setText("View Time Tabel");
        timeTabelPopupMenu.add(jMenuItem6);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem4.setText("Edit Time Tabel");
        timeTabelPopupMenu.add(jMenuItem4);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Panola Institute Of Education");

        jXImagePanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("MV Boli", 0, 36)); // NOI18N
        jLabel1.setText("Panola Institute Of Education");

        jLabel2.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel2.setText("Add A Student");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panola/images/system-shutdown-3 (Custom).png"))); // NOI18N
        jLabel3.setText("Yasiru");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel3.setIconTextGap(10);

        TimeLable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TimeLable.setText("jLabel4");

        dateLable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateLable.setText("jLabel4");

        jSeparator1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(204, 204, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("NIC");

        studentIDText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        studentIDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIDTextActionPerformed(evt);
            }
        });
        studentIDText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                studentIDTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studentIDTextKeyReleased(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(204, 204, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Student Name");

        jLabel7.setBackground(new java.awt.Color(204, 204, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Address");

        addressText.setColumns(20);
        addressText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        addressText.setRows(5);
        addressText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addressTextKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(addressText);

        jLabel6.setBackground(new java.awt.Color(204, 204, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("School");

        jLabel8.setBackground(new java.awt.Color(204, 204, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Phone Number");

        phoneNumberText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        phoneNumberText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNumberTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneNumberTextKeyReleased(evt);
            }
        });

        category.add(Revision);
        Revision.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Revision.setText("Revision");
        Revision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevisionActionPerformed(evt);
            }
        });
        Revision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RevisionKeyPressed(evt);
            }
        });

        category.add(Theory);
        Theory.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Theory.setSelected(true);
        Theory.setText("Theory");
        Theory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TheoryActionPerformed(evt);
            }
        });
        Theory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TheoryKeyPressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(204, 204, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Batch");

        jLabel11.setBackground(new java.awt.Color(204, 204, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Teacher's Name");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panola/images/home (Custom).jpg"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setText("Registration Fee");

        regFeeText.setEditable(false);
        regFeeText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        regFeeText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        regFeeText.setText("0.0");
        regFeeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                regFeeTextKeyPressed(evt);
            }
        });

        classFeeText.setEditable(false);
        classFeeText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        classFeeText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        classFeeText.setText("0.0");
        classFeeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                classFeeTextKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel16.setText("Class Fee");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel17.setText("Paid Amount");

        paidAmountText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        paidAmountText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        paidAmountText.setText("0.0");
        paidAmountText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidAmountTextActionPerformed(evt);
            }
        });
        paidAmountText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paidAmountTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidAmountTextKeyReleased(evt);
            }
        });

        balanceText.setEditable(false);
        balanceText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        balanceText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        balanceText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                balanceTextKeyPressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel18.setText("Balance");

        saveButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        studentNameText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        studentNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameTextActionPerformed(evt);
            }
        });

        captureButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panola/images/cutmypic (Custom)_1.png"))); // NOI18N
        captureButton.setEnabled(false);
        captureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureButtonActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(204, 204, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setText("Subject");

        jLabel20.setBackground(new java.awt.Color(204, 204, 255));
        jLabel20.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel20.setText("Category");

        batchCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        batchCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchComboItemStateChanged(evt);
            }
        });
        batchCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchComboActionPerformed(evt);
            }
        });

        subjectCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        subjectCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                subjectComboItemStateChanged(evt);
            }
        });
        subjectCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectComboActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("+ New");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel21.setText("Total Amount");

        totalAmountText.setEditable(false);
        totalAmountText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        totalAmountText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalAmountText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                totalAmountTextKeyPressed(evt);
            }
        });

        teacherNameText.setEditable(false);
        teacherNameText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        teacherNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherNameTextActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(204, 204, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Student ID");

        IDText.setEditable(false);
        IDText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        schoolCombo.setEditable(true);
        schoolCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schoolComboActionPerformed(evt);
            }
        });
        schoolCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                schoolComboKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel2Layout = new javax.swing.GroupLayout(jXImagePanel2);
        jXImagePanel2.setLayout(jXImagePanel2Layout);
        jXImagePanel2Layout.setHorizontalGroup(
            jXImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        jXImagePanel2Layout.setVerticalGroup(
            jXImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout paneLayout = new javax.swing.GroupLayout(pane);
        pane.setLayout(paneLayout);
        paneLayout.setHorizontalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        paneLayout.setVerticalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );

        printButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printButton.setText("Print ID");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("V");

        javax.swing.GroupLayout jXImagePanel1Layout = new javax.swing.GroupLayout(jXImagePanel1);
        jXImagePanel1.setLayout(jXImagePanel1Layout);
        jXImagePanel1Layout.setHorizontalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subjectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addComponent(batchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))))
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(33, 33, 33)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(studentNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                                .addComponent(studentIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(phoneNumberText, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                            .addComponent(schoolCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(captureButton)
                                .addGap(199, 199, 199))
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cancelButton)
                                    .addComponent(jXImagePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TimeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateLable, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IDText, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(teacherNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                        .addComponent(Theory)
                                        .addGap(52, 52, 52)
                                        .addComponent(Revision)))))
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(regFeeText))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(classFeeText))
                                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(paidAmountText))
                                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(balanceText, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(totalAmountText, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton)
                                .addGap(18, 18, 18)
                                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jXImagePanel1Layout.setVerticalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel1Layout.createSequentialGroup()
                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXImagePanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addComponent(jXImagePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(schoolCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(phoneNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(batchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton5))
                                        .addGap(5, 5, 5)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(subjectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(Theory)
                                                .addComponent(Revision)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(teacherNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(IDText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(regFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(classFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totalAmountText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(paidAmountText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5)
                                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(balanceText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(captureButton)))
                        .addGap(18, 18, 18)
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveButton)
                            .addComponent(jButton1)
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TimeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cancelButton)
                                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateLable, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(studentIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(studentNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(360, 360, 360))))
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

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked

    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void studentIDTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentIDTextKeyPressed
        String text = studentIDText.getText();
        boolean matches = text.matches("[0-9]*");
        if (!matches) {
            studentIDText.setText(text.substring(0, text.length() - 1));
        }
    }//GEN-LAST:event_studentIDTextKeyPressed

    private void phoneNumberTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTextKeyPressed
        String text = studentIDText.getText();
        boolean matches = text.matches("[0-9]{0,9}");
        if (!matches) {
            studentIDText.setText(text.substring(0, text.length() - 1));
        }
    }//GEN-LAST:event_phoneNumberTextKeyPressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void regFeeTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regFeeTextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_regFeeTextKeyPressed

    private void classFeeTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_classFeeTextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_classFeeTextKeyPressed

    private void paidAmountTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountTextKeyPressed
        int a = evt.getKeyCode();
        try {
            if (a == 10 || Integer.parseInt(paidAmountText.getText()) >= Integer.parseInt(totalAmountText.getText())) {
                saveButton.setEnabled(true);
            }
        } catch (NumberFormatException ex) {

        }
    }//GEN-LAST:event_paidAmountTextKeyPressed

    private void balanceTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_balanceTextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceTextKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AddNewBatch addNewBatch = new AddNewBatch();
        addNewBatch.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void totalAmountTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalAmountTextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountTextKeyPressed

    private void paidAmountTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidAmountTextActionPerformed
        setSaveButtonEnable();
    }//GEN-LAST:event_paidAmountTextActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String StudentID = IDText.getText();
        String NIC = studentIDText.getText();

        try {
            Student StudentAvilable = StudentController.searchStudentAvailable(NIC);
            if (StudentAvilable != null) {

                // String LastID=IDText.getText();
                String SubjectID = SubjectController.getSubjectID(subjectCombo.getSelectedItem().toString());
                int BatchYear = Integer.parseInt(batchCombo.getSelectedItem().toString());
                StudentBatchSubjectDetails studentBatchSubjectDetails = new StudentBatchSubjectDetails(StudentID, NIC, SubjectID, BatchYear, Category());
                int res = StudentSubjectBatchDetailsController.addDetails(studentBatchSubjectDetails);
                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "Add to Student Batch Details");
                    String PaymentID = IDGenarator.getNewID("Payment", "PID", "P");
                    Payment payment = new Payment(PaymentID, dateLable.getText(), "Class Fee");
                    int res1 = PaymentController.addPayment(payment);
                    if (res1 > 0) {
                        JOptionPane.showMessageDialog(this, "Mounthly Payment Paid");
                        StudentClassFeePayment studentClassFeePayment = new StudentClassFeePayment(StudentID, PaymentID, Double.parseDouble(classFeeText.getText()), Integer.parseInt(dateLable.getText().substring(0, 4)), Integer.parseInt(dateLable.getText().substring(5, 7)));
                        int res2 = StudentClassFeeController.addNewClassFeePayment(studentClassFeePayment);
                        if (res2 > 0) {
                            // JOptionPane.showMessageDialog(this, "Added Class Payment");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Fail");
                }
            } else if (StudentAvilable == null) {
                String Name = studentNameText.getText();
                String Address = addressText.getText();
                String phoneNumber = phoneNumberText.getText();
                String School = schoolCombo.getSelectedItem().toString();
                Student student = new Student(NIC, Name, Address, phoneNumber, School);
                int res = StudentController.addStudentNew(student);
                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "New Student Add");
                    String LastID = IDText.getText();
                    String SubjectID = SubjectController.getSubjectID(subjectCombo.getSelectedItem().toString());
                    int BatchYear = Integer.parseInt(batchCombo.getSelectedItem().toString());
                    StudentBatchSubjectDetails studentBatchSubjectDetails = new StudentBatchSubjectDetails(LastID, NIC, SubjectID, BatchYear, Category());
                    int res1 = StudentSubjectBatchDetailsController.addDetails(studentBatchSubjectDetails);
                    if (res1 > 0) {
                        JOptionPane.showMessageDialog(this, "Add to Student Batch Details");
                        String PaymentID = IDGenarator.getNewID("Payment", "PID", "P");
                        Payment payment = new Payment(PaymentID, dateLable.getText(), "Class Fee");
                        int res2 = PaymentController.addPayment(payment);
                        if (res2 > 0) {
                            // JOptionPane.showMessageDialog(this, "Mounthly Payment and Addmission Paid");
                            String PaymentID1 = IDGenarator.getNewID("Payment", "PID", "P");
                            Payment payment1 = new Payment(PaymentID1, dateLable.getText(), " Addmission");
                            int res5 = PaymentController.addPayment(payment1);
                            if (res5 > 0) {
                                //JOptionPane.showMessageDialog(this, "Payment1");
                            }
                            StudentAddmissionPayment studentAddmissionPayment = new StudentAddmissionPayment(NIC, PaymentID1, Double.parseDouble(regFeeText.getText()));
                            int res4 = StudentAddmissionPaymentController.addNewAddmission(studentAddmissionPayment);
                            if (res4 > 0) {
                                //JOptionPane.showMessageDialog(this, "Reg Fee");
                            }
                            StudentClassFeePayment studentClassFeePayment = new StudentClassFeePayment(StudentID, PaymentID, Double.parseDouble(classFeeText.getText()), Integer.parseInt(dateLable.getText().substring(0, 4)), Integer.parseInt(dateLable.getText().substring(5, 7)));
                            int res3 = StudentClassFeeController.addNewClassFeePayment(studentClassFeePayment);
                            if (res3 > 0) {
                                JOptionPane.showMessageDialog(this, "Added Full Payment");
                                captureButton.setEnabled(true);
                            }
                        }

                    }
                }

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "This Student Allredy Added");
        }
        try {
            StudentImage studentImage = StudentImageController.searchImage(NIC);
            if (studentImage == null) {
                webSource = new VideoCapture(0);
                myThread = new DaemonThread();
                Thread t = new Thread(myThread);
                t.setDaemon(true);
                myThread.runnable = true;
                t.start();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_saveButtonActionPerformed

    private void subjectComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectComboActionPerformed

    }//GEN-LAST:event_subjectComboActionPerformed

    private void studentIDTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIDTextActionPerformed

        String NIC = studentIDText.getText();
        try {
            Student StudentAvilable;

            StudentAvilable = StudentController.searchStudentAvailable(NIC);
            if (StudentAvilable != null) {
                studentNameText.setText(StudentAvilable.getName());
                addressText.setText(StudentAvilable.getAddress());
                phoneNumberText.setText(StudentAvilable.getContatct_Number());
                regFeeText.setText("0.0");
                fillTotalAmount();
                StudentImage studentImage = StudentImageController.searchImage(NIC);

                if (studentImage != null) {
                    //  ImageIcon imageIcon=new ImageIcon(".src/"+NIC+".png");
                    //    jXImagePanel2.setImage(imageIcon.getImage());
                    ImageIcon image = new ImageIcon("./src/" + NIC + ".png");
                    JLabel background = new JLabel(image);
                    background.setBounds(0, 0, 300, 250);
                    getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
                    // JPanel panel = new JPanel();
                    //  panel.setOpaque(false);
                    //  setContentPane(panel);
                    pane.removeAll();
                    pane.add(background);
                    pane.revalidate();
                    pane.repaint();
                }

                setSaveButtonEnable();
            } else {
                studentNameText.requestFocus();
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_studentIDTextActionPerformed

    private void subjectComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_subjectComboItemStateChanged
        try {
            fillTeacherText();
            fillStudentID();
            fillClassFee();
            fillTotalAmount();
        } catch (NullPointerException ex) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_subjectComboItemStateChanged

    private void batchComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batchComboActionPerformed

    private void TheoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TheoryActionPerformed
        fillStudentID();
    }//GEN-LAST:event_TheoryActionPerformed

    private void RevisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevisionActionPerformed
        fillStudentID();// TODO add your handling code here:
    }//GEN-LAST:event_RevisionActionPerformed

    private void batchComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchComboItemStateChanged
        try {
            fillStudentID();
        } catch (NullPointerException ex) {

        }

    }//GEN-LAST:event_batchComboItemStateChanged

    private void studentNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNameTextActionPerformed
        addressText.requestFocus();
        setSaveButtonEnable();
    }//GEN-LAST:event_studentNameTextActionPerformed

    private void teacherNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherNameTextActionPerformed

    private void TheoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TheoryKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            Revision.setSelected(true);
        }
    }//GEN-LAST:event_TheoryKeyPressed

    private void addressTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressTextKeyPressed
        setSaveButtonEnable();
    }//GEN-LAST:event_addressTextKeyPressed

    private void RevisionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RevisionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            Theory.setSelected(true);
        }
    }//GEN-LAST:event_RevisionKeyPressed

    private void schoolComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schoolComboActionPerformed
        String school = schoolCombo.getSelectedItem().toString();
        try {
            School school1 = SchoolController.searchSchoolAvalable(school);
            if (school1 == null) {
                int res = SchoolController.addNew(school);
                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "School Added");
                    fillschoolCombo(schoolCombo);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_schoolComboActionPerformed

    private void captureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureButtonActionPerformed
        if (!studentIDText.getText().equals("")) {
            int res = JOptionPane.showConfirmDialog(this, "Is this NIC is correct?", "", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                String NIC = studentIDText.getText();
                studentIDText.setEnabled(false);
                File outputfile = new File("./src/"+studentIDText.getText() + ".png");
                try {
                    ImageIO.write(buff, "png", outputfile);
                    int res1 = StudentImageController.addNew(NIC, outputfile);
                    if (res1 > 0) {
                        JOptionPane.showMessageDialog(this, "Added");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        myThread.runnable = false;

        webSource.release();
        captureButton.setEnabled(false);
    }//GEN-LAST:event_captureButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        if (!studentIDText.getText().equals("") & !studentNameText.getText().equals("")) {
            try {
                JasperReport compileReport = JasperCompileManager.compileReport("./src/Reports/StudentID.jrxml");
                Map<String, Object> map = new HashMap<>();
                map.put("NIC", studentIDText.getText());
                map.put("SBSD.LastID", IDText.getText());
                JasperPrint fillReport = JasperFillManager.fillReport(compileReport, map, DBConnection.getDBConnection().getConnection());
                JasperViewer.viewReport(fillReport, false);
            } catch (JRException ex) {
                Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            myThread.runnable = false;
            webSource.release();
            captureButton.setEnabled(false);
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
            this.dispose();
        } catch (NullPointerException ex) {
            System.out.println("Cam Not Opened");
        }
    }//GEN-LAST:event_printButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        try {
            myThread.runnable = false;
            webSource.release();
            captureButton.setEnabled(false);
        } catch (NullPointerException ex) {
            System.out.println("Cam Not Opened");
        }
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            myThread.runnable = false;

            webSource.release();
            captureButton.setEnabled(false);
        } catch (NullPointerException ex) {
            System.out.println("Cam in not opened");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void schoolComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_schoolComboKeyPressed
        if(evt.getKeyCode()==VK_BACK_SPACE){
            schoolCombo.removeAllItems();
        }
    }//GEN-LAST:event_schoolComboKeyPressed

    private void studentIDTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentIDTextKeyReleased
        String text = studentIDText.getText();
        boolean matches = text.matches("[0-9]{0,9}");
        if (!matches) {
            studentIDText.setText(text.substring(0, text.length() - 1));
        }
    }//GEN-LAST:event_studentIDTextKeyReleased

    private void phoneNumberTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTextKeyReleased
        String text = phoneNumberText.getText();
        boolean matches = text.matches("[0-9]{0,10}");
        if (!matches) {
            phoneNumberText.setText(text.substring(0, text.length() - 1));
        }
    }//GEN-LAST:event_phoneNumberTextKeyReleased

    private void paidAmountTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountTextKeyReleased
        String text = paidAmountText.getText();
        boolean matches = text.matches("[0-9]{0,6}");
        if (!matches) {
            paidAmountText.setText(text.substring(0, text.length() - 1));
        }
    }//GEN-LAST:event_paidAmountTextKeyReleased

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
            java.util.logging.Logger.getLogger(AddAStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDText;
    private javax.swing.JRadioButton Revision;
    private javax.swing.JRadioButton Theory;
    private javax.swing.JLabel TimeLable;
    private javax.swing.JTextArea addressText;
    private javax.swing.JTextField balanceText;
    public static javax.swing.JComboBox batchCombo;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton captureButton;
    private javax.swing.ButtonGroup category;
    private javax.swing.JTextField classFeeText;
    private javax.swing.JLabel dateLable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel1;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel2;
    private javax.swing.JTextField paidAmountText;
    private javax.swing.JPanel pane;
    private javax.swing.JTextField phoneNumberText;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField regFeeText;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox schoolCombo;
    private javax.swing.JTextField studentIDText;
    private javax.swing.JTextField studentNameText;
    private javax.swing.JPopupMenu studentPopupMenu;
    private javax.swing.JComboBox subjectCombo;
    private javax.swing.JTextField teacherNameText;
    private javax.swing.JPopupMenu timeTabelPopupMenu;
    private javax.swing.JTextField totalAmountText;
    // End of variables declaration//GEN-END:variables

    private void setDateAndTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formetedDate = simpleDateFormat.format(date);
        dateLable.setText(formetedDate);

        Thread t1 = new Thread() {

            @Override
            public void run() {
                while (true) {
                    Date date = new Date();
                    SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss a");
                    String formatedTime = simpleTimeFormat.format(date);
                    TimeLable.setText(formatedTime);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };
        t1.start();
    }

    private void fillRegFeeText() throws ClassNotFoundException, SQLException {
        Double addmition = AddmitionController.getAddmition();
        regFeeText.setText(Double.toString(addmition));
    }

    private void fillClassFeeText() throws ClassNotFoundException, SQLException {
        Double Subject = SubjectController.getFee((String) subjectCombo.getSelectedItem());
        classFeeText.setText(Double.toString(Subject));

    }

    private void fillTotalAmount() {
        double regFee = Double.parseDouble(regFeeText.getText());
        double classFee = Double.parseDouble(classFeeText.getText());
        double Total = regFee + classFee;
        totalAmountText.setText(Double.toString(Total));
    }

    private void fillStudentID() {
        String batch = batchCombo.getSelectedItem().toString();
        String subjectName = subjectCombo.getSelectedItem().toString();
        try {
            String subjectID = SubjectController.getSubjectID(subjectName);
            subjectID = subjectID.substring(7, 9);
            // String studentIDNumber = IDGenarator.getNewID("StudentBatchSubjectDetails", "LastID", "S");
            String studentIDNumber = IDGenarator.getStudentID();
            if (studentIDNumber != null) {
                int res = IDController.addID(studentIDNumber);
                if (res > 0) {
                    studentIDNumber = batch + CategoryNumber() + subjectID + studentIDNumber;
                    IDText.setText(studentIDNumber);
                    // System.out.print(studentIDNumber);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Please Add a Batch");
            AddNewBatch addNewBatch = new AddNewBatch();
            addNewBatch.setVisible(true);
        }
    }

    private void fillTeacherText() {

        try {
            String teacherText = SubjectController.getTeacherName(SubjectController.getSubjectID(subjectCombo.getSelectedItem().toString()));
            if (teacherText != null) {
                teacherNameText.setText(teacherText);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddAStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Please Add A Teacher");
            AddATeacher addATeacher = new AddATeacher();
            addATeacher.setVisible(true);
        }

    }

    private String Category() {
        String Category;
        if (Theory.isSelected()) {
            return "Theory";
        }
        return "Revision";
    }

    private void fillAdmissionFee() throws ClassNotFoundException, SQLException {
        double addmission = AddmitionController.getAddmition();
        regFeeText.setText(Double.toString(addmission));
    }

    private void fillClassFee() throws ClassNotFoundException, SQLException {
        String ClassFee = SubjectController.getClassFee(SubjectController.getSubjectID(subjectCombo.getSelectedItem().toString()));
        classFeeText.setText(ClassFee);
    }

    private void setSaveButtonEnable() {
        Double paidAmount = Double.parseDouble(paidAmountText.getText());
        Double total = Double.parseDouble(totalAmountText.getText());
        if (paidAmount >= total && !studentIDText.getText().equals("") && !studentNameText.getText().equals("") && !addressText.getText().equals("")) {
            saveButton.setEnabled(true);
            Double balance = paidAmount - total;
            balanceText.setText(balance.toString());
        } else {
            saveButton.setEnabled(false);
        }
    }

    private void fillschoolCombo() throws ClassNotFoundException, SQLException {
        ArrayList<School> allSchool = SchoolController.searchSchool();
        for (School school : allSchool) {
            schoolCombo.addItem(school.getName());
        }
    }

    private void fillschoolCombo(JComboBox schoolCombo) throws ClassNotFoundException, SQLException {
        ArrayList<School> allSchools = SchoolController.searchSchool();
        schoolCombo.removeAllItems();
        for (School school : allSchools) {
            schoolCombo.addItem(school.getName());
        }
    }

    private String CategoryNumber() {
        String Category;
        if (Theory.isSelected()) {
            return "1";
        }
        return "2";
    }

}
