package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static void callGame() {
        final int numberOfFields = 2;
        String[][] questionsAndAnswers = new String[Engine.getMaxRounds()][numberOfFields];
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        for (int i = 0; i < Engine.getMaxRounds(); i++) {
            final int maxNumberValue = 100;
            int currentNumber = Engine.genNumber(maxNumberValue);

            String question = "Question: " + currentNumber;
            String answer = computeAnswer(currentNumber);

            questionsAndAnswers[i][numberOfFields - 2] = question;
            questionsAndAnswers[i][numberOfFields - 1] = answer;
        }

        Engine.play(questionsAndAnswers, rules);
    }

    private static String computeAnswer(int currentNumber) {
        String cResult = "yes";
        int countMax = (int) (Math.sqrt(currentNumber));

        if (currentNumber <= 1) {
            return "no";
        }
        for (int i = 2; i <= countMax; i++) {
            if (currentNumber % i == 0) {
                cResult = "no";
                break;
            }
        }
        return cResult;
    }
}
