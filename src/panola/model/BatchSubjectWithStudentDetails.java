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
public class BatchSubjectWithStudentDetails {
    private String name;
    private String address;
    private String contact_Number;
    private int Year;
    private String Subject_Name;
    private String Category;

    public BatchSubjectWithStudentDetails() {
    }

    public BatchSubjectWithStudentDetails(String name, String address, String contact_Number, int Year, String Subject_Name, String Category) {
        this.name = name;
        this.address = address;
        this.contact_Number = contact_Number;
        this.Year = Year;
        this.Subject_Name = Subject_Name;
        this.Category = Category;
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
     * @return the contact_Number
     */
    public String getContact_Number() {
        return contact_Number;
    }

    /**
     * @param contact_Number the contact_Number to set
     */
    public void setContact_Number(String contact_Number) {
        this.contact_Number = contact_Number;
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
     * @return the Subject_Name
     */
    public String getSubject_Name() {
        return Subject_Name;
    }

    /**
     * @param Subject_Name the Subject_Name to set
     */
    public void setSubject_Name(String Subject_Name) {
        this.Subject_Name = Subject_Name;
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
    
}
