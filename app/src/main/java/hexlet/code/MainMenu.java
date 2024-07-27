package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

class MainMenu {
    public static void selectOption() {
        System.out.print("""
                Please enter the game number and press Enter.
                1-Greet
                2-Even
                3-Calc
                0-Exit
                Your choise:\s""");

        int selection = ScannerUtil.nextInt();

        switch (selection) {
            case 1:
                Cli.greetings();
                break;
            case 2:
                Even.isGameLoop();
                break;
            case 3:
                Calc.isGameLoop();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid value, try again");
        }
    }
}
