package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Cli;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        String gameNumber = scanner.next();
        System.out.println("Your choice: " + gameNumber);
        switch (gameNumber) {
            case "0":
                break;
            case "1":
                Cli.greeting();
                break;
            case "2":
                Even.evenGame();
                break;
            case "3":
                Calc.calcGame();
                break;
            default:
                System.out.println("Incorrect game number");
                break;
        }
        scanner.close();
    }
}
