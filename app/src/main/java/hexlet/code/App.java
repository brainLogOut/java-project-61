package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Cli;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        String gameNumber = scanner.next();
        System.out.println("Your choice: " + gameNumber);
        gameRun(gameNumber);
        scanner.close();
    }

    private static void gameRun(String gameNumber) {
        switch (gameNumber) {
            case "0":
                break;
            case "1":
                Cli.greeting();
                break;
            case "2":
                Even.runEvenGame();
                break;
            case "3":
                Calc.runCalcGame();
                break;
            case "4":
                Gcd.runGcdGame();
                break;
            case "5":
                Progression.runProgressionGame();
                break;
            case "6":
                Prime.runPrimeGame();
                break;
            default:
                System.out.println("Incorrect game number");
                break;
        }
    }
}
