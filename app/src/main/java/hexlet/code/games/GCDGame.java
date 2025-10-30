package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCDGame {

    private static final int MAX_NUM = 10;

    private static final String BRIEF = "Find the greatest common divisor of given numbers.";

    public static void play() {
        String[][] questions = new String[Engine.ROUND_COUNT][];
        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            var a = Utils.generateNumber(0, MAX_NUM);
            var b = Utils.generateNumber(0, MAX_NUM);
            var question = a + " " + b;
            var answer = Integer.toString(getGCD(a, b));
            questions[i] = new String[] {question, answer};
        }
        Engine.run(BRIEF, questions);
    }

    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
