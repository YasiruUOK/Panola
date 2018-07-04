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
import panola.model.User;

/**
 *
 * @author Yasiru
 */
public class UserController {

    public static ArrayList<User> searchUser() throws ClassNotFoundException, SQLException {
        String sql="Select * from User";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<User> userList=new ArrayList<>();
        while(rst.next()){
            User user=new User(rst.getString("userName"),rst.getString("password"));
            userList.add(user);
        }
        return userList;
    }

    public static User searchUserAvailable(String userName) throws SQLException, ClassNotFoundException {
        String sql="Select * from User where userName='"+userName+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            User user=new User(rst.getString("userName"), rst.getString("password"));
            return user;
        }
        return null;
    }

    public static int addUser(User user) throws SQLException, ClassNotFoundException {
        String sql="Insert into user values(?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, user.getUserName());
        stm.setObject(2, user.getPassword());
        return stm.executeUpdate();
    }

    public static int removeUser(Object valueAt) throws ClassNotFoundException, SQLException {
        String sql="Delete from User where userName='"+valueAt+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static int resetPassword(User user) throws ClassNotFoundException, SQLException {
        String sql="update User set password='"+user.getPassword()+"' where userName='"+user.getUserName()+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    
    
}
