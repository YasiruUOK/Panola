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
import panola.model.Payment;
import panola.model.StudentClassFeePayment;

/**
 *
 * @author Yasiru
 */
public class PaymentController {

    public static int addPayment(Payment payment) throws ClassNotFoundException, SQLException {
        String sql="Insert into Payment values(?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, payment.getPayment_ID());
        stm.setObject(2, payment.getDate());
        stm.setObject(3, payment.getReason());
        return stm.executeUpdate();
    }

    public static ArrayList<StudentClassFeePayment> viewPayment(String ID) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select P.Date, SCF.fee from Payment P , StudentClassFeePayment SCF where P.PID=SCF.PID and SCF.LastID='"+ID+"'");
        ArrayList<StudentClassFeePayment> paymentList=new ArrayList<>();
        while(rst.next()){
            StudentClassFeePayment studentClassFeePayment=new StudentClassFeePayment(rst.getString("P.Date"), rst.getString("SCF.fee"));
            paymentList.add(studentClassFeePayment);
        }
        return paymentList;
    }
    
}
