package hexlet.code;

public class Cli {
    public static String greetings() {
        System.out.print("\nWelcome to the Brain Games!\nMay I have your name? ");
        String userName = App.getUserInput();
        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
