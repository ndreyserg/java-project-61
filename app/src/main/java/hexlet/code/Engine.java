package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final int ROUNDS_COUNT = 3;

    public static void run(String gameName) {
        var userName = greeting();
        var game = getGame(gameName);
        if (game == null) {
            return;
        }
        outputMessage(game.getBriefing());
        var gameResult = playGame(game);
        var message = gameResult ? "Congratulations, %s!" : "Let's try again, %s!";
        outputMessage(String.format(message, userName));
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

    private static boolean playGame(Game game) {
        for (var round : game.getRounds()) {
            outputMessage("Question: " + round.getQuestion());
            var answer = ask("Your answer: ");
            var roundResult = round.getAnswer().equals(answer);
            if (roundResult) {
                outputMessage("Correct!");
            } else {
                outputMessage(
                        String.format("'%s' is wrong answer ;(. Correct answer was '%s'.", answer, round.getAnswer())
                );
                return false;
            }
        }
        return true;
    }

    private static void outputMessage(String message) {
        System.out.println(message);
    }

    private static Game getGame(String gameName) {
        switch (gameName) {
            case "Even":
                return EvenGame.getGame(ROUNDS_COUNT);
            default:
                return null;
        }
    }
}
