package com.emiz.cinema.services;

import com.emiz.cinema.models.MovieShowTime;

import java.util.List;

public interface MovieShowTimeService {
    List<MovieShowTime> getAllByMovieId(Long id);
    MovieShowTime store(MovieShowTime movieShowTime);
    void deleteShowTime(Long id);
}
