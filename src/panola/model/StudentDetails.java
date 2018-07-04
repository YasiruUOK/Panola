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
public class StudentDetails {
    private String StudentName;
    private String Address;
    private String school;
    private String phoneNumber;
    private String Batch;
    private String Subject;
    private String TeacherName;
    private String string;

    public StudentDetails() {
    }

    public StudentDetails(String StudentName, String Address, String school, String phoneNumber, String Batch, String Subject, String TeacherName) {
        this.StudentName = StudentName;
        this.Address = Address;
        this.school = school;
        this.phoneNumber = phoneNumber;
        this.Batch = Batch;
        this.Subject = Subject;
        this.TeacherName = TeacherName;
    }

    /**
     * @return the StudentName
     */
    public String getStudentName() {
        return StudentName;
    }

    /**
     * @param StudentName the StudentName to set
     */
    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the Batch
     */
    public String getBatch() {
        return Batch;
    }

    /**
     * @param Batch the Batch to set
     */
    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    /**
     * @return the Subject
     */
    public String getSubject() {
        return Subject;
    }

    /**
     * @param Subject the Subject to set
     */
    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    /**
     * @return the TeacherName
     */
    public String getTeacherName() {
        return TeacherName;
    }

    /**
     * @param TeacherName the TeacherName to set
     */
    public void setTeacherName(String TeacherName) {
        this.TeacherName = TeacherName;
    }

    /**
     * @return the string
     */
    public String getString() {
        return string;
    }

    /**
     * @param string the string to set
     */
    public void setString(String string) {
        this.string = string;
    }

    
}
    