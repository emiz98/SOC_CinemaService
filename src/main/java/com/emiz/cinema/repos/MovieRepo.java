package com.emiz.cinema.repos;

import com.emiz.cinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie,Long> {
}
