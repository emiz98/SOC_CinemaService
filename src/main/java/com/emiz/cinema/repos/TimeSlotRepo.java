package com.emiz.cinema.repos;

import com.emiz.cinema.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepo extends JpaRepository<TimeSlot,Long> {
}
