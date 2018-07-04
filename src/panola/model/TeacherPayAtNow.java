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
public class TeacherPayAtNow {
    private String Year;
    private String Category;
    private int NoOfStudentClassFeePaid;
    private int TotalNumberOfStudent;
    private double ClassFee;
    private double PaymentPrecentage;
    private double ExpectedAmount;
    private double TotalRecivedAmount;

    public TeacherPayAtNow() {
    }

    public TeacherPayAtNow(String Year, String Category, int NoOfStudentClassFeePaid, int TotalNumberOfStudent, double ClassFee, double PaymentPrecentage, double ExpectedAmount, double TotalRecivedAmount) {
        this.Year = Year;
        this.Category = Category;
        this.NoOfStudentClassFeePaid = NoOfStudentClassFeePaid;
        this.TotalNumberOfStudent = TotalNumberOfStudent;
        this.ClassFee = ClassFee;
        this.PaymentPrecentage = PaymentPrecentage;
        this.ExpectedAmount = ExpectedAmount;
        this.TotalRecivedAmount = TotalRecivedAmount;
    }

    /**
     * @return the Year
     */
    public String getYear() {
        return Year;
    }

    /**
     * @param Year the Year to set
     */
    public void setYear(String Year) {
        this.Year = Year;
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
     * @return the NoOfStudentClassFeePaid
     */
    public int getNoOfStudentClassFeePaid() {
        return NoOfStudentClassFeePaid;
    }

    /**
     * @param NoOfStudentClassFeePaid the NoOfStudentClassFeePaid to set
     */
    public void setNoOfStudentClassFeePaid(int NoOfStudentClassFeePaid) {
        this.NoOfStudentClassFeePaid = NoOfStudentClassFeePaid;
    }

    /**
     * @return the TotalNumberOfStudent
     */
    public int getTotalNumberOfStudent() {
        return TotalNumberOfStudent;
    }

    /**
     * @param TotalNumberOfStudent the TotalNumberOfStudent to set
     */
    public void setTotalNumberOfStudent(int TotalNumberOfStudent) {
        this.TotalNumberOfStudent = TotalNumberOfStudent;
    }

    /**
     * @return the ClassFee
     */
    public double getClassFee() {
        return ClassFee;
    }

    /**
     * @param ClassFee the ClassFee to set
     */
    public void setClassFee(double ClassFee) {
        this.ClassFee = ClassFee;
    }

    /**
     * @return the PaymentPrecentage
     */
    public double getPaymentPrecentage() {
        return PaymentPrecentage;
    }

    /**
     * @param PaymentPrecentage the PaymentPrecentage to set
     */
    public void setPaymentPrecentage(double PaymentPrecentage) {
        this.PaymentPrecentage = PaymentPrecentage;
    }

    /**
     * @return the ExpectedAmount
     */
    public double getExpectedAmount() {
        return ExpectedAmount;
    }

    /**
     * @param ExpectedAmount the ExpectedAmount to set
     */
    public void setExpectedAmount(double ExpectedAmount) {
        this.ExpectedAmount = ExpectedAmount;
    }

    /**
     * @return the TotalRecivedAmount
     */
    public double getTotalRecivedAmount() {
        return TotalRecivedAmount;
    }

    /**
     * @param TotalRecivedAmount the TotalRecivedAmount to set
     */
    public void setTotalRecivedAmount(double TotalRecivedAmount) {
        this.TotalRecivedAmount = TotalRecivedAmount;
    }
    
    
}
