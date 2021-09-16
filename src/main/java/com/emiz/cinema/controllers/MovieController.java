package com.emiz.cinema.controllers;

import com.emiz.cinema.models.Movie;
import com.emiz.cinema.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "views/movies/movies";
    }

    @GetMapping("/movies/new")
    public String createMovie(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "views/movies/create_movie";
    }

    @PostMapping("/movies")
    public String storeMovie(@ModelAttribute("movie") Movie movie) {
        movieService.storeMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/movies/edit/{id}")
    public String editMovie(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "views/movies/edit_movie";
    }

    @PostMapping("/movies/{id}")
    public String updateMovie(@PathVariable Long id, @ModelAttribute("movie") Movie movie, Model model) {
        Movie existingMovie = movieService.getMovieById(id);
        existingMovie.setTitle(movie.getTitle());
        if (movie.getDescription() != "") {
            existingMovie.setDescription(movie.getDescription());
        } else {
            existingMovie.setDescription(null);
        }

        if (movie.getYoutube() != "") {
            existingMovie.setYoutube(movie.getYoutube());
        } else {
            existingMovie.setYoutube(null);
        }

        existingMovie.setTmdbId(movie.getTmdbId());
        movieService.updateMovie(existingMovie);
        return "redirect:/movies";
    }

    @GetMapping("/movies/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}
