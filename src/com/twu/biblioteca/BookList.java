package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void initialize() {
        books.add(new Book("Book 1", "Author 1", 2008));
        books.add(new Book("Book 2", "Author 1", 2009));
        books.add(new Book("Book 3", "Author 2", 2010));
    }

    public String getBookListDetailsAsString() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            if (book.isAvailable()) {
                sb.append(book.getBookDetails());
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public boolean checkoutBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isAvailable()) {
                book.checkout();
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && !book.isAvailable()) {
                book.returned();
                return true;
            }
        }
        return false;
    }
}
