/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.other;

import java.sql.SQLException;
import java.text.NumberFormat;
import panola.Controller.IDController;

/**
 *
 * @author Yasiru
 */
public class IDGenarator {
   public static String getNewID(String tableName,String columName,String prifix) throws ClassNotFoundException, SQLException{
       String lastID=IDController.getLastID(tableName,columName);
       if(lastID!=null){
           int id=Integer.parseInt(lastID.split(prifix)[1]);
           id++;
           NumberFormat numberFormat=NumberFormat.getInstance();
           numberFormat.setMinimumIntegerDigits(3);
           numberFormat.setGroupingUsed(false);
           String newID=numberFormat.format(id);
           return prifix+newID;
       }else{
           return prifix+"001";
       }
   } 

    public static String getStudentNewID(String tableName, String columName) throws ClassNotFoundException, SQLException {
        String lastID=IDController.getLastID(tableName,columName);
        if(lastID!=null){
            int id=Integer.parseInt(lastID.substring(8, 10));
            id++;
            NumberFormat numberFormat=NumberFormat.getInstance();
           numberFormat.setMinimumIntegerDigits(3);
           numberFormat.setGroupingUsed(false);
           String newID=numberFormat.format(id);
            return newID;
        }
        return "001";
    }

    public static String getStudentID() throws ClassNotFoundException, SQLException {
        String ID=IDController.getID();
        if(ID!=null){
            int id=Integer.parseInt(ID);
            id++;
            NumberFormat numberFormat=NumberFormat.getInstance();
           numberFormat.setMinimumIntegerDigits(3);
           numberFormat.setGroupingUsed(false);
           String newID=numberFormat.format(id);
            return newID;
        }
        return "001";
    }
}
