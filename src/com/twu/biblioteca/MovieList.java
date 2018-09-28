package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieList extends AbstractResources {

    @Override
    public ArrayList<Movie> getResources() {
        return movies;
    }

    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieList() {
        movies.add(new Movie("Movie 1", 2008, "Director 1"));
        movies.add(new Movie("Movie 2", 2009, "Director 1"));
        movies.add(new Movie("Movie 3", 2010, "Director 2"));
    }
}
