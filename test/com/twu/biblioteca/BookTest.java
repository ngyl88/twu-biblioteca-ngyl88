package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private static final String TITLE = "Book Title for Testing";
    private static final String AUTHOR = "Test Author";
    private static final int YEAR = 2008;

    @Test
    public void shouldCreateNewBook() {
        assertNotNull(new Book(TITLE, AUTHOR, YEAR));
    }

    @Test
    public void shouldReturnBookDetailsAsString() {
        StringBuilder expectedSB = new StringBuilder();
        expectedSB.append("- Title: " + TITLE);
        expectedSB.append("\t\t\tAuthor: " + AUTHOR);
        expectedSB.append("\t\t\tYear Published: " + YEAR);
        String expected = expectedSB.toString();

        Book book = createBookForTest();
        assertEquals(book.getBookDetails(), expected);
    }

    @Test
    public void newBookShouldBeAvailable() {
        Book book = createBookForTest();
        assertTrue(book.isAvailable());
    }

    @Test
    public void checkoutBookShouldNotBeAvailable() {
        Book book = createBookForTest();
        book.checkout();
        assertFalse(book.isAvailable());
    }

    @Test
    public void returnedBookShouldBeAvailable() {
        Book book = createBookForTest();
        book.checkout();

        book.returned();
        assertTrue(book.isAvailable());
    }

    private Book createBookForTest() {
        return new Book(TITLE, AUTHOR, YEAR);
    }

}