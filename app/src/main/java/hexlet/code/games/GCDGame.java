package hexlet.code.games;

import hexlet.code.Engine;
import java.security.SecureRandom;

public class GCDGame {
    private static final SecureRandom GENERATOR = new SecureRandom();

    private static final int MAX_NUM = 10;

    private static final String BRIEF = "Find the greatest common divisor of given numbers.";

    public static void play(int roundCount) {
        String[][] questions = new String[roundCount][];
        for (int i = 0; i < roundCount; i++) {
            questions[i] = getQuestion();
        }
        Engine.run(BRIEF, questions);
    }

    private static String[] getQuestion() {
        var a = GENERATOR.nextInt(MAX_NUM);
        var b = GENERATOR.nextInt(MAX_NUM);
        var question = a + " " + b;
        var answer = Integer.toString(getGCD(a, b));
        return new String[] {question, answer};
    }

    private static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
