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
import panola.db.DBConnection;
import panola.model.StudentBatchSubjectDetails;
import panola.model.StudentSubjectBatch;
import panola.model.Subject;

/**
 *
 * @author Yasiru
 */
public class StudentSubjectBatchDetailsController {

   public static StudentSubjectBatch searchStudent(String ID) throws ClassNotFoundException, SQLException {
        String sql="Select S.Name, Sub.Name from Student S, Subject Sub, StudentBatchSubjectDetails SSBD where S.NIC=SSBD.NIC and Sub.ID=SSBD.SubID and SSBD.LastID='"+ID+"'";
        Connection Conn=DBConnection.getDBConnection().getConnection();
        Statement stm=Conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            StudentSubjectBatch studentSubjectBatch=new StudentSubjectBatch(rst.getString("Name"),rst.getString("Sub.Name"));
            return studentSubjectBatch;
        }
        return null;
    }

    public static int saveStudent(StudentSubjectBatch studentSubjectBatch) throws SQLException, ClassNotFoundException {
        String sql="insert IGNORE into StudentSubjectBatchDetails values(?,?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, studentSubjectBatch.getStudentID());
        stm.setObject(2, studentSubjectBatch.getYear());
        stm.setObject(3, studentSubjectBatch.getSubject_ID());
        stm.setObject(4, studentSubjectBatch.getNIC());
        return stm.executeUpdate();
    }

    public static int addDetails(StudentBatchSubjectDetails studentBatchSubjectDetails) throws ClassNotFoundException, SQLException {
        String sql="Insert into StudentBatchSubjectDetails values(?,?,?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, studentBatchSubjectDetails.getLastID());
        stm.setObject(2, studentBatchSubjectDetails.getNIC());
        stm.setObject(3, studentBatchSubjectDetails.getSubjectID());
        stm.setObject(4, studentBatchSubjectDetails.getYear());
        stm.setObject(5, studentBatchSubjectDetails.getCategory());
        return stm.executeUpdate();
    }

   
    
}
