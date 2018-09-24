package com.twu.biblioteca;

public class BibliotecaApp {
    private static final MessageHelper messageHelper = new MessageHelper();

    public static void main(String[] args) {
        System.out.println(messageHelper.getWelcomeMessage());
    }
}
