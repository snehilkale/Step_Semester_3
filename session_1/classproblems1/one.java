package classproblems1;

import java.util.Random;

public class one {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final Random random = new Random();

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        
        return "Computer Wins";
    }

    public static void main(String[] args) {
        // Predefined moves for live demo as suggested
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int n = playerMoves.length;

        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            computerMoves[i] = MOVES[random.nextInt(3)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-14s | %-12s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("Round %-4d | %-12s | %-14s | %-12s\n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("---------------------------------------------------------------");

        double winPercentage = ((double) wins / n) * 100;
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", 
                          wins, losses, draws, winPercentage);
    }
}
