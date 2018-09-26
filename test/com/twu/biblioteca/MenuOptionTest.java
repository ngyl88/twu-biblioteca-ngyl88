package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuOptionTest {

    @Test
    public void shouldReturnTrueIfQuit() {
        assertTrue(MenuOption.isQuit("q"));
    }

    @Test
    public void shouldReturnFalseIfNotQuit() {
        assertFalse(MenuOption.isQuit("1"));
    }

    @Test
    public void shouldReturnTrueIfListBook() {
        assertTrue(MenuOption.isMeantForBooks("1"));
        assertTrue(MenuOption.isListBook("1"));
    }

    @Test
    public void shouldReturnFalseIfNotListBook() {
        assertFalse(MenuOption.isListBook("q"));
    }

    @Test
    public void shouldReturnTrueIfCheckoutBook() {
        assertTrue(MenuOption.isMeantForBooks("2"));
        assertTrue(MenuOption.isCheckoutBook("2"));
    }

    @Test
    public void shouldReturnFalseIfNotCheckoutBook() {
        assertFalse(MenuOption.isCheckoutBook("q"));
    }

    @Test
    public void shouldReturnTrueIfReturnBook() {
        assertTrue(MenuOption.isMeantForBooks("3"));
        assertTrue(MenuOption.isReturnBook("3"));
    }

    @Test
    public void shouldReturnFalseIfNotReturnBook() {
        assertFalse(MenuOption.isReturnBook("q"));
    }

    @Test
    public void shouldReturnFalseForOtherOptionThanBook() {
        assertFalse(MenuOption.isMeantForBooks("q"));
    }

}