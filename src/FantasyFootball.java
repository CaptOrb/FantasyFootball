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
                player.setWeekPlayerScore(Util.askDetails(player, i), i);
            }
        }

        for (int i = 0; i < numWeeks; i++) {
            Compare weekToCompare = new Compare(i);

            // sort the scores from week 1 from highest to lowest
            Collections.sort(players, weekToCompare);

            // Call method to print the sorted player scores for the first week
            Util.printSortedScores(players, i);
        }
    }
}
