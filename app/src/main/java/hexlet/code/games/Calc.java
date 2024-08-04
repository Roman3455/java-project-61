package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class Calc {
    public static void run() {
        String ruleMessage = "What is the result of the expression?";
        Engine.run(getQuestionsAndAnswers(), ruleMessage);
    }

    private static final int OPERAND_BOUND = 100;

    private static String[][] getQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.QUESTION_ANSWER_COLUMNS][Engine.MAX_WIN];
        String[] operators = {"+", "-", "*"};

        for (int i = 0; i < Engine.MAX_WIN; i++) {
            int randomIntNum1 = RandomUtils.getRandomIntNum(OPERAND_BOUND);
            int randomIntNum2 = RandomUtils.getRandomIntNum(OPERAND_BOUND);
            String operator = operators[RandomUtils.getRandomIntNum(operators.length)];

            switch (operator) {
                case "+":
                    questionsAndAnswers[0][i] = randomIntNum1 + "+" + randomIntNum2;
                    questionsAndAnswers[1][i] = String.valueOf(randomIntNum1 + randomIntNum2);
                    break;
                case "-":
                    questionsAndAnswers[0][i] = randomIntNum1 + "-" + randomIntNum2;
                    questionsAndAnswers[1][i] = String.valueOf(randomIntNum1 - randomIntNum2);
                    break;
                default:
                    questionsAndAnswers[0][i] = randomIntNum1 + "*" + randomIntNum2;
                    questionsAndAnswers[1][i] = String.valueOf(randomIntNum1 * randomIntNum2);
                    break;
            }
        }

        return questionsAndAnswers;
    }
}
