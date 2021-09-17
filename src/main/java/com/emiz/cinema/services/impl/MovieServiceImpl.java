package com.emiz.cinema.services.impl;

import com.emiz.cinema.models.Movie;
import com.emiz.cinema.repos.MovieRepo;
import com.emiz.cinema.services.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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
    public Movie storeMovie(Movie movie,MultipartFile imageFile) throws IOException {
        String folder = "src/main/resources/static/assets/images/";
        String filename = UUID.randomUUID().toString();
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + filename+".jpg");
        Files.write(path,bytes);
        movie.setPoster_path(filename+".jpg");
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
        Movie movie = movieRepo.findById(id).get();
        String imageName = movie.getPoster_path();
        File fileToDelete = new File("src/main/resources/static/assets/images/"+imageName);
        fileToDelete.delete();
        movieRepo.deleteById(id);
    }
}
