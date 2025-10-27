package hexlet.code.games;

import hexlet.code.Engine;

import java.security.SecureRandom;

public class ProgressionGame {
    private static final SecureRandom GENERATOR = new SecureRandom();

    private static final  int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_PROGRESSION_STEP = 5;
    private static final int MAX_START = 10;

    private static final String BRIEF = "What number is missing in the progression?";

    public static void play(int roundCount) {
        String[][] questions = new String[roundCount][];
        for (int i = 0; i < roundCount; i++) {
            questions[i] = getQuestion();
        }
        Engine.run(BRIEF, questions);
    }

    private static String[] getQuestion() {
        var start = GENERATOR.nextInt(MAX_START);
        var step = GENERATOR.nextInt(MAX_PROGRESSION_STEP);
        var length = MIN_PROGRESSION_LENGTH + GENERATOR.nextInt(MAX_PROGRESSION_LENGTH - MIN_PROGRESSION_LENGTH);
        var answerInex = GENERATOR.nextInt(length);

        String[] progression = getProgression(start, step, length);
        var answer = progression[answerInex];
        progression[answerInex] = "..";
        var question = String.join(" ", progression);
        return new String[]{question, answer};
    }

    private static String[] getProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (var i = 0; i < length; i++) {
            progression[i] = Integer.toString(start + i * step);
        }
        return progression;
    }
}
