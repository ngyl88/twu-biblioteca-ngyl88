package com.twu.biblioteca;

public class Book extends AbstractResource {

    public String getTitle() {
        return title;
    }

    private final String title;
    private final String author;
    private final int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String getDetailsAsString() {
        StringBuilder expectedSB = new StringBuilder();
        expectedSB.append("- Title: " + this.title);
        expectedSB.append("\t\t\tAuthor: " + this.author);
        expectedSB.append("\t\t\tYear Published: " + this.yearPublished);

        return expectedSB.toString();
    }

    @Override
    public String getIdentifier() {
        return this.title;
    }
}
