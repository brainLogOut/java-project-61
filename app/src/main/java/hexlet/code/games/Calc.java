package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    public static int calcGame () {
        Scanner scanner = new Scanner(System.in);

        Engine.greeting();
        System.out.println("What is the result of the expression?");
        for (int i = 0; i < Engine.maxRounds; i++) {
            int firstDigit = (int) (Math.random() * 11);
            int secondDigit = (int) (Math.random() * 13);
            int opCode = (int) (Math.random() * 10 / 4);
            String[] operations = {"+", "-", "*"};
            String result = "";
            System.out.println("Question: " + firstDigit + " " + operations[opCode] + " " + secondDigit + " " + "=");
            String answer = scanner.next();

            if (operations[opCode].equals("+")) {
                result = Integer.toString(firstDigit + secondDigit);
            } else if (operations[opCode].equals("-")) {
                result = Integer.toString(firstDigit - secondDigit);
            } else if (operations[opCode].equals("*")) {
                result = Integer.toString(firstDigit * secondDigit);
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