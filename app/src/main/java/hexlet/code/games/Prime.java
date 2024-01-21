package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Prime {
    public static int primeGame() {
        Scanner scanner = new Scanner(System.in);
        String startMessage = "Answer 'yes' if giving number is prime. Otherwise answer 'no'.";

        Engine.greeting();
        System.out.println(startMessage);
        for (int i = 0; i < Engine.maxRounds; i++) {
            int currentNumber = (int) (Math.random() * 99);

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
        String cResult = "yes";
        int countMax = (int) (Math.sqrt(currentNumber));

        for (int i = 2; i <= countMax; i++) {
            if (currentNumber % i == 0) {
                cResult = "no";
                break;
            }
        }
        return cResult;
    }
}
