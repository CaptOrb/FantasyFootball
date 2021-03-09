import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class week1PlayerComparator implements Comparator < Player > {
    public int compare(Player p1, Player p2) {
        return Integer.compare(p2.getScore(1), p1.getScore(1));
    }
}

class week2PlayerComparator implements Comparator < Player > {
    public int compare(Player p1, Player p2) {
        return Integer.compare(p2.getScore(2), p1.getScore(2));
    }
}
public class FantasyFootball {

    private static final int NUMBERWEEKS = 2;

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        Util.displayWelcomeMessage();

        int numPlayers;

        do{
            System.out.print("How many players are on each team? (Min: 2) ");
            numPlayers = keyboard.nextInt();

            if(numPlayers < 2)
            System.out.print("\nAt least two players are required!\n");

        } while (numPlayers < 2);

        String[] playerName = new String[numPlayers];

        // Call method to obtain all the players names
        Util.initialisePlayers(playerName, numPlayers);

        // Array of player objects
        Player[] players = new Player[playerName.length];

        // Create player objects, store them in array of player objects
        for (int j = 0; j < playerName.length; j++) {
            players[j] = new Player(playerName[j]);
        }

        // for every week, ask all the players how each of their team's players performed in the game
        for (int i = 0; i < NUMBERWEEKS; i++) {
            for (Player player : players) {
                // store the score obtained for each week
                player.setWeekPlayerScore(Util.askDetails(player, i), i);
            }
        }

        // sort the scores from week 1 from highest to lowest
        Arrays.sort(players, new week1PlayerComparator());

        // Call method to print the sorted player scores for the first week
        Util.printSortedScores(players, 1);

        // sort the scores from week 2 from highest to lowest
        Arrays.sort(players, new week2PlayerComparator());

        // Call method to print the sorted player scores for the second week
        Util.printSortedScores(players, 2);
    }
}
