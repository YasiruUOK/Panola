/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oracle.jdbc.driver.DBConversion;
import panola.db.DBConnection;
import panola.model.Teacher;
import panola.model.TeacherPayAtNow;
import panola.model.TeacherPayments;

/**
 *
 * @author Yasiru
 */
public class TeacherPaymentsController {

    

    public static String getDueToPay(String teacherName, double totalPayment) throws ClassNotFoundException, SQLException {
        String sql="Select "+totalPayment+"-TP.PaymentAmount From TeacherPayments TP, Teacher T where T.NIC=TP.NIC and TP.PaymentMonth=month(curdate()) and TP.PaymentYear=year(curdate()) and T.Name='"+teacherName+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            String dueToPay=new String(rst.getString(""+totalPayment+"-TP.PaymentAmount"));
            return dueToPay;
        }
        return null;
    }

    public static int addPayment(String NIC, double PayAtNow) throws ClassNotFoundException, SQLException {
        String sql="Insert into TeacherPayments values('"+NIC+"',"+PayAtNow+",month(curdate()),year(curdate()),curdate())";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
        
    }

    public static ArrayList<Teacher> getDetails( String resultDateFrom, String resultDateTo) throws ClassNotFoundException, SQLException {
        String sql="Select T.Name, TP.PaidDate, TP.PaymentAmount From Teacher T, TeacherPayments TP where T.NIC=TP.NIC  and TP.PaidDate>='"+resultDateFrom+"' and TP.PaidDate<='"+resultDateTo+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Teacher> detailList=new ArrayList<>();
        while(rst.next()){
            Teacher teacher=new Teacher(rst.getString("T.Name"),rst.getString("TP.PaidDate"),rst.getDouble("TP.PaymentAmount"));
            detailList.add(teacher);
        }
        return detailList;
    }

    public static ArrayList<TeacherPayments> getDetails(String Name) throws ClassNotFoundException, SQLException {
        String sql="Select TP.PaidDate, TP.PaymentAmount From TeacherPayments TP, Teacher T where T.NIC=TP.NIC and T.Name='"+Name+"' and TP.PaymentMonth=month(curdate())";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<TeacherPayments> paymentList=new ArrayList<>();
        while (rst.next()) {            
            TeacherPayments teacherPayments=new TeacherPayments(rst.getString("TP.PaidDate"),rst.getDouble("TP.PaymentAmount"));
            paymentList.add(teacherPayments);
        }
        return paymentList;
    }
    
}
