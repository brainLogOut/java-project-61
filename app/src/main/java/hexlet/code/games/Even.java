package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;
public class Even {
    public static int evenGame() {
        Scanner scanner = new Scanner(System.in);

        Engine.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < 3; i++) {
            int currentNumber = (int) (Math.random() * 100);
            String result = "";

            System.out.println("Question: " + currentNumber);
            String answer = scanner.next();
            if (currentNumber % 2 == 0) {
                result = "yes";
            } else if (currentNumber % 2 != 0) {
                result = "no";
            }
            if (!answer.equalsIgnoreCase(result)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + result + "'.");
                return 1;
            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + Engine.userName + "!");
        scanner.close();
        return 0;
    }
}