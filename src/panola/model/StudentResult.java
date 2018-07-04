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
public class StudentResult {
    private String Name;
    private String School;
    private String IndexNumber;
    private String Result;
    private String ZScore;
    private String DistrictRank;
    private String IslandRank;
    private String Batch;
    private String SubjectID;

    public StudentResult() {
    }

    public StudentResult(String Name, String School, String IndexNumber, String Result, String ZScore, String DistrictRank, String IslandRank) {
        this.Name = Name;
        this.School = School;
        this.IndexNumber = IndexNumber;
        this.Result = Result;
        this.ZScore = ZScore;
        this.DistrictRank = DistrictRank;
        this.IslandRank = IslandRank;
    }

    public StudentResult(String Name, String School, String IndexNumber, String Result, String ZScore, String DistrictRank, String IslandRank, String Batch, String SubjectID) {
        this.Name = Name;
        this.School = School;
        this.IndexNumber = IndexNumber;
        this.Result = Result;
        this.ZScore = ZScore;
        this.DistrictRank = DistrictRank;
        this.IslandRank = IslandRank;
        this.Batch = Batch;
        this.SubjectID = SubjectID;
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
     * @return the School
     */
    public String getSchool() {
        return School;
    }

    /**
     * @param School the School to set
     */
    public void setSchool(String School) {
        this.School = School;
    }

    /**
     * @return the IndexNumber
     */
    public String getIndexNumber() {
        return IndexNumber;
    }

    /**
     * @param IndexNumber the IndexNumber to set
     */
    public void setIndexNumber(String IndexNumber) {
        this.IndexNumber = IndexNumber;
    }

    /**
     * @return the Result
     */
    public String getResult() {
        return Result;
    }

    /**
     * @param Result the Result to set
     */
    public void setResult(String Result) {
        this.Result = Result;
    }

    /**
     * @return the ZScore
     */
    public String getZScore() {
        return ZScore;
    }

    /**
     * @param ZScore the ZScore to set
     */
    public void setZScore(String ZScore) {
        this.ZScore = ZScore;
    }

    /**
     * @return the DistrictRank
     */
    public String getDistrictRank() {
        return DistrictRank;
    }

    /**
     * @param DistrictRank the DistrictRank to set
     */
    public void setDistrictRank(String DistrictRank) {
        this.DistrictRank = DistrictRank;
    }

    /**
     * @return the IslandRank
     */
    public String getIslandRank() {
        return IslandRank;
    }

    /**
     * @param IslandRank the IslandRank to set
     */
    public void setIslandRank(String IslandRank) {
        this.IslandRank = IslandRank;
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
     * @return the SubjectID
     */
    public String getSubjectID() {
        return SubjectID;
    }

    /**
     * @param SubjectID the SubjectID to set
     */
    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }
    
}
