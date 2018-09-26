package com.twu.biblioteca;

import static com.twu.biblioteca.DisplayUtils.displayInformationWithHeader;
import static com.twu.biblioteca.DisplayUtils.promptMessage;
import static com.twu.biblioteca.InputUtils.getInputFromUser;

public class BibliotecaApp {
    private static final BookList bookList = new BookList();

    private static final MenuHandler menuHandler = new MenuHandler();

    public static void main(String[] args) {

        promptMessage(MessageHelper.getWelcomeMessage());

        initializeApp();

        displayInformationWithHeader("Options:", menuHandler.getOptionListAsString());

        String userOption = getUserOptionForMenuOption();

        while (!MenuOption.isQuit(userOption)) {

            if (MenuOption.isListBook(userOption)) {
                displayInformationWithHeader("Book List:", bookList.getBookListDetailsAsString());
            } else if (MenuOption.isCheckoutBook(userOption)) {
                handleBookCheckout();
            } else if (MenuOption.isReturnBook(userOption)) {
                handleBookReturn();
            }

            userOption = getUserOptionForMenuOption();
        }

        exitApp();
    }

    private static void handleBookReturn() {
        String bookTitle = getInputFromUser("Please enter book title: ");
        if (bookList.returnBook(bookTitle)) {
            promptMessage(MessageHelper.getMessageForSuccessBookReturn());
        } else {
            promptMessage(MessageHelper.getMessageForFailedBookReturn());
        }
    }

    private static void handleBookCheckout() {
        String bookTitle = getInputFromUser("Please enter book title: ");
        if (bookList.checkoutBookByTitle(bookTitle)) {
            promptMessage(MessageHelper.getMessageForSuccessBookCheckout());
        } else {
            promptMessage(MessageHelper.getMessageForFailedBookCheckout());
        }
    }

    private static String getUserOptionForMenuOption() {
        String userOption = getInputFromUser("Please enter your option: ");

        while (menuHandler.isInvalidOption(userOption)) {
            promptMessage(MessageHelper.getMessageForInvalidMenuOption());
            userOption = getInputFromUser("Please enter your option: ");
        }
        return userOption;
    }

    private static void exitApp() {
        InputUtils.closeStream();
        System.exit(0);
    }

    private static void initializeApp() {
        bookList.initialize();
        InputUtils.openStream();
    }
}
