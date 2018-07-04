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
public class StreamSubjectDetails {
    private String SSD_ID;
    private String Subject_ID;
    private String StreamID;

    public StreamSubjectDetails() {
    }

    public StreamSubjectDetails(String SSD_ID, String Subject_ID, String StreamID) {
        this.SSD_ID = SSD_ID;
        this.Subject_ID = Subject_ID;
        this.StreamID = StreamID;
    }

    /**
     * @return the SSD_ID
     */
    public String getSSD_ID() {
        return SSD_ID;
    }

    /**
     * @param SSD_ID the SSD_ID to set
     */
    public void setSSD_ID(String SSD_ID) {
        this.SSD_ID = SSD_ID;
    }

    /**
     * @return the Subject_ID
     */
    public String getSubject_ID() {
        return Subject_ID;
    }

    /**
     * @param Subject_ID the Subject_ID to set
     */
    public void setSubject_ID(String Subject_ID) {
        this.Subject_ID = Subject_ID;
    }

    /**
     * @return the StreamID
     */
    public String getStreamID() {
        return StreamID;
    }

    /**
     * @param StreamID the StreamID to set
     */
    public void setStreamID(String StreamID) {
        this.StreamID = StreamID;
    }
    
    
}
