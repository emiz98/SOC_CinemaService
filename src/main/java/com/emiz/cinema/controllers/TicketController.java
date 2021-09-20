package com.emiz.cinema.controllers;

import com.emiz.cinema.models.Tickets;
import com.emiz.cinema.services.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        Tickets ticket = new Tickets();
        model.addAttribute("ticket",ticket);
        return "views/tickets/create";
    }
}
