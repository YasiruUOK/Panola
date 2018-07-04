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
import panola.db.DBConnection;

/**
 *
 * @author Yasiru
 */
public class IDController {

    public static String getLastID(String tableName, String columName) throws ClassNotFoundException, SQLException {
        String sql="select "+columName+" from "+tableName+" order by 1 desc limit 1";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }

    public static String getID() throws ClassNotFoundException, SQLException {
        String sql="Select ID from StudentID order by 1 desc limit 1";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString("ID");
        }
        return null;
    }

    public static int addID(String studentIDNumber) throws ClassNotFoundException, SQLException {
        String sql="insert into StudentID values('"+studentIDNumber+"')";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }
    
}
