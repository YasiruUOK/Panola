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
public class PaymentHistory {
    private String Batch;
    private String Subject;
    private String Category;
    private String fromDate;
    private String toDate;
    private String StudentName;
    private String NIC;
    private String address;
    private String paymentFor;
    private String PaidDate;
    private double paidAmount;

    public PaymentHistory() {
    }

    public PaymentHistory(String Batch, String Subject, String Category, String fromDate, String toDate, String StudentName, String NIC, String address, String paymentFor, String PaidDate, double paidAmount) {
        this.Batch = Batch;
        this.Subject = Subject;
        this.Category = Category;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.StudentName = StudentName;
        this.NIC = NIC;
        this.address = address;
        this.paymentFor = paymentFor;
        this.PaidDate = PaidDate;
        this.paidAmount = paidAmount;
    }
    public PaymentHistory(String Batch, String Subject, String Category, String StudentName, double paidAmount,String PaidDate, String fromDate, String toDate) {
        this.Batch = Batch;
        this.Subject = Subject;
        this.Category = Category;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.StudentName = StudentName;
        this.paidAmount = paidAmount;
        this.PaidDate=PaidDate;
    }
    public PaymentHistory(String Batch, String Subject, String Category, String fromDate, String toDate) {
        this.Batch = Batch;
        this.Subject = Subject;
        this.Category = Category;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
    public PaymentHistory(String fromDate, String toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
    public PaymentHistory(String StudentName, String NIC, String address, String paymentFor, String PaidDate, double paidAmount) {
        this.StudentName = StudentName;
        this.NIC = NIC;
        this.address = address;
        this.paymentFor = paymentFor;
        this.PaidDate = PaidDate;
        this.paidAmount = paidAmount;
    }
    /**
     * @return the Batch
     */
    public String getBatch() {
        return Batch;
    }

    /**
     * @param Batch the Batch to set
     */
    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    /**
     * @return the Subject
     */
    public String getSubject() {
        return Subject;
    }

    /**
     * @param Subject the Subject to set
     */
    public void setSubject(String Subject) {
        this.Subject = Subject;
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
     * @return the fromDate
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @return the toDate
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * @return the StudentName
     */
    public String getStudentName() {
        return StudentName;
    }

    /**
     * @param StudentName the StudentName to set
     */
    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
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
     * @return the paymentFor
     */
    public String getPaymentFor() {
        return paymentFor;
    }

    /**
     * @param paymentFor the paymentFor to set
     */
    public void setPaymentFor(String paymentFor) {
        this.paymentFor = paymentFor;
    }

    /**
     * @return the PaidDate
     */
    public String getPaidDate() {
        return PaidDate;
    }

    /**
     * @param PaidDate the PaidDate to set
     */
    public void setPaidDate(String PaidDate) {
        this.PaidDate = PaidDate;
    }

    /**
     * @return the paidAmount
     */
    public double getPaidAmount() {
        return paidAmount;
    }

    /**
     * @param paidAmount the paidAmount to set
     */
    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    
}
