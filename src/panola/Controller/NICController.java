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
import panola.model.NIC;

/**
 *
 * @author Yasiru
 */
public class NICController {

    public static NIC searchNICDetail(String NIC) throws ClassNotFoundException, SQLException {
        String sql="Select * from NIC where NIC='"+NIC+"'";
        ResultSet rst=DBConnection.getDBConnection().getConnection().createStatement().executeQuery(sql);
        if(rst.next()){
            NIC nic=new NIC(rst.getString("NIC"), rst.getString("name"), rst.getString("address"), rst.getString("contact_Number"), rst.getString("School"));
            return nic;
        }
        return null;
    }

    public static int addNICDetails(NIC nic) throws ClassNotFoundException, SQLException {
        String sql="Insert IGNORE into NIC values(?,?,?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement pst=conn.prepareStatement(sql);
        pst.setObject(1, nic.getNIC());
        pst.setObject(2, nic.getName());
        pst.setObject(3, nic.getAddress());
        pst.setObject(4, nic.getContact_Number());
        pst.setObject(5, nic.getSchool());
        return pst.executeUpdate();
    }

    public static NIC getNICDetails(String NIC) throws SQLException, ClassNotFoundException {
        String sql="Select * from NIC where NIC='"+NIC+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            NIC nic=new NIC(rst.getString("NIC"),rst.getString("name"),rst.getString("address"),rst.getString("contact_Number"),rst.getString("School"));
            return nic;
        }
        return null;
    }
    
}
