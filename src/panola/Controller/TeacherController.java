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
import panola.model.Teacher;
import panola.model.TeacherPayAtNow;

/**
 *
 * @author Yasiru
 */
public class TeacherController {

    

     public static ArrayList<Teacher> getAllTeacher() throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select * from Teacher");
        ArrayList<Teacher> teacherList=new ArrayList<>();
        while(rst.next()){
            Teacher teacher=new Teacher(rst.getString("Name"));
            teacherList.add(teacher);
        }
        return teacherList;
    }

    public static boolean searchATeacher(String NIC) throws ClassNotFoundException, SQLException {
        String sql="Select * from Teacher where NIC='"+NIC+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return true;
        }
        return false;
    }

    public static boolean addTeacherDetails(Teacher teacher) throws ClassNotFoundException, SQLException {
        String sql="Insert into Teacher values(?,?,?,?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, teacher.getNIC());
        stm.setObject(2, teacher.getName());
        stm.setObject(3, teacher.getAddress());
        stm.setObject(4, teacher.getHomeNumber());
        stm.setObject(5, teacher.getMobileNumber());
        stm.setObject(6, teacher.getPaymentPercentage());
        if(stm.executeUpdate()>0){
            return true;
        }
        return false;
    }

    public static String getID(String Name) throws ClassNotFoundException, SQLException {
        String sql="Select NIC from Teacher where Name='"+Name+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            String teacher=new String(rst.getString("NIC"));
            return  teacher;
        }
        return null;
    }

    public static ArrayList<TeacherPayAtNow> getDetails(String teacherName) throws ClassNotFoundException, SQLException {
        String sql="Select SBSD.Year, SBSD.Category, count(SCFP.LastID), count(SBSD.LastID), Sub.fee,T.PaymentPercentage, count(SCFP.LastID)*Sub.fee*T.PaymentPercentage/100, count(SBSD.LastID)*Sub.fee*T.PaymentPercentage/100 from StudentBatchSubjectDetails SBSD, Subject Sub, Teacher T,StudentClassFeePayment SCFP where SBSD.SubID=Sub.ID and Sub.TeacherID=T.NIC and SBSD.LastID=SCFP.LastID and month(curdate())=SCFP.PaymentMounth and year(curdate())=SCFP.PaymentYear and T.Name='"+teacherName+"' group by SBSD.Year";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
         ArrayList<TeacherPayAtNow> teacherList=new ArrayList<>();
        while(rst.next()){
           TeacherPayAtNow teacherPayAtNow=new TeacherPayAtNow(rst.getString("SBSD.Year"), rst.getString("SBSD.Category"), rst.getInt("count(SCFP.LastID)"), rst.getInt("count(SBSD.LastID)"), rst.getDouble("Sub.fee"), rst.getDouble("T.PaymentPercentage"), rst.getDouble("count(SCFP.LastID)*Sub.fee*T.PaymentPercentage/100"), rst.getDouble("count(SBSD.LastID)*Sub.fee*T.PaymentPercentage/100"));
           teacherList.add(teacherPayAtNow);
        }
        return teacherList;
    }

    public static Double getExpectedAmount(String teacherName) throws ClassNotFoundException, SQLException {
        String sql="Select count(SBSD.LastID)*Sub.fee*T.PaymentPercentage/100 from StudentBatchSubjectDetails SBSD, Subject Sub, Teacher T where SBSD.SubID=Sub.ID and Sub.TeacherID=T.NIC and T.Name='"+teacherName+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        double amount=0;
        while(rst.next()){
            amount=rst.getDouble("count(SBSD.LastID)*Sub.fee*T.PaymentPercentage/100")+amount;
        }
        return amount;
    }

    public static String getTeacherID(String SubjectName) throws ClassNotFoundException, SQLException {
        String sql="Select T.NIC From Teacher T, Subject S where T.NIC=S.TeacherID and S.Name='"+SubjectName+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            String TeacherID=new String(rst.getString("T.NIC"));
            return  TeacherID;
        }
        return null;
    }

    public static int changeTeacherName(String oldName, String NewName) throws ClassNotFoundException, SQLException {
        String sql="Update Teacher set Name='"+NewName+"' where Name='"+oldName+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static Teacher searchATeacherbyName(String Name) throws ClassNotFoundException, SQLException {
        String sql="Select * from Teacher where Name='"+Name+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            Teacher teacher=new Teacher(rst.getString("NIC"), rst.getString("Name"), rst.getString("address"), rst.getString("HomeNumber"), rst.getString("MobileNumber"), rst.getDouble("PaymentPercentage"));
            return teacher;
        }
        return null;
    }

    public static int updateDetails(Teacher teacher) throws ClassNotFoundException, SQLException {
        String sql="Update Teacher set NIC=?, address=?, HomeNumber=?, MobileNumber=?, PaymentPercentage=? where Name=?";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement pst=conn.prepareStatement(sql);
        pst.setObject(1, teacher.getNIC());
        pst.setObject(2, teacher.getAddress());
        pst.setObject(3, teacher.getHomeNumber());
        pst.setObject(4, teacher.getMobileNumber());
        pst.setObject(5, teacher.getPaymentPercentage());
        pst.setObject(6, teacher.getName());
        return pst.executeUpdate();
    }

    public static ArrayList<Teacher> getTeacherNameNotInSubject() throws ClassNotFoundException, SQLException {
        String sql="Select Name From Teacher where NIC Not in(Select S.TeacherID From Subject S, Teacher T where T.NIC=S.TeacherID)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Teacher> teacherList=new ArrayList<>();
        while(rst.next()){
            Teacher Name=new Teacher(rst.getString("Name"));
            teacherList.add(Name);
        }
        return teacherList;
    }

    public static Object getTeachername(String TeacherID) throws SQLException, ClassNotFoundException {
        String sql="Select Name From Teacher where NIC='"+TeacherID+"'";
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
