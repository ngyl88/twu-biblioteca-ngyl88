package com.twu.biblioteca;

public class DisplayUtils {

    public static void promptMessage(String message) {
        System.out.println(message);
    }

    public static void displayInformationWithHeader(String header, String information) {
        promptMessage(header);
        promptMessage(information);
    }
}
