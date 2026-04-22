import java.util.Scanner;

class RockPaperScissors {
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0) return "rock";
        if (choice == 1) return "paper";
        return "scissors";
    }

    public static String findWinner(String player, String computer) {
        if (player.equals(computer)) return "tie";
        if (player.equals("rock") && computer.equals("scissors") ||
            player.equals("paper") && computer.equals("rock") ||
            player.equals("scissors") && computer.equals("paper")) {
            return "player";
        }
        return "computer";
    }

    public static String[][] calculateStats(int playerWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][2];
        double playerPercent = (double) playerWins / totalGames * 100;
        double computerPercent = (double) computerWins / totalGames * 100;
        stats[0][0] = "Player";
        stats[0][1] = String.format("%.2f", playerPercent);
        stats[1][0] = "Computer";
        stats[1][1] = String.format("%.2f", computerPercent);
        return stats;
    }

    public static void displayResults(String[][] results, String[][] stats) {
        System.out.println("Game Results:");
        for (String[] result : results) {
            System.out.println("Player: " + result[0] + ", Computer: " + result[1] + ", Winner: " + result[2]);
        }
        System.out.println("\nWin Percentages:");
        System.out.println("Player\tPercentage");
        for (String[] stat : stats) {
            System.out.println(stat[0] + "\t" + stat[1] + "%");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int numGames = sc.nextInt();
        sc.nextLine();
        String[][] results = new String[numGames][3];
        int playerWins = 0;
        int computerWins = 0;
        for (int i = 0; i < numGames; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String player = sc.nextLine().toLowerCase();
            String computer = getComputerChoice();
            String winner = findWinner(player, computer);
            results[i][0] = player;
            results[i][1] = computer;
            results[i][2] = winner;
            if (winner.equals("player")) playerWins++;
            if (winner.equals("computer")) computerWins++;
        }
        String[][] stats = calculateStats(playerWins, computerWins, numGames);
        displayResults(results, stats);
        sc.close();
    }
}