package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class Even {
    public static void run() {
        String ruleMessage = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.run(getQuestionsAndAnswers(), ruleMessage);
    }

    private static final int NUMBER_BOUND = 100;

    private static String[][] getQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.QUESTION_ANSWER_COLUMNS][Engine.MAX_WIN];
        for (int i = 0; i < Engine.MAX_WIN; i++) {
            int randomIntNum = RandomUtils.getRandomIntNum(NUMBER_BOUND);
            questionsAndAnswers[0][i] = String.valueOf(randomIntNum);

            boolean numBoolean = (randomIntNum % 2 == 0);
            if (numBoolean) {
                questionsAndAnswers[1][i] = "yes";
            } else {
                questionsAndAnswers[1][i] = "no";
            }
        }

        return questionsAndAnswers;
    }
}
