package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieListTest {

    @Test
    public void shouldLoadMoviesWhenConstructed() {
        MovieList movieList = new MovieList();
        assertTrue(movieList.getResources().size() > 0);
    }

    @Test
    public void stringRepresentationReturnedForMovieListShouldNotBeEmptyString() {
        MovieList movieList = new MovieList();
        assertNotEquals(movieList.getAvailableResourcesInDescriptiveString(), "");
    }

    @Test
    public void stringRepresentationShouldContainAvailableMovie() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);

        assertTrue(movieList.getAvailableResourcesInDescriptiveString().contains(firstMovie.getName()));
    }

    @Test
    public void shouldBeAbleToCheckoutMovieByName() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);

        movieList.checkout(firstMovie.getName(), "");
        assertFalse(firstMovie.isAvailable());
    }

    @Test
    public void stringRepresentationShouldNotContainUnavailableMovie() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);
        movieList.checkout(firstMovie.getName(), "");

        assertFalse(movieList.getAvailableResourcesInDescriptiveString().contains(firstMovie.getName()));
    }

    @Test
    public void shouldReturnTrueUponSuccessfulCheckout() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);

        boolean success = movieList.checkout(firstMovie.getName(), "");
        assertTrue(success);
    }

    @Test
    public void shouldReturnFalseUponUnsuccessfulCheckout() {
        MovieList movieList = new MovieList();

        boolean success = movieList.checkout("Invalid Movie Name", "");
        assertFalse(success);
    }

    @Test
    public void shouldReturnFalseWhenAttemptForConsecutiveCheckout() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);
        movieList.checkout(firstMovie.getName(), "");

        boolean success = movieList.checkout(firstMovie.getName(), "");
        assertFalse(success);
    }

    @Test
    public void checkoutMovieShouldHaveCorrectCheckoutTo() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);

        firstMovie.checkout("abc-2018");
        assertEquals("abc-2018", firstMovie.getCheckoutTo());
    }

    @Test
    public void newMovieShouldHaveNullAsCheckoutTo() {
        MovieList movieList = new MovieList();
        Movie firstMovie = getFirstAvailableMovie(movieList);

        assertNull(firstMovie.getCheckoutTo());
    }

    private Movie getFirstAvailableMovie(MovieList movieList) {
        Movie firstMovie = movieList.getResources().get(0);
        assertTrue(firstMovie.isAvailable());

        return firstMovie;
    }

}