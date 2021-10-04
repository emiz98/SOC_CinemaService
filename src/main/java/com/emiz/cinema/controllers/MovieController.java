package com.emiz.cinema.controllers;

import com.emiz.cinema.models.Movie;
import com.emiz.cinema.services.BannerService;
import com.emiz.cinema.services.FoodService;
import com.emiz.cinema.services.MovieService;
import com.emiz.cinema.services.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MovieController {

    private MovieService movieService;
    private TicketService ticketService;
    private FoodService foodService;
    private BannerService bannerService;

    public MovieController(MovieService movieService, TicketService ticketService, FoodService foodService, BannerService bannerService) {
        this.movieService = movieService;
        this.ticketService = ticketService;
        this.foodService = foodService;
        this.bannerService = bannerService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("movieCount",movieService.getAllMovies().size());
        model.addAttribute("ticketCount",ticketService.getAllTickets().size());
        model.addAttribute("foodCount",foodService.getAllFood().size());
        model.addAttribute("bannerCount",bannerService.getAllBanners().size());
        return "index";
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

//        final String uri = "https://api.themoviedb.org/3/search/movie?api_key=2d993593c6f4bc11d6feb87b34548c0b&query=DUNE";
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(uri, String.class);
//        model.addAttribute("apis",response);

        return "views/movies/create_movie";
    }

    @PostMapping("/movies")
    public String storeMovie(@ModelAttribute("movie") Movie movie, @RequestParam("imageFile") MultipartFile imageFile) {
        try {
            movieService.storeMovie(movie, imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/movies";
    }

    @GetMapping("/movies/edit/{id}")
    public String editMovie(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "views/movies/edit_movie";
    }

    @PostMapping("/movies/{id}")
    public String updateMovie(@PathVariable Long id, @ModelAttribute("movie") Movie movie, @RequestParam("imageFile") MultipartFile imageFile, Model model) {
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

        try {
            movieService.updateMovie(existingMovie, imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/movies";
    }

    @GetMapping("/movies/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}
