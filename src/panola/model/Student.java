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
public class Student {
    private String NIC;
    private String name;
    private String address;
    private String contatct_Number;
    private String School;
    private String BatchYear;
    private String Subject;
    private String Medium;
    private String Category;
    //private String date;
    private Date date;

    public Student() {
    }
    public Student(String name, String address, String contatct_Number, String School, String BatchYear, String Subject, String Medium, String Category, Date date) {
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.contatct_Number = contatct_Number;
        this.School = School;
        this.BatchYear = BatchYear;
        this.Subject = Subject;
        this.Medium = Medium;
        this.Category = Category;
        this.date = date;
    }
    
    public Student(String NIC, String name, String address, String contatct_Number, String School, String BatchYear, String Subject, String Medium, String Category, Date date) {
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.contatct_Number = contatct_Number;
        this.School = School;
        this.BatchYear = BatchYear;
        this.Subject = Subject;
        this.Medium = Medium;
        this.Category = Category;
        this.date = date;
    }
     public Student(String NIC, String name, String address, String contatct_Number, String School) {
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.contatct_Number = contatct_Number;
        this.School = School;
     }
     public Student(String NIC, String name, String address, String contatct_Number) {
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.contatct_Number = contatct_Number;
     }
    public Student(String name){
        this.name=name;
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contatct_Number
     */
    public String getContatct_Number() {
        return contatct_Number;
    }

    /**
     * @param contatct_Number the contatct_Number to set
     */
    public void setContatct_Number(String contatct_Number) {
        this.contatct_Number = contatct_Number;
    }

    /**
     * @return the School
     */
    public String getSchool() {
        return School;
    }

    /**
     * @param School the School to set
     */
    public void setSchool(String School) {
        this.School = School;
    }

    /**
     * @return the BatchYear
     */
    public String getBatchYear() {
        return BatchYear;
    }

    /**
     * @param BatchYear the BatchYear to set
     */
    public void setBatchYear(String BatchYear) {
        this.BatchYear = BatchYear;
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
     * @return the Medium
     */
    public String getMedium() {
        return Medium;
    }

    /**
     * @param Medium the Medium to set
     */
    public void setMedium(String Medium) {
        this.Medium = Medium;
    }

    /**
     * @return the Category
     */
    public String getCategory() {
        return Category;
    }

    /**
     * @param Category the Category to set
     */
    public void setCategory(String Category) {
        this.Category = Category;
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
