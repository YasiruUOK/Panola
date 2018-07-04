/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import panola.db.DBConnection;
import panola.model.StudentAddmissionPayment;

/**
 *
 * @author Yasiru
 */
public class StudentAddmissionPaymentController {

    public static int addNewAddmission(StudentAddmissionPayment studentAddmissionPayment) throws ClassNotFoundException, SQLException {
        String sql="Insert into StudentAddmissionPayment values(?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, studentAddmissionPayment.getNIC());
        stm.setObject(2, studentAddmissionPayment.getPID());
        stm.setObject(3, studentAddmissionPayment.getFee());
        return stm.executeUpdate();
    }
    
}
