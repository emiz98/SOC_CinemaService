package com.emiz.cinema.controllers;

import com.emiz.cinema.models.MovieShowTime;
import com.emiz.cinema.models.Tickets;
import com.emiz.cinema.services.MovieShowTimeService;
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
    private MovieShowTimeService movieShowTimeService;

    public TicketController(TicketService ticketService, MovieShowTimeService movieShowTimeService) {
        this.ticketService = ticketService;
        this.movieShowTimeService = movieShowTimeService;
    }

    @GetMapping("/tickets")
    public String getTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "views/tickets/tickets";
    }

    @GetMapping("/tickets/new")
    public String createTicket(Model model) {
        model.addAttribute("movies", ticketService.getAllMovies());
        return "views/tickets/showMovies";
    }

    @PostMapping("/tickets/new/shows")
    public String createTicket2(@ModelAttribute("movie") Long id, Model model) {
        model.addAttribute("movie", id);
        model.addAttribute("movieShowTimes", ticketService.getAllMovieShowTimesByMovieId(id));
        return "views/tickets/create";
    }

    @PostMapping("/tickets")
    public String storeTicket(@ModelAttribute("ticket") Tickets tickets) {
        MovieShowTime existingShowTime = movieShowTimeService.getShowTimeById(tickets.getMovieShowTime().getId());
        String seats ="";
        if(existingShowTime.getSeats()=="" || existingShowTime.getSeats()==null){
            seats = tickets.getSeats();
        }
        else{
            seats = existingShowTime.getSeats()+','+tickets.getSeats();
        }
        existingShowTime.setSeats(seats);
        ticketService.storeTicket(tickets);
        return "redirect:/tickets";
    }

    @GetMapping("/tickets/{id}")
    public String deleteTicket(@PathVariable Long id) {
        Tickets deletingTicket = ticketService.getTicketById(id);
        MovieShowTime existingShowTime = movieShowTimeService.getShowTimeById(deletingTicket.getMovieShowTime().getId());
        String seats = existingShowTime.getSeats();
        String updateSeats = seats.replace(','+deletingTicket.getSeats(),"");
        existingShowTime.setSeats(updateSeats);
        ticketService.deleteTicket(id);
        return "redirect:/tickets";
    }
}
