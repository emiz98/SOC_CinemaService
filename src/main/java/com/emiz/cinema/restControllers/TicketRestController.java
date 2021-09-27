package com.emiz.cinema.restControllers;

import com.emiz.cinema.models.MovieShowTime;
import com.emiz.cinema.models.Tickets;
import com.emiz.cinema.services.MovieShowTimeService;
import com.emiz.cinema.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TicketRestController {

    private TicketService ticketService;
    private MovieShowTimeService movieShowTimeService;

    public TicketRestController(TicketService ticketService, MovieShowTimeService movieShowTimeService) {
        this.ticketService = ticketService;
        this.movieShowTimeService = movieShowTimeService;
    }


    @GetMapping("/tickets/{email}")
    public List<Tickets> getTicketsByEmail(@PathVariable String email){
        return ticketService.getAllTickets();
    }

    @PostMapping("/tickets")
    public Tickets createTicket(@RequestBody Tickets tickets){
        MovieShowTime existingShowTime = movieShowTimeService.getShowTimeById(tickets.getMovieShowTime().getId());
        String seats ="";
        if(existingShowTime.getSeats()=="" || existingShowTime.getSeats()==null){
            seats = tickets.getSeats();
        }
        else{
            seats = existingShowTime.getSeats()+','+tickets.getSeats();
        }
        existingShowTime.setSeats(seats);
        return ticketService.storeTicket(tickets);
    }
}
