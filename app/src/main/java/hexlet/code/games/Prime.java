package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static void callGame() {
        final int numberOfFields = 2;
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][numberOfFields];
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

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
        final int minValue = 0;
        final int maxValue = 100;
        int currentNumber = Utils.genNumber(minValue, maxValue);

        generatedRoundData[0] = "Question: " + currentNumber;
        generatedRoundData[1] = isPrime(currentNumber);

        return generatedRoundData;
    }

    private static String isPrime(int currentNumber) {
        String computedAnswer = "yes";
        int countMax = (int) (Math.sqrt(currentNumber));

        if (currentNumber <= 1) {
            return "no";
        }
        for (int i = 2; i <= countMax; i++) {
            if (currentNumber % i == 0) {
                computedAnswer = "no";
                break;
            }
        }
        return computedAnswer;
    }
}
