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
public class Medium {
    private String MID;
    private String Medium;

    public Medium() {
    }

    public Medium(String MID, String Medium) {
        this.MID = MID;
        this.Medium = Medium;
    }

    /**
     * @return the MID
     */
    public String getMID() {
        return MID;
    }

    /**
     * @param MID the MID to set
     */
    public void setMID(String MID) {
        this.MID = MID;
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
    
}
