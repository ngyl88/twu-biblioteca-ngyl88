package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldCreateNewBook() {
        String title = "testBook";
        String author = "test Author";
        int yearPublished = 2008;

        assertNotNull(new Book(title, author, yearPublished));
    }

}