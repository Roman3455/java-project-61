package hexlet.code;

import java.util.Scanner;

class Cli {
    public static String getUserName() {
        Scanner nameScan = new Scanner(System.in);
        String userName = nameScan.next();
        nameScan.close();

        return userName;
    }
}
