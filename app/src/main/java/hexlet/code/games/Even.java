package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Randomizer;
import hexlet.code.ScannerUtil;

public class Even {
    public static void isGameLoop() {
        String userName = Cli.greetings();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int maxWin = 3;
        int countCorrectAnswers = 0;
        int boundNum = 100;
        while (countCorrectAnswers < maxWin) {
            int num = Randomizer.getRandomIntNum(boundNum);
            boolean numBoolean = (num % 2 == 0);
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

        if (countCorrectAnswers == maxWin) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
