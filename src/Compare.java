import java.util.Comparator;

public class Compare implements Comparator<Player> {
    private final int week;

    public Compare(int week) {
        this.week = week;
    }

    public int compare(Player a, Player b) {
        return Integer.compare(b.getScore(week), a.getScore(week));
    }
}
