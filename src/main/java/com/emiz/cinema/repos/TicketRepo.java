package com.emiz.cinema.repos;

import com.emiz.cinema.models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepo extends JpaRepository<Tickets,Long> {
    List<Tickets> findByEmail(String email);
}
