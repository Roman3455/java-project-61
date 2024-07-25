package hexlet.code;

public class Even {
    public static void isEvenNum() {
        String userName = Cli.greetings();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        String incorrectYes = "'yes' is wrong answer ;(. Correct answer was 'no'.\nLet's try again, " + userName + "!";
        String incorrectNo = "'no' is wrong answer ;(. Correct answer was 'yes'.\nLet's try again, " + userName + "!";
        int countCorrectAnswers = 0;
        do {
            int num = getRandomNum();
            boolean numBoolean = num % 2 == 0;

            System.out.println("Question: " + num);

            String userAnswer = getUserAnswer();
            boolean userAnswerBoolean;
            if (userAnswer.equalsIgnoreCase("yes")) {
                userAnswerBoolean = true;
            } else if (userAnswer.equalsIgnoreCase("no")) {
                userAnswerBoolean = false;
            } else {
                System.out.println("Wrong answer, " + userName);
                break;
            }

            if (numBoolean == userAnswerBoolean) {
                System.out.println("Correct!");
                countCorrectAnswers++;
            } else {
                if (!numBoolean) {
                    System.out.println(incorrectYes);
                    break;
                }
                System.out.println(incorrectNo);
                break;
            }

        } while (countCorrectAnswers < 3);

        if (countCorrectAnswers == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    private static String getUserAnswer() {
        return ScannerUtil.next();
    }

    private static int getRandomNum() {
        double randomNum = Math.random() * 100;
        return (int) randomNum;
    }
}
