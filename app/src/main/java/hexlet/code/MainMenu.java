package hexlet.code;

class MainMenu {
    public static int selectOption() {
        System.out.print("""
                Please enter the game number and press Enter.
                1-Greet
                2-Even
                0-Exit
                Your choise:\s""");

        return ScannerUtil.nextInt();
    }
}
