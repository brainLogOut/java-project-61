package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static String userName;
    public static void greeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games");
        System.out.println("May I have your name?");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }

    public static String check (String answer, String result) {
        System.out.println("Your answer: " + answer);
        if (!result.equalsIgnoreCase(answer)) {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + result + "'.");
            System.out.println("Let's try again, " + userName);
            return "error";
        }
        System.out.println("Correct!");
        return "correct";
    }
}
