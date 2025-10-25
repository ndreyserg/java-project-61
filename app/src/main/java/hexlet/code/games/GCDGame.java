package hexlet.code.games;

import java.security.SecureRandom;

public class GCDGame {
    private static final SecureRandom GENERATOR = new SecureRandom();

    private static final int MAX_NUM = 10;

    public static Game getGame(int roundCount) {
        Round[] rounds = new Round[roundCount];
        for (int i = 0; i < roundCount; i++) {
            rounds[i] = getRound();
        }
        return new Game(
                "Find the greatest common divisor of given numbers.",
                rounds
        );
    }

    private static Round getRound() {
        var a = GENERATOR.nextInt(MAX_NUM);
        var b = GENERATOR.nextInt(MAX_NUM);
        return new Round(
                a + " " + b,
                Integer.toString(getGCD(a, b))
        );
    }

    private static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
