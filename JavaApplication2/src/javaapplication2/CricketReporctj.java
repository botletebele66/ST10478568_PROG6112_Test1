package javaapplication8;

/**
 *
 * @author RC_Student_Lab
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author RC_Student_Lab
 */
public class CricketReport1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Declaration of arrays
        String[] players = {"Jacques Kallis", "Hashim Amla", "AB de Villiers"};
        String[] stadiums = {"Kingsmead", "St Georges", "Wanderers"};
        
        int[][] runs = new int[players.length][stadiums.length];
        
        // Get user input for runs scored
        System.out.println("CRICKET RUNS INPUT SYSTEM");
        System.out.println("=========================");
        System.out.println();
        
        for (int i = 0; i < players.length; i++) {
            System.out.println("Enter runs scored by " + players[i] + ":");
            System.out.println("----------------------------------------");
            
            for (int j = 0; j < stadiums.length; j++) {
                System.out.print("Please Enter the number of runs scored at " + stadiums[j] + ": ");
                
                // Input validation
                while (true) {
                    try {
                        runs[i][j] = Integer.parseInt(scanner.nextLine());
                        if (runs[i][j] < 0) {
                            System.out.print("Please enter a non-negative number: ");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. Please enter a valid number: ");
                    }
                }
            }
            System.out.println();
        }
        
        // NEW SECTION: Display runs by each player at each stadium
        System.out.println("\nRUNS BY EACH PLAYER AT EACH STADIUM");
        System.out.println("====================================");
        System.out.println();
        
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i] + ":");
            for (int j = 0; j < stadiums.length; j++) {
                System.out.println("  - " + stadiums[j] + ": " + runs[i][j] + " runs");
            }
            System.out.println();
        }
        
        // Print the report header
        System.out.println("\nCRICKET RUNS SCORED REPORT");
        System.out.println("==========================");
        System.out.println();
        
        // Print column headers
        System.out.printf("%-20s", "Player/Stadium");
        for (String stadium : stadiums) {
            System.out.printf("%-15s", stadium);
        }
        System.out.printf("%-10s%n", "Total");
        System.out.println("----------------------------------------------------------------");
        
        // Print the data and calculate totals
        int[] playerTotals = new int[players.length];
        int[] stadiumTotals = new int[stadiums.length];
        int grandTotal = 0;
        
        // Print each player's runs and calculate totals
        for (int i = 0; i < players.length; i++) {
            System.out.printf("%-20s", players[i]);
            playerTotals[i] = 0;
            
            for (int j = 0; j < stadiums.length; j++) {
                System.out.printf("%-15d", runs[i][j]);
                playerTotals[i] += runs[i][j];
                stadiumTotals[j] += runs[i][j];
                grandTotal += runs[i][j];
            }
            System.out.printf("%-10d%n", playerTotals[i]);
        }
        
        // Print stadium totals row
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-20s", "STADIUM TOTALS");
        for (int j = 0; j < stadiums.length; j++) {
            System.out.printf("%-15d", stadiumTotals[j]);
        }
        System.out.printf("%-10d%n", grandTotal);
        
        System.out.println();
        
        // Display stadium totals clearly
        System.out.println("TOTAL RUNS AT EACH STADIUM:");
        System.out.println("===========================");
        for (int j = 0; j < stadiums.length; j++) {
            System.out.println(stadiums[j] + ": " + stadiumTotals[j] + " total runs");
        }
        
        System.out.println();
        
        // Determine and display the stadium with the most runs scored
        int maxRuns = stadiumTotals[0];
        String topStadium = stadiums[0];
        
        for (int j = 1; j < stadiums.length; j++) {
            if (stadiumTotals[j] > maxRuns) {
                maxRuns = stadiumTotals[j];
                topStadium = stadiums[j];
            }
        }
        
        System.out.println("STADIUM WITH MOST RUNS SCORED:");
        System.out.println("==============================");
        System.out.println(topStadium + " with " + maxRuns + " total runs");
        
        System.out.println();
        
        // Display individual player statistics
        System.out.println("PLAYER STATISTICS:");
        System.out.println("==================");
        
        // Find player with highest total runs
        int maxPlayerRuns = playerTotals[0];
        String topPlayer = players[0];
        
        for (int i = 1; i < players.length; i++) {
            if (playerTotals[i] > maxPlayerRuns) {
                maxPlayerRuns = playerTotals[i];
                topPlayer = players[i];
            }
        }
        
        System.out.println("Top Scorer: " + topPlayer + " with " + maxPlayerRuns + " total runs");
        
        scanner.close();
    }
}
