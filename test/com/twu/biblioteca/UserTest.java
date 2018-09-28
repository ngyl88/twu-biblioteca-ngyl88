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
        assertFalse(testUser.checkPassword(PASSWORD + "not matched"));
    }

    @Test
    public void shouldBeNullIfNotConstructedWithUserInformation() {
        User testUser = new User(LIBRARY_NUMBER, PASSWORD);
        assertNull(testUser.getName());
        assertNull(testUser.getEmail());
        assertNull(testUser.getPhoneNumber());
    }

    @Test
    public void shouldReturnCorrectName() {
        String testName = "name";

        User testUser = new User(LIBRARY_NUMBER, PASSWORD, testName, "", "");
        assertEquals(testName, testUser.getName());
    }

    @Test
    public void shouldReturnCorrectEmail() {
        String testEmail = "email";

        User testUser = new User(LIBRARY_NUMBER, PASSWORD, "", testEmail, "");
        assertEquals(testEmail, testUser.getEmail());
    }

    @Test
    public void shouldReturnCorrectPhoneNumber() {
        String testPhoneNumber = "+65 98887666";

        User testUser = new User(LIBRARY_NUMBER, PASSWORD, "", "", testPhoneNumber);
        assertEquals(testPhoneNumber, testUser.getPhoneNumber());
    }

    @Test
    public void shouldReturnUserInformationCorrectly() {

        String testName = "Test Name";
        String testEmail = "test@example.com";
        String testPhoneNumber = "+65 9999 8888";
        User testUser = new User(LIBRARY_NUMBER, PASSWORD, testName, testEmail, testPhoneNumber);

        StringBuilder expectedSB = new StringBuilder();
        expectedSB.append("- Name: " + testName);
        expectedSB.append("\t\t\tEmail: " + testEmail);
        expectedSB.append("\t\t\tPhone: " + testPhoneNumber);
        String expected = expectedSB.toString();

        assertEquals(expected, testUser.getUserInformationInString());
    }

}