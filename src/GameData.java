public final class GameData {

    private GameData(){}

    private static final int POINTS_FOR_PLAYING = 2;
    private static final int POINTS_FOR_GOAL = 5;

    private static final int POINTS_FOR_ASSIST_GOAL = 3;
    private static final int POINTS_FOR_MISSING_PENALTY = -3;

    private static final int POINTS_FOR_YELLOW_CARD = -1;

    private static final int POINTS_FOR_RED_CARD = -3;

    private static final int POINTS_FOR_MAN_MATCH = 5;

    public static int getPointsForPlaying() {
        return POINTS_FOR_PLAYING;
    }

    public static int getPointsForGoal() {
        return POINTS_FOR_GOAL;
    }

    public static int getPointsForAssistGoal() {
        return POINTS_FOR_ASSIST_GOAL;
    }

    public static int getPointsForMissingPenalty() {
        return POINTS_FOR_MISSING_PENALTY;
    }

    public static int getPointsForYellowCard() {
        return POINTS_FOR_YELLOW_CARD;
    }

    public static int getPointsForRedCard() {
        return POINTS_FOR_RED_CARD;
    }

    public static int getPointsForManMatch() {
        return POINTS_FOR_MAN_MATCH;
    }
}