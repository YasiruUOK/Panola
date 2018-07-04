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
import panola.model.Stream;

/**
 *
 * @author Yasiru
 */
public class StreamController {

    public static int addStream(String stream) throws ClassNotFoundException, SQLException {
        String sql="insert into Stream values(?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, stream);
        return stm.executeUpdate();
    }

    public static ArrayList<Stream> getAllStream() throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("select * from Stream");
        ArrayList<Stream> streamList=new ArrayList<>();
        while(rst.next()){
            Stream stream=new Stream(rst.getString("stream"));
            streamList.add(stream);
        }
        return streamList;
    }

    public static int changeStream(String newSteam, String oldStream) throws ClassNotFoundException, SQLException {
        String sql="Update Stream set stream='"+newSteam+"' where stream='"+oldStream+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }
    
}
