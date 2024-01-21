package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    public static int calcGame() {
        Scanner scanner = new Scanner(System.in);

        Engine.greeting();
        System.out.println("What is the result of the expression?");
        for (int i = 0; i < Engine.getMaxRounds(); i++) {
            int firstDigit = Engine.genNumber(11);
            int secondDigit = Engine.genNumber(13);
            int opDivider = 4;
            int opCode = Engine.genNumber(10) / 4;
            String[] operations = {"+", "-", "*"};

            System.out.println("Question: " + firstDigit + " " + operations[opCode] + " " + secondDigit + " " + "=");
            String answer = scanner.next();
            String result = calcResult(firstDigit, secondDigit, operations[opCode]);
            String checkResult = Engine.check(answer, result, (i + 1));
            if (checkResult.equals("error")) {
                return 1;
            }
        }
        scanner.close();
        return 0;
    }

    private static String calcResult(int firstDigit, int secondDigit, String operation) {
        String cResult = "";

        if (operation.equals("+")) {
            cResult = Integer.toString(firstDigit + secondDigit);
        } else if (operation.equals("-")) {
            cResult = Integer.toString(firstDigit - secondDigit);
        } else if (operation.equals("*")) {
            cResult = Integer.toString(firstDigit * secondDigit);
        }
        return cResult;
    }
}
