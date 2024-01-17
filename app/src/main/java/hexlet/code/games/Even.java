package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;
public class Even {
    public static int evenGame() {
        Scanner scanner = new Scanner(System.in);

        Engine.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < Engine.maxRounds; i++) {
            int currentNumber = (int) (Math.random() * 100);
            String result = "";

            System.out.println("Question: " + currentNumber);
            String answer = scanner.next();
            if (currentNumber % 2 == 0) {
                result = "yes";
            } else if (currentNumber % 2 != 0) {
                result = "no";
            }
            String checkResult = Engine.check(answer, result, (i + 1));
            if (checkResult.equals("error")) {
                return 1;
            }
        }
        scanner.close();
        return 0;
    }
}