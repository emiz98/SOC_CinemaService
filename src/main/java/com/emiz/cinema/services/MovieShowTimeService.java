package com.emiz.cinema.services;

import com.emiz.cinema.models.DateSlot;
import com.emiz.cinema.models.MovieShowTime;
import com.emiz.cinema.models.TimeSlot;

import java.util.List;

public interface MovieShowTimeService {
    List<MovieShowTime> getAllByMovieId(Long id);
    List<MovieShowTime> findDuplicateShowTimes(DateSlot date, TimeSlot time);
    MovieShowTime store(MovieShowTime movieShowTime);
    MovieShowTime getShowTimeById(Long id);
    void deleteShowTime(Long id);
}
