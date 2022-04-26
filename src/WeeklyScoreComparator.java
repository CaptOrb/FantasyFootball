import java.util.Comparator;

public class WeeklyScoreComparator implements Comparator<Player> {
    private final int week;

    public WeeklyScoreComparator(int week) {
        this.week = week;
    }

    public int compare(Player p1, Player p2) {
        return Integer.compare(p2.getWeeklyScore(week), p1.getWeeklyScore(week));
    }
}

