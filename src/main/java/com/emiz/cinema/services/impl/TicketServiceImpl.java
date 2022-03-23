package com.emiz.cinema.services.impl;

import com.emiz.cinema.models.Movie;
import com.emiz.cinema.models.MovieShowTime;
import com.emiz.cinema.models.Tickets;
import com.emiz.cinema.repos.MovieRepo;
import com.emiz.cinema.repos.MovieShowTimeRepo;
import com.emiz.cinema.repos.TicketRepo;
import com.emiz.cinema.services.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepo ticketRepo;
    private MovieRepo movieRepo;
    private MovieShowTimeRepo movieShowTimeRepo;

    public TicketServiceImpl(TicketRepo ticketRepo, MovieRepo movieRepo, MovieShowTimeRepo movieShowTimeRepo) {
        this.ticketRepo = ticketRepo;
        this.movieRepo = movieRepo;
        this.movieShowTimeRepo = movieShowTimeRepo;
    }

    @Override
    public List<Tickets> getAllTickets() {
        return ticketRepo.findAll();
    }

    @Override
    public List<Tickets> getAllTicketsByEmail(String email) {
        return ticketRepo.findByEmail(email);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public List<MovieShowTime> getAllMovieShowTimesByMovieId(Long id) {
        return movieShowTimeRepo.findByMovieId(id);
    }

    @Override
    public Tickets storeTicket(Tickets tickets) {
        return ticketRepo.save(tickets);
    }

    @Override
    public Tickets getTicketById(Long id) {
        return ticketRepo.findById(id).get();
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepo.deleteById(id);
    }
}
