package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Gcd {
    public static int gcdGame() {
        Scanner scanner = new Scanner(System.in);

        Engine.greeting();
        System.out.println("Find the greatest common division of given numbers");
        for (int i = 0; i < Engine.maxRounds; i++) {
            int firstDigit = (int) (Math.random() * 11);
            int secondDigit = (int) (Math.random() * 13);

            System.out.println("Question: " + firstDigit + " " + secondDigit);
            String answer = scanner.next();
            String result = calcResult(firstDigit, secondDigit);
            String checkResult = Engine.check(answer, result, (i + 1));
            if (checkResult.equals("error")) {
                return 1;
            }
        }
        scanner.close();
        return 0;
    }

    private static String calcResult(int firstDigit, int secondDigit) {
        int m = Math.abs(firstDigit);
        int n = Math.abs(secondDigit);
        int k = 1;

        //Бинарный алгоритм Евклида.
        if (firstDigit == 0 && secondDigit == 0) {
            return "1";
        }
        while (true) {
            if (m == 0 && n > 0) {
                return Integer.toString(n);
            } else if (n == 0 && m > 0) {
                return Integer.toString(m);
            } else if (m == n) {
                return Integer.toString(m * k);
            } else if (m == 1 && n > 0) {
                return Integer.toString(m * k);
            } else if (m > 0 && n == 1) {
                return Integer.toString(n * k);
            } else if (m % 2 == 0 && n % 2 == 0) {
                m /= 2;
                n /= 2;
                k *= 2;
            } else if (m % 2 == 0 && n % 2 != 0) {
                m /= 2;
            } else if (m % 2 != 0 && n % 2 == 0) {
                n /= 2;
            } else if (m % 2 != 0 && n % 2 != 0 && n > m) {
                n = (n - m) / 2;
            } else if (m % 2 != 0 && n % 2 != 0 && n < m) {
                m = (m - n) / 2;
            }
        }
    }
}