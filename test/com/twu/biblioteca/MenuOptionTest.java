package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.MenuOption.*;
import static org.junit.Assert.*;

public class MenuOptionTest {

    @Test
    public void shouldReturnTrueIfQuit() {
        assertTrue(QUIT.keyMatches("q"));
    }

    @Test
    public void shouldReturnFalseIfNotQuit() {
        assertFalse(QUIT.keyMatches("1"));
    }

    @Test
    public void shouldReturnTrueIfListBook() {
        assertTrue(isMeantForBooks("1"));
        assertTrue(LIST_BOOK.keyMatches("1"));
    }

    @Test
    public void shouldReturnFalseIfNotListBook() {
        assertFalse(LIST_BOOK.keyMatches("q"));
    }

    @Test
    public void shouldReturnTrueIfCheckoutBook() {
        assertTrue(isMeantForBooks("2"));
        assertTrue(CHECKOUT_BOOK.keyMatches("2"));
    }

    @Test
    public void shouldReturnFalseIfNotCheckoutBook() {
        assertFalse(CHECKOUT_BOOK.keyMatches("q"));
    }

    @Test
    public void shouldReturnTrueIfReturnBook() {
        assertTrue(isMeantForBooks("3"));
        assertTrue(RETURN_BOOK.keyMatches("3"));
    }

    @Test
    public void shouldReturnFalseIfNotReturnBook() {
        assertFalse(RETURN_BOOK.keyMatches("q"));
    }

    @Test
    public void shouldReturnFalseForOtherOptionThanBook() {
        assertFalse(isMeantForBooks("q"));
    }

    @Test
    public void shouldReturnTrueIfListMovie() {
        assertTrue(LIST_MOVIE.keyMatches("4"));
    }

    @Test
    public void shouldReturnFalseIfNotListMovie() {
        assertFalse(LIST_MOVIE.keyMatches("q"));
    }

}