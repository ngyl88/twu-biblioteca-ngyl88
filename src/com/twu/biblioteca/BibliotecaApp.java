package com.twu.biblioteca;

public class BibliotecaApp {
    private static final BookList bookList = new BookList();

    private static final MenuHandler menuHandler = new MenuHandler();

    public static void main(String[] args) {
        initializeApp();

        displayForSelection("Options:", menuHandler.getOptionListAsString());

        String userOption = getUserOption();

        if(userOption.equals(MenuOption.LIST_BOOK.getOptionKey())) {
            displayForSelection("Book List:", bookList.getBookListDetailsAsString());
        }

        exitApp();
    }

    private static String getUserOption() {
        String userOption = InputUtils.getUserOptionAsString();

        while(menuHandler.isInvalidOption(userOption)) {
            printLine(MessageHelper.getMessageForInvalidMenuOption());
            userOption = InputUtils.getUserOptionAsString();
        }
        return userOption;
    }

    private static void displayForSelection(String type, String optionListAsString) {
        printLine(type);
        printLine(optionListAsString);
    }

    private static void exitApp() {
        InputUtils.closeStream();
    }

    private static void initializeApp() {
        printLine(MessageHelper.getWelcomeMessage());

        bookList.initialize();
        InputUtils.openStream();
    }

    private static void printLine(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }
}
