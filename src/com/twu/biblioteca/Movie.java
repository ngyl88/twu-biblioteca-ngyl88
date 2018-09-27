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
    private Integer rating;

    public Movie(String name, int year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }
}
