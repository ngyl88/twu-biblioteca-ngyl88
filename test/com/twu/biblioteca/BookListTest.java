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
        BookList bookList = createAndInitializeBookList();
        assertTrue("No book loaded",bookList.getBooks().size() > 0);
    }

    @Test
    public void shouldBeAbleToReturnBookListAsString() {
        BookList bookList = createAndInitializeBookList();
        assertNotEquals(bookList.getBookListDetailsAsString(), "");
    }

    @Test
    public void shouldBeAbleToCheckoutBookByTitle() {
        BookList bookList = createAndInitializeBookList();
        Book firstBook = getFirstAvailableBook(bookList);

        bookList.checkoutBookByTitle(firstBook.getTitle());
        assertFalse(firstBook.isAvailable());
    }

    @Test
    public void shouldReturnTrueUponSuccessfulCheckout() {
        BookList bookList = createAndInitializeBookList();
        Book firstBook = getFirstAvailableBook(bookList);

        boolean success = bookList.checkoutBookByTitle(firstBook.getTitle());
        assertTrue(success);
    }

    private Book getFirstAvailableBook(BookList bookList) {
        Book firstBook = bookList.getBooks().get(0);
        assertTrue(firstBook.isAvailable());

        return firstBook;
    }

    private BookList createAndInitializeBookList() {
        BookList bookList = new BookList();
        bookList.initialize();
        return bookList;
    }

}