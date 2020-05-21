import java.util.Scanner;

class methods {

    static void displayWelcomeMessage(){
        System.out.println("Welcome to Fantasy Football!\n\nYou will be asked to input details about each player's weekly " +
                "performance " + "and then each player's total points will be computed for each week.\n" +
                "The points every player obtained per week will be displayed ranked from highest to lowest\n");
    }

    private static Scanner keyboard = new Scanner(System.in);

    static void initialisePlayers(String[] player, int numPlayers){
        for (int i = 0; i < numPlayers; i++) {
            while (true) {
                System.out.print("Enter player " + (i + 1) + "'s name: ");
                player[i] = keyboard.nextLine();

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
        String playerName = player.getName();

        System.out.print("\nDid " + playerName + " play in the game on week " + playerWeek + "? (y/n) ");
        didPlay = keyboard.nextLine();

        // Check if the player played in the game
        // if they did award them 2 points and proceed to ask further details about the players scores
        if (didPlay.equals("y")) {
            score += 2;

            int didScore;
            System.out.print("How many times did " + playerName + " score a goal in the game? ");
            didScore = keyboard.nextInt();
            keyboard.nextLine();
            // Award 5 points for scoring each goal
            score += 5 * didScore;

            int goalAssist;
            System.out.print("How many times did " + playerName + " assist a goal? ");
            goalAssist = keyboard.nextInt();
            keyboard.nextLine();
            // Award 3 points for assisting each goal
            score += 3 * goalAssist;

            int missedPenalty;
            System.out.print("How many times did " + playerName + " miss a penalty? ");
            missedPenalty = keyboard.nextInt();
            keyboard.nextLine();
            //subtract 3 points for each missed penalty
            score -= 3 * missedPenalty;

            String yellowCard;
            System.out.print("Did " + playerName + " get a yellow card? (y/n) ");
            yellowCard = keyboard.nextLine();
            if (yellowCard.equals("y")) {
                //subtract 1 point for a yellow card
                score -= 1;
            }

            String redCard;
            System.out.print("Did " + playerName + " get a red card? (y/n) ");
            redCard = keyboard.nextLine();
            if (redCard.equals("y")) {
                //subtract 3 points for a red card
                score -= 3;
            }

            String manOfMatch;
            System.out.print("Was " + playerName + " the man of the match? (y/n) ");
            manOfMatch = keyboard.nextLine();
            if (manOfMatch.equals("y")) {
                // Award 5 points for the man of the match
                score += 5;
            }
        }

        // Output player's total score
        System.out.println(playerName + " has obtained a score of " + score + " points");
        return score;
    }

    static void printSortedScores(Player[] players, int week) {

        System.out.println("\nYou will now see the points for each player for week " + week + " sorted from highest to lowest\n");
        System.out.println("Player            Points");

        // Print the sorted player names and scores
        for (Player aPlayer : players) {
            System.out.printf("%-10s %10d %n", aPlayer.getName() + "  ", aPlayer.getScore(week));
        }
    }
}
