import java.util.Scanner;

/**
 *
 * @author RC_Student_Lab
 */
public class CricketReporctj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Declaration of arrays
        String[] players = {"Jacques Kallis", "Hashim Amla", "AB de Villiers"};
        String[] stadiums = {"Kingsmead", "St Georges", "Wanderers"};
        
        int[][] runs = new int[stadiums.length][players.length];
        
        // Get user input for runs scored - organized by stadiums first
        System.out.println("CRICKET RUNS INPUT SYSTEM");
        System.out.println("=========================");
        System.out.println();
        
        for (int i = 0; i < stadiums.length; i++) {
            System.out.println("Enter runs scored at " + stadiums[i] + ":");
            System.out.println("----------------------------------------");
            
            for (int j = 0; j < players.length; j++) {
                System.out.print("Please Enter the number of runs scored by " + players[j] + ": ");
                
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
        
        // Print the report header
        System.out.println("\nCRICKET RUNS SCORED REPORT");
        System.out.println("==========================");
        System.out.println();
        
        // Print column headers - Stadiums as rows, Players as columns
        System.out.printf("%-20s", "Stadium/Player");
        for (String player : players) {
            System.out.printf("%-20s", player);
        }
        System.out.printf("%-10s%n", "Stadium Total");
        System.out.println("----------------------------------------------------------------------------");
        
        // Print the data and calculate totals
        int[] stadiumTotals = new int[stadiums.length];
        int[] playerTotals = new int[players.length];
        int grandTotal = 0;
        
        // Print each stadium's runs and calculate totals
        for (int i = 0; i < stadiums.length; i++) {
            System.out.printf("%-20s", stadiums[i]);
            stadiumTotals[i] = 0;
            
            for (int j = 0; j < players.length; j++) {
                System.out.printf("%-20d", runs[i][j]);
                stadiumTotals[i] += runs[i][j];
                playerTotals[j] += runs[i][j];
                grandTotal += runs[i][j];
            }
            System.out.printf("%-10d%n", stadiumTotals[i]);
        }
        
        // Print player totals row
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-20s", "PLAYER TOTALS");
        for (int j = 0; j < players.length; j++) {
            System.out.printf("%-20d", playerTotals[j]);
        }
        System.out.printf("%-10d%n", grandTotal);
        
        System.out.println();
        
        // Display stadium totals clearly
        System.out.println("TOTAL RUNS AT EACH STADIUM:");
        System.out.println("===========================");
        for (int i = 0; i < stadiums.length; i++) {
            System.out.println(stadiums[i] + ": " + stadiumTotals[i] + " total runs");
        }
        
        System.out.println();
        
        // Display player totals clearly
        System.out.println("TOTAL RUNS BY EACH PLAYER:");
        System.out.println("==========================");
        for (int j = 0; j < players.length; j++) {
            System.out.println(players[j] + ": " + playerTotals[j] + " total runs");
        }
        
        System.out.println();
        
        // Determine and display the stadium with the most runs scored
        int maxRuns = stadiumTotals[0];
        String topStadium = stadiums[0];
        
        for (int i = 1; i < stadiums.length; i++) {
            if (stadiumTotals[i] > maxRuns) {
                maxRuns = stadiumTotals[i];
                topStadium = stadiums[i];
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
        
        for (int j = 1; j < players.length; j++) {
            if (playerTotals[j] > maxPlayerRuns) {
                maxPlayerRuns = playerTotals[j];
                topPlayer = players[j];
            }
        }
        
        System.out.println("Top Scorer: " + topPlayer + " with " + maxPlayerRuns + " total runs");
        System.out.println();
        
        // Display each player's average
        System.out.println("Player Averages:");
        for (int j = 0; j < players.length; j++) {
            double average = (double) playerTotals[j] / stadiums.length;
            System.out.printf("%s: %.2f runs per stadium%n", players[j], average);
        }
        
        // Display each stadium's average
        System.out.println("\nStadium Averages:");
        for (int i = 0; i < stadiums.length; i++) {
            double average = (double) stadiumTotals[i] / players.length;
            System.out.printf("%s: %.2f runs per player%n", stadiums[i], average);
        }
        
        scanner.close();
    }
}
