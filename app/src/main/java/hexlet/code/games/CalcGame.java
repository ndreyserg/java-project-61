package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    private static final String[] OPERATIONS = new String[]{"+", "-", "*"};

    private static final int MAX_NUM = 100;

    private static final String BRIEF = "What is the result of the expression?";

    public static void play() {
        String[][] questions = new String[Engine.ROUND_COUNT][];
        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            var a = Utils.generateNumber(0, MAX_NUM);
            var b = Utils.generateNumber(0, MAX_NUM);
            var op = OPERATIONS[Utils.generateNumber(0, OPERATIONS.length - 1)];
            var answer = getAnswer(a, b, op);
            var question =  String.format("%d %s %d", a, op, b);
            questions[i] = new String[]{question, Integer.toString(answer)};
        }
        Engine.run(BRIEF, questions);
    }

    private static int getAnswer(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> throw new RuntimeException("Invalid operation: " + op);
        };
    }
}
