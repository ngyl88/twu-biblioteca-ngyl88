package com.twu.biblioteca;

import static com.twu.biblioteca.DisplayUtils.displayInformationWithHeader;
import static com.twu.biblioteca.DisplayUtils.promptMessage;
import static com.twu.biblioteca.InputUtils.getInputFromUser;

public class ResourceHandler {

    private static String RESOURCE_TYPE_BOOK = "book";
    private static String RESOURCE_TYPE_MOVIE = "movie";

    private final BookList bookList = new BookList();
    private final MovieList movieList = new MovieList();

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
            promptMessage(MessageHelper.getMessageForSuccessCheckout(RESOURCE_TYPE_BOOK));
        } else {
            promptMessage(MessageHelper.getMessageForFailedCheckout(RESOURCE_TYPE_BOOK));
        }
    }

    private void handleMovieCheckout() {
        String movieName = getInputFromUser("Please enter movie name: ");
        if (movieList.checkoutMovieByName(movieName)) {
            promptMessage(MessageHelper.getMessageForSuccessCheckout(RESOURCE_TYPE_MOVIE));
        } else {
            promptMessage(MessageHelper.getMessageForFailedCheckout(RESOURCE_TYPE_MOVIE));
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

        } else if (MenuOption.LIST_MOVIE.keyMatches(userOption)) {
            displayInformationWithHeader("Movie List:", movieList.getAvailableMovieListDetailsAsString());

        } else if (MenuOption.CHECKOUT_MOVIE.keyMatches(userOption)) {
            handleMovieCheckout();
        }

    }
}
