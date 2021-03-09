public class Player {

    private final String playerName;

    private final int[] weeklyScore = new int[10];

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

    public int getScore(int week) {
        return weeklyScore[week];
    }

    public void setWeekPlayerScore(int newScore, int week) {
        weeklyScore[week] = newScore;
    }
}

