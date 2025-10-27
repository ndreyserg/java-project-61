package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void run() {
        greeting();
    }

    public static void run(String brief, String[][] questions) {
        var userName = greeting();
        outputMessage(brief);
        var gameResult = playGame(questions);
        var message = gameResult ? "Congratulations, %s!" : "Let's try again, %s!";
        outputMessage(String.format(message, userName));
    }

    private static boolean playGame(String[][] questions) {
        for (var question : questions) {
            outputMessage("Question: " + question[0]);
            var answer = ask("Your answer: ");
            var roundResult = question[1].equals(answer);
            if (roundResult) {
                outputMessage("Correct!");
            } else {
                outputMessage(
                    String.format("'%s' is wrong answer ;(. Correct answer was '%s'.", answer, question[1])
                );
                return false;
            }
        }
        return true;
    }

    private static String greeting() {
        outputMessage("Welcome to the Brain Games!");
        var name = ask("May I have your name? ");
        outputMessage(String.format("Hello, %s!", name));
        return name;
    }

    private static String ask(String question) {
        System.out.print(question);
        return SCANNER.nextLine();
    }

    private static void outputMessage(String message) {
        System.out.println(message);
    }
}
