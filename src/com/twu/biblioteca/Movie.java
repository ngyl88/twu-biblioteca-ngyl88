package com.twu.biblioteca;

public class Movie {

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public boolean isAvailable() {
        return available;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        if (rating > 0 && rating <=10) {
            this.rating = rating;
        }
    }

    private final String name;
    private final int year;
    private final String director;
    private boolean available = true;
    private Integer rating;

    public Movie(String name, int year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }

    public String getDetailsAsString() {
        String ratingAsString = this.rating == null ? "unrated" : this.rating.toString();

        StringBuilder sb = new StringBuilder();
        sb.append("- Name: " + this.name);
        sb.append("\t\t\tYear: " + this.year);
        sb.append("\t\t\tDirector: " + this.director);
        sb.append("\t\t\tRating: " + ratingAsString);

        return sb.toString();
    }

    public void checkout() {
        this.available = false;
    }
}
