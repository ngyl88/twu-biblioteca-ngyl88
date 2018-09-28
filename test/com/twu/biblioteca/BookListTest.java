package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void shouldLoadBooksWhenConstructed() {
        BookList bookList = new BookList();
        assertTrue(bookList.getResources().size() > 0);
    }

    @Test
    public void shouldBeAbleToReturnBookListAsString() {
        BookList bookList = new BookList();
        assertNotEquals(bookList.getAvailableResourcesInDescriptiveString(), "");
    }

    @Test
    public void shouldBeAbleToCheckoutBookByTitle() {
        BookList bookList = new BookList();
        Book firstBook = getFirstAvailableBook(bookList);

        bookList.checkout(firstBook.getTitle(), "");
        assertFalse(firstBook.isAvailable());
    }

    @Test
    public void stringRepresentationShouldNotContainUnavailableBook() {
        BookList bookList = new BookList();
        Book bookCheckedOut = generateCheckedOutBookFromBookList(bookList);
        assertFalse(bookList.getAvailableResourcesInDescriptiveString().contains(bookCheckedOut.getTitle()));
    }

    @Test
    public void shouldReturnTrueUponSuccessfulCheckout() {
        BookList bookList = new BookList();
        Book firstBook = getFirstAvailableBook(bookList);

        boolean success = bookList.checkout(firstBook.getTitle(), "");
        assertTrue(success);
    }

    @Test
    public void shouldReturnFalseUponUnsuccessfulCheckoutOfAnInvalidBook() {
        BookList bookList = new BookList();

        boolean success = bookList.checkout("Some Invalid Book", "");
        assertFalse(success);
    }

    @Test
    public void shouldReturnFalseIfAttemptedToRepeatedlyCheckoutABook() {
        BookList bookList = new BookList();
        Book bookCheckedOut = generateCheckedOutBookFromBookList(bookList);

        boolean success = bookList.checkout(bookCheckedOut.getTitle(), "");
        assertFalse(success);
    }

    @Test
    public void shouldBeAbleToReturnBookByTitle() {
        BookList bookList = new BookList();
        Book bookCheckedOut = generateCheckedOutBookFromBookList(bookList);

        bookList.returnResource(bookCheckedOut.getTitle());
        assertTrue(bookCheckedOut.isAvailable());
    }

    @Test
    public void shouldReturnTrueUponSuccessfulReturn() {
        BookList bookList = new BookList();
        Book bookCheckedOut = generateCheckedOutBookFromBookList(bookList);

        boolean success = bookList.returnResource(bookCheckedOut.getTitle());
        assertTrue(success);
    }

    @Test
    public void shouldReturnFalseUponUnsuccessfulReturnOfAnInvalidBook() {
        BookList bookList = new BookList();

        boolean success = bookList.returnResource("Some Invalid Book");
        assertFalse(success);
    }

    @Test
    public void shouldReturnFalseIfAttemptedToRepeatedlyReturnABook() {
        BookList bookList = new BookList();
        Book bookCheckedOut = generateCheckedOutBookFromBookList(bookList);
        bookList.returnResource(bookCheckedOut.getTitle());

        boolean success = bookList.returnResource(bookCheckedOut.getTitle());
        assertFalse(success);
    }

    private Book generateCheckedOutBookFromBookList(BookList bookList) {
        Book firstBook = getFirstAvailableBook(bookList);

        bookList.checkout(firstBook.getTitle(), "");
        assertFalse(firstBook.isAvailable());

        return firstBook;
    }

    private Book getFirstAvailableBook(BookList bookList) {
        Book firstBook = bookList.getResources().get(0);
        assertTrue(firstBook.isAvailable());

        return firstBook;
    }

}