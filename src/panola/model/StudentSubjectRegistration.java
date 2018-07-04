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
public class StudentSubjectRegistration {
    private String SSR_ID;

    public StudentSubjectRegistration() {
    }

    public StudentSubjectRegistration(String SSR_ID) {
        this.SSR_ID = SSR_ID;
    }

    /**
     * @return the SSR_ID
     */
    public String getSSR_ID() {
        return SSR_ID;
    }

    /**
     * @param SSR_ID the SSR_ID to set
     */
    public void setSSR_ID(String SSR_ID) {
        this.SSR_ID = SSR_ID;
    }
    
}
