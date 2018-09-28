package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList extends AbstractResources {

    @Override
    public ArrayList<Book> getResources() {
        return books;
    }

    private ArrayList<Book> books = new ArrayList<>();

    public BookList() {
        books.add(new Book("Book 1", "Author 1", 2008));
        books.add(new Book("Book 2", "Author 1", 2009));
        books.add(new Book("Book 3", "Author 2", 2010));
    }
}
