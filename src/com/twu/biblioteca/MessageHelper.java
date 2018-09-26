package com.twu.biblioteca;

public class MessageHelper {
    public static String getWelcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public static String getMessageForInvalidMenuOption() {
        return "Select a valid option!";
    }

    public static String getMessageForSuccessBookCheckout() {
        return "Thank you! Enjoy the book";
    }

    public static String getMessageForFailedBookCheckout() {
        return "That book is not available.";
    }

    public static String getMessageForSuccessBookReturn() {
        return "Thank you for returning the book.";
    }

    public static String getMessageForFailedBookReturn() {
        return "That is not a valid book to return.";
    }
}
