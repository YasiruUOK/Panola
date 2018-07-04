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
public class AddmissionPaymentDetails {
    private String batch;
    private String category;
    private String subject;
    private String DateFrom;
    private String DateTo;
    private Date date;
    private double fee;

    public AddmissionPaymentDetails() {
    }

    public AddmissionPaymentDetails(String batch, String category, String subject, String DateFrom, String DateTo) {
        this.batch = batch;
        this.category = category;
        this.subject = subject;
        this.DateFrom = DateFrom;
        this.DateTo = DateTo;
    }
    public AddmissionPaymentDetails(String batch, String category, String subject, Date date, double fee) {
        this.batch = batch;
        this.category = category;
        this.subject = subject;
        this.date=date;
        this.fee=fee;
    }
    /**
     * @return the batch
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param batch the batch to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    public String getBatch() {
        return batch;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }
    public double getFee() {
        return fee;
    }
    /**
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the medium
     */
   

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the DateFrom
     */
    public String getDateFrom() {
        return DateFrom;
    }

    /**
     * @param DateFrom the DateFrom to set
     */
    public void setDateFrom(String DateFrom) {
        this.DateFrom = DateFrom;
    }

    /**
     * @return the DateTo
     */
    public String getDateTo() {
        return DateTo;
    }

    /**
     * @param DateTo the DateTo to set
     */
    public void setDateTo(String DateTo) {
        this.DateTo = DateTo;
    }
    

    
}
