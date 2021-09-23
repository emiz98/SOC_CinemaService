package com.emiz.cinema.repos;

import com.emiz.cinema.models.MovieShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieShowTimeRepo extends JpaRepository<MovieShowTime,Long> {
    List<MovieShowTime> findByMovieId(Long id);
}
