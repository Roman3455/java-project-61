package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class GCD {
    public static void run() {
        String ruleMessage = "Find the greatest common divisor of given numbers.";
        Engine.run(getQuestionsAndAnswers(), ruleMessage);
    }

    private static final int NUMBER_BOUND = 100;

    private static String[][] getQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.QUESTION_ANSWER_COLUMNS][Engine.MAX_WIN];
        for (int i = 0; i < Engine.MAX_WIN; i++) {
            int randomIntNum1 = RandomUtils.getRandomIntNum(NUMBER_BOUND);
            int randomIntNum2 = RandomUtils.getRandomIntNum(NUMBER_BOUND);
            questionsAndAnswers[0][i] = randomIntNum1 + " " + randomIntNum2;
            int result = gsd(randomIntNum1, randomIntNum2);
            questionsAndAnswers[1][i] = String.valueOf(result);
        }

        return questionsAndAnswers;
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
