package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Randomizer;
import hexlet.code.ScannerUtil;

public class Calc {
    public static void isGameLoop() {
        String userName = Cli.greetings();
        System.out.println("What is the result of the expression?");

        int maxWin = 3;
        int countCorrectAnswers = 0;
        int boundNum = 100;
        int compOperationNum = 3;
        while (countCorrectAnswers < maxWin) {
            int computingOperation = Randomizer.getRandomIntNum(compOperationNum);
            int randNum1 = Randomizer.getRandomIntNum(boundNum);
            int randNum2 = Randomizer.getRandomIntNum(boundNum);

            String question;
            int result;

            switch (computingOperation) {
                case 0:
                    question = randNum1 + " + " + randNum2;
                    result = randNum1 + randNum2;
                    break;
                case 1:
                    question = randNum1 + " - " + randNum2;
                    result = randNum1 - randNum2;
                    break;
                default:
                    question = randNum1 + " * " + randNum2;
                    result = randNum1 * randNum2;
                    break;
            }

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            int userAnswer = ScannerUtil.nextInt();

            if (userAnswer != result) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + result + "'.\n"
                        + "Let's try again, " + userName + "!");
                break;
            }

            System.out.println("Correct!");
            countCorrectAnswers++;
        }

        if (countCorrectAnswers == maxWin) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
