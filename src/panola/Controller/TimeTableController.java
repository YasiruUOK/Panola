/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.Controller;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import panola.View.TimeTable;
import panola.db.DBConnection;
import panola.model.Timetable;

/**
 *
 * @author Yasiru
 */
public class TimeTableController {

    public static ArrayList<Timetable> getDayDetails(String Day) throws ClassNotFoundException, SQLException {
        String sql="select TT.Year, Sub.Name, TT.Category, T.Name, TT.Time From TimeTable TT, Subject Sub, StudentBatchSubjectDetails SBSD, Teacher T where T.NIC=TT.TID and SBSD.Year=TT.Year and Sub.ID=TT.SubID and TT.Day='"+Day+"' group by TT.Category,Sub.Name";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Timetable> timeTableList=new ArrayList<>();
        while(rst.next()){
            Timetable timeTable=new Timetable(rst.getString("TT.Year"),rst.getString("Sub.Name"),rst.getString("TT.Category"),rst.getString("T.Name"),rst.getString("TT.Time"));
            timeTableList.add(timeTable);
        }
        return timeTableList;
    }

    public static int addDetails(Timetable timetable) throws ClassNotFoundException, SQLException {
        String sql="Insert into TimeTable values(?,?,?,?,?,?)";
        Connection conn=(Connection) DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, timetable.getTeacherID());
        stm.setObject(2, timetable.getSubjectID());
        stm.setObject(3, timetable.getYear());
        stm.setObject(4, timetable.getCategory());
        stm.setObject(5, timetable.getDate());
        stm.setObject(6, timetable.getTime());
        return stm.executeUpdate();
    }

    public static ArrayList<Timetable> getAllDetails() throws ClassNotFoundException, SQLException {
        String sql="Select TT.Year, Sub.Name, TT.Category, T.Name,TT.Day, TT.Time From TimeTable TT, Subject Sub, Teacher T where T.NIC=TT.TID and Sub.ID=TT.SubID group by T.Name, TT.category, TT.Year";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Timetable> timeTableList=new ArrayList<>();
        while(rst.next()){
            Timetable timeTable=new Timetable(rst.getString("TT.Year"),rst.getString("Sub.Name"),rst.getString("TT.Category"),rst.getString("T.Name"),rst.getString("TT.Day"),rst.getString("TT.Time"));
            timeTableList.add(timeTable);
        }
        return timeTableList;
    }

    public static int delectDetails(String SubjectID, String Batch, String Day, String Category, String time) throws ClassNotFoundException, SQLException {
        String sql="delete from TimeTable where SubID='"+SubjectID+"' and Year='"+Batch+"' and Day='"+Day+"' and Category='"+Category+"' and Time='"+time+"'";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static String getClassDay(int Year, String RealSubjectID, String Category) throws ClassNotFoundException, SQLException {
        String sql="Select Day From TimeTable where Year='"+Year+"' and SubID='"+RealSubjectID+"' and Category='"+Category+"'";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            String day=new String(rst.getString("Day"));
            return day;
        }
        return null;
    }

    public static ArrayList<Timetable> getSubjectDetails(String subject) throws ClassNotFoundException, SQLException {
        String sql="Select TT.Year, TT.Category, TT.Day, TT.Time From TimeTable TT, Subject Sub where Sub.ID=TT.SubID and Sub.Name='"+subject+"' ";
        java.sql.Connection conn= DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Timetable> timeTableList=new ArrayList<>();
        while(rst.next()){
            Timetable timeTable=new Timetable(rst.getString("TT.Year"),rst.getString("TT.Category"),rst.getString("TT.Day"),rst.getString("TT.Time"));
            timeTableList.add(timeTable);
        }
        return timeTableList;
    }
    public static ArrayList<Timetable> getDateDetails(String Day) throws ClassNotFoundException, SQLException {
        String sql="select TT.Year, Sub.Name, TT.Category, T.Name, TT.Time From TimeTable TT, Subject Sub, Teacher T where T.NIC=TT.TID and Sub.ID=TT.SubID and TT.Day='"+Day+"' group by TT.Category,Sub.Name";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Timetable> timeTableList=new ArrayList<>();
        while(rst.next()){
            Timetable timeTable=new Timetable(rst.getString("TT.Year"),rst.getString("Sub.Name"),rst.getString("TT.Category"),rst.getString("T.Name"),rst.getString("TT.Time"));
            timeTableList.add(timeTable);
        }
        return timeTableList;
    }

    public static ArrayList<Timetable> getAllWeekDetails() throws ClassNotFoundException, SQLException {
        String sql="Select TT.Year, Sub.Name, TT.Category, T.Name,TT.Day, TT.Time From TimeTable TT, Subject Sub, Teacher T where T.NIC=TT.TID and Sub.ID=TT.SubID";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Timetable> timeTableList=new ArrayList<>();
        while(rst.next()){
            Timetable timeTable=new Timetable(rst.getString("TT.Year"),rst.getString("Sub.Name"),rst.getString("TT.Category"),rst.getString("T.Name"),rst.getString("TT.Day"),rst.getString("TT.Time"));
            timeTableList.add(timeTable);
        }
        return timeTableList;
    }
    
}
