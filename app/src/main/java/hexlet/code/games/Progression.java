package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.MainMenu;
import hexlet.code.Randomizer;
import hexlet.code.ScannerUtil;

public class Progression {
    public static void isGameLoop() {
        String userName = Cli.greetings();
        System.out.println("What number is missing in the progression?");

        int countCorrectAnswers = 0;
        int minProgrLength = 5;
        int maxProgrLength = 11;
        int minProgrStep = 2;
        int maxProgrStep = 6;
        int minFirstVal = -50;
        int maxFirstVal = 51;
        while (countCorrectAnswers < MainMenu.MAX_WIN) {
            int progressionLength = Randomizer.getRandomIntNum(minProgrLength, maxProgrLength);
            int[] progressionArr = new int[progressionLength];
            int progressionStep = Randomizer.getRandomIntNum(minProgrStep, maxProgrStep);
            int randIndex = Randomizer.getRandomIntNum(progressionArr.length);
            progressionArr[0] = Randomizer.getRandomIntNum(minFirstVal, maxFirstVal);
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

        if (countCorrectAnswers == MainMenu.MAX_WIN) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
