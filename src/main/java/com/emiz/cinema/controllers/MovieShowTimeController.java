package com.emiz.cinema.controllers;

import com.emiz.cinema.models.MovieShowTime;
import com.emiz.cinema.services.DateService;
import com.emiz.cinema.services.MovieShowTimeService;
import com.emiz.cinema.services.TimeSlotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieShowTimeController {

    private MovieShowTimeService movieShowTimeService;
    private DateService dateService;
    private TimeSlotService timeSlotService;

    public MovieShowTimeController(MovieShowTimeService movieShowTimeService, DateService dateService, TimeSlotService timeSlotService) {
        this.movieShowTimeService = movieShowTimeService;
        this.dateService = dateService;
        this.timeSlotService = timeSlotService;
    }

    @GetMapping("/showT/{id}")
    public String getMovieShowTimes(@PathVariable Long id, Model model) {
        model.addAttribute("movieShowTimes", movieShowTimeService.getAllByMovieId(id));
        model.addAttribute("movieId", id);
        return "views/showT/showTimes";
    }

    @GetMapping("/showT/new/{id}")
    public String createShowTime(@PathVariable Long id, Model model) {
        MovieShowTime mdt = new MovieShowTime();
        model.addAttribute("mdt", mdt);
        model.addAttribute("movieId", id);
        model.addAttribute("dates", dateService.getAllDates());
        model.addAttribute("times", timeSlotService.getAllTimeSlots());
        return "views/showT/create";
    }

    @PostMapping("/showT")
    public String storeShowTime(@ModelAttribute("mdt") MovieShowTime mdt, Model model) {
        Integer size = movieShowTimeService.findDuplicateShowTimes(mdt.getDateSlot(), mdt.getTimeSlot()).size();
        if (size == 0) {
            movieShowTimeService.store(mdt);
        }
        return "redirect:/showT/" + mdt.getMovie().getId();
//        model.addAttribute("existingShowTimes", size);
//        return "views/showT/temp";
//        return "redirect:/showT/"+mdt.getMovie().getId();
    }

    @GetMapping("/showT/{movieId}/{id}")
    public String deleteShowTime(@PathVariable("movieId") Long movieId, @PathVariable("id") Long id) {
        movieShowTimeService.deleteShowTime(id);
        return "redirect:/showT/" + movieId;
    }
}
