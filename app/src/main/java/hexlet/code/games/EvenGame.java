package hexlet.code.games;

import java.security.SecureRandom;

import hexlet.code.Engine;

public class EvenGame {

    private static final SecureRandom GENERATOR = new SecureRandom();

    private static final int MAX_NUM = 100;

    private static final String BRIEFING = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void play(int roundCount) {
        String[][] questions = new String[roundCount][];
        for (int i = 0; i < roundCount; i++) {
            questions[i] = getQuestion();
        }
        Engine.run(
                BRIEFING,
                questions
        );
    }

    private static String[] getQuestion() {
        var question = GENERATOR.nextInt(MAX_NUM);
        var answer = question % 2 == 0 ? "yes" : "no";
        return new String[]{Integer.toString(question), answer};
    }
}
