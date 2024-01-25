package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    public static void callGame() {
        final int numberOfFields = 2;
        String[][] questionsAndAnswers = new String[Engine.getMaxRounds()][numberOfFields];
        String rules = "What number is missing in the progression?";

        for (int i = 0; i < Engine.getMaxRounds(); i++) {
            final int lengthAdd = 5;
            final int progrLengthMax = 5;
            int progressionLength = Engine.genNumber(progrLengthMax) + lengthAdd;
            String[] progressionNumbers = new String[progressionLength];
            int indexToHide = (int) (Math.random() * progressionLength);

            progressionInit(progressionNumbers);
            String question = genQuestion(progressionNumbers, indexToHide);;
            String answer = progressionNumbers[indexToHide];

            questionsAndAnswers[i][numberOfFields - 2] = question;
            questionsAndAnswers[i][numberOfFields-1] = answer;
        }
        Engine.play(questionsAndAnswers, rules);
    }

    private static void progressionInit(String[] progressionNumbers) {
        final int maxFirstDigit = 11;
        int firstDigit = Engine.genNumber(maxFirstDigit);
        final int progrDeltaMax = 13;
        final int deltaAdd = 1;
        int progressionDelta = Engine.genNumber(progrDeltaMax) + deltaAdd;
        progressionNumbers[0] = Integer.toString(firstDigit);

        for (int i = 1; i < progressionNumbers.length; i++) {
            int prevNumber = Integer.parseInt(progressionNumbers[i - 1]);
            progressionNumbers[i] = Integer.toString(prevNumber + progressionDelta);
        }
    }

    private static String genQuestion(String[] progressionNumbers, int positionToHide) {
        StringBuilder question = new StringBuilder();

        question.append("Question:");
        for (int i = 0; i < progressionNumbers.length; i++) {
            if (i != positionToHide) {
                question.append(" ");
                question.append(progressionNumbers[i]);
            } else {
                question.append(" ");
                question.append("..");
            }
        }
        return question.toString();
    }
}
