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
import panola.db.DBConnection;
import panola.model.AddmissionPaymentDetails;
import panola.model.Addmition;
import panola.model.StudentAddmissionDetails;

/**
 *
 * @author Yasiru
 */
public class AddmitionController {

    public static Double getAddmition() throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("select fee from addmision");
        if(rst.next()){
            Double fee=new Double(rst.getDouble("fee"));
            return fee;
        }
        return 0.0;
    }

    public static int addAddmition(double newFee) throws SQLException, ClassNotFoundException {
        String sql="insert into addmision Values('"+newFee+"')";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }


    public static ArrayList<AddmissionPaymentDetails> viewDetails(AddmissionPaymentDetails addmission) throws ClassNotFoundException, SQLException {
        String sql="Select S.Name, S.NIC, S.address, P.Date, SAP.fee From Student S, Payment P, StudentAddmissionPayment SAP,StudentBatchSubjectDetails SBSD, Subject Sub where S.NIC=SAP.NIC and SAP.PID=P.PID and S.NIC=SBSD.NIC and SBSD.SubID=Sub.ID and P.Date>='"+addmission.getDateFrom()+"' and P.Date<='"+addmission.getDateTo()+"' and SBSD.Year='"+addmission.getBatch()+"' and Sub.Name='"+addmission.getSubject()+"' and SBSD.Category='"+addmission.getCategory()+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<AddmissionPaymentDetails> studentAddmissionDetailsList=new ArrayList<>();
        while(rst.next()){
            AddmissionPaymentDetails addmissionPaymentDetails=new AddmissionPaymentDetails(rst.getString("S.Name"), rst.getString("S.NIC"), rst.getString("S.address"), rst.getDate("P.Date"), rst.getDouble("SAP.fee"));
            studentAddmissionDetailsList.add(addmissionPaymentDetails);
        }
        return studentAddmissionDetailsList;
    }

   
    
}
