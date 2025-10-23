package hexlet.code;

import java.util.Scanner;
import java.util.StringJoiner;

public class App {
    public static void main(String[] args) {
        String[] commands = new String[]{"Exit", "Greet", "Even"};
        var commandNumber = selectCommand(commands);

        if (commandNumber >= commands.length || commandNumber < 1) {
            return;
        }
        var name = Cli.greeting();
        Game game = getGame(commands[commandNumber]);

        if (game == null) {
            return;
        }
        var result = game.play();
        var message = result ? "Congratulations, %s!%s" : "Let's try again, %s!%s";
        System.out.printf(message, name, System.lineSeparator());
    }

    public static int selectCommand(String[] commands) {
        var joiner = new StringJoiner(System.lineSeparator());

        for (var i = 1; i < commands.length; i++) {
            joiner.add(i + " - " + commands[i]);
        }
        joiner.add("0 - " + commands[0]);
        System.out.println(joiner);
        System.out.print("Your choice: ");
        var scanner = new Scanner(System.in);
        var commandNumber = scanner.nextInt();
        System.out.print(System.lineSeparator());
        return commandNumber;
    }

    private static Game getGame(String name) {
        switch (name) {
            case "Even":
                return new EvenGame();
            default:
                return null;
        }
    }
}
