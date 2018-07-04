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
public class Payment {
    private String Payment_ID;
    private String Date;
    private String Reason;

    public Payment() {
    }

    public Payment(String Payment_ID, String Date, String Reason) {
        this.Payment_ID = Payment_ID;
        this.Date = Date;
        this.Reason = Reason;
    }
    public Payment(String Payment_ID, String Date) {
        this.Payment_ID = Payment_ID;
        this.Date = Date;
        this.Reason = Reason;
    }
    /**
     * @return the Payment_ID
     */
    public String getPayment_ID() {
        return Payment_ID;
    }

    /**
     * @param Payment_ID the Payment_ID to set
     */
    public void setPayment_ID(String Payment_ID) {
        this.Payment_ID = Payment_ID;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the Reason
     */
    public String getReason() {
        return Reason;
    }

    /**
     * @param Reason the Reason to set
     */
    public void setReason(String Reason) {
        this.Reason = Reason;
    }
    
    
}
