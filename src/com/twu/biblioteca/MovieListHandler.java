package com.twu.biblioteca;

import static com.twu.biblioteca.DisplayUtils.displayInformationWithHeader;

public class MovieListHandler {
    private final MovieList movieList = new MovieList();

    // TODO: UNIT TEST NOT CREATED (support main)
    public void handleUserOption(String userOption) {
        if (MenuOption.LIST_MOVIE.keyMatches(userOption)) {
            displayInformationWithHeader("Movie List:", movieList.getAvailableMovieListDetailsAsString());
        }
    }
}
