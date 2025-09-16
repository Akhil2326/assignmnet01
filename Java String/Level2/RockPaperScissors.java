import java.util.Scanner;

public class RockPaperScissors {

    // Method to get computer choice randomly: "rock", "paper" or "scissors"
    public static String getComputerChoice() {
        double random = Math.random();
        if (random < 1.0 / 3) return "rock";
        else if (random < 2.0 / 3) return "paper";
        else return "scissors";
    }

    // Method to determine winner:
    // Returns "user", "computer", or "tie"
    public static String findWinner(String userChoice, String compChoice) {
        if (userChoice.equals(compChoice)) {
            return "tie";
        }

        switch (userChoice) {
            case "rock":
                return (compChoice.equals("scissors")) ? "user" : "computer";
            case "paper":
                return (compChoice.equals("rock")) ? "user" : "computer";
            case "scissors":
                return (compChoice.equals("paper")) ? "user" : "computer";
            default:
                return "invalid"; // in case user input is invalid
        }
    }

    // Method to calculate stats and return a 2D String array with averages & percentages
    public static String[][] calculateStats(int userWins, int compWins, int ties, int totalGames) {
        double userWinPercent = totalGames == 0 ? 0 : (userWins * 100.0 / totalGames);
        double compWinPercent = totalGames == 0 ? 0 : (compWins * 100.0 / totalGames);
        double tiePercent = totalGames == 0 ? 0 : (ties * 100.0 / totalGames);

        String[][] stats = new String[4][2];
        stats[0][0] = "Total Games Played"; stats[0][1] = String.valueOf(totalGames);
        stats[1][0] = "User Wins";           stats[1][1] = userWins + " (" + String.format("%.2f", userWinPercent) + "%)";
        stats[2][0] = "Computer Wins";       stats[2][1] = compWins + " (" + String.format("%.2f", compWinPercent) + "%)";
        stats[3][0] = "Ties";                stats[3][1] = ties + " (" + String.format("%.2f", tiePercent) + "%)";

        return stats;
    }

    // Method to display all game results and the stats table
    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.printf("%-10s | %-12s | %-14s | %-8s\n", "Game No.", "User Choice", "Computer Choice", "Winner");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("%-10s | %-12s | %-14s | %-8s\n",
                    (i + 1),
                    gameResults[i][0],
                    gameResults[i][1],
                    gameResults[i][2]);
        }

        System.out.println("\nSummary:");
        System.out.printf("%-20s | %-15s\n", "Category", "Count (Percentage)");
        System.out.println("----------------------------------------");
        for (String[] stat : stats) {
            System.out.printf("%-20s | %-15s\n", stat[0], stat[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of games to play: ");
        int totalGames = scanner.nextInt();
        scanner.nextLine();  // consume newline

        String[][] gameResults = new String[totalGames][3]; // Store userChoice, compChoice, winner

        int userWins = 0, compWins = 0, ties = 0;

        for (int i = 0; i < totalGames; i++) {
            System.out.print("\nGame " + (i + 1) + " - Enter your choice (rock, paper, scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();

            // Validate user input
            while (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.print("Invalid input. Please enter rock, paper, or scissors: ");
                userChoice = scanner.nextLine().toLowerCase();
            }

            String compChoice = getComputerChoice();
            String winner = findWinner(userChoice, compChoice);

            if (winner.equals("user")) userWins++;
            else if (winner.equals("computer")) compWins++;
            else ties++;

            // Save game result
            gameResults[i][0] = userChoice;
            gameResults[i][1] = compChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, compWins, ties, totalGames);

        displayResults(gameResults, stats);

        scanner.close();
    }
}
