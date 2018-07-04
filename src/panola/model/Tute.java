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
public class Tute {
    private String Tute_ID;
    private String Subject_ID;
    private String Category;
    private Date date;
    private String Year;
    private String Name;
    private int CopyAvailable;

    public Tute() {
    }

    public Tute(String Tute_ID, String Subject_ID, String Category, Date date, String Year, String Name, int CopyAvailable) {
        this.Tute_ID = Tute_ID;
        this.Subject_ID = Subject_ID;
        this.Category = Category;
        this.date = date;
        this.Year = Year;
        this.Name = Name;
        this.CopyAvailable = CopyAvailable;
    }
    public Tute(String Name) {
        this.Name = Name;
    }

    public Tute(String Year, String Subject_ID, String Category){
        this.Year=Year;
        this.Subject_ID=Subject_ID;
        this.Category=Category;
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
     * @return the CopyAvailable
     */
    public int getCopyAvailable() {
        return CopyAvailable;
    }

    /**
     * @param CopyAvailable the CopyAvailable to set
     */
    public void setCopyAvailable(int CopyAvailable) {
        this.CopyAvailable = CopyAvailable;
    }
    
}
