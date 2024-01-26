package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String userName;
    private static final int MAX_ROUNDS = 3;

    public static void play(String[][] questionsAndAnswers, String rules) {
        Scanner scanner = new Scanner(System.in);

        greeting();
        System.out.println(rules);

        for (int i = 0; i < Engine.getMaxRounds(); i++) {
            final int questionIndex = questionsAndAnswers[i].length - 2;
            final int answerIndex = questionsAndAnswers[i].length - 1;

            String question = questionsAndAnswers[i][questionIndex];
            String validAnswer = questionsAndAnswers[i][answerIndex];

            System.out.println(question);
            String userAnswer = scanner.next();
            String checkAnswer = check(validAnswer, userAnswer, i);
            if (checkAnswer.equals("error")) {
                break;
            }
        }

        scanner.close();
    }

    public static void greeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }

    public static String check(String validAnswer, String userAnswer, int roundIndex) {
        System.out.println("Your answer: " + userAnswer);
        if (!validAnswer.equalsIgnoreCase(userAnswer)) {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + validAnswer + "'.");
            System.out.println("Let's try again, " + userName + "!");
            return "error";
        }
        System.out.println("Correct!");
        if ((roundIndex + 1) == MAX_ROUNDS) {
            System.out.println("Congratulations, " + userName + "!");
        }
        return "correct";
    }

    public static int genNumber(int maxValue) {
        return (int) (Math.random() * maxValue);
    }

    public static int getMaxRounds() {
        return MAX_ROUNDS;
    }


}
