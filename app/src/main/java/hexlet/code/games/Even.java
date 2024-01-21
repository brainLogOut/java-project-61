package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;
public class Even {
    public static int evenGame() {
        Scanner scanner = new Scanner(System.in);

        Engine.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < Engine.maxRounds; i++) {
            int currentNumber = Engine.genNumber(100);

            System.out.println("Question: " + currentNumber);
            String answer = scanner.next();
            String result = calcResult(currentNumber);
            String checkResult = Engine.check(answer, result, (i + 1));
            if (checkResult.equals("error")) {
                return 1;
            }
        }
        scanner.close();
        return 0;
    }

    private static String calcResult(int currentNumber) {
        String cResult = "";

        if (currentNumber % 2 == 0) {
            cResult = "yes";
        } else if (currentNumber % 2 != 0) {
            cResult = "no";
        }
        return cResult;
    }
}
