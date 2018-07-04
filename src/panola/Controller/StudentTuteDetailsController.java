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
import panola.model.Student_Tute_Details;
import panola.model.Tute;

/**
 *
 * @author Yasiru
 */
public class StudentTuteDetailsController {

    


    public static ArrayList<Student_Tute_Details> getAllDetails(String id) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select TD.Tute_ID, T.Name, TD.Date  from Student_Tute_Details TD, Tute T where TD.tute_ID=T.Tute_ID and TD.LastID='"+id+"'");
        ArrayList<Student_Tute_Details> student_Tute_DetailsesList=new ArrayList<>();
        while(rst.next()){
            Student_Tute_Details student_Tute_Details=new Student_Tute_Details(rst.getString("Name"), rst.getString("Tute_ID"), rst.getDate("Date"));
            student_Tute_DetailsesList.add(student_Tute_Details);
        }
        return student_Tute_DetailsesList;
    }


    public static int issueATute(Student_Tute_Details student_Tute_Details) throws ClassNotFoundException, SQLException {
        String sql="Insert into Student_Tute_Details values(?,?,?)";
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, student_Tute_Details.getStudentID());
        stm.setObject(2, student_Tute_Details.getTute_ID());
        stm.setObject(3, student_Tute_Details.getDate());
        return stm.executeUpdate();
    }
    
}
