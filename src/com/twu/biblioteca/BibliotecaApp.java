package com.twu.biblioteca;

public class BibliotecaApp {
    private static final BookList bookList = new BookList();

    private static final MenuHandler menuHandler = new MenuHandler();

    public static void main(String[] args) {
        initializeApp();

        displayForSelection("Options:", menuHandler.getOptionListAsString());

        String userOption = getUserOptionForMenuOption();

        while (!MenuOption.isQuit(userOption)) {

            if (MenuOption.isListBook(userOption)) {
                displayForSelection("Book List:", bookList.getBookListDetailsAsString());
            } else if (MenuOption.isCheckoutBook(userOption)) {
                handleBookCheckout();
            }

            userOption = getUserOptionForMenuOption();
        }

        exitApp();
    }

    private static void handleBookCheckout() {
        String bookTitle = InputUtils.getUserOptionAsString("Please enter book title: ");
        if(bookList.checkoutBookByTitle(bookTitle)) {
            printLine(MessageHelper.getMessageForSuccessBookCheckout());
        } else {
            printLine(MessageHelper.getMessageForFailedBookCheckout());
        }
    }

    private static String getUserOptionForMenuOption() {
        String userOption = InputUtils.getUserOptionAsString("Please enter your option: ");

        while (menuHandler.isInvalidOption(userOption)) {
            printLine(MessageHelper.getMessageForInvalidMenuOption());
            userOption = InputUtils.getUserOptionAsString("Please enter your option: ");
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
