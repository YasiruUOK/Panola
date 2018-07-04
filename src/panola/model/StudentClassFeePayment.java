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
public class StudentClassFeePayment {
    private String StudentID;
    private String PID;
    private double fee;
    private int PaymentYear;
    private int PaymentMounth;

    public StudentClassFeePayment() {
    }
    public StudentClassFeePayment(int PaymentYear, int PaymentMounth,String StudentID, double fee){
        this.PaymentYear = PaymentYear;
        this.PaymentMounth = PaymentMounth;
        this.StudentID = StudentID;
        this.fee = fee;
    }
    public StudentClassFeePayment(String StudentID, String PID, double fee, int PaymentYear, int PaymentMounth) {
        this.StudentID = StudentID;
        this.PID = PID;
        this.fee = fee;
        this.PaymentYear = PaymentYear;
        this.PaymentMounth = PaymentMounth;
    }
    public StudentClassFeePayment(int PaymentYear,int PaymentMounth){
        this.PaymentYear=PaymentYear;
        this.PaymentMounth=PaymentMounth;
    }
    public StudentClassFeePayment(String StudentID, String PID, double fee) {
        this.StudentID = StudentID;
        this.PID = PID;
        this.fee = fee;
    }
    public StudentClassFeePayment(String StudentID, String PID) {
        this.StudentID = StudentID;
        this.PID = PID;
    }
    /**
     * @return the StudentID
     */
    public String getStudentID() {
        return StudentID;
    }

    /**
     * @param StudentID the StudentID to set
     */
    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    /**
     * @return the PID
     */
    public String getPID() {
        return PID;
    }

    /**
     * @param PID the PID to set
     */
    public void setPID(String PID) {
        this.PID = PID;
    }

    /**
     * @return the fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(double fee) {
        this.fee = fee;
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

    /**
     * @return the PaymentMounth
     */
    public int getPaymentMounth() {
        return PaymentMounth;
    }

    /**
     * @param PaymentMounth the PaymentMounth to set
     */
    public void setPaymentMounth(int PaymentMounth) {
        this.PaymentMounth = PaymentMounth;
    }

    
}
