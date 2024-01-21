package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Gcd {
    public static int gcdGame() {
        Scanner scanner = new Scanner(System.in);

        Engine.greeting();
        System.out.println("Find the greatest common divisor of given numbers.");
        for (int i = 0; i < Engine.getMaxRounds(); i++) {
            final int maxFirstDigit = 11;
            int firstDigit = Engine.genNumber(maxFirstDigit);
            final int maxSecondDigit = 13;
            int secondDigit = Engine.genNumber(maxSecondDigit);

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
        String result = "";
        boolean exit = false;

        //Бинарный алгоритм Евклида.
        if (firstDigit == 0 && secondDigit == 0) {
            return "1";
        }
        while (!exit) {
            if (m == 0 && n > 0) {
                result = Integer.toString(n);
                exit = true;
            } else if (n == 0 && m > 0) {
                result = Integer.toString(m);
                exit = true;
            } else if (m == n) {
                result = Integer.toString(m * k);
                exit = true;
            } else if (m == 1 && n > 0) {
                result = Integer.toString(m * k);
                exit = true;
            } else if (m > 0 && n == 1) {
                result = Integer.toString(n * k);
                exit = true;
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
        return result;
    }
}
