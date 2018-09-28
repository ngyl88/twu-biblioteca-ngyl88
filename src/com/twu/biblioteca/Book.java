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
        StringBuilder tempSB = new StringBuilder();
        tempSB.append("- Title: " + this.title);
        tempSB.append("\t\t\tAuthor: " + this.author);
        tempSB.append("\t\t\tYear Published: " + this.yearPublished);

        return tempSB.toString();
    }

    @Override
    public String getIdentifier() {
        return this.title;
    }
}
