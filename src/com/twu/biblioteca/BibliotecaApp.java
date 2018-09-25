package com.twu.biblioteca;

public class BibliotecaApp {
    private static final MessageHelper messageHelper = new MessageHelper();

    private static final BookList bookList = new BookList();

    private static final MenuHandler menuHandler = new MenuHandler();

    public static void main(String[] args) {
        System.out.println(messageHelper.getWelcomeMessage());

        bookList.initialize();

        // #4: display menu options
        System.out.println("Options:");
        System.out.println(menuHandler.getOptionListAsString());

        // #4: get user options

        System.out.println("Book List:");
        System.out.println(bookList.getBookListDetailsAsString());
    }
}
