package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        var scanner = new Scanner(System.in);
        var name = scanner.nextLine();
        System.out.printf("Hello, %s!%s", name, System.lineSeparator());
    }
}
