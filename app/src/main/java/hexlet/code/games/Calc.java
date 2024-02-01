package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static void callGame() {
        final int numberOfFields = 2;
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][numberOfFields];
        String rules = "What is the result of the expression?";

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }

        Engine.play(questionsAndAnswers, rules);
    }

    public static String[] generateRoundData() {
        String[] generatedRoundData = new String[2];
        final int maxValueFirst = 11;
        int firstNumber = Utils.generateNumber(maxValueFirst);
        final int maxValueSecond = 13;
        int secondNumber = Utils.generateNumber(maxValueSecond);
        final int maxValueOpCode = 2;
        int opCode = Utils.generateNumber(maxValueOpCode);
        String[] operations = {"+", "-", "*"};

        generatedRoundData[0] = firstNumber + " "
                + operations[opCode] + " " + secondNumber + " " + "=";
        generatedRoundData[1] = calculate(firstNumber, secondNumber, operations[opCode]);

        return generatedRoundData;
    }

    private static String calculate(int firstDigit, int secondDigit, String operation) {
        String computedAnswer = "";

        switch (operation) {
            case "+":
                computedAnswer = Integer.toString(firstDigit + secondDigit);
                break;
            case "-":
                computedAnswer = Integer.toString(firstDigit - secondDigit);
                break;
            case "*":
                computedAnswer = Integer.toString(firstDigit * secondDigit);
                break;
            default:
                System.out.println("Wrong opCode.");
        }
        return computedAnswer;
    }
}
