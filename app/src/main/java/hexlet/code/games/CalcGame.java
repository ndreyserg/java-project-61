package hexlet.code.games;

import java.security.SecureRandom;

public class CalcGame {
    private static final SecureRandom GENERATOR = new SecureRandom();
    private static final String[] OPERATIONS = new String[]{"+", "-", "*"};

    private static final int MAX_NUM = 100;

    public static Game getGame(int roundCount) {
        Round[] rounds = new Round[roundCount];
        for (int i = 0; i < roundCount; i++) {
            rounds[i] = getRound();
        }
        return new Game(
                "What is the result of the expression?",
                rounds
        );
    }

    private static Round getRound() {
        var a = GENERATOR.nextInt(MAX_NUM);
        var b = GENERATOR.nextInt(MAX_NUM);
        var op = OPERATIONS[GENERATOR.nextInt(OPERATIONS.length)];
        var answer = getAnswer(a, b, op);
        return new Round(
                String.format("%d %s %d", a, op, b),
                Integer.toString(answer)
        );
    }

    private static int getAnswer(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            default -> a * b;
        };
    }


}
