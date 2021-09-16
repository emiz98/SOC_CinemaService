package com.emiz.cinema.repos;

import com.emiz.cinema.models.DateSlot;
import com.emiz.cinema.models.MovieDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDTRepo extends JpaRepository<MovieDateTime,Long> {
    List<MovieDateTime> findByMovieId(Long id);
}
