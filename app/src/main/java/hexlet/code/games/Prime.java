package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Randomizer;
import hexlet.code.ScannerUtil;

public class Prime {
    public static void isGameLoop() {
        String userName = Cli.greetings();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int maxWin = 3;
        int countCorrectAnswers = 0;
        while (countCorrectAnswers < maxWin) {
            int num = Randomizer.getRandomIntNum(200);
            boolean numBoolean = isPrimeCheck(num);
            System.out.println("Question: " + num);
            System.out.print("Your answer: ");
            String userAnswer = ScannerUtil.next();

            if (userAnswer.equalsIgnoreCase("yes") && (userAnswer.equalsIgnoreCase("yes")
                    != numBoolean)) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.\n"
                        + "Let's try again, " + userName + "!");
                break;
            }
            if (userAnswer.equalsIgnoreCase("no") && (userAnswer.equalsIgnoreCase("no")
                    == numBoolean)) {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.\n"
                        + "Let's try again, " + userName + "!");
                break;
            }
            if (!userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("no")
                    && !numBoolean) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was 'no'.\n"
                        + "Let's try again, " + userName + "!");
                break;
            }
            if (!userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("no")
                    && numBoolean) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was 'yes'.\n"
                        + "Let's try again, " + userName + "!");
                break;
            }
            System.out.println("Correct!");
            countCorrectAnswers++;
        }
        if (countCorrectAnswers == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    private static boolean isPrimeCheck(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }

        }
        return true;
    }
}
