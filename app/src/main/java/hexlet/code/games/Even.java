package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;
public class Even {
    public static int evenGame() {
        Scanner scanner = new Scanner(System.in);
        String startMessageEven = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        Engine.greeting();
        System.out.println(startMessageEven);
        for (int i = 0; i < Engine.maxRounds; i++) {
            int currentNumberEven = (int) (Math.random() * 100);

            System.out.println("Question: " + currentNumberEven);
            String answerEven = scanner.next();
            String resultEven = calcResult(currentNumberEven);
            String checkResult = Engine.check(answerEven, resultEven, (i + 1));
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
