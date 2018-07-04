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
public class Teacher {
    private String NIC;
    private String Name;
    private String address;
    private String HomeNumber;
    private String MobileNumber;
    private double PaymentPercentage;

    public Teacher() {
    }

    public Teacher(String NIC, String Name, String address, String HomeNumber, String MobileNumber, double PaymentPercentage) {
        this.NIC = NIC;
        this.Name = Name;
        this.address = address;
        this.HomeNumber = HomeNumber;
        this.MobileNumber = MobileNumber;
        this.PaymentPercentage = PaymentPercentage;
    }
    public Teacher(String Name, String address, double PaymentPercentage) {
        this.Name = Name;
        this.address = address;
        this.PaymentPercentage = PaymentPercentage;
    }
    public Teacher(String Name){
        this.Name=Name;
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
     * @return the HomeNumber
     */
    public String getHomeNumber() {
        return HomeNumber;
    }

    /**
     * @param HomeNumber the HomeNumber to set
     */
    public void setHomeNumber(String HomeNumber) {
        this.HomeNumber = HomeNumber;
    }

    /**
     * @return the MobileNumber
     */
    public String getMobileNumber() {
        return MobileNumber;
    }

    /**
     * @param MobileNumber the MobileNumber to set
     */
    public void setMobileNumber(String MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    /**
     * @return the PaymentPercentage
     */
    public double getPaymentPercentage() {
        return PaymentPercentage;
    }

    /**
     * @param PaymentPercentage the PaymentPercentage to set
     */
    public void setPaymentPercentage(double PaymentPercentage) {
        this.PaymentPercentage = PaymentPercentage;
    }
    
}
