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
public class StudentBatchSubjectDetails {
    private String address;
    private String LastID;
    private String NIC;
    private String SubID;
    private int Year;
    private String Category;

    public StudentBatchSubjectDetails() {
    }

    public StudentBatchSubjectDetails(String LastID, String NIC, String SubjectID, int Year, String Category) {
        this.LastID=LastID;
        this.NIC = NIC;
        this.SubID = SubjectID;
        this.Year = Year;
        this.Category = Category;
    }
    public StudentBatchSubjectDetails(String LastID, String NIC,String address, String SubjectID, int Year, String Category) {
        this.LastID=LastID;
        this.NIC = NIC;
        this.SubID = SubjectID;
        this.Year = Year;
        this.Category = Category;
        this.address=address;
    }
    public StudentBatchSubjectDetails( String SubjectID, int Year, String Category) {
        this.SubID = SubjectID;
        this.Year = Year;
        this.Category = Category;
    }
    public StudentBatchSubjectDetails(String LastID, String NIC, String SubjectID, String Category) {
        this.LastID=LastID;
        this.NIC = NIC;
        this.SubID = SubjectID;
        this.Category = Category;
    }
    public StudentBatchSubjectDetails( String NIC, String SubjectID, int Year, String Category) {
        this.NIC = NIC;
        this.SubID = SubjectID;
        this.Year = Year;
        this.Category = Category;
    }
    public StudentBatchSubjectDetails(int Year) {
        this.Year=Year;
    }
    public StudentBatchSubjectDetails(String LastID) {
        this.LastID=LastID;
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
     * @return the SubjectID
     */
    public String getSubjectID() {
        return SubID;
    }

    /**
     * @param SubjectID the SubjectID to set
     */
    public void setSubjectID(String SubjectID) {
        this.SubID = SubjectID;
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
    public String getLastID(){
        return LastID;
    }
    public void setLastID(String LastID){
        this.LastID=LastID;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    
}
