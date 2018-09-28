package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private static final String LIBRARY_NUMBER = "001-2018";
    private static final String PASSWORD = "password";

    @Test
    public void shouldCreateNewUserWithLibraryNumberAndPassword() {
        User testUser = new User(LIBRARY_NUMBER, PASSWORD);
        assertEquals(LIBRARY_NUMBER, testUser.getLibraryNumber());
    }

    @Test
    public void shouldReturnTrueIfPasswordMatched() {
        User testUser = new User(LIBRARY_NUMBER, PASSWORD);
        assertTrue(testUser.checkPassword(PASSWORD));
    }

    @Test
    public void shouldReturnFalseIfPasswordUnmatched() {
        User testUser = new User(LIBRARY_NUMBER, PASSWORD);
        assertFalse(testUser.checkPassword(PASSWORD + "notmatched"));
    }

}