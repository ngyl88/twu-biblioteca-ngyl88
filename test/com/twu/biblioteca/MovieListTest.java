package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieListTest {

    @Test
    public void shouldLoadMoviesWhenConstructed() {
        MovieList movieList = new MovieList();
        assertTrue(movieList.getMovies().size() > 0);
    }

    @Test
    public void stringRepresentationReturnedForMovieListShouldNotBeEmptyString() {
        MovieList movieList = new MovieList();
        assertNotEquals(movieList.getAvailableMovieListDetailsAsString(), "");
    }

    // TODO: To update when a movie can be not available
    @Test
    public void stringRepresentationShouldNotContainUnavailableMovie() {
        MovieList movieList = new MovieList();
        assertFalse(movieList.getAvailableMovieListDetailsAsString().contains("TO UPDATE THIS TEST"));
    }

}