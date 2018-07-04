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
public class ClassCategory {
    private String CCID;
    private String Name;

    public ClassCategory() {
    }

    public ClassCategory(String CCID, String Name) {
        this.CCID = CCID;
        this.Name = Name;
    }

    /**
     * @return the CCID
     */
    public String getCCID() {
        return CCID;
    }

    /**
     * @param CCID the CCID to set
     */
    public void setCCID(String CCID) {
        this.CCID = CCID;
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
    
}
