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
public class StudentTute {
    private String Tute_ID;
    private String Name;
    private Date date;
    private int Issued;
    private int Available;

    public StudentTute() {
    }

    public StudentTute(String Tute_ID, String Name, Date date, int Issued, int Available) {
        this.Tute_ID = Tute_ID;
        this.Name = Name;
        this.date = date;
        this.Issued = Issued;
        this.Available = Available;
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
     * @return the Issued
     */
    public int getIssued() {
        return Issued;
    }

    /**
     * @param Issued the Issued to set
     */
    public void setIssued(int Issued) {
        this.Issued = Issued;
    }

    /**
     * @return the Available
     */
    public int getAvailable() {
        return Available;
    }

    /**
     * @param Available the Available to set
     */
    public void setAvailable(int Available) {
        this.Available = Available;
    }
    
    
}
