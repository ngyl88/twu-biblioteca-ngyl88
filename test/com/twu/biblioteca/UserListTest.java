package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserListTest {
    private final String LIBRARY_NUMBER = "001-2018";
    private final String PASSWORD = "pass1234";

    @Test
    public void shouldLoadedWithUsersWhenConstructed() {
        UserList userList = new UserList();
        assertTrue(userList.getSize() > 0);
    }

    @Test
    public void shouldReturnTrueIfCredentialsMatched() {
        UserList userList = new UserList();
        assertTrue(userList.checkLoginCredentials(LIBRARY_NUMBER, PASSWORD));
    }

    @Test
    public void shouldReturnFalseIfLibraryNumberNotExisting() {
        UserList userList = new UserList();
        assertFalse(userList.checkLoginCredentials("random", PASSWORD));
    }

    @Test
    public void shouldReturnFalseIfPasswordNotMatching() {
        UserList userList = new UserList();
        assertFalse(userList.checkLoginCredentials(LIBRARY_NUMBER, "random"));
    }

    @Test
    public void shouldReturnUserByValidLibraryNumber() {
        UserList userList = new UserList();
        assertNotNull(userList.getUserByLibraryNumber(LIBRARY_NUMBER));
    }

}