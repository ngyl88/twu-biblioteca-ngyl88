package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void shouldLoadBooksWhenConstructed() {
        BookList bookList = new BookList();
        assertTrue(bookList.getBooks().size() > 0);
    }

    @Test
    public void shouldBeAbleToReturnBookListAsString() {
        BookList bookList = new BookList();
        assertNotEquals(bookList.getAvailableBookListDetailsAsString(), "");
    }

    @Test
    public void shouldBeAbleToCheckoutBookByTitle() {
        BookList bookList = new BookList();
        Book firstBook = getFirstAvailableBook(bookList);

        bookList.checkoutBookByTitle(firstBook.getTitle());
        assertFalse(firstBook.isAvailable());
    }

    @Test
    public void shouldReturnTrueUponSuccessfulCheckout() {
        BookList bookList = new BookList();
        Book firstBook = getFirstAvailableBook(bookList);

        boolean success = bookList.checkoutBookByTitle(firstBook.getTitle());
        assertTrue(success);
    }

    @Test
    public void shouldReturnFalseUponUnsuccessfulCheckoutOfAnInvalidBook() {
        BookList bookList = new BookList();

        boolean success = bookList.checkoutBookByTitle("Some Invalid Book");
        assertFalse(success);
    }

    @Test
    public void shouldReturnFalseIfAttemptedToRepeatedlyCheckoutABook() {
        BookList bookList = new BookList();
        Book bookCheckedOut = generateCheckedOutBookFromBookList(bookList);

        boolean success = bookList.checkoutBookByTitle(bookCheckedOut.getTitle());
        assertFalse(success);
    }

    @Test
    public void shouldBeAbleToReturnBookByTitle() {
        BookList bookList = new BookList();
        Book bookCheckedOut = generateCheckedOutBookFromBookList(bookList);

        bookList.returnBook(bookCheckedOut.getTitle());
        assertTrue(bookCheckedOut.isAvailable());
    }

    @Test
    public void shouldReturnTrueUponSuccessfulReturn() {
        BookList bookList = new BookList();
        Book bookCheckedOut = generateCheckedOutBookFromBookList(bookList);

        boolean success = bookList.returnBook(bookCheckedOut.getTitle());
        assertTrue(success);
    }

    @Test
    public void shouldReturnFalseUponUnsuccessfulReturnOfAnInvalidBook() {
        BookList bookList = new BookList();

        boolean success = bookList.returnBook("Some Invalid Book");
        assertFalse(success);
    }

    @Test
    public void shouldReturnFalseIfAttemptedToRepeatedlyReturnABook() {
        BookList bookList = new BookList();
        Book bookCheckedOut = generateCheckedOutBookFromBookList(bookList);
        bookList.returnBook(bookCheckedOut.getTitle());

        boolean success = bookList.returnBook(bookCheckedOut.getTitle());
        assertFalse(success);
    }

    private Book generateCheckedOutBookFromBookList(BookList bookList) {
        Book firstBook = getFirstAvailableBook(bookList);

        bookList.checkoutBookByTitle(firstBook.getTitle());
        assertFalse(firstBook.isAvailable());

        return firstBook;
    }

    private Book getFirstAvailableBook(BookList bookList) {
        Book firstBook = bookList.getBooks().get(0);
        assertTrue(firstBook.isAvailable());

        return firstBook;
    }

}