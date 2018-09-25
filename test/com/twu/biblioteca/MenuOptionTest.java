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
        assertTrue(MenuOption.isListBook("1"));
    }

    @Test
    public void shouldReturnFalseIfListBook() {
        assertFalse(MenuOption.isListBook("q"));
    }

}