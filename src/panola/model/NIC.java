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
public class NIC {
    private String NIC;
    private String name;
    private String address;
    private String contact_Number;
    private String School;

    public NIC() {
    }

    public NIC(String NIC, String name, String address, String contact_Number, String School) {
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.contact_Number = contact_Number;
        this.School = School;
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
    
}
