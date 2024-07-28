package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Randomizer;
import hexlet.code.ScannerUtil;

public class Progression {
    public static void isGameLoop() {
        String userName = Cli.greetings();
        System.out.println("What number is missing in the progression?");

        int maxWin = 3;
        int countCorrectAnswers = 0;
        while (countCorrectAnswers < maxWin) {
            int progressionLength = Randomizer.getRandomIntNum(5, 11);
            int[] progressionArr = new int[progressionLength];
            int progressionStep = Randomizer.getRandomIntNum(2, 6);
            int randIndex = Randomizer.getRandomIntNum(progressionArr.length);
            progressionArr[0] = Randomizer.getRandomIntNum(-50, 51);
            for (int i = 1; i < progressionLength; i++) {
                progressionArr[i] = progressionArr[i - 1] + progressionStep;
            }

            System.out.print("Question: ");
            for (int j = 0; j < progressionLength; j++) {
                if (j == randIndex) {
                    System.out.print(".. ");
                } else {
                    System.out.print(progressionArr[j] + " ");
                }
            }

            System.out.print("\nYour answer: ");
            int userAnswer = ScannerUtil.nextInt();
            if (userAnswer != progressionArr[randIndex]) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + progressionArr[randIndex] + "'.\n" + "Let's try again, " + userName + "!");
                break;
            }

            System.out.println("Correct!");
            countCorrectAnswers++;
        }

        if (countCorrectAnswers == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
