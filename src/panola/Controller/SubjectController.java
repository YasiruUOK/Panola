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
import java.util.ArrayList;
import panola.db.DBConnection;
import panola.model.Student;
import panola.model.Subject;

/**
 *
 * @author Yasiru
 */
public class SubjectController {

    public static ArrayList<Subject> getAllSubject() throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select * from Subject");
        ArrayList<Subject> subjectList=new ArrayList<>();
        while(rst.next()){
            Subject subject=new Subject(rst.getString("Name"),rst.getDouble("fee"),rst.getString("TeacherID"));
            subjectList.add(subject);
        }
        return subjectList;
    }

    public static int addSubject(Subject subject) throws ClassNotFoundException, SQLException {
        String sql="Insert into Subject values(?,?,?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, subject.getSubject_ID());
        stm.setObject(2, subject.getName());
        stm.setObject(3, subject.getFee());
        stm.setObject(4, subject.getStream());
        stm.setObject(5, subject.getTeacherName());
        return stm.executeUpdate();
    }

    public static Double getFee(String toString) throws ClassNotFoundException, SQLException {
        String sql="Select fee from Subject where ID='"+toString+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            Double fee=rst.getDouble("fee");
            return fee;
        }
        return 0.0;
    }

    public static String getSubjectID(String subjectName) throws ClassNotFoundException, SQLException {
        String sql="Select * from Subject where Name='"+subjectName+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            String id=rst.getString("ID");
            return id;
        }
        return "001";
    }

    public static double getStudentFee(String ID) throws SQLException, ClassNotFoundException {
        String sql="Select S.fee From Subject S, StudentBatchSubjectDetails SSBD where S.ID=SSBD.SubID and SSBD.LastID='"+ID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
           double fee=rst.getDouble("fee");
           return fee;
        }
        return 0;
    }

    public static String getStudentSubjectID(String StudentID) throws ClassNotFoundException, SQLException {
        String sql="Select * from StudentBatchSubjectDetails where LastID='"+StudentID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            String id=rst.getString("ID");
            return id;
        }
        return "001";
    }

    public static String getTeacherName(String subjectID) throws ClassNotFoundException, SQLException {
        String sql="Select T.Name from Subject S , Teacher T where S.TeacherID=T.NIC and S.ID='"+subjectID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            String name=new String(rst.getString("Name"));
            return name;
        }
        return null;
    }

    public static String getClassFee(String ID) throws ClassNotFoundException, SQLException {
        String sql="Select fee from Subject where ID='"+ID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement statement=conn.createStatement();
        ResultSet rst=statement.executeQuery(sql);
        if(rst.next()){
            String fee=new String(rst.getString("fee"));
            return fee;
        }
        return "0";
    }

    public static int changeFee(String SubjectID, String Fee) throws ClassNotFoundException, SQLException {
        String sql="Update Subject set fee='"+Fee+"' where ID='"+SubjectID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static int removeSubject(String subject) throws ClassNotFoundException, SQLException {
        String sql="delete from Subject where Name='"+subject+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static int renameSubject(String oldName, String newName) throws ClassNotFoundException, SQLException {
        String sql="Update Subject set Name='"+newName+"' where Name='"+oldName+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static Object getSubjectName(String SubjectID) throws ClassNotFoundException, SQLException {
        String sql="Select Name From Subject where ID='"+SubjectID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            String name=new String(rst.getString("Name"));
            return name;
        }
        return null;
    }

    

    
}
