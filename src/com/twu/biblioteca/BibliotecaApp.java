package com.twu.biblioteca;

public class BibliotecaApp {
    private static final BookList bookList = new BookList();

    private static final MenuHandler menuHandler = new MenuHandler();

    public static void main(String[] args) {
        initializeApp();

        displayForSelection("Options:", menuHandler.getOptionListAsString());

        String userOption = getUserOption();

        if(MenuOption.isQuit(userOption)) {
            exitApp();
        }

        if(MenuOption.isListBook(userOption)) {
            displayForSelection("Book List:", bookList.getBookListDetailsAsString());
        } else if(MenuOption.isCheckoutBook(userOption)) {
            // TODO #7
            //String bookTitle = getUserOption();
            //bookList.checkoutByBookTitle(bookTitle);
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
        System.exit(0);
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
