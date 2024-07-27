package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Randomizer;
import hexlet.code.ScannerUtil;

public class GCD {
    public static void isGameLoop() {
        String userName = Cli.greetings();
        System.out.println("Find the greatest common divisor of given numbers.");

        int maxWin = 3;
        int countCorrectAnswers = 0;
        while (countCorrectAnswers < maxWin) {
            int randNum1 = Randomizer.getRandomIntNum(100);
            int randNum2 = Randomizer.getRandomIntNum(100);
            System.out.println("Question: " + randNum1 + " " + randNum2);
            System.out.print("Your answer: ");
            int userAnswer = ScannerUtil.nextInt();
            int result = gsd(randNum1, randNum2);

            if (userAnswer != result) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + result + "'.\n"
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

    private static int gsd(int num1, int num2) {
        while (num2 != 0) {
            int tmp = num2;
            num2 = num1 % num2;
            num1 = tmp;
        }
        return num1;
    }
}
