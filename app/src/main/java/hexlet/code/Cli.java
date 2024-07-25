package hexlet.code;

public class Cli {
    public static String greetings() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String userName = getUserName();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    private static String getUserName() {
        return ScannerUtil.next();
    }
}
