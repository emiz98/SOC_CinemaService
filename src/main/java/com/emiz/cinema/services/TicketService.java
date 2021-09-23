package com.emiz.cinema.services;

import com.emiz.cinema.models.Movie;
import com.emiz.cinema.models.MovieShowTime;
import com.emiz.cinema.models.Tickets;

import java.util.List;

public interface TicketService {
    List<Tickets> getAllTickets();
    List<Movie> getAllMovies();
    List<MovieShowTime> getAllMovieShowTimesByMovieId(Long id);
    Tickets storeTicket(Tickets tickets);
    Tickets getTicketById(Long id);
    void deleteTicket(Long id);
}
