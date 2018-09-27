package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieList {

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieList() {
        movies.add(new Movie("Movie 1", 2008, "Director 1"));
        movies.add(new Movie("Movie 2", 2009, "Director 1"));
        movies.add(new Movie("Movie 3", 2010, "Director 2"));
    }

    public String getAvailableMovieListDetailsAsString() {
        StringBuilder sb = new StringBuilder();
        for (Movie movie : movies) {
            if (movie.isAvailable()) {
                sb.append(movie.getDetailsAsString());
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
