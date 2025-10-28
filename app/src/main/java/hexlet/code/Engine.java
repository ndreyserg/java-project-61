package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUND_COUNT = 3;

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void run(String brief, String[][] questions) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var userName = SCANNER.nextLine();
        System.out.printf("Hello, %s!\n", userName);
        System.out.println(brief);

        if (questions.length == 0) {
            return;
        }

        var gameResult = true;

        for (var question : questions) {
            System.out.println("Question: " + question[0]);
            System.out.print("Your answer: ");
            var answer = SCANNER.nextLine();
            var roundResult = question[1].equals(answer);
            if (roundResult) {
                System.out.println("Correct!");
            } else {
                System.out.printf(
                        "'%s' is wrong answer ;(. Correct answer was '%s'.%s",
                        answer, question[1], System.lineSeparator()
                );
                gameResult = false;
                break;
            }
        }
        var message = gameResult ? "Congratulations, %s!%s" : "Let's try again, %s!%s";
        System.out.printf(message, userName, System.lineSeparator());
    }

}
