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
public class TeacherPayments {
    private String NIC;
    private double PaymentAmount;
    private int PaymentMonth;
    private int PaymentYear;

    public TeacherPayments() {
    }

    public TeacherPayments(String NIC, double PaymentAmount, int PaymentMonth, int PaymentYear) {
        this.NIC = NIC;
        this.PaymentAmount = PaymentAmount;
        this.PaymentMonth = PaymentMonth;
        this.PaymentYear = PaymentYear;
    }
    public TeacherPayments(String NIC, double PaymentAmount) {
        this.NIC = NIC;
        this.PaymentAmount = PaymentAmount;
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
     * @return the PaymentAmount
     */
    public double getPaymentAmount() {
        return PaymentAmount;
    }

    /**
     * @param PaymentAmount the PaymentAmount to set
     */
    public void setPaymentAmount(double PaymentAmount) {
        this.PaymentAmount = PaymentAmount;
    }

    /**
     * @return the PaymentMonth
     */
    public int getPaymentMonth() {
        return PaymentMonth;
    }

    /**
     * @param PaymentMonth the PaymentMonth to set
     */
    public void setPaymentMonth(int PaymentMonth) {
        this.PaymentMonth = PaymentMonth;
    }

    /**
     * @return the PaymentYear
     */
    public int getPaymentYear() {
        return PaymentYear;
    }

    /**
     * @param PaymentYear the PaymentYear to set
     */
    public void setPaymentYear(int PaymentYear) {
        this.PaymentYear = PaymentYear;
    }

    
}
