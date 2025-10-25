package hexlet.code.games;

import java.security.SecureRandom;

public class ProgressionGame {
    private static final SecureRandom GENERATOR = new SecureRandom();

    private static final  int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_PROGRESSION_STEP = 5;
    private static final int MAX_START = 10;

    public static Game getGame(int roundCount) {
        Round[] rounds = new Round[roundCount];
        for (int i = 0; i < roundCount; i++) {
            rounds[i] = getRound();
        }
        return new Game(
                "What number is missing in the progression?",
                rounds
        );
    }

    private static Round getRound() {
        var start = GENERATOR.nextInt(MAX_START);
        var step = GENERATOR.nextInt(MAX_PROGRESSION_STEP);
        var length = MIN_PROGRESSION_LENGTH + GENERATOR.nextInt(MAX_PROGRESSION_LENGTH - MIN_PROGRESSION_LENGTH);
        var answerInex = GENERATOR.nextInt(length);

        String[] progression = getProgression(start, step, length);
        var answer = progression[answerInex];
        progression[answerInex] = "..";

        return new Round(
                String.join(" ", progression),
                answer
        );
    }

    private static String[] getProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (var i = 0; i < length; i++) {
            progression[i] = Integer.toString(start + i * step);
        }
        return progression;
    }
}
