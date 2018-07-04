/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import panola.db.DBConnection;
import panola.model.Attendance;

/**
 *
 * @author Yasiru
 */
public class AttendanceController {

    public static int markAttendance(Attendance attendance) throws ClassNotFoundException, SQLException {
        String sql="Insert into Attendance value(?,?,?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, attendance.getYear());
        stm.setObject(2, attendance.getModifySubject_ID());
        stm.setObject(3, attendance.getModifyStudentID());
        stm.setObject(4, attendance.getDate());
        stm.setObject(5, attendance.getTime());
        return stm.executeUpdate();
    }
    
}
