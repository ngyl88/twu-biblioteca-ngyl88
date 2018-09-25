package com.twu.biblioteca;

public class BibliotecaApp {
    private static final MessageHelper messageHelper = new MessageHelper();

    private static final BookList bookList = new BookList();

    private static final MenuHandler menuHandler = new MenuHandler();

    public static void main(String[] args) {
        System.out.println(messageHelper.getWelcomeMessage());

        bookList.initialize();
        InputUtils.openStream();

        System.out.println("Options:");
        System.out.println(menuHandler.getOptionListAsString());

        String userOption = InputUtils.getUserOptionAsString();

        while(menuHandler.isInvalidOption(userOption)) {
            System.out.println("Select a valid option!");
            userOption = InputUtils.getUserOptionAsString();
        }

        if(userOption.equals(MenuOption.LIST_BOOK.getOptionKey())) {
            System.out.println("Book List:");
            System.out.println(bookList.getBookListDetailsAsString());
        }

        InputUtils.closeStream();
    }
}
