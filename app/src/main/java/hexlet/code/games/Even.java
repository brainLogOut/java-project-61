package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static void callGame() {
        final int numberOfFields = 2;
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][numberOfFields];
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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
        generatedRoundData[1] = isEven(currentNumber) ? "yes" : "no";

        return generatedRoundData;
    }

    private static boolean isEven(int currentNumber) {
        return currentNumber % 2 == 0;
    }
}
