package hexlet.code;

import java.util.Scanner;
import java.util.StringJoiner;


public class App {
    public static void main(String[] args) {
        String[] commands = new String[]{"Exit", "Greet", "Even", "Calc", "GCD", "Progression"};
        var commandNumber = selectCommand(commands);
        if (commandNumber >= commands.length || commandNumber < 1) {
            return;
        }
        Engine.run(commands[commandNumber]);
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
}
