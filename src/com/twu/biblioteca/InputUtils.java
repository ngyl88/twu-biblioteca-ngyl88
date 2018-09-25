package com.twu.biblioteca;

import java.util.Scanner;

public class InputUtils {

    private static Scanner in = null;

    public static void openStream() {
        if (in == null) {
            in = new Scanner(System.in);
        }
    }

    public static String getUserOptionAsString() {
        System.out.print("Please enter your option: ");
        return in.nextLine();
    }

    public static void closeStream() {
        in.close();
    }
}
