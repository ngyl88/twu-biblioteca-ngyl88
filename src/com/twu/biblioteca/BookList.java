package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> books = new ArrayList<Book>();

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
            sb.append(book.getBookDetails());
            sb.append(System.lineSeparator());
        }
        sb.append(System.lineSeparator());

        return sb.toString();
    }
}
