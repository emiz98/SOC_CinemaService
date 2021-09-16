package com.emiz.cinema.controllers;

import com.emiz.cinema.services.MovieDTService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MovieDTController {

    private MovieDTService movieDTService;

    public MovieDTController(MovieDTService movieDTService) {
        this.movieDTService = movieDTService;
    }

    @GetMapping("/showTimes/{id}")
    public String getMovieShowTimes(@PathVariable("id") Long id, Model model){
        model.addAttribute("movieShowTimes",movieDTService.getDTByMovieId(id));
    return "views/showTimes/showTimes";
    }
}
