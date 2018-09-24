package com.twu.biblioteca;

public class Book {

    private final String title;
    private final String author;
    private final int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getBookDetails() {
        StringBuilder expectedSB = new StringBuilder();
        expectedSB.append("Title: " + this.title);
        expectedSB.append("\t\t\tAuthor: " + this.author);
        expectedSB.append("\t\t\tYear Published: " + this.yearPublished);

        return expectedSB.toString();
    }
}
