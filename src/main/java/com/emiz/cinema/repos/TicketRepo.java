package com.emiz.cinema.repos;

import com.emiz.cinema.models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Tickets,Long> {
}
