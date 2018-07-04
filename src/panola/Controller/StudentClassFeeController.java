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
import panola.View.paymentHistory;
import panola.db.DBConnection;
import panola.model.PaymentHistory;
import panola.model.Student;
import panola.model.StudentBatchSubjectDetails;
import panola.model.StudentClassFeePayment;

/**
 *
 * @author Yasiru
 */
public class StudentClassFeeController {

    public static int addNewClassFeePayment(StudentClassFeePayment studentClassFeePayment) throws ClassNotFoundException, SQLException {
        String sql="Insert into StudentClassFeePayment values(?,?,?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, studentClassFeePayment.getStudentID());
        stm.setObject(2, studentClassFeePayment.getPID());
        stm.setObject(3, studentClassFeePayment.getFee());
        stm.setObject(4, studentClassFeePayment.getPaymentYear());
        stm.setObject(5, studentClassFeePayment.getPaymentMounth());
        return stm.executeUpdate();
    }

    

    public static StudentClassFeePayment searchStudentLastPayment(String ID) throws SQLException, ClassNotFoundException {
       String sql="Select PaymentYear, PaymentMounth from StudentClassFeePayment where LastID='"+ID+"'";
       Connection conn=DBConnection.getDBConnection().getConnection();
       Statement stm=conn.createStatement();
       ResultSet rst=stm.executeQuery(sql);
       if(rst.next()){
           StudentClassFeePayment studentClassFeePayment=new StudentClassFeePayment(rst.getInt("PaymentYear"),rst.getInt("PaymentMounth"));
           return studentClassFeePayment;
       }
       return null;
    }

    public static ArrayList<StudentClassFeePayment> searchStudentAllPayment(StudentBatchSubjectDetails studentBatchSubjectDetails) throws ClassNotFoundException, SQLException {
        String sql="Select SCF.PaymentYear, SCF.PaymentMounth, P.Date, SCF.fee from StudentClassFeePayment SCF , Payment P , StudentBatchSubjectDetails SB where SCF.PID=P.PID and SCF.LastID=SB.LastID and SB.NIC='"+studentBatchSubjectDetails.getLastID()+"' and SB.Year='"+studentBatchSubjectDetails.getNIC()+"' and SB.SubID='"+studentBatchSubjectDetails.getSubjectID()+"' and SB.Category='"+studentBatchSubjectDetails.getCategory()+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<StudentClassFeePayment> studentClassFeePaymentsList=new ArrayList<>();
        while(rst.next()){
            StudentClassFeePayment studentClassFeePayment=new StudentClassFeePayment(rst.getInt("SCF.PaymentYear"), rst.getInt("SCF.PaymentMounth"), rst.getString("P.Date"), rst.getDouble("SCF.fee"));
            studentClassFeePaymentsList.add(studentClassFeePayment);
        }
        return studentClassFeePaymentsList;
    }

    public static ArrayList<PaymentHistory> searchStudentClassFeePayment(PaymentHistory paymentHistory) throws ClassNotFoundException, SQLException {
        String sql="Select S.Name, S.NIC, S.address, P.Payment_Type, P.Date, SCFP.fee From Student S, Payment P, StudentClassFeePayment SCFP, StudentBatchSubjectDetails SBSD where S.NIC=SBSD.NIC and SBSD.LastID=SCFP.LastID and SCFP.PID=P.PID and SBSD.Year='"+paymentHistory.getBatch()+"' and SBSD.SubID='"+paymentHistory.getSubject()+"' and SBSD.Category='"+paymentHistory.getCategory()+"' and P.Date>='"+paymentHistory.getFromDate()+"' and P.Date<='"+paymentHistory.getToDate()+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
         ResultSet rst=stm.executeQuery(sql);
        ArrayList<PaymentHistory> paymentHistoryList=new ArrayList<>();
        while (rst.next()) {
            PaymentHistory paymentHistory1=new PaymentHistory(rst.getString("S.Name"),rst.getString("S.NIC"),rst.getString("S.address"),rst.getString("P.Payment_Type"),rst.getString("P.Date"),rst.getDouble("SCFP.fee"));
            paymentHistoryList.add(paymentHistory1);
        }
        return paymentHistoryList;
    }

    

    public static ArrayList<Student> getArrearsList(int selectedYear, int selectedMounth, String Year, String SubjectID, String category) throws ClassNotFoundException, SQLException {
        String sql="Select S.NIC, S.Name, S.address, S.phoneNumber From Student S, StudentBatchSubjectDetails SBSD, StudentClassFeePayment SCFP where S.NIC=SBSD.NIC and SBSD.LastID=SCFP.LastID and SBSD.Year='"+Year+"' and SBSD.SubID='"+SubjectID+"' and SBSD.Category='"+category+"' and SCFP.PaymentMounth & SCFP.PaymentYear not in("+selectedMounth+" & "+selectedYear+")";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Student> studentList=new ArrayList<>();
        while(rst.next()){
            Student student=new Student(rst.getString("NIC"), rst.getString("Name"), rst.getString("address"), rst.getString("phoneNumber"));
            studentList.add(student);
        }
        return studentList;
    }

    

    public static ArrayList<PaymentHistory> searchStudentClassFeeForInstitute(PaymentHistory paymentHistory) throws ClassNotFoundException, SQLException {
        String sql="Select SBSD.Year, Sub.Name, SBSD.Category, S.Name, SCFP.fee,P.Date, SCFP.PaymentYear, SCFP.PaymentMounth From Student S, StudentBatchSubjectDetails SBSD, Subject Sub, StudentClassFeePayment SCFP, Payment P where S.NIC=SBSD.NIC and SBSD.SubID=Sub.ID and SBSD.LastID=SCFP.LastID and SCFP.PID=P.PID and P.Date>='"+paymentHistory.getFromDate()+"' and P.Date<='"+paymentHistory.getToDate()+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<PaymentHistory> paymentHistorys=new ArrayList<>();
        while(rst.next()){
            PaymentHistory paaymentDetails=new PaymentHistory(rst.getString("SBSD.Year"), rst.getString("Sub.Name"), rst.getString("SBSD.Category"), rst.getString("S.Name"), rst.getDouble("SCFP.fee"),rst.getString("P.Date"), rst.getString("SCFP.PaymentYear"), rst.getString("SCFP.PaymentMounth"));
            paymentHistorys.add(paaymentDetails);
        }
        return paymentHistorys;
    }

    

    
    
}
