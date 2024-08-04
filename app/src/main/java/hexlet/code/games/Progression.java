package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.StringJoiner;

public class Progression {
    public static void run() {
        String ruleMessage = "What number is missing in the progression?";
        Engine.run(getQuestionsAndAnswers(), ruleMessage);
    }

    private static String[][] getQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.QUESTION_ANSWER_COLUMNS][Engine.MAX_WIN];
        for (int i = 0; i < Engine.MAX_WIN; i++) {
            int[] progressionArr = getProgression();
            int hiddenNumIndex = RandomUtils.getRandomIntNum(progressionArr.length);
            questionsAndAnswers[1][i] = String.valueOf(progressionArr[hiddenNumIndex]);

            StringJoiner joiner = new StringJoiner(" ");
            for (int j = 0; j < progressionArr.length; j++) {
                if (j == hiddenNumIndex) {
                    joiner.add("..");
                } else {
                    joiner.add(String.valueOf(progressionArr[j]));
                }
            }

            questionsAndAnswers[0][i] = joiner.toString();
        }

        return questionsAndAnswers;
    }

    private static final int MIN_FIRST_VAL = -50;
    private static final int MAX_FIRST_VAL = 51;
    private static final int MIN_PROGRESSION_STEP = 2;
    private static final int MAX_PROGRESSION_STEP = 6;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 11;

    private static int[] getProgression() {
        int progressionLength = RandomUtils.getRandomIntNum(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        int progressionStep = RandomUtils.getRandomIntNum(MIN_PROGRESSION_STEP, MAX_PROGRESSION_STEP);

        int[] progressionArr = new int[progressionLength];
        progressionArr[0] = RandomUtils.getRandomIntNum(MIN_FIRST_VAL, MAX_FIRST_VAL);
        for (int i = 1; i < progressionLength; i++) {
            progressionArr[i] = progressionArr[i - 1] + progressionStep;
        }

        return progressionArr;
    }
}
