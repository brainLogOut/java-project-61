package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static void callGame() {
        final int numberOfFields = 2;
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][numberOfFields];
        String rules = "What is the result of the expression?";

        for (String[] questionOrAnswer : questionsAndAnswers) {
            String[] roundData = generateRoundData();

            String question = roundData[0];
            String answer = roundData[1];

            questionOrAnswer[0] = question;
            questionOrAnswer[1] = answer;
        }

        Engine.play(questionsAndAnswers, rules);
    }

    public static String[] generateRoundData() {
        String[] generatedRoundData = new String[2];
        final int minValueFirst = 0;
        final int maxValueFirst = 11;
        int firstNumber = Utils.genNumber(minValueFirst, maxValueFirst);
        final int minValueSecond = 0;
        final int maxValueSecond = 13;
        int secondNumber = Utils.genNumber(minValueSecond, maxValueSecond);
        final int minValueOpCode = 0;
        final int maxValueOpCode = 2;
        int opCode = Utils.genNumber(minValueOpCode, maxValueOpCode);
        String[] operations = {"+", "-", "*"};

        generatedRoundData[0] = "Question: " + firstNumber + " "
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
