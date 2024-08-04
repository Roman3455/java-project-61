package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class Prime {
    public static void run() {
        String ruleMessage = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.run(getQuestionsAndAnswers(), ruleMessage);
    }

    private static final int NUMBER_BOUND = 200;

    private static String[][] getQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.QUESTION_ANSWER_COLUMNS][Engine.MAX_WIN];
        for (int i = 0; i < Engine.MAX_WIN; i++) {
            int randomIntNum = RandomUtils.getRandomIntNum(NUMBER_BOUND);
            questionsAndAnswers[0][i] = String.valueOf(randomIntNum);

            boolean numBoolean = isPrimeCheck(randomIntNum);
            if (numBoolean) {
                questionsAndAnswers[1][i] = "yes";
            } else {
                questionsAndAnswers[1][i] = "no";
            }
        }

        return questionsAndAnswers;
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
