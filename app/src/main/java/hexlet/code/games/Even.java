package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void callGame() {
        final int numberOfFields = 2;
        String[][] questionsAndAnswers = new String[Engine.getMaxRounds()][numberOfFields];
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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
        String answer = "";
        if (currentNumber % 2 == 0) {
            answer = "yes";
        } else if (currentNumber % 2 != 0) {
            answer = "no";
        }

        return answer;
    }
}
