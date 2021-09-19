package com.emiz.cinema.services;

import com.emiz.cinema.models.Movie;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie storeMovie(Movie movie,MultipartFile imageFile) throws IOException;
    Movie updateMovie(Movie movie,MultipartFile imageFile) throws IOException;
    Movie getMovieById(Long id);
    void deleteMovie(Long id);
}
