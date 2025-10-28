package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class PrimeGame {

    private static final int MAX_NUMBER = 20;

    private static final String BRIEF = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void play() {
        String[][] questions = new String[Engine.ROUND_COUNT][];
        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            var question = Utils.generateNumber(0, MAX_NUMBER);
            var answer = Utils.isPrime(question) ? "yes" : "no";
            questions[i] = new String[]{Integer.toString(question), answer};
        }
        Engine.run(BRIEF, questions);
    }
}
