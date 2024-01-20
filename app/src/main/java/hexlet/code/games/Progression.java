package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Progression {
    public static int progressionGame() {
        Scanner scanner = new Scanner(System.in);

        Engine.greeting();
        System.out.println("What number missing in the progression?");
        for (int i = 0; i < Engine.maxRounds; i++) {
            int progressionLength = (int) (Math.random() * 5 + 5);
            String[] progressionNumbers = new String[progressionLength];
            int indexToHide = (int) (Math.random() * progressionLength);

            progressionInit(progressionNumbers);
            questionPrint(progressionNumbers, indexToHide);
            String answer = scanner.next();
            String result = progressionNumbers[indexToHide];
            String checkResult = Engine.check(answer, result, (i + 1));
            if (checkResult.equals("error")) {
                return 1;
            }
        }
        scanner.close();
        return 0;
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
        int firstDigit = (int) (Math.random() * 11);
        int progressionDelta = (int) (Math.random() * 10 + 1);
        progressionNumbers[0] = Integer.toString(firstDigit);

        for (int i = 1; i < progressionNumbers.length; i++) {
            int prevNumber = Integer.parseInt(progressionNumbers[i - 1]);
            progressionNumbers[i] = Integer.toString(prevNumber + progressionDelta);
        }
    }
}
