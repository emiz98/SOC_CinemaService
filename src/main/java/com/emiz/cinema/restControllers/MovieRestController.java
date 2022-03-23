package com.emiz.cinema.restControllers;

import com.emiz.cinema.models.Movie;
import com.emiz.cinema.models.MovieShowTime;
import com.emiz.cinema.services.MovieService;
import com.emiz.cinema.services.MovieShowTimeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/")
public class MovieRestController {

    private MovieService movieService;
    private MovieShowTimeService movieShowTimeService;

    public MovieRestController(MovieService movieService, MovieShowTimeService movieShowTimeService) {
        this.movieService = movieService;
        this.movieShowTimeService = movieShowTimeService;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieDetails(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/showTimes/{id}")
    public List<MovieShowTime> getMovieShowTimes(@PathVariable Long id) {
        return movieShowTimeService.getAllByMovieId(id);
    }

    @PostMapping("/showTimes")
    public MovieShowTime updateSeats(@RequestBody MovieShowTime movieShowTime) {
        MovieShowTime existingShowTime = movieShowTimeService.getShowTimeById(movieShowTime.getId());
        existingShowTime.setSeats(movieShowTime.getSeats());
        movieShowTimeService.store(existingShowTime);
        return existingShowTime;
    }
}
