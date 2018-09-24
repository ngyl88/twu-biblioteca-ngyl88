package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void shouldBeCreatedWithEmptyBookList() {
        assertTrue(new BookList().getBooks().size() == 0);
    }

    @Test
    public void shouldLoadPreExistingBook() {
        BookList bookList = new BookList();
        bookList.initialize();
        assertTrue("No book loaded",bookList.getBooks().size() > 0);
    }

}