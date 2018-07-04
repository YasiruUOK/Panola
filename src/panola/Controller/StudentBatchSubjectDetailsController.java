/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.Controller;

import com.sun.org.apache.xalan.internal.xsltc.trax.SAX2StAXBaseWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import panola.db.DBConnection;
import panola.model.Student;
import panola.model.StudentBatchSubjectDetails;
import panola.model.StudentDetails;
import panola.model.StudentSubjectBatch;
import panola.model.Subject;

/**
 *
 * @author Yasiru
 */
public class StudentBatchSubjectDetailsController {

    public static StudentDetails searchStudent(String StudentID) throws ClassNotFoundException, SQLException {
        String sql="Select S.Name, S.address, S.school, S.phoneNumber, SBSD.Year, Sub.name, T.Name from Student S, Subject Sub, Teacher T, StudentBatchSubjectDetails SBSD where S.NIC=SBSD.NIC and SBSD.SubID=Sub.ID and Sub.TeacherID=T.NIC and SBSD.LastID='"+StudentID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            StudentDetails studentDetails=new StudentDetails(rst.getString("S.Name"),rst.getString("S.address"),rst.getString("S.school"),rst.getString("S.phoneNumber"),rst.getString("SBSD.Year"),rst.getString("Sub.name"),rst.getString("T.Name"));
            return studentDetails;
        }
        return null;
    }

    public static StudentBatchSubjectDetails getNIC(String ID) throws ClassNotFoundException, SQLException {
        String sql="select NIC from StudentBatchSubjectDetails where LastID='"+ID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            StudentBatchSubjectDetails studentDetails=new StudentBatchSubjectDetails(rst.getString("NIC"));
            return studentDetails;
        }
        return null;
    }

    

    public static String getLastID(String Batch, String SubjectID, String NIC, String category) throws ClassNotFoundException, SQLException {
        String sql="Select LastID From StudentBatchSubjectDetails where Year='"+Batch+"' and SubID='"+SubjectID+"' and Category='"+category+"' and NIC='"+NIC+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString("LastID");
        }
        return null;
    }

    public static ArrayList<Student> getDetails(StudentBatchSubjectDetails studentBatchSubjectDetails) throws ClassNotFoundException, SQLException {
        String sql="Select S.NIC, S.Name, S.address, S.phoneNumber, S.school From Student S, StudentBatchSubjectDetails SBSD where S.NIC=SBSD.NIC and SBSD.Year=? and SBSD.SubID=? and SBSD.Category=?";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, studentBatchSubjectDetails.getYear());
        stm.setObject(2, studentBatchSubjectDetails.getSubjectID());
        stm.setObject(3, studentBatchSubjectDetails.getCategory());
        ResultSet rst=stm.executeQuery();
        ArrayList<Student> studentList=new ArrayList<>();
        while (rst.next()) {            
            Student student=new Student(rst.getString("S.NIC"), rst.getString("S.Name"), rst.getString("S.address"), rst.getString("S.phoneNumber"), rst.getString("S.school"));
            studentList.add(student);
        }
        return studentList;
    }

   
    public static ArrayList<Subject> getData(String NIC,String Year) throws ClassNotFoundException, SQLException {
        String sql="Select S.Name, Sub.Name From Student S, Subject Sub, StudentBatchSubjectDetails SBSD where S.NIC=SBSD.NIC and SBSD.SubID=Sub.ID and S.NIC='"+NIC+"' and SBSD.Year='"+Year+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Subject> subjectList=new ArrayList<>();
        while(rst.next()){
            Subject subject=new Subject(rst.getString("S.Name"),rst.getString("Sub.Name"));
            subjectList.add(subject);
        }
        return subjectList;
    }

    public static ArrayList<StudentBatchSubjectDetails> getDetailsByName(String Name) throws ClassNotFoundException, SQLException {
        String sql="select SBSD.LastID, S.Name, S.address, SBSD.Year, SBSD.Category, Sub.Name From Student S, StudentBatchsubjectDetails SBSD, Subject Sub where S.NIC=SBSD.NIC and Sub.ID=SBSD.SubID and S.Name like '"+Name+"%' ";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement statement=conn.createStatement();
        ResultSet rst=statement.executeQuery(sql);
        ArrayList<StudentBatchSubjectDetails> studentBatchSubjectDetailsList=new ArrayList<>();
        while(rst.next()){
            StudentBatchSubjectDetails studentBatchSubjectDetails=new StudentBatchSubjectDetails(rst.getString("SBSD.LastID"), rst.getString("S.Name"), rst.getString("S.address"), rst.getString("SBSD.Category"),rst.getInt("SBSD.Year"), rst.getString("Sub.Name"));
            studentBatchSubjectDetailsList.add(studentBatchSubjectDetails);
        }
        return studentBatchSubjectDetailsList;
    }
    
}
