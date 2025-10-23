package hexlet.code.games;

import java.util.Random;

public class EvenGame {

    private static final Random GENERATOR = new Random();

    private static final int MAX_NUM = 100;

    public static Game getGame(int roundCount) {
        Round[] rounds = new Round[roundCount];
        for (int i = 0; i < roundCount; i++) {
            rounds[i] = getRound();
        }
        return new Game(
                "Answer 'yes' if the number is even, otherwise answer 'no'.",
                rounds
        );
    }

    private static Round getRound() {
        var question = GENERATOR.nextInt(MAX_NUM);
        return new Round(
                Integer.toString(question),
                question % 2 == 0 ? "yes" : "no"
        );
    }
}
