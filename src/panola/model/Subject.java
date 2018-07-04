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
public class Subject {
    private String Subject_ID;
    private String Name;
    private double fee;
    private String teacherName;
    private String stream;

    public Subject() {
    }
    public Subject(String Subject_ID){
        this.Subject_ID=Subject_ID;
    }
    public Subject(double fee){
        this.fee=fee;
    }
    public Subject(String Subject_ID, String Name, double fee, String teacherName) {
        this.Subject_ID = Subject_ID;
        this.Name = Name;
        this.fee = fee;
        this.teacherName = teacherName;
    }
    public Subject(String Subject_ID, String Name) {
        this.Subject_ID = Subject_ID;
        this.Name = Name;
    }
    public Subject(String Name, double fee, String teacherName){
        this.Name=Name;
        this.fee=fee;
        this.teacherName=teacherName;
    }
     public Subject(String Subject_ID, String Name, double fee,String Stream, String teacherName) {
        this.Subject_ID = Subject_ID;
        this.Name = Name;
        this.fee = fee;
        this.teacherName = teacherName;
        this.stream=stream;
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
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /**
     * @return the teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName the teacherName to set
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getStream(){
        return stream;
    }
    public void setStream(String stream){
        this.stream=stream;
    }
    
}
