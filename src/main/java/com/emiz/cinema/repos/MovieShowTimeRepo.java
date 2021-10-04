package com.emiz.cinema.repos;

import com.emiz.cinema.models.DateSlot;
import com.emiz.cinema.models.MovieShowTime;
import com.emiz.cinema.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieShowTimeRepo extends JpaRepository<MovieShowTime,Long> {
    List<MovieShowTime> findByMovieId(Long id);
    List<MovieShowTime> findByDateSlotAndTimeSlot(DateSlot date, TimeSlot time);
}
