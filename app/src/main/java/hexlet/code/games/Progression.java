package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.MainMenu;
import hexlet.code.Randomizer;
import hexlet.code.ScannerUtil;

public class Progression {
    private static final int MIN_FIRST_VAL = -50;
    private static final int MAX_FIRST_VAL = 51;
    private static final int MIN_PROGRESSION_STEP = 2;
    private static final int MAX_PROGRESSION_STEP = 6;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 11;

    public static void isGameLoop() {
        String userName = Cli.greetings();
        System.out.println("What number is missing in the progression?");

        int countCorrectAnswers = 0;
        while (countCorrectAnswers < MainMenu.MAX_WIN) {
            int progressionLength = Randomizer.getRandomIntNum(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            int[] progressionArr = new int[progressionLength];
            int progressionStep = Randomizer.getRandomIntNum(MIN_PROGRESSION_STEP, MAX_PROGRESSION_STEP);
            int randIndex = Randomizer.getRandomIntNum(progressionArr.length);
            progressionArr[0] = Randomizer.getRandomIntNum(MIN_FIRST_VAL, MAX_FIRST_VAL);
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
