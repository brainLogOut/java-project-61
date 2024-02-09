package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final int MIN_VALUE = 5;
    private static final int MAX_VALUE = 10;

    public static void callGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][];
        String rules = "What number is missing in the progression?";

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }

        Engine.play(questionsAndAnswers, rules);
    }

    public static String[] generateRoundData() {
        String[] generatedRoundData = new String[2];
        int progressionLength = Utils.generateNumber(MIN_VALUE, MAX_VALUE);
        final int indexToHide = Utils.generateNumber(progressionLength);
        int progressionDelta = Utils.generateNumber(MIN_VALUE, MAX_VALUE);
        int firstNumber = Utils.generateNumber(MAX_VALUE);

        String[] progression = generateProgression(firstNumber, progressionLength, progressionDelta);

        generatedRoundData[1] = progression[indexToHide];
        generatedRoundData[0] = generateQuestion(progression, indexToHide);

        return generatedRoundData;
    }

    private static String[] generateProgression(int firstNumber, int progressionLength, int progressionDelta) {
        String[] generatedProgression = new String[progressionLength];
        int currentNumber = firstNumber;

        generatedProgression[0] = Integer.toString(firstNumber);
        for (int i = 1; i < generatedProgression.length; i++) {
            currentNumber += progressionDelta;
            generatedProgression[i] = Integer.toString(currentNumber);
        }

        return generatedProgression;
    }

    private static String generateQuestion(String[] progression, int indexToHide) {
        StringBuilder generatedQuestion = new StringBuilder();

        progression[indexToHide] = "..";
        for (String s : progression) {
            generatedQuestion.append(s);
            generatedQuestion.append(" ");
        }

        return generatedQuestion.toString();
    }
}
