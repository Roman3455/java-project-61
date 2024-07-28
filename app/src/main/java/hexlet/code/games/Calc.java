package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.MainMenu;
import hexlet.code.Randomizer;
import hexlet.code.ScannerUtil;

public class Calc {
    private static final int NUM_BOUND = 100;
    private static final int COMPUTING_OPERATOR_NUM = 3;

    public static void isGameLoop() {
        String userName = Cli.greetings();
        System.out.println("What is the result of the expression?");

        int countCorrectAnswers = 0;
        while (countCorrectAnswers < MainMenu.MAX_WIN) {
            int computingOperator = Randomizer.getRandomIntNum(COMPUTING_OPERATOR_NUM);
            int randNum1 = Randomizer.getRandomIntNum(NUM_BOUND);
            int randNum2 = Randomizer.getRandomIntNum(NUM_BOUND);

            String question;
            int result;
            switch (computingOperator) {
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

        if (countCorrectAnswers == MainMenu.MAX_WIN) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
