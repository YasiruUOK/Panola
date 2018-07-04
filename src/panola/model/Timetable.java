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
public class Timetable {
    private String SubjectID;
    private String TeacherID;
    private String Year;
    private String category;
    private String date;
    private String Time;
    private int NoOfStudent;

    public Timetable() {
    }

    public Timetable(String SubjectID, String TeacherID, String Year, String category, String date, String Time, int NoOfStudent) {
        this.SubjectID = SubjectID;
        this.TeacherID = TeacherID;
        this.Year = Year;
        this.category = category;
        this.date = date;
        this.Time = Time;
        this.NoOfStudent = NoOfStudent;
    }
    public Timetable(String Year, String category, String date, String Time) {
        this.Year = Year;
        this.category = category;
        this.date = date;
        this.Time = Time;
    }
    public Timetable(String SubjectID, String TeacherID, String Year, String category, String date, String Time) {
        this.SubjectID = SubjectID;
        this.TeacherID = TeacherID;
        this.Year = Year;
        this.category = category;
        this.date = date;
        this.Time = Time;
    }
    public Timetable(String SubjectID, String TeacherID, String Year, String category, String Time) {
        this.SubjectID = SubjectID;
        this.TeacherID = TeacherID;
        this.Year = Year;
        this.category = category;
        this.Time = Time;
    }
    /**
     * @return the SubjectID
     */
    public String getSubjectID() {
        return SubjectID;
    }

    /**
     * @param SubjectID the SubjectID to set
     */
    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }

    /**
     * @return the TeacherID
     */
    public String getTeacherID() {
        return TeacherID;
    }

    /**
     * @param TeacherID the TeacherID to set
     */
    public void setTeacherID(String TeacherID) {
        this.TeacherID = TeacherID;
    }

    /**
     * @return the Year
     */
    public String getYear() {
        return Year;
    }

    /**
     * @param Year the Year to set
     */
    public void setYear(String Year) {
        this.Year = Year;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
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

    /**
     * @return the NoOfStudent
     */
    public int getNoOfStudent() {
        return NoOfStudent;
    }

    /**
     * @param NoOfStudent the NoOfStudent to set
     */
    public void setNoOfStudent(int NoOfStudent) {
        this.NoOfStudent = NoOfStudent;
    }

   
}
