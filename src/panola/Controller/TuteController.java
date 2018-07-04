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
import panola.model.StudentTute;
import panola.model.Student_Tute_Details;
import panola.model.Tute;

/**
 *
 * @author Yasiru
 */
public class TuteController {

    public static int addTute(Tute tute) throws ClassNotFoundException, SQLException {
        String sql="Insert into Tute values(?,?,?,?,?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, tute.getTute_ID());
        stm.setObject(2, tute.getSubject_ID());
        stm.setObject(3, tute.getCategory());
        stm.setObject(4, tute.getDate());
        stm.setObject(5, tute.getYear());
        stm.setObject(6, tute.getName());
        stm.setObject(7, tute.getCopyAvailable());
        return stm.executeUpdate();
    }

    public static int deleteRaw(String ID) throws SQLException, ClassNotFoundException {
        String sql="Delete from Tute where Tute_ID='"+ID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static ArrayList<StudentTute> getTuteDetils(String Batch, String Subject, String Category) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select T.Tute_ID, T.Name, T.Date, count(ST.LastID), T.CopyAvailable-count(ST.LastID) from Tute T , Student_Tute_Details ST  where T.Tute_ID=ST.Tute_ID and T.Year='"+Batch+"' and T.Subject_ID='"+Subject+"' and T.Category='"+Category+"' group by T.Tute_ID");
        ArrayList<StudentTute> tuteList=new ArrayList<>();
        while(rst.next()){
            StudentTute studentTute=new StudentTute(rst.getString("Tute_ID"),rst.getString("Name"),rst.getDate("Date"),rst.getInt("count(ST.LastID)"),rst.getInt("T.CopyAvailable-count(ST.LastID)"));
            tuteList.add(studentTute);
        }
        return tuteList;
    }

    public static String getTuteName(String tuteID) throws SQLException, ClassNotFoundException {
        String sql="Select Name from Tute where Tute_ID='"+tuteID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        while (rst.next()){
            String name=new String(rst.getString("Name"));
            return name;
        }
        return null;
    }

    public static boolean getTuteAvailable(String TuteId) throws ClassNotFoundException, SQLException {
        String sql="Select * from Tute where Tute_ID='"+TuteId+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        while (rst.next()) {
            return true;
        }
        return false;
    }

    public static ArrayList<Tute> getTuteID(String Year, String SubjectID, String Category) throws ClassNotFoundException, SQLException {
        String sql="select Tute_ID from Tute where Year='"+Year+"' and Subject_ID='"+SubjectID+"' and Category='"+Category+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Tute> tuteList=new ArrayList<>();
        while(rst.next()){
            Tute tute=new Tute(rst.getString("Tute_ID"));
            tuteList.add(tute);
        }
        return tuteList;
    }

    public static int updateDetails(String TuteID, String TuteName, int numberOfCoppies) throws ClassNotFoundException, SQLException {
        String sql="Update Tute set Name='"+TuteName+"', CopyAvailable=CopyAvailable+"+numberOfCoppies+" where Tute_ID='"+TuteID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    
    
}
