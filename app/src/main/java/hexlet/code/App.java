package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        return scanner.next();
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        System.out.print("""
                Please enter the game number and press Enter.
                1-Greet
                2-Even
                3-Calc
                4-GCD
                5-Progression
                6-Prime
                0-Exit
                Your choise:\s""");

        String selection = getUserInput();

        switch (selection) {
            case "1":
                Cli.greetings();
                break;
            case "2":
                Even.run();
                break;
            case "3":
                Calc.run();
                break;
            case "4":
                GCD.run();
                break;
            case "5":
                Progression.run();
                break;
            case "6":
                Prime.run();
                break;
            case "0":
                break;
            default:
                System.out.println("Invalid value, try again");
        }

        closeScanner();
    }
}
