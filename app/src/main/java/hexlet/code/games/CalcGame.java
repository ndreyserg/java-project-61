package hexlet.code.games;

import hexlet.code.Engine;

import java.security.SecureRandom;

public class CalcGame {
    private static final SecureRandom GENERATOR = new SecureRandom();

    private static final String[] OPERATIONS = new String[]{"+", "-", "*"};

    private static final int MAX_NUM = 100;

    private static final String BRIEF = "What is the result of the expression?";

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
        var op = OPERATIONS[GENERATOR.nextInt(OPERATIONS.length)];
        var answer = getAnswer(a, b, op);
        var question =  String.format("%d %s %d", a, op, b);
        return new String[]{question, Integer.toString(answer)};
    }

    private static int getAnswer(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            default -> a * b;
        };
    }
}
