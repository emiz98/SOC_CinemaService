package com.emiz.cinema.controllers;

import com.emiz.cinema.models.Tickets;
import com.emiz.cinema.services.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public String getTickets(Model model){
        model.addAttribute("tickets",ticketService.getAllTickets());
        return "views/tickets/tickets";
    }

    @GetMapping("/tickets/new")
    public String createTicket(Model model){
        model.addAttribute("movies",ticketService.getAllMovies());
        return "views/tickets/showMovies";
    }

    @PostMapping("/tickets/new/shows")
    public String createTicket2(@ModelAttribute("movie") Long id ,Model model){
        model.addAttribute("movieId", id);
        model.addAttribute("movieShowTimes",ticketService.getAllMovieShowTimesByMovieId(id));
        return "views/tickets/create";
    }

    @PostMapping("/tickets")
    public String storeTicket(@ModelAttribute("ticket") Tickets tickets){
        ticketService.storeTicket(tickets);
        return "redirect:/tickets";
    }

    @GetMapping("/tickets/{id}")
    public String deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
        return "redirect:/tickets";
    }
}
