package com.twu.biblioteca;

import static com.twu.biblioteca.DisplayUtils.displayInformationWithHeader;
import static com.twu.biblioteca.DisplayUtils.promptMessage;
import static com.twu.biblioteca.InputUtils.getInputFromUser;

public class BookListHandler {
    private final BookList bookList = new BookList();

    private void handleBookReturn() {
        String bookTitle = getInputFromUser("Please enter book title: ");
        if (bookList.returnBook(bookTitle)) {
            promptMessage(MessageHelper.getMessageForSuccessBookReturn());
        } else {
            promptMessage(MessageHelper.getMessageForFailedBookReturn());
        }
    }

    private void handleBookCheckout() {
        String bookTitle = getInputFromUser("Please enter book title: ");
        if (bookList.checkoutBookByTitle(bookTitle)) {
            promptMessage(MessageHelper.getMessageForSuccessBookCheckout());
        } else {
            promptMessage(MessageHelper.getMessageForFailedBookCheckout());
        }
    }

    // TODO: UNIT TEST NOT CREATED (support main)
    public void handleUserOption(String userOption) {

        if (MenuOption.LIST_BOOK.keyMatches(userOption)) {
            displayInformationWithHeader("Book List:", bookList.getAvailableBookListDetailsAsString());

        } else if (MenuOption.CHECKOUT_BOOK.keyMatches(userOption)) {
            handleBookCheckout();

        } else if (MenuOption.RETURN_BOOK.keyMatches(userOption)) {
            handleBookReturn();

        }

    }
}
