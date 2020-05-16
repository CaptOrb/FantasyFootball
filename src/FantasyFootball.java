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

        for (int i = 0; i < numPlayers; i++) {
            while (true) {
                System.out.print("Enter player " + (i + 1) + "'s name: ");
                playerName[i] = keyboard.next();

                // if the user didn't enter a player name, inform them that the player name cannot be empty
                if (playerName[i] == null || playerName[i].length() == 0) {
                    System.out.println("\nYou must enter a player name");
                } else {
                    break;
                }
            }
        }

        Player[] players = new Player[playerName.length];

        for (int j = 0; j < playerName.length; j++) {
            players[j] = new Player(playerName[j]);

            players[j].setWeek1PlayerScore(methods.askDetails(players[j], 1));
        }

        // sort the scores from week 1 from highest to lowest
        Arrays.sort(players, new week1PlayerComparator());

        for (int k = 0; k < playerName.length; k++) {
            players[k].setWeek2PlayerScore(methods.askDetails(players[k], 2));
        }

        System.out.println("\nYou will now see the scores of each player for week 1 sorted from highest to lowest\n");
        System.out.println("Player            Score");
        for (int m = 0; m < playerName.length; m++) {

            // print scores from week 1
            System.out.printf("%-10s %10d %n", players[m].getName() + "  ", players[m].getScore(1));
        }

        // sort the scores from week 2 from highest to lowest
        Arrays.sort(players, new week2PlayerComparator());

        System.out.println("\nYou will now see the scores of each player for week 2 sorted from highest to lowest\n");
        System.out.println("Player            Score");
        for (int n = 0; n < playerName.length; n++) {
            System.out.printf("%-10s %10d %n", players[n].getName() + "  ", players[n].getScore(2));
        }
    }
}