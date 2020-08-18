package com.comdis.catalogd.models;

public class Movie {
    private String movies;
    private String name;

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie(String movies, String name) {
        this.movies = movies;
        this.name = name;
    }

    public Movie() {
    }
    
}