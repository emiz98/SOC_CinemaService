package com.emiz.cinema.services;

import com.emiz.cinema.models.Tickets;

import java.util.List;

public interface TicketService {
    List<Tickets> getAllTickets();
    Tickets storeTicket(Tickets tickets);
    Tickets getTicketById(Long id);
    void deleteTicket(Long id);
}
