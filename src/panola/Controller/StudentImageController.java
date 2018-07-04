/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.Controller;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import panola.db.DBConnection;
import panola.model.StudentImage;

/**
 *
 * @author Yasiru
 */
public class StudentImageController {


    public static StudentImage searchImage(String NIC) throws ClassNotFoundException, SQLException {
        String sql="select * from StudentPhoto where NIC='"+NIC+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            StudentImage studentImage=new StudentImage(rst.getString("NIC"), rst.getBlob("Photo"));
            return studentImage;
        }
        return null;
    }

    public static int addNew(String NIC, File outputfile) throws ClassNotFoundException, SQLException {
        String sql="Insert into StudentPhoto VALUES('"+NIC+"',('C://Users//Yasiru//Documents//NetBeansProjects//Panola//src//"+outputfile+"'))";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

}
