package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final int MAX_VALUE = 10;

    public static void callGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][];
        String rules = "What is the result of the expression?";

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }

        Engine.play(questionsAndAnswers, rules);
    }

    public static String[] generateRoundData() {
        String[] generatedRoundData = new String[2];
        int firstNumber = Utils.generateNumber(MAX_VALUE);
        int secondNumber = Utils.generateNumber(MAX_VALUE);
        String[] operations = {"+", "-", "*"};
        final int maxValueOpCode = operations.length - 1;
        int opCode = Utils.generateNumber(maxValueOpCode);

        generatedRoundData[0] = firstNumber + " "
                + operations[opCode] + " " + secondNumber + " " + "=";
        generatedRoundData[1] = Integer.toString(
                calculate(firstNumber, secondNumber, operations[opCode]));

        return generatedRoundData;
    }

    private static int calculate(int firstDigit, int secondDigit, String operation) {
        int computedAnswer;

        switch (operation) {
            case "+":
                computedAnswer = firstDigit + secondDigit;
                break;
            case "-":
                computedAnswer = firstDigit - secondDigit;
                break;
            case "*":
                computedAnswer = firstDigit * secondDigit;
                break;
            default:
                throw new RuntimeException("This operation is not supported.");
        }
        return computedAnswer;
    }
}
