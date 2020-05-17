import java.util.Scanner;

class methods {
    private static Scanner keyboard = new Scanner(System.in);

    static void initialisePlayers(String[] player, int numPlayers){
        for (int i = 0; i < numPlayers; i++) {
            while (true) {
                System.out.print("Enter player " + (i + 1) + "'s name: ");
                player[i] = keyboard.next();

                // if the user didn't enter a player name, inform them that the player name cannot be empty
                if (player[i] == null || player[i].length() == 0) {
                    System.out.println("\nYou must enter a player name");
                } else {
                    break;
                }
            }
        }
    }

    static int askDetails(Player player, int playerWeek) {

        //every player at the beginning has 0 points
        int score = 0;
        String didPlay;
        System.out.print("\nDid " + player.getName() + " play in the game on week " + playerWeek + "? (y/n) ");
        didPlay = keyboard.next();

        // Check if the player played in the game
        // if they did award them 2 points and proceed to ask further details about the players scores
        if (didPlay.equals("y")) {
            score += 2;

            int didScore;
            System.out.print("How many times did " + player.getName() + " score a goal in the game? ");
            didScore = keyboard.nextInt();
            keyboard.nextLine();
            // Award 5 points for scoring each goal
            score += 5 * didScore;

            int goalAssist;
            System.out.print("How many times did " + player.getName() + " assist a goal? ");
            goalAssist = keyboard.nextInt();
            // Award 3 points for assisting eacg goal
            score += 3 * goalAssist;

            int missedPenalty;
            System.out.print("How many times did " + player.getName() + " miss a penalty? ");
            missedPenalty = keyboard.nextInt();
            //subtract 3 points for each missed penalty
            score -= 3 * missedPenalty;

            String yellowCard;
            System.out.print("Did " + player.getName() + " get a yellow card? (y/n) ");
            yellowCard = keyboard.next();
            if (yellowCard.equals("y")) {
                score -= 1;
            }

            String redCard;
            System.out.print("Did " + player.getName() + " get a red card? (y/n) ");
            redCard = keyboard.next();
            if (redCard.equals("y")) {
                //subtract 3 point for a red card
                score -= 3;
            }

            String manOfMatch;
            System.out.print("Was " + player.getName() + " the man of the match? (y/n) ");
            manOfMatch = keyboard.next();
            if (manOfMatch.equals("y")) {
                // Award 5 points for man of the match
                score += 5;
            }
        }

        // Output player's total score
        System.out.println(player.getName() + " has obtained a score of " + score + " points");
        return score;
    }

    static void printSortedScores(Player[] player, int week) {

        System.out.println("\nYou will now see the scores of each player for week " + week + " sorted from highest to lowest\n");
        System.out.println("Player            Score");

        // Print the player names and scores
        for (Player aPlayer : player) {
            System.out.printf("%-10s %10d %n", aPlayer.getName() + "  ", aPlayer.getScore(week));
        }
    }
}
