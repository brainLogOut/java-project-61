package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Progression {
    public static void runProgressionGame() {
        Scanner scanner = new Scanner(System.in);

        Engine.greeting();
        System.out.println("What number is missing in the progression?");
        for (int i = 0; i < Engine.getMaxRounds(); i++) {
            final int lengthAdd = 5;
            final int progrLengthMax = 5;
            int progressionLength = Engine.genNumber(progrLengthMax) + lengthAdd;
            String[] progressionNumbers = new String[progressionLength];
            int indexToHide = (int) (Math.random() * progressionLength);

            progressionInit(progressionNumbers);
            questionPrint(progressionNumbers, indexToHide);
            String answer = scanner.next();
            String result = progressionNumbers[indexToHide];
            String checkResult = Engine.check(answer, result, (i + 1));
            if (checkResult.equals("error")) {
                break;
            }
        }
        scanner.close();
    }

    private static void questionPrint(String[] progressionNumbers, int positionToHide) {
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
        System.out.println(question);
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
}
