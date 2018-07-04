/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.other;

import com.alee.managers.popup.PopupManager;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import panola.Controller.BatchYearController;
import panola.Controller.SchoolController;
import panola.Controller.StreamController;
import panola.Controller.StudentController;
import panola.Controller.StudentImageController;
import panola.Controller.StudentTuteDetailsController;
import panola.Controller.SubjectController;
import panola.Controller.TeacherController;
import panola.Controller.TimeTableController;
import panola.View.AddAStudent;
import panola.View.IssuedTuteDetails;
import panola.View.MainWindow;
import panola.model.BatchYear;
import panola.model.PaymentHistory;
import panola.model.School;
import panola.model.Stream;
import panola.model.StudentBatchSubjectDetails;
import panola.model.StudentImage;
import panola.model.Student_Tute_Details;
import panola.model.Subject;
import panola.model.Teacher;
import panola.model.Timetable;

/**
 *
 * @author Yasiru
 */
public class Methods {
    
   /* public static void fillBatchCombo() throws ClassNotFoundException, SQLException{
        ArrayList<BatchYear> allBatchYear=BatchYearController.getAllBatchYear();
        AddAStudent.batchCombo.removeAllItems();
        for (BatchYear batchYear : allBatchYear) {
            AddAStudent.batchCombo.addItem(batchYear.getYear());
        }
    }*/

    public static void fillBatchCombo(JComboBox batchCombo) throws ClassNotFoundException, SQLException {
        ArrayList<BatchYear> allBatchYear=BatchYearController.getAllBatchYear();
        batchCombo.removeAllItems();
        for (BatchYear batchYear : allBatchYear) {
            batchCombo.addItem(batchYear.getYear());
        }
    }

    

    public static void fillSubjectCombo(JComboBox subjectCombo, JTextField Text) throws ClassNotFoundException, SQLException {
        ArrayList<Subject> allSubject=SubjectController.getAllSubject();
        for(Subject subject:allSubject){
            subjectCombo.addItem(subject.getName());
            Text.setText(subject.getTeacherName());
        }
    }

    public static void fillSubjectCombo(JComboBox Combo) throws ClassNotFoundException, SQLException {
        ArrayList<Subject> allSubject=SubjectController.getAllSubject();
        Combo.removeAllItems();;
        for(Subject subject:allSubject){
            Combo.addItem(subject.getName());
        }
    }

    public static void issueATute(String tuteID, Date from, String StudentID) {
        Student_Tute_Details student_Tute_Details=new Student_Tute_Details(StudentID, tuteID, Date.from(Instant.now()));

                try {
                    int res= StudentTuteDetailsController.issueATute(student_Tute_Details);
                    if(res>0){
                        JOptionPane.showMessageDialog(null, "Tute Issued");
                        IssuedTuteDetails.viewTable(MainWindow.idText.getText());
                        
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(IssuedTuteDetails.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No Tute");
                } catch(NullPointerException ex){
                    //JOptionPane.showMessageDialog(null, "This Tute Allredy Issued For This Student");
                }
    }

    public static void panelTransparance(JPanel panel){
        panel.setBackground(new Color(0, 0, 0, 65));
    }

    public static void textFieldTransparance(JTextField text){
        text.setBackground(new Color(0, 0, 0, 100));
    }

    public static void DigitsOnly(JTextField Text) {
        String text = Text.getText();
        boolean matches = text.matches("[0-9]*");
        if (! matches) {
            Text.setText(text.substring(0, text.length() - 1));
        }
    }

    public static void fillStremCombo(JComboBox Combo) throws ClassNotFoundException, SQLException {
        ArrayList<Stream> allStream=StreamController.getAllStream();
        Combo.removeAllItems();
        for (Stream stream : allStream) {
            Combo.addItem(stream.getStream());
        }
    }

    public static void coboBoxTransparance(JComboBox Combo) {
        Combo.setBackground(new Color(0, 0, 0, 100));
    }

    public static void buttonTransparance(JButton Button) {
        Button.setBackground(new Color(0, 0, 0, 100));
    }

    public static String getDay(String resultDateFrom) {
        String day=resultDateFrom.substring(0, 2);
        return day;
    }

    public static String getMounth(String resultDateFrom) {
        String mounth=resultDateFrom.substring(3, 5);
        return mounth;
    }

    public static String getYear(String resultDateFrom) {
        String year=resultDateFrom.substring(6, 10);
        return year;
    }

    public static void fillBatchComboUsingNIC(String NIC, JComboBox Combo) throws SQLException, ClassNotFoundException {
        ArrayList<StudentBatchSubjectDetails> studentsBatch=StudentController.searchStudentBatch(NIC);
        Combo.removeAllItems();
        for (StudentBatchSubjectDetails students : studentsBatch) {
            Combo.addItem(students.getYear());
        }
    }
    
    public static void fillSubjectComboUsingBatch(String Batch, JComboBox Combo, String NIC) throws ClassNotFoundException, SQLException {
        ArrayList<StudentBatchSubjectDetails> studentsSubject=StudentController.searchStudentSubjectUsingBatch(NIC,Batch);
        Combo.removeAllItems();
        for (StudentBatchSubjectDetails students : studentsSubject) {
            Combo.addItem(students.getLastID());
        }
    }

    public static void fillCategoryComboUsingSubject(String Batch, String Subject, JComboBox categoryCombo, String NIC) throws ClassNotFoundException, SQLException {
        ArrayList<StudentBatchSubjectDetails> studentsSubject=StudentController.searchStudentSubjectUsingSubject(NIC,Batch,Subject);
        categoryCombo.removeAllItems();
        for (StudentBatchSubjectDetails students : studentsSubject) {
            categoryCombo.addItem(students.getLastID());
        }
    }

    public static void tabPaneTransparance(JTabbedPane TabPane) {
        TabPane.setBackground(new Color(0, 0, 0, 65));
    }

    public static void fillTeacherNameCombo(JComboBox teacherNameCombo) throws ClassNotFoundException, SQLException {
        ArrayList<Teacher> allTeacherName=TeacherController.getAllTeacher();
        teacherNameCombo.removeAllItems();
        for (Teacher teacher : allTeacherName) {
            teacherNameCombo.addItem(teacher.getName());
        }
    }

    public static void fillTimeTable(JTable timetable) throws ClassNotFoundException, SQLException {
        ArrayList<Timetable> timetableDetails = TimeTableController.getAllDetails();
        DefaultTableModel dtm = (DefaultTableModel) timetable.getModel();
        dtm.setRowCount(0);
        for (Timetable timeTable : timetableDetails) {
            Object[] ob = {timeTable.getDate(),timeTable.getTeacherID(),timeTable.getCategory(),timeTable.getSubjectID(),timeTable.getYear(),timeTable.getTime()};
            dtm.addRow(ob);
        }
    }

    public static void fillWeekTimeTable(JTable timeTableWeek) throws ClassNotFoundException, SQLException {
        ArrayList<Timetable> timetableDetails = TimeTableController.getAllWeekDetails();
        DefaultTableModel dtm = (DefaultTableModel) timeTableWeek.getModel();
        dtm.setRowCount(0);
        for (Timetable timeTable : timetableDetails) {
            Object[] ob = {timeTable.getDate(),timeTable.getTeacherID(),timeTable.getCategory(),timeTable.getSubjectID(),timeTable.getYear(),timeTable.getTime()};
            dtm.addRow(ob);
        }
    }

    public static void fillSchoolCombo(JComboBox schoolCombo) throws ClassNotFoundException, SQLException {
        ArrayList<School> allSchools = SchoolController.searchSchool();
        schoolCombo.removeAllItems();
        for (School school : allSchools) {
            schoolCombo.addItem(school.getName());
        }
    }

   

    
}
