package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class ProgressionGame {

    private static final  int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_PROGRESSION_STEP = 5;
    private static final int MAX_START = 10;

    private static final String BRIEF = "What number is missing in the progression?";

    public static void play() {
        String[][] questions = new String[Engine.ROUND_COUNT][];
        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            var start = Utils.generateNumber(0, MAX_START);
            var step = Utils.generateNumber(0, MAX_PROGRESSION_STEP);
            var length = Utils.generateNumber(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            var answerInex = Utils.generateNumber(0, length - 1);
            String[] progression = getProgression(start, step, length);
            var answer = progression[answerInex];
            progression[answerInex] = "..";
            var question = String.join(" ", progression);
            questions[i] = new String[]{question, answer};
        }
        Engine.run(BRIEF, questions);
    }

    private static String[] getProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (var i = 0; i < length; i++) {
            progression[i] = Integer.toString(start + i * step);
        }
        return progression;
    }
}
