package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String userName;
    private static final int maxRounds = 3;
    public static void greeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }

    public static String check(String answer, String result, int roundNum) {
        System.out.println("Your answer: " + answer);
        if (!result.equalsIgnoreCase(answer)) {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + result + "'.");
            System.out.println("Let's try again, " + userName + "!");
            return "error";
        }
        System.out.println("Correct!");
        if (roundNum == maxRounds) {
            System.out.println("Congratulations, " + userName + "!");
        }
        return "correct";
    }

    public static int genNumber(int maxValue) {
        return (int) (Math.random() * maxValue);
    }

    public static int getMaxRounds() {
        return maxRounds;
    }
}
