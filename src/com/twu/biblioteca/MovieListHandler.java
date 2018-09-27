package com.twu.biblioteca;

import static com.twu.biblioteca.DisplayUtils.displayInformationWithHeader;
import static com.twu.biblioteca.DisplayUtils.promptMessage;
import static com.twu.biblioteca.InputUtils.getInputFromUser;

public class MovieListHandler {
    private final MovieList movieList = new MovieList();

    private void handleMovieCheckout() {
        String movieName = getInputFromUser("Please enter movie name: ");
        if (movieList.checkoutMovieByName(movieName)) {
            promptMessage(MessageHelper.getMessageForSuccessCheckout("movie"));
        } else {
            promptMessage(MessageHelper.getMessageForFailedCheckout("movie"));
        }
    }

    // TODO: UNIT TEST NOT CREATED (support main)
    public void handleUserOption(String userOption) {
        if (MenuOption.LIST_MOVIE.keyMatches(userOption)) {
            displayInformationWithHeader("Movie List:", movieList.getAvailableMovieListDetailsAsString());
        } else if (MenuOption.CHECKOUT_MOVIE.keyMatches(userOption)) {
            handleMovieCheckout();
        }
    }
}
