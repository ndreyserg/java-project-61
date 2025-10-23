package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public final class EvenGame implements Game {

    private final Random generator = new Random();

    public boolean play() {
        final var roundCount = 3;
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (var i = 0; i < roundCount; i++) {
            var roundResult = playRound();
            if (!roundResult) {
                return false;
            }
        }
        return true;
    }

    private boolean playRound() {
        final var  maxRandomNumber = 10000;
        var num = this.generator.nextInt(maxRandomNumber);
        var correctAnswer = num % 2 == 0 ? "yes" : "no";
        System.out.println("Question: " + num);
        System.out.print("Your answer: ");
        var scanner = new Scanner(System.in);
        var answer = scanner.nextLine();
        var roundResult = correctAnswer.equals(answer);
        if (roundResult) {
            System.out.println("Correct!");
        } else {
            System.out.printf(
                    "'%s' is wrong answer ;(. Correct answer was '%s')'.%s",
                    answer,
                    correctAnswer,
                    System.lineSeparator()
            );
        }
        return roundResult;
    }
}
