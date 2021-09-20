package com.emiz.cinema.services.impl;

import com.emiz.cinema.models.Tickets;
import com.emiz.cinema.repos.TicketRepo;
import com.emiz.cinema.services.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepo ticketRepo;

    public TicketServiceImpl(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Override
    public List<Tickets> getAllTickets() {
        return ticketRepo.findAll();
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
