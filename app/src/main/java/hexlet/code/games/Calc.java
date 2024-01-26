package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void callGame() {
        final int numberOfFields = 2;
        String[][] questionsAndAnswers = new String[Engine.getMaxRounds()][numberOfFields];
        String rules = "What is the result of the expression?";

        for (int i = 0; i < Engine.getMaxRounds(); i++) {
            final int maxFirstDigit = 11;
            int firstDigit = Engine.genNumber(maxFirstDigit);
            final int maxSecondDigit = 13;
            int secondDigit = Engine.genNumber(maxSecondDigit);
            final int opCodeMax = 10;
            final int opDivider = 4;
            int opCode = Engine.genNumber(opCodeMax) / opDivider;
            String[] operations = {"+", "-", "*"};

            String question = "Question: " + firstDigit + " "
                    + operations[opCode] + " " + secondDigit + " " + "=";
            String answer = computeAnswer(firstDigit, secondDigit, operations[opCode]);

            questionsAndAnswers[i][numberOfFields - 2] = question;
            questionsAndAnswers[i][numberOfFields - 1] = answer;
        }

        Engine.play(questionsAndAnswers, rules);
    }

    private static String computeAnswer(int firstDigit, int secondDigit, String operation) {
        String cResult = "";

        switch (operation) {
            case "+":
                cResult = Integer.toString(firstDigit + secondDigit);
                break;
            case "-":
                cResult = Integer.toString(firstDigit - secondDigit);
                break;
            case "*":
                cResult = Integer.toString(firstDigit * secondDigit);
                break;
            default:
                System.out.println("Wrong opCode.");
        }
        return cResult;
    }
}
