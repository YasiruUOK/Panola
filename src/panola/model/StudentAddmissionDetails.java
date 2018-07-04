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
public class StudentAddmissionDetails {
    private String name;
    private String address;
    private String contact_Number;
    private Date Date;
    private int fee;

    public StudentAddmissionDetails() {
    }

    public StudentAddmissionDetails(String name, String address, String contact_Number, Date Date, int fee) {
        this.name = name;
        this.address = address;
        this.contact_Number = contact_Number;
        this.Date = Date;
        this.fee = fee;
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
     * @return the Date
     */
    public Date getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(Date Date) {
        this.Date = Date;
    }

    /**
     * @return the fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(int fee) {
        this.fee = fee;
    }
    
}
