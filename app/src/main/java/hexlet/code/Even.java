package hexlet.code;

import java.util.Scanner;
public class Even {
    public static void evenGame() {
        Scanner scanner = new Scanner(System.in);
        int validAnswers = 0;

        System.out.println("Welcome to the Brain Games");
        System.out.println("May I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        do {
            int currentNumber = (int) (Math.random() * 100);
            System.out.println("Question: " + currentNumber);
            String answer = scanner.next();
            if ((answer.equalsIgnoreCase("yes")
                    && currentNumber % 2 == 0)
                    || (answer.equalsIgnoreCase("no")
                    && currentNumber % 2 != 0)) {
                validAnswers++;
            } else {
                break;
            }
        } while (validAnswers < 3);
        if (validAnswers == 3) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Wrong answer, try again later");
        }
        scanner.close();
    }
}
