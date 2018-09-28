package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserManagerTest {

    private static String VALID_LIBRARY_NUMBER = "001-2018";
    private static String VALID_PASSWORD = "pass1234";

    private static String INVALID_LIBRARY_NUMBER = "xxx-2018";
    private static String INVALID_PASSWORD = "xxx-2018";

    @Test
    public void shouldMarkedLoggedInAsTrueIfLoginWithValidCredentials() {
        UserManager manager = new UserManager();
        manager.login(VALID_LIBRARY_NUMBER, VALID_PASSWORD);
        assertTrue(manager.getLoginStatus());
    }

    @Test
    public void shouldMarkedLoggedInAsFalseIfLoginWithInvalidLibraryNumber() {
        UserManager manager = new UserManager();
        manager.login(INVALID_LIBRARY_NUMBER, VALID_PASSWORD);
        assertFalse(manager.getLoginStatus());
    }

    @Test
    public void shouldMarkedLoggedInAsFalseIfLoginWithInvalidPassword() {
        UserManager manager = new UserManager();
        manager.login(VALID_LIBRARY_NUMBER, INVALID_PASSWORD);
        assertFalse(manager.getLoginStatus());
    }

    @Test
    public void currentUserShouldBeCorrectIfLoginSuccess() {
        UserManager manager = new UserManager();
        manager.login(VALID_LIBRARY_NUMBER, VALID_PASSWORD);
        assertEquals(VALID_LIBRARY_NUMBER, manager.getCurrentUserLibraryNumber());
    }

    @Test
    public void currentUserShouldBeNullIfLoginFailed() {
        UserManager manager = new UserManager();
        manager.login(VALID_LIBRARY_NUMBER, INVALID_PASSWORD);
        assertNull(manager.getCurrentUserLibraryNumber());
    }

    @Test
    public void getUserInformationShouldBeDefinedIfLogin() {
        UserManager manager = new UserManager();
        manager.login(VALID_LIBRARY_NUMBER, VALID_PASSWORD);
        assertNotNull(manager.getCurrentUserInformation());
    }

    @Test
    public void getUserInformationShouldBeEmptyStringIfNotLogin() {
        UserManager manager = new UserManager();
        assertEquals("", manager.getCurrentUserInformation());
    }

}