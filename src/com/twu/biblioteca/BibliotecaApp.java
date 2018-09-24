package com.twu.biblioteca;

public class BibliotecaApp {
    private static final MessageHelper messageHelper = new MessageHelper();

    private static final BookList bookList = new BookList();

    public static void main(String[] args) {
        System.out.println(messageHelper.getWelcomeMessage());

        bookList.initialize();

        System.out.println("Book List:");
        System.out.println(bookList.getBookListDetails());
    }
}
