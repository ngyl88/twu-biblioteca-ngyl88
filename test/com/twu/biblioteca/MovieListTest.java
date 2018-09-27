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

    @Test
    public void stringRepresentationShouldContainAvailableMovie() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);

        assertTrue(movieList.getAvailableMovieListDetailsAsString().contains(firstMovie.getName()));
    }

    @Test
    public void shouldBeAbleToCheckoutMovieByName() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);

        movieList.checkoutMovieByName(firstMovie.getName());
        assertFalse(firstMovie.isAvailable());
    }

    @Test
    public void stringRepresentationShouldNotContainUnavailableMovie() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);
        movieList.checkoutMovieByName(firstMovie.getName());

        assertFalse(movieList.getAvailableMovieListDetailsAsString().contains(firstMovie.getName()));
    }

    @Test
    public void shouldReturnTrueUponSuccessfulCheckout() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);

        boolean success = movieList.checkoutMovieByName(firstMovie.getName());
        assertTrue(success);
    }

    @Test
    public void shouldReturnFalseUponUnsuccessfulCheckout() {
        MovieList movieList = new MovieList();

        boolean success = movieList.checkoutMovieByName("Invalid Movie Name");
        assertFalse(success);
    }

    @Test
    public void shouldReturnFalseWhenAttemptForConsecutiveCheckout() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);
        movieList.checkoutMovieByName(firstMovie.getName());

        boolean success = movieList.checkoutMovieByName(firstMovie.getName());
        assertFalse(success);
    }

    private Movie getFirstAvailableMovie(MovieList movieList) {
        Movie firstMovie = movieList.getMovies().get(0);
        assertTrue(firstMovie.isAvailable());

        return firstMovie;
    }

}