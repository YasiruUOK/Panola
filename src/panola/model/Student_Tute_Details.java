/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.model;

import java.util.Date;

/**
 *
 * @author Yasiru
 */
public class Student_Tute_Details {
    private String StudentID;
    private String Tute_ID;
    private Date date;

    public Student_Tute_Details() {
    }

    public Student_Tute_Details(String StudentID, String Tute_ID, Date date) {
        this.StudentID = StudentID;
        this.Tute_ID = Tute_ID;
        this.date = date;
    }

    /**
     * @return the StudentID
     */
    public String getStudentID() {
        return StudentID;
    }

    /**
     * @param StudentID the StudentID to set
     */
    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    /**
     * @return the Tute_ID
     */
    public String getTute_ID() {
        return Tute_ID;
    }

    /**
     * @param Tute_ID the Tute_ID to set
     */
    public void setTute_ID(String Tute_ID) {
        this.Tute_ID = Tute_ID;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
}
