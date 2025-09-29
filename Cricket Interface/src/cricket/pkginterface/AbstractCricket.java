/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricket.pkginterface;

// AbstractCricket.java - Abstract class
public abstract class AbstractCricket implements Cricket {
    private String batsmanName;
    private String stadiumName;
    private int totalRuns;
    
    // Constructor
    public AbstractCricket(String batsmanName, String stadiumName, int totalRuns) {
        setBatsmanName(batsmanName);
        setStadiumName(stadiumName);
        setTotalRuns(totalRuns);
    }
    
    // Validation and setter methods
    private void setBatsmanName(String batsmanName) {
        if (batsmanName == null || batsmanName.trim().isEmpty()) {
            throw new IllegalArgumentException("Batsman name cannot be empty or null");
        }
        this.batsmanName = batsmanName.trim();
    }
    
    private void setStadiumName(String stadiumName) {
        if (stadiumName == null || stadiumName.trim().isEmpty()) {
            throw new IllegalArgumentException("Stadium name cannot be empty or null");
        }
        this.stadiumName = stadiumName.trim();
    }
    
    private void setTotalRuns(int totalRuns) {
        if (totalRuns < 0) {
            throw new IllegalArgumentException("Total runs cannot be negative");
        }
        this.totalRuns = totalRuns;
    }
    
    // Interface method implementations
    @Override
    public String getBatsman() {
        return batsmanName;
    }
    
    @Override
    public String getStadium() {
        return stadiumName;
    }
    
    @Override
    public int getRunsScored() {
        return totalRuns;
    }
}