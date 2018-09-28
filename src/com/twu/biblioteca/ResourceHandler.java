package com.twu.biblioteca;

import static com.twu.biblioteca.DisplayUtils.displayInformationWithHeader;
import static com.twu.biblioteca.DisplayUtils.promptMessage;
import static com.twu.biblioteca.InputUtils.getInputFromUser;

public class ResourceHandler {

    private static String RESOURCE_TYPE_BOOK = "book";
    private static String RESOURCE_TYPE_MOVIE = "movie";

    private final BookList bookList = new BookList();
    private final MovieList movieList = new MovieList();

    // TODO: how to reduce duplication ?
    private void handleBookReturn() {
        String bookTitle = getInputFromUser("Please enter book title: ");
        if (bookList.returnResource(bookTitle)) {
            promptMessage(MessageHelper.getMessageForSuccessBookReturn());
        } else {
            promptMessage(MessageHelper.getMessageForFailedBookReturn());
        }
    }

    private void handleBookCheckout(String userLibraryNumber) {
        String bookTitle = getInputFromUser("Please enter book title: ");
        if (bookList.checkout(bookTitle, userLibraryNumber)) {
            promptMessage(MessageHelper.getMessageForSuccessCheckout(RESOURCE_TYPE_BOOK));
        } else {
            promptMessage(MessageHelper.getMessageForFailedCheckout(RESOURCE_TYPE_BOOK));
        }
    }

    private void handleMovieCheckout(String userLibraryNumber) {
        String movieName = getInputFromUser("Please enter movie name: ");
        if (movieList.checkout(movieName, userLibraryNumber)) {
            promptMessage(MessageHelper.getMessageForSuccessCheckout(RESOURCE_TYPE_MOVIE));
        } else {
            promptMessage(MessageHelper.getMessageForFailedCheckout(RESOURCE_TYPE_MOVIE));
        }
    }

    // TODO: UNIT TEST NOT CREATED (support main)
    public void handleUserOption(String userOption, String userLibraryNumber) {

        if (MenuOption.LIST_BOOK.keyMatches(userOption)) {
            displayInformationWithHeader("Book List:", bookList.getAvailableResourcesInDescriptiveString());

        } else if (MenuOption.CHECKOUT_BOOK.keyMatches(userOption)) {
            handleBookCheckout(userLibraryNumber);

        } else if (MenuOption.RETURN_BOOK.keyMatches(userOption)) {
            handleBookReturn();

        } else if (MenuOption.LIST_MOVIE.keyMatches(userOption)) {
            displayInformationWithHeader("Movie List:", movieList.getAvailableResourcesInDescriptiveString());

        } else if (MenuOption.CHECKOUT_MOVIE.keyMatches(userOption)) {
            handleMovieCheckout(userLibraryNumber);
        }

    }
}
