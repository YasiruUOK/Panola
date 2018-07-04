/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.model;

/**
 *
 * @author Yasiru
 */
public class Attendance {
    private int Year;
    private String ModifySubject_ID;
    private String ModifyStudentID;
    private String Date;
    private String Time;

    public Attendance() {
    }

    public Attendance(int Year, String ModifySubject_ID, String ModifyStudentID, String Date, String Time) {
        this.Year = Year;
        this.ModifySubject_ID = ModifySubject_ID;
        this.ModifyStudentID = ModifyStudentID;
        this.Date = Date;
        this.Time = Time;
    }

    /**
     * @return the Year
     */
    public int getYear() {
        return Year;
    }

    /**
     * @param Year the Year to set
     */
    public void setYear(int Year) {
        this.Year = Year;
    }

    /**
     * @return the ModifySubject_ID
     */
    public String getModifySubject_ID() {
        return ModifySubject_ID;
    }

    /**
     * @param ModifySubject_ID the ModifySubject_ID to set
     */
    public void setModifySubject_ID(String ModifySubject_ID) {
        this.ModifySubject_ID = ModifySubject_ID;
    }

    /**
     * @return the ModifyStudentID
     */
    public String getModifyStudentID() {
        return ModifyStudentID;
    }

    /**
     * @param ModifyStudentID the ModifyStudentID to set
     */
    public void setModifyStudentID(String ModifyStudentID) {
        this.ModifyStudentID = ModifyStudentID;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the Time
     */
    public String getTime() {
        return Time;
    }

    /**
     * @param Time the Time to set
     */
    public void setTime(String Time) {
        this.Time = Time;
    }

    
}
