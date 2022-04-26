import java.util.ArrayList;
import java.util.Scanner;

public class GameUtil {

    static void displayWelcomeMessage() {
        System.out.println("Welcome to Fantasy Football!\n\n"
                + "You will be asked to input details about each player's weekly performance and then each player's total points"
                + " will be computed for each week.\n"
                + "The points every player obtained per week will be displayed ranked from highest to lowest");
    }

    private static final Scanner keyboard = new Scanner(System.in);

    static ArrayList<Player> initialisePlayers(int numPlayers) {
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            while (true) {
                System.out.print("Enter player " + (i + 1) + "'s name: ");

                String playerName = keyboard.nextLine();
                // if the user didn't enter a player name, inform them that the player name cannot be empty
                if (playerName == null || playerName.length() == 0) {
                    System.out.println("\nYou must enter a player name");
                } else {
                    players.add(new Player(playerName));
                    break;
                }
            }
        }
        return players;
    }

    static int askDetails(Player player, int playerWeek) {

        //every player at the beginning has 0 points
        int score = 0;
        String playerName = player.getName();

        System.out.print("\nDid " + playerName + " play in the game on week " + (playerWeek + 1) + "? (y/n) ");
        String didPlay = keyboard.nextLine();

        // Check if the player played in the game
        // if they did award them 2 points and proceed to ask further details about the players scores
        if (didPlay.equalsIgnoreCase("y")) {
            score += GameData.getPointsForPlaying();

            System.out.print("How many times did " + playerName + " score a goal in the game? ");
            int numScores = keyboard.nextInt();
            keyboard.nextLine();
            score += GameData.getPointsForGoal() * numScores;


            System.out.print("How many times did " + playerName + " assist a goal? ");
            int numGoalAssisted = keyboard.nextInt();
            keyboard.nextLine();

            score += GameData.getPointsForAssistGoal() * numGoalAssisted;

            System.out.print("How many times did " + playerName + " miss a penalty? ");
            int numMissedPenalties = keyboard.nextInt();
            keyboard.nextLine();
            score += GameData.getPointsForMissingPenalty() * numMissedPenalties;


            System.out.print("Did " + playerName + " get a yellow card? (y/n) ");
            String yellowCard = keyboard.nextLine();
            if (yellowCard.equalsIgnoreCase("y")) {
                score += GameData.getPointsForYellowCard();
            }


            System.out.print("Did " + playerName + " get a red card? (y/n) ");
            String redCard = keyboard.nextLine();
            if (redCard.equalsIgnoreCase("y")) {
                score += GameData.getPointsForRedCard();
            }

            System.out.print("Was " + playerName + " the man of the match? (y/n) ");
            String manOfMatch = keyboard.nextLine();
            if (manOfMatch.equalsIgnoreCase("y")) {
                score += GameData.getPointsForManMatch();
            }
        }

        return score;
    }

    static void printSortedScores(ArrayList<Player> players, int week) {

        System.out.println("\nYou will now see the points for each player for week " + (week + 1)
                + " sorted from highest to lowest\n");
        System.out.println("Player            Points");

        // Print the sorted player names and scores
        for (Player player : players) {
            System.out.printf("%-10s %10d %n", player.getName() + "  ", player.getWeeklyScore(week));
        }
    }
}
