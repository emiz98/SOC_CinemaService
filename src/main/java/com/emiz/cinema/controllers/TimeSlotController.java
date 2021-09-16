package com.emiz.cinema.controllers;

import com.emiz.cinema.models.TimeSlot;
import com.emiz.cinema.services.TimeSlotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TimeSlotController {

    private TimeSlotService timeSlotService;

    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    @GetMapping("/timeSlots")
    public String getTimeSlots(Model model) {
        model.addAttribute("timeSlots", timeSlotService.getAllTimeSlots());
        return "views/timeSlots/timeSlots";
    }

    @GetMapping("/timeSlots/new")
    public String createTimeSlot(Model model) {
        TimeSlot timeSlot = new TimeSlot();
        model.addAttribute("timeSlot", timeSlot);
        return "views/timeSlots/create_timeslot";
    }

    @PostMapping("/timeSlots")
    public String storeTimeSlot(@ModelAttribute("timeSlot") TimeSlot timeSlot) {
        timeSlotService.storeTimeSlot(timeSlot);
        return "redirect:/timeSlots";
    }

    @GetMapping("/timeSlots/edit/{id}")
    public String editTimeSlot(@PathVariable("id") Long id, Model model) {
        model.addAttribute("timeSlot", timeSlotService.getTimeSlotById(id));
        return "views/timeSlots/edit_timeSlot";
    }

    @PostMapping("/timeSlots/{id}")
    public String updateTimeSlot(@PathVariable Long id, @ModelAttribute("timeSlot") TimeSlot timeSlot, Model model) {
        TimeSlot existingTimeSlot = timeSlotService.getTimeSlotById(id);
        existingTimeSlot.setTitle(timeSlot.getTitle());
        existingTimeSlot.setTime(timeSlot.getTime());

        timeSlotService.updateTimeSlot(existingTimeSlot);
        return "redirect:/timeSlots";
    }

    @GetMapping("/timeSlots/{id}")
    public String deleteTimeSlot(@PathVariable Long id){
        timeSlotService.deleteTimeSlot(id);
        return "redirect:/timeSlots";
    }
}
