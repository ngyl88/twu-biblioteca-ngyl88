package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private static final String NAME = "Movie Name for Testing";
    private static final String DIRECTOR = "Anonymous";
    private static final int YEAR = 2008;

    @Test
    public void shouldCreateNewMovieWithNameYearDirector() {
        assertNotNull(new Movie(NAME, YEAR, DIRECTOR));
    }

    @Test
    public void newMovieShouldHaveCorrectName() {
        Movie movie = new Movie(NAME, YEAR, DIRECTOR);
        assertEquals(NAME, movie.getName());
    }

    @Test
    public void newMovieShouldHaveCorrectYear() {
        Movie movie = new Movie(NAME, YEAR, DIRECTOR);
        assertEquals(YEAR, movie.getYear());
    }

    @Test
    public void newMovieShouldHaveCorrectDirector() {
        Movie movie = new Movie(NAME, YEAR, DIRECTOR);
        assertEquals(DIRECTOR, movie.getDirector());
    }

    @Test
    public void newMovieShouldBeAvailable() {
        Movie movie = new Movie(NAME, YEAR, DIRECTOR);
        assertTrue(movie.isAvailable());
    }

    @Test
    public void newMovieShouldHaveRatingUnrated() {
        Movie movie = new Movie(NAME, YEAR, DIRECTOR);
        assertNull(movie.getRating());
    }

    @Test
    public void shouldBeAbleToSetMovieRatingTo1() {
        Movie movie = new Movie(NAME, YEAR, DIRECTOR);
        movie.setRating(1);
        assertTrue(movie.getRating() == 1);
    }

    @Test
    public void shouldNotBeAbleToSetMovieRatingTo0() {
        Movie movie = new Movie(NAME, YEAR, DIRECTOR);
        movie.setRating(0);
        assertNull(movie.getRating());
    }

    @Test
    public void shouldNotBeAbleToSetMovieRatingTo11() {
        Movie movie = new Movie(NAME, YEAR, DIRECTOR);
        movie.setRating(11);
        assertNull(movie.getRating());
    }

    @Test
    public void shouldReturnNewMovieDetailsWithUnratedRatingAsString() {
        Movie movie = new Movie(NAME, YEAR, DIRECTOR);
        String expected = getDescriptiveStringWithRating("unrated");

        assertEquals(expected, movie.getDetailsAsString());
    }

    @Test
    public void shouldReturnMovieDetailsWithCorrectRatingAsString() {
        Movie movie = new Movie(NAME, YEAR, DIRECTOR);
        movie.setRating(2);
        String expected = getDescriptiveStringWithRating("2");

        assertEquals(expected, movie.getDetailsAsString());
    }

    private String getDescriptiveStringWithRating(String rating) {
        StringBuilder expectedSB = new StringBuilder();
        expectedSB.append("- Name: " + NAME);
        expectedSB.append("\t\t\tYear: " + YEAR);
        expectedSB.append("\t\t\tDirector: " + DIRECTOR);
        expectedSB.append("\t\t\tRating: " + rating);
        return expectedSB.toString();
    }

    @Test
    public void checkoutMovieShouldNotBeAvailable() {
        Movie movie = new Movie(NAME, YEAR, DIRECTOR);
        movie.checkout("");
        assertFalse(movie.isAvailable());
    }
}
