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
import panola.model.Year;
import panola.model.BatchYear;

/**
 *
 * @author Yasiru
 */
public class BatchYearController {


    public static int addNewBatch(String batchYear) throws SQLException, ClassNotFoundException {
        String sql="Insert into Year values(?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, batchYear);
        return stm.executeUpdate();
    }

    public static ArrayList<BatchYear> getAllBatchYear() throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select * from Year");
        ArrayList<BatchYear> batchYearList=new ArrayList<>();
        while(rst.next()){
            BatchYear batchYear=new BatchYear(rst.getString("year"));
            batchYearList.add(batchYear);
        }
        return batchYearList;
    }

    public static boolean searchYear(String batchYear) throws ClassNotFoundException, SQLException {
        String sql="Select * from Year where Year='"+batchYear+"' ";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return true;
        }
        return false;
    }

    public static int removeBatch(String batch) throws ClassNotFoundException, SQLException {
        String sql="Delete from Year where Year='"+batch+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    
}
