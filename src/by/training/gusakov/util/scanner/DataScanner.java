package by.training.gusakov.util.scanner;

import java.util.Scanner;

public class DataScanner {
    public static String getStringFromConsole() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int getIntFromConsole() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            sc.next();
        }
        return sc.nextInt();
    }

    public static long getLongFromConsole() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextLong()) {
            sc.next();
        }
        return sc.nextLong();
    }

    public static double getDoubleFromConsole() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextDouble()) {
            sc.next();
        }
        return sc.nextDouble();
    }
}
