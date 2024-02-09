package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Gcd {
    private static final int MAX_VALUE = 10;

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
        int firstNumber = Utils.generateNumber(MAX_VALUE);
        int secondNumber = Utils.generateNumber(MAX_VALUE);

        generatedRoundData[0] = firstNumber + " " + secondNumber;
        generatedRoundData[1] = Integer.toString(computeGcd(firstNumber, secondNumber));

        return generatedRoundData;
    }

    private static int computeGcd(int firstDigit, int secondDigit) {
        int m = Math.abs(firstDigit);
        int n = Math.abs(secondDigit);
        int t;

        if (firstDigit == 0 && secondDigit == 0) {
            return 1;
        }
        while (n != 0) {
            t = n;
            n = m % n;
            m = t;
        }

        return m;
    }
}
