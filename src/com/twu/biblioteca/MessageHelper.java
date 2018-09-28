package com.twu.biblioteca;

public class MessageHelper {
    public static String getWelcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public static String getMessageForInvalidMenuOption() {
        return "Select a valid option!";
    }

    public static String getMessageForSuccessCheckout(String resourceType) {
        return "Thank you! Enjoy the " + resourceType;
    }

    public static String getMessageForFailedCheckout(String resourceType) {
        return "That " + resourceType + " is not available.";
    }

    public static String getMessageForSuccessBookReturn() {
        return "Thank you for returning the book.";
    }

    public static String getMessageForFailedBookReturn() {
        return "That is not a valid book to return.";
    }

    public static String getMessageForLoginRequired() {
        return "Login required!";
    }

    public static String getMessageForSuccessLogin() {
        return "Login success!";
    }

    public static String getMessageForFailedLogin() {
        return "Login failed!";
    }
}
