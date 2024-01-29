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
        String[] progressionAndHiddenItem = generateProgression();
        final int questionIndex = 0;
        final int answerIndex = 1;

        generatedRoundData[questionIndex] = progressionAndHiddenItem[questionIndex];
        generatedRoundData[answerIndex] = progressionAndHiddenItem[answerIndex];

        return generatedRoundData;
    }

    private static String[] generateProgression() {
        StringBuilder progression = new StringBuilder();
        String hiddenItem = "";
        String[] progressionAndHiddenMember = new String[2];
        final int minProgressionLength = 5;
        final int maxProgressionLength = 10;
        int progressionLength = Utils.genNumber(minProgressionLength, maxProgressionLength);
        final int positionToHide = (int) (Math.random() * progressionLength) + 1;
        final int minValueFirst = 0;
        final int maxValueFirst = 20;
        int firstNumber = Utils.genNumber(minValueFirst, maxValueFirst);
        final int minValueDelta = 1;
        final int maxValueDelta = 10;
        int progressionDelta = Utils.genNumber(minValueDelta, maxValueDelta);
        int currentMember = firstNumber;

        progression.append("Question: ");
        for (int i = 1; i <= progressionLength; i++) {
            if (i != positionToHide) {
                progression.append(currentMember);
                progression.append(" ");
            } else {
                progression.append("..");
                progression.append(" ");
                hiddenItem = Integer.toString(currentMember);
            }
            currentMember += progressionDelta;
        }

        progressionAndHiddenMember[0] = progression.toString();
        progressionAndHiddenMember[1] = hiddenItem;

        return progressionAndHiddenMember;
    }
}
