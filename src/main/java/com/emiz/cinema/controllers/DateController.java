package com.emiz.cinema.controllers;

import com.emiz.cinema.models.DateSlot;
import com.emiz.cinema.services.DateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DateController {

    private DateService dateService;

    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/dates")
    public String getDates(Model model){
        model.addAttribute("dateSlots", dateService.getAllDates());
        return "views/dates/dates";
    }

    @GetMapping("dates/new")
    public String createDate(Model model){
        DateSlot dateSlot = new DateSlot();
        model.addAttribute("dateSlot",dateSlot);
        return "views/dates/create_date";
    }

    @PostMapping("/dates")
    public String storeDate(@ModelAttribute("dateSlot") DateSlot dateSlot){
        dateService.storeDate(dateSlot);
        return "redirect:/dates";
    }

    @GetMapping("/dates/{id}")
    public String deleteDateSlot(@PathVariable Long id){
        dateService.deleteDateSlot(id);
        return "redirect:/dates";
    }
}
