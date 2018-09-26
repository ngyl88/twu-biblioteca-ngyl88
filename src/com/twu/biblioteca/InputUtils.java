package com.twu.biblioteca;

import java.util.Scanner;

public class InputUtils {

    private static Scanner in = null;

    public static void openStream() {
        if (in == null) {
            in = new Scanner(System.in);
        }
    }

    public static String getUserOptionAsString(String instruction) {
        System.out.print(instruction);
        return in.nextLine();
    }

    public static void closeStream() {
        in.close();
    }
}
