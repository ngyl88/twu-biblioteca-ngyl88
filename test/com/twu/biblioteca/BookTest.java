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
        StringBuilder expected = new StringBuilder();
        expected.append("Title: " + TITLE);
        expected.append("\t\t\tAuthor: " + AUTHOR);
        expected.append("\t\t\tYear Published: " + YEAR);

        Book book = createBookForTest();
        assertEquals(book.getBookDetails(), expected);
    }

    private Book createBookForTest() {
        return new Book(TITLE, AUTHOR, YEAR);
    }

}