package com.twu.biblioteca;

import java.util.Scanner;

public class InputUtils {

    public static String getUserOptionAsString() {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Please enter your option: ");
            return in.next();
        } finally {
            in.close();
        }
    }
}
