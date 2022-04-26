import java.util.HashMap;
import java.util.Map;

public class Player {

    private final String playerName;

    private final Map<Integer, Integer> weeklyScores = new HashMap<>();

    Player(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name should not be empty");
        } else {
            this.playerName = name;
        }
    }

    public String getName() {
        return playerName;
    }

    public void setWeeklyScore(int week, int score){
        weeklyScores.put(week, score);
    }

    public int getWeeklyScore(int week){
        return weeklyScores.get(week);
    }

}

