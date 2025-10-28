package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.Greeting;

import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        var scanner = new Scanner(System.in);
        var choice = scanner.next();
        System.out.print(System.lineSeparator());

        switch (choice) {
            case "1":
                Greeting.play();
                break;
            case "2":
                EvenGame.play();
                break;
            case "3":
                CalcGame.play();
                break;
            case "4":
                GCDGame.play();
                break;
            case "5":
                ProgressionGame.play();
                break;
            case "6":
                PrimeGame.play();
                break;
            default:
                System.out.println("Unknown user choice: " + choice);
                break;
        }
    }
}
