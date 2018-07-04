/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.Controller;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTextField;
import panola.View.Result;
import panola.db.DBConnection;
import panola.model.ResultDetails;
import panola.model.StudentResult;

/**
 *
 * @author Yasiru
 */
public class ResultController {
    public static Object getResultDetails;

    public static int addResult(String IndexNumber, String StudentLastID1, String Result1) throws ClassNotFoundException, SQLException {
        String sql="Insert into Result values('"+IndexNumber+"','"+StudentLastID1+"','"+Result1+"')";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }


    public static int addDetails(String IndexNumber, String districtRank, String landRank, String ZScore) throws ClassNotFoundException, SQLException {
        String sql="Insert into ResultDetails values('"+IndexNumber+"','"+districtRank+"','"+landRank+"','"+ZScore+"')";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static ArrayList<StudentResult> getDetails(String Batch, String Subject) throws ClassNotFoundException, SQLException {
        String sql="Select S.Name, S.School, R.indexNumber, R.Result, RD.zScore, RD.disRank, RD.islandRank from Student S, Result R, ResultDetails RD, StudentBatchSubjectDetails SBSD, Subject Sub where S.NIC=SBSD.NIC and SBSD.SubID=Sub.ID and SBSD.LastID=R.LastID and R.indexNumber=RD.indexNumber and SBSD.Year='"+Batch+"' and Sub.Name='"+Subject+"'";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<StudentResult> details=new ArrayList<>();
        while(rst.next()){
            StudentResult studentResult=new StudentResult(rst.getString("S.Name"), rst.getString("S.School"), rst.getString("R.indexNumber"), rst.getString("R.Result"), rst.getString("RD.zScore"), rst.getString("RD.disRank"), rst.getString("RD.islandRank"));
            details.add(studentResult);
        }
        return details;
    }

    public static int removeData(String indexNumber) throws SQLException, ClassNotFoundException {
        String sql="Delete From Result where indexNumber='"+indexNumber+"'";
        Connection conn=(Connection) DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static ArrayList<StudentResult> getBestResultDetails(String Batch, String Subject, int Rank) throws SQLException, ClassNotFoundException {
        String sql="Select S.Name, S.School, R.indexNumber, R.Result, RD.zScore, RD.disRank, RD.islandRank from Student S, Result R, ResultDetails RD, StudentBatchSubjectDetails SBSD, Subject Sub where S.NIC=SBSD.NIC and SBSD.SubID=Sub.ID and SBSD.LastID=R.LastID and R.indexNumber=RD.indexNumber and SBSD.Year='"+Batch+"' and Sub.Name='"+Subject+"' order by RD.zScore asc limit "+Rank+" ";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<StudentResult> details=new ArrayList<>();
        while(rst.next()){
            StudentResult studentResult=new StudentResult(rst.getString("S.Name"), rst.getString("S.School"), rst.getString("R.indexNumber"), rst.getString("R.Result"), rst.getString("RD.zScore"), rst.getString("RD.disRank"), rst.getString("RD.islandRank"));
            details.add(studentResult);
        }
        return details;
    }

    public static ArrayList<StudentResult> getAPassesDetails(String Batch, String Subject, String Result) throws ClassNotFoundException, SQLException {
        String sql="Select S.Name, S.School, R.indexNumber, R.Result, RD.zScore, RD.disRank, RD.islandRank from Student S, Result R, ResultDetails RD, StudentBatchSubjectDetails SBSD, Subject Sub where S.NIC=SBSD.NIC and SBSD.SubID=Sub.ID and SBSD.LastID=R.LastID and R.indexNumber=RD.indexNumber and SBSD.Year='"+Batch+"' and Sub.Name='"+Subject+"' and R.Result='"+Result+"' order by RD.zScore";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<StudentResult> details=new ArrayList<>();
        while(rst.next()){
            StudentResult studentResult=new StudentResult(rst.getString("S.Name"), rst.getString("S.School"), rst.getString("R.indexNumber"), rst.getString("R.Result"), rst.getString("RD.zScore"), rst.getString("RD.disRank"), rst.getString("RD.islandRank"));
            details.add(studentResult);
        }
        return details;
    }

    public static int updateResults(String IndexNumber, String LastID, String Result) throws SQLException, ClassNotFoundException {
        String sql="Update Result set indexNumber='"+IndexNumber+"' , Result='"+Result+"' where LastID='"+LastID+"'";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        return stm.executeUpdate(sql);
    }

    public static ResultDetails getResultDetails(String NIC) throws ClassNotFoundException, SQLException {
        String sql="Select RD.indexNumber, RD.disRank, RD.islandRank, RD.zScore from ResultDetails RD, Result R, StudentBatchSubjectDetails SBSD where RD.indexNumber=R.indexNumber and R.LastID=SBSD.LastID and SBSD.NIC='"+NIC+"'";
        java.sql.Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            ResultDetails resultDetails=new ResultDetails(rst.getString("RD.indexNumber"), rst.getString("RD.disRank"), rst.getString("RD.islandRank"), rst.getString("RD.zScore"));
            return resultDetails;
        }
        return null;
    }

    

    
    
}
