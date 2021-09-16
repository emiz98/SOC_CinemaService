package com.emiz.cinema.services.impl;

import com.emiz.cinema.models.Movie;
import com.emiz.cinema.repos.MovieRepo;
import com.emiz.cinema.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepo movieRepo;

    public MovieServiceImpl(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Movie storeMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepo.findById(id).get();
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepo.deleteById(id);
    }
}
