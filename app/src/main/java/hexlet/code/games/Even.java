package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;
public class Even {
    public static void evenGame() {
        Scanner scanner = new Scanner(System.in);

        Engine.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < Engine.getMaxRounds(); i++) {
            final int maxNumberValue = 100;
            int currentNumber = Engine.genNumber(maxNumberValue);
            String result = "";
            String checkResult;
            String answer;

            System.out.println("Question: " + currentNumber);
            answer = scanner.next();
            if (currentNumber % 2 == 0) {
                result = "yes";
            } else if (currentNumber % 2 > 0) {
                result = "no";
            }
            checkResult = Engine.check(answer, result, (i + 1));
            if (checkResult.equals("error")) {
                break;
            }
        }
        scanner.close();
    }
}
