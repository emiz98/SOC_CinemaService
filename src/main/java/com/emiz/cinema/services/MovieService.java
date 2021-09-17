package com.emiz.cinema.services;

import com.emiz.cinema.models.Movie;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie storeMovie(Movie movie);
    Movie updateMovie(Movie movie);
    Movie getMovieById(Long id);
    void deleteMovie(Long id);

    void saveImage(MultipartFile imageFile);
}
