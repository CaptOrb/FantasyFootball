import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player {

    private String playerName;

    private int week1PlayerScore, week2PlayerScore;

    Player(String name) {
        this.playerName = name;
        this.week1PlayerScore = 0;
        this.week2PlayerScore = 0;
    }

    String getName() {
        return playerName;
    }

    int getScore(int week) {
        if (week == 1)
            return week1PlayerScore;
        else
            return week2PlayerScore;
    }

    void setWeek1PlayerScore(int newScore) {
        this.week1PlayerScore = newScore;
    }

    void setWeek2PlayerScore(int newScore) {
        this.week2PlayerScore = newScore;
    }
}
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

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int numPlayers;

        while (true) {
            System.out.print("How many players are on each team? (Min: 2) ");
            numPlayers = keyboard.nextInt();
            if (numPlayers > 1)
                break;
            else
                System.out.println("At least two players are required!\n");
        }

        String[] playerName = new String[numPlayers];

        // Call method to obtain all the players names
        methods.initialisePlayers(playerName, numPlayers);

        // Now that we have the players names, create player object for every player
        Player[] players = new Player[playerName.length];

        for (int j = 0; j < playerName.length; j++) {
            players[j] = new Player(playerName[j]);

            // store the score obtained for the first week
            players[j].setWeek1PlayerScore(methods.askDetails(players[j], 1));
        }

        for (int k = 0; k < playerName.length; k++) {
            // store the score obtained for the second week
            players[k].setWeek2PlayerScore(methods.askDetails(players[k], 2));
        }

        // sort the scores from week 1 from highest to lowest
        Arrays.sort(players, new week1PlayerComparator());

        // Call method to print the sorted player scores for the first week
        methods.printSortedScores(players, 1);

        // sort the scores from week 2 from highest to lowest
        Arrays.sort(players, new week2PlayerComparator());

        // Call method to print the sorted player scores for the second week
        methods.printSortedScores(players, 2);
    }
}
