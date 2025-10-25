package hexlet.code.games;

import java.security.SecureRandom;

public class PrimeGame {

    private static final int MAX_NUMBER = 20;

    private static final SecureRandom GENERATOR = new SecureRandom();

    public static Game getGame(int roundCound) {
        Round[] rounds = new Round[roundCound];
        for (int i = 0; i < roundCound; i++) {
            rounds[i] = getRound();
        }
        return new Game(
                "Answer 'yes' if given number is prime. Otherwise answer 'no'.",
                rounds
        );
    }

    public static Round getRound() {
        var question = GENERATOR.nextInt(MAX_NUMBER);
        var answer = isPrime(question) ? "yes" : "no";
        return new Round(
                Integer.toString(question),
                answer
        );
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
