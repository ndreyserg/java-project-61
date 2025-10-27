package hexlet.code.games;

import hexlet.code.Engine;

import java.security.SecureRandom;

public class PrimeGame {

    private static final int MAX_NUMBER = 20;

    private static final SecureRandom GENERATOR = new SecureRandom();

    private static final String BRIEF = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void play(int roundCount) {
        String[][] questions = new String[roundCount][];
        for (int i = 0; i < roundCount; i++) {
            questions[i] = getQuestion();
        }
        Engine.run(BRIEF, questions);
    }

    private static String[] getQuestion() {
        var question = GENERATOR.nextInt(MAX_NUMBER);
        var answer = isPrime(question) ? "yes" : "no";
        return new String[]{
            Integer.toString(question),
            answer
        };
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        final int limit = (int) Math.sqrt(number);
        final int firstDivider = 3;
        var divider = firstDivider;
        while (divider <= limit) {
            if (number % divider == 0) {
                return false;
            }
            divider += 2;
        }
        return true;
    }
}
