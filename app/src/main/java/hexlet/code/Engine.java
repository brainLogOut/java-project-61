package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int MAX_ROUNDS = 3;

    public static void play(String[][] questionsAndAnswers, String rules) {
        Scanner scanner = new Scanner(System.in);
        boolean successfulGame = true;

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rules);

        for (String[] questionOrAnswer : questionsAndAnswers) {
            final int questionIndex = 0;
            final int answerIndex = 1;

            String question = questionOrAnswer[questionIndex];
            String validAnswer = questionOrAnswer[answerIndex];

            System.out.println(question);
            String userAnswer = scanner.next();
            System.out.println("Your answer: " + userAnswer);

            if (!validAnswer.equals(userAnswer)) {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '"
                        + validAnswer + "'.");
                successfulGame = false;
                break;
            } else {
                System.out.println("Correct!");
            }
        }

        if (successfulGame) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
        scanner.close();
    }
}
