package hexlet.code;

public class App {
    public static void main(String[] args) {
        int number = MainMenu.selectOption();

        switch (number) {
            case 1:
                Cli.greetings();
                break;
            case 2:
                Even.isEvenNum();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid value");
        }

        ScannerUtil.close();
    }
}
