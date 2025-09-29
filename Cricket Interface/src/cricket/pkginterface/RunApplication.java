/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricket.pkginterface;

// RunApplication.java - Main application class
import java.util.Scanner;

public class RunApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Get user input
            System.out.print("The Cricketer name : ");
            String batsmanName = scanner.nextLine();
            
            System.out.print("Enter the Stadium : ");
            String stadiumName = scanner.nextLine();
            
            System.out.print("Enter the total runs scored by " + batsmanName + " at " + stadiumName + ": ");
            int totalRuns = scanner.nextInt();
            
            // Create CricketRunsScored object
            CricketRunsScored cricketRecord = new CricketRunsScored(batsmanName, stadiumName, totalRuns);
            
            // Print the report
            cricketRecord.printReport();
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter valid data.");
        } finally {
            scanner.close();
        }
    }
}