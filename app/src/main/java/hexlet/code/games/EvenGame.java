package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenGame {

    private static final int MAX_NUM = 100;

    private static final String BRIEFING = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void play() {
        String[][] questions = new String[Engine.ROUND_COUNT][];
        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            var question = Utils.generateNumber(0, MAX_NUM);
            var answer = question % 2 == 0 ? "yes" : "no";
            questions[i] = new String[]{Integer.toString(question), answer};
        }
        Engine.run(
                BRIEFING,
                questions
        );
    }
}
