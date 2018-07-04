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
public class StudentSubjectBatch {
    private String StudentID;
    private int Year;
    private String Subject_ID;
    private String NIC;

    public StudentSubjectBatch() {
    }

    public StudentSubjectBatch(String StudentID, int Year, String Subject_ID, String NIC) {
        this.StudentID = StudentID;
        this.Year = Year;
        this.Subject_ID = Subject_ID;
        this.NIC = NIC;
    }
    public StudentSubjectBatch(String StudentID, String Subject_ID){
        this.StudentID=StudentID;
        this.Subject_ID=Subject_ID;
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
     * @return the Subject_ID
     */
    public String getSubject_ID() {
        return Subject_ID;
    }

    /**
     * @param Subject_ID the Subject_ID to set
     */
    public void setSubject_ID(String Subject_ID) {
        this.Subject_ID = Subject_ID;
    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
    
    
}
