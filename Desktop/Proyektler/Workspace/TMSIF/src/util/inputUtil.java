package util;

import java.util.Scanner;

public class inputUtil {
    public static String requireString(String title) {
        System.out.println(title);
        return new Scanner(System.in).nextLine();
    }

    public static Double requireDouble(String title) {
        System.out.println(title);
        return new Scanner(System.in).nextDouble();
    }

    public static Integer requireInt(String title) {
        System.out.println(title);
        return new Scanner(System.in).nextInt();
    }
}
