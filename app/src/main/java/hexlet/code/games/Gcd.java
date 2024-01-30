package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Gcd {
    public static void callGame() {
        final int numberOfFields = 2;
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][numberOfFields];
        String rules = "Find the greatest common divisor of given numbers.";

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

        generatedRoundData[0] = "Question: " + firstNumber + " " + secondNumber;
        generatedRoundData[1] = computeGcd(firstNumber, secondNumber);

        return generatedRoundData;
    }

    private static String computeGcd(int firstDigit, int secondDigit) {
        int m = Math.abs(firstDigit);
        int n = Math.abs(secondDigit);
        int k = 1;
        String result = "";
        boolean exit = false;

        //Бинарный алгоритм Евклида.
        if (firstDigit == 0 && secondDigit == 0) {
            return "1";
        }
        while (!exit) {
            if (m == 0 && n > 0) {
                result = Integer.toString(n);
                exit = true;
            } else if (n == 0 && m > 0) {
                result = Integer.toString(m);
                exit = true;
            } else if (m == n) {
                result = Integer.toString(m * k);
                exit = true;
            } else if (m == 1 && n > 0) {
                result = Integer.toString(m * k);
                exit = true;
            } else if (m > 0 && n == 1) {
                result = Integer.toString(n * k);
                exit = true;
            } else if (m % 2 == 0 && n % 2 == 0) {
                m /= 2;
                n /= 2;
                k *= 2;
            } else if (m % 2 == 0 && n % 2 != 0) {
                m /= 2;
            } else if (m % 2 != 0 && n % 2 == 0) {
                n /= 2;
            } else if (m % 2 != 0 && n % 2 != 0 && n > m) {
                n = (n - m) / 2;
            } else if (m % 2 != 0 && n % 2 != 0 && n < m) {
                m = (m - n) / 2;
            }
        }
        return result;
    }
}
