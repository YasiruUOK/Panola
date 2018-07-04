/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import panola.db.DBConnection;
import panola.model.BatchSubjectWithStudentDetails;
import panola.model.Student;
import panola.model.StudentAddmissionDetails;
import panola.model.StudentBatchSubjectDetails;

/**
 *
 * @author Yasiru
 */
public class StudentController {

    public static int addStudent(Student student) throws ClassNotFoundException, SQLException {
        String sql="insert IGNORE into Student values(?,?,?,?,?,?,?,?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, student.getNIC());
        stm.setObject(2, student.getName());
        stm.setObject(3, student.getAddress());
        stm.setObject(4, student.getContatct_Number());
        stm.setObject(5, student.getSchool());
        stm.setObject(6, student.getBatchYear());
        stm.setObject(7, student.getSubject());
        stm.setObject(8, student.getMedium());
        stm.setObject(9, student.getCategory());
        stm.setObject(10, student.getDate());
        return stm.executeUpdate();
    }

   /* public static Student searchStudent(String ID) throws ClassNotFoundException, SQLException {
        String sql="Select * from Student where StudentID=?";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, ID);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
           Student student=new Student(rst.getString("StudentID"),rst.getString("name"),rst.getString("Subject"));
           
        }
    }*/

    public static Student searchStudent(String ID) throws ClassNotFoundException, SQLException {
        String sql="Select S.name from Student S, StudentSubjectBatchDetails SSBD where S.NIC=SSBD.NIC and SSBD.StudentID='"+ID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            Student student=new Student(rst.getString("name"));
            return student;
        }
        return null;
    }

    public static StudentAddmissionDetails searchStudentAddmissionDetails(String NIC) throws ClassNotFoundException, SQLException {
        String sql="Select S.name, S.address, S.phoneNumber, P.Date, SAP.fee  from Student S, Payment P, StudentAddmissionPayment SAP where S.NIC=SAP.NIC and SAP.PID=P.PID and S.NIC='"+NIC+"'";
        ResultSet rst=DBConnection.getDBConnection().getConnection().createStatement().executeQuery(sql);
        while(rst.next()){
            StudentAddmissionDetails studentAddmissionDetails=new StudentAddmissionDetails(rst.getString("name"), rst.getString("address"), rst.getString("phoneNumber"), rst.getDate("Date"), rst.getInt("fee"));
            return studentAddmissionDetails;
        }
        return null;
    }

    public static Student searchStudentDetails(String NIC) throws ClassNotFoundException, SQLException {
        String sql="Select S.NIC, S.Name, S.address, S.phoneNumber from Student S where  S.NIC='"+NIC+"'";
        ResultSet rst=DBConnection.getDBConnection().getConnection().createStatement().executeQuery(sql);
        while(rst.next()){
            Student student=new Student(rst.getString("NIC"), rst.getString("name"), rst.getString("address"), rst.getString("phoneNumber"));
            return student;
        }
        return null;
    }

    
    public static Student searchDetails(String id, String batch, String Subject) throws ClassNotFoundException, SQLException {
        String sql="Select * from Student where NIC='"+id+"' and BatchYear='"+batch+"' and Subject='"+Subject+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            Student student=new Student(rst.getString("NIC"));
            return student;
        }
        return null;
    }

    public static Student searchStudentAvailable(String NIC) throws ClassNotFoundException, SQLException {
        String sql="Select * from Student where NIC='"+NIC+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            Student student=new Student(rst.getString("NIC"), rst.getString("Name"), rst.getString("address"), rst.getString("phoneNumber"), rst.getString("school"));
            return student;
        }
        return null;
    }

    public static int addStudentNew(Student student) throws ClassNotFoundException, SQLException {
        String sql="Insert into Student Values(?,?,?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, student.getNIC());
        stm.setObject(2, student.getName());
        stm.setObject(3, student.getAddress());
        stm.setObject(4, student.getContatct_Number());
        stm.setObject(5, student.getSchool());
        return stm.executeUpdate();
    }

    public static ArrayList<StudentBatchSubjectDetails> searchStudentBatch(String NIC) throws SQLException, ClassNotFoundException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select Year from StudentBatchSubjectDetails where NIC='"+NIC+"' group by Year");
        ArrayList<StudentBatchSubjectDetails> batchList=new ArrayList<>();
        while(rst.next()){
            StudentBatchSubjectDetails studentBatchSubjectDetails=new StudentBatchSubjectDetails(Integer.parseInt(rst.getString("Year")));
            batchList.add(studentBatchSubjectDetails);
        }
        return batchList;
    }

    public static ArrayList<StudentBatchSubjectDetails> searchStudentSubject(String NIC, String Year) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select S.Name from StudentBatchSubjectDetails SB, Subject S where S.ID=SB.SubID and NIC='"+NIC+"' and Year='"+Year+"'");
        ArrayList<StudentBatchSubjectDetails> subjectList=new ArrayList<>();
        while(rst.next()){
            StudentBatchSubjectDetails studentBatchSubjectDetails=new StudentBatchSubjectDetails(rst.getString("S.Name"));
            subjectList.add(studentBatchSubjectDetails);
        }
        return subjectList;
    }

    public static ArrayList<StudentBatchSubjectDetails> searchStudentCategory(String NIC, String Year, String SubjectID) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select Category  from StudentBatchSubjectDetails where  NIC='"+NIC+"' and Year='"+Year+"' and SubID='"+SubjectID+"'");
        ArrayList<StudentBatchSubjectDetails> subjectList=new ArrayList<>();
        while(rst.next()){
            StudentBatchSubjectDetails studentBatchSubjectDetails=new StudentBatchSubjectDetails(rst.getString("Category"));
            subjectList.add(studentBatchSubjectDetails);
        }
        return subjectList;
    }

    public static ArrayList<StudentBatchSubjectDetails> searchStudentSubjectUsingBatch(String NIC, String Batch) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select Sub.Name From Subject Sub, StudentBatchSubjectDetails SBSD where Sub.ID=SBSD.SubID and SBSD.NIC='"+NIC+"' and SBSD.Year='"+Batch+"'");
        ArrayList<StudentBatchSubjectDetails> subjectList=new ArrayList<>();
        while(rst.next()){
            StudentBatchSubjectDetails studentBatchSubjectDetails=new StudentBatchSubjectDetails(rst.getString("Sub.Name"));
            subjectList.add(studentBatchSubjectDetails);
        }
        return subjectList;
    }

    public static ArrayList<StudentBatchSubjectDetails> searchStudentSubjectUsingSubject(String NIC, String Batch, String Subject) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select SBSD.Category From StudentBatchSubjectDetails SBSD, Subject S where SBSD.SubID=S.ID and NIC='"+NIC+"' and Year='"+Batch+"' and S.Name='"+Subject+"'");
        ArrayList<StudentBatchSubjectDetails> categoryList=new ArrayList<>();
        while(rst.next()){
            StudentBatchSubjectDetails studentBatchSubjectDetails=new StudentBatchSubjectDetails(rst.getString("SBSD.Category"));
            categoryList.add(studentBatchSubjectDetails);
        }
        return categoryList;
    }

    public static int deleteStudent(String ID) throws ClassNotFoundException, SQLException {
        String sql="Delete from StudentBatchSubjectDetails where LastID='"+ID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }
    
}
