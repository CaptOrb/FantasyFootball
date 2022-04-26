import java.util.*;

public class FantasyFootball {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        Util.displayWelcomeMessage();

        int numPlayers = 0;
        int numWeeks = 0;

        do {
            System.out.print("How many players are on each team? (Min: 2) ");

            try {
                numPlayers = keyboard.nextInt();

            } catch (InputMismatchException ex) {
                System.out.println("Must enter an integer");
                keyboard.next();
            }
        } while (numPlayers < 2);


        do {
            System.out.print("How many weeks would you like to keep track of the teams? (Min: 2)\n ");

            try {
                numWeeks = keyboard.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Must enter an integer");
                keyboard.next();
            }

            if (numWeeks < 2)
                System.out.print("\nYou must choose at least 2 weeks\n");

        } while (numWeeks < 2);


        // Call method to obtain all the players names
        ArrayList<Player> players = Util.initialisePlayers(numPlayers);

        // for every week, ask all the players how each of their team's players performed in the game
        for (int i = 0; i < numWeeks; i++) {
            for (Player player : players) {
                // store the score obtained for each week
                player.setWeeklyScore(i, Util.askDetails(player, i));
            }
        }

        for (int i = 0; i < numWeeks; i++) {
            WeeklyScoreComparator weekToWeeklyScoreComparator = new WeeklyScoreComparator(i);

            // sort the scores from week 1 from highest to lowest
            players.sort(weekToWeeklyScoreComparator);

            // Call method to print the sorted player scores for the first week
            Util.printSortedScores(players, i);
        }
    }
}
