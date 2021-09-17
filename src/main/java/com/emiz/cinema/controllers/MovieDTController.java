package com.emiz.cinema.controllers;

import com.emiz.cinema.models.MovieDateTime;
import com.emiz.cinema.services.DateService;
import com.emiz.cinema.services.MovieDTService;
import com.emiz.cinema.services.TimeSlotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieDTController {

    private MovieDTService movieDTService;
    private DateService dateService;
    private TimeSlotService timeSlotService;

    public MovieDTController(MovieDTService movieDTService, DateService dateService, TimeSlotService timeSlotService) {
        this.movieDTService = movieDTService;
        this.dateService = dateService;
        this.timeSlotService = timeSlotService;
    }

    @GetMapping("/showTimes/{id}")
    public String getMovieShowTimes(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movieShowTimes", movieDTService.getDTByMovieId(id));
        model.addAttribute("movieId", id);
        return "views/showTimes/showTimes";
    }

    @GetMapping("/showTimes/new/{id}")
    public String createShowTime(@PathVariable("id") Long id, Model model) {
        MovieDateTime mdt = new MovieDateTime();
        model.addAttribute("mdt", mdt);
        model.addAttribute("movieId", id);
        model.addAttribute("dates", dateService.getAllDates());
        model.addAttribute("times", timeSlotService.getAllTimeSlots());
        return "views/showTimes/create_showTimes";
    }

    @PostMapping("/showTimes")
    public String storeShowDT(@ModelAttribute("mdt") MovieDateTime mdt) {
        movieDTService.storeMDT(mdt);
        return "redirect:/showTimes/"+mdt.getMovieId();
    }

    @GetMapping("/showTimes/{movieId}/{id}")
    public String deleteShowDT(@PathVariable("movieId") Long movieId, @PathVariable("id") Long id){
        movieDTService.deleteShowDT(id);
        return "redirect:/showTimes/"+movieId;
    }
}
