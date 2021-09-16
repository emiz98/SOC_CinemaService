package com.emiz.cinema.repos;

import com.emiz.cinema.models.DateSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepo extends JpaRepository<DateSlot,Long> {
}
