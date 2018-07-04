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
public class ResultDetails {
    private String indexNumber;
    private String disRank;
    private String islandRank;
    private String zScore;

    public ResultDetails() {
    }

    public ResultDetails(String indexNumber, String disRank, String islandRank, String zScore) {
        this.indexNumber = indexNumber;
        this.disRank = disRank;
        this.islandRank = islandRank;
        this.zScore = zScore;
    }

    /**
     * @return the indexNumber
     */
    public String getIndexNumber() {
        return indexNumber;
    }

    /**
     * @param indexNumber the indexNumber to set
     */
    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    /**
     * @return the disRank
     */
    public String getDisRank() {
        return disRank;
    }

    /**
     * @param disRank the disRank to set
     */
    public void setDisRank(String disRank) {
        this.disRank = disRank;
    }

    /**
     * @return the islandRank
     */
    public String getIslandRank() {
        return islandRank;
    }

    /**
     * @param islandRank the islandRank to set
     */
    public void setIslandRank(String islandRank) {
        this.islandRank = islandRank;
    }

    /**
     * @return the zScore
     */
    public String getzScore() {
        return zScore;
    }

    /**
     * @param zScore the zScore to set
     */
    public void setzScore(String zScore) {
        this.zScore = zScore;
    }
    
}
