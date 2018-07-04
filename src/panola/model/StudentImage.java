/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panola.model;

import java.io.File;
import java.sql.Blob;

/**
 *
 * @author Yasiru
 */
public class StudentImage {
    private String NIC;
    private Blob Photo;

    public StudentImage() {
    }

    public StudentImage(String NIC, Blob Photo) {
        this.NIC = NIC;
        this.Photo = Photo;
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
     * @return the Photo
     */
    public Blob getPhoto() {
        return Photo;
    }

    /**
     * @param Photo the Photo to set
     */
    public void setPhoto(Blob Photo) {
        this.Photo = Photo;
    }

   
}
