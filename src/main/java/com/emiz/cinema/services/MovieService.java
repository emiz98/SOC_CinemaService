package com.emiz.cinema.services;

import com.emiz.cinema.models.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie storeMovie(Movie movie);
    Movie updateMovie(Movie movie);
    Movie getMovieById(Long id);
    void deleteMovie(Long id);
}
