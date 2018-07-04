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
import panola.model.School;

/**
 *
 * @author Yasiru
 */
public class SchoolController {

    public static ArrayList<School> searchSchool() throws ClassNotFoundException, SQLException {
        String sql="Select * from School";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<School> schoolList=new ArrayList<>();
        while(rst.next()){
            School school=new School(rst.getString("name"));
            schoolList.add(school);
        }
        return schoolList;
    }

    public static int addNew(String school) throws ClassNotFoundException, SQLException {
        String sql="Insert into school values('"+school+"')";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static School searchSchoolAvalable(String school) throws ClassNotFoundException, SQLException {
        String sql="select * from School where name='"+school+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        while(rst.next()){
            School school1=new School("name");
            return school1;
        }
        return null;
    }

    public static int changeSchoolName(String SchoolName, String NewSchoolName) throws SQLException, ClassNotFoundException {
        String sql="Update School set Name='"+NewSchoolName+"' where Name='"+SchoolName+"' ";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static int removeSchool(String SchoolName) throws ClassNotFoundException, SQLException {
        String sql="Delete From School where NAme='"+SchoolName+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }
    
}
