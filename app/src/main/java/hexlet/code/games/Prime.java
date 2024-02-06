package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static void callGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][];
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }

        Engine.play(questionsAndAnswers, rules);
    }

    public static String[] generateRoundData() {
        String[] generatedRoundData = new String[2];
        final int maxValue = 100;
        int currentNumber = Utils.generateNumber(maxValue);

        generatedRoundData[0] = Integer.toString(currentNumber);
        generatedRoundData[1] = isPrime(currentNumber) ? "yes" : "no";

        return generatedRoundData;
    }

    private static boolean isPrime(int currentNumber) {
        int countMax = (int) (Math.sqrt(currentNumber));

        if (currentNumber <= 1) {
            return false;
        }
        for (int i = 2; i <= countMax; i++) {
            if (currentNumber % i == 0) {
                return false;
            }
        }

        return true;
    }
}
