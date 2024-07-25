package hexlet.code;

import java.util.Scanner;

public class ScannerUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String next() {
        return scanner.next();
    }

    public static int nextInt() {
        return scanner.nextInt();
    }

    public static void close() {
        scanner.close();
    }
}
