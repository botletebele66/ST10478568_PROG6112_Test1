/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricket.pkginterface;

// CricketRunsScored.java - Subclass
public class CricketRunsScored extends AbstractCricket {
    
    // Constructor
    public CricketRunsScored(String batsmanName, String stadiumName, int totalRuns) {
        super(batsmanName, stadiumName, totalRuns);
    }
    
    // Method to print the report
    public void printReport() {
        System.out.println("\nBATSMAN RUNS SCORED REPORT");
        System.out.println("Cricket Player : " + getBatsman());
        System.out.println("Stadium : " + getStadium());
        System.out.println("TOTAL RUNS SCORED : " + getRunsScored());
    }
}