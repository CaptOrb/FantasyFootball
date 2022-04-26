import java.util.ArrayList;
import java.util.InputMismatchException;
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

    static int determineWeeklyPlayerPerformance(Player player, int week) {

        int totalPlayerScore = 0;
        String playerName = player.getName();

        askQuestion("\nDid " + playerName + " play in the game on week " + (week + 1) + "? (y/n) ");
        String didPlay = keyboard.nextLine();

        if (didPlay.equalsIgnoreCase("y")) {
            totalPlayerScore += GameData.getPointsForPlaying();
            int numScores;

            do {
                askQuestion("How many times did " + playerName + " score a goal in the game? ");

                numScores = parseNextInteger();
                totalPlayerScore += GameData.getPointsForGoal() * numScores;

            } while (numScores < 0);

            int numGoalAssisted;
            do {
                askQuestion("How many times did " + playerName + " assist a goal? ");
                numGoalAssisted = parseNextInteger();
                totalPlayerScore += GameData.getPointsForAssistGoal() * numGoalAssisted;

            } while (numGoalAssisted < 0);

            int numMissedPenalties;
            do {
                askQuestion("How many times did " + playerName + " miss a penalty? ");
                numMissedPenalties = parseNextInteger();
                totalPlayerScore += GameData.getPointsForMissingPenalty() * numMissedPenalties;
            } while (numMissedPenalties < 0);

            askQuestion("Did " + playerName + " get a yellow card? (y/n) ");
            String yellowCard = keyboard.nextLine();
            if (yellowCard.equalsIgnoreCase("y")) {
                totalPlayerScore += GameData.getPointsForYellowCard();
            }

            askQuestion("Did " + playerName + " get a red card? (y/n) ");
            String redCard = keyboard.nextLine();
            if (redCard.equalsIgnoreCase("y")) {
                totalPlayerScore += GameData.getPointsForRedCard();
            }

            askQuestion("Was " + playerName + " the man of the match? (y/n) ");
            String manOfMatch = keyboard.nextLine();
            if (manOfMatch.equalsIgnoreCase("y")) {
                totalPlayerScore += GameData.getPointsForManMatch();
            }
        }

        return totalPlayerScore;
    }

    public static int parseNextInteger() {
        int input = -1;

        try {
            input = keyboard.nextInt();
            keyboard.nextLine();
        } catch (InputMismatchException ex) {
            System.out.println("Must enter an integer");
            keyboard.next();
        }

        return input;
    }

    private static void askQuestion(String question) {
        System.out.print(question);
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
