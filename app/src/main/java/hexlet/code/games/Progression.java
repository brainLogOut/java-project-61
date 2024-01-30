package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static void callGame() {
        final int numberOfFields = 2;
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][numberOfFields];
        String rules = "What number is missing in the progression?";

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
        final int minProgressionLength = 5;
        final int maxProgressionLength = 10;
        int progressionLength = Utils.genNumber(minProgressionLength, maxProgressionLength);
        final int indexToHide = (int) (Math.random() * progressionLength);

        String[] progression = generateProgression(progressionLength);

        generatedRoundData[0] = generateQuestion(progression, indexToHide);
        generatedRoundData[1] = progression[indexToHide];

        return generatedRoundData;
    }

    private static String[] generateProgression(int progressionLength) {
        String[] generatedProgression = new String[progressionLength];
        final int minValueFirst = 0;
        final int maxValueFirst = 20;
        int firstNumber = Utils.genNumber(minValueFirst, maxValueFirst);
        final int minValueDelta = 1;
        final int maxValueDelta = 10;
        int progressionDelta = Utils.genNumber(minValueDelta, maxValueDelta);
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

        generatedQuestion.append("Question: ");
        for (int i = 0; i < progression.length; i++) {
            if (i != indexToHide) {
                generatedQuestion.append(progression[i]);
                generatedQuestion.append(" ");
            } else {
                generatedQuestion.append("..");
                generatedQuestion.append(" ");
            }
        }
        return generatedQuestion.toString();
    }
}
