package hexlet.code;

public class Engine {
    public static final int MAX_WIN = 3;
    public static final int QUESTION_ANSWER_COLUMNS = 2;

    public static void run(String[][] questionsAndAnswers, String ruleMessage) {
        String userName = Cli.greetings();
        System.out.println(ruleMessage);

        int countCorrectAnswers = 0;
        while (countCorrectAnswers < MAX_WIN) {
            System.out.println("Question: " + questionsAndAnswers[0][countCorrectAnswers]);
            System.out.print("Your answer: ");
            String userAnswer = App.getUserInput();

            if (!userAnswer.equalsIgnoreCase(questionsAndAnswers[1][countCorrectAnswers])) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[1][countCorrectAnswers] + "'.\n"
                        + "Let's try again, " + userName + "!");
                break;
            }

            System.out.println("Correct!");
            countCorrectAnswers++;
        }

        if (countCorrectAnswers == Engine.MAX_WIN) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
