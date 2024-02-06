package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Gcd {
    public static void callGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][];
        String rules = "Find the greatest common divisor of given numbers.";

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

        generatedRoundData[0] = firstNumber + " " + secondNumber;
        generatedRoundData[1] = computeGcd(firstNumber, secondNumber);

        return generatedRoundData;
    }

    private static String computeGcd(int firstDigit, int secondDigit) {
        int m = Math.abs(firstDigit);
        int n = Math.abs(secondDigit);
        int t;

        if (firstDigit == 0 && secondDigit == 0) {
            return "1";
        }
        while (n != 0) {
            t = n;
            n = m % n;
            m = t;
        }

        return Integer.toString(m);
    }
}
