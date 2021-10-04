package com.emiz.cinema.services.impl;

import com.emiz.cinema.models.DateSlot;
import com.emiz.cinema.models.MovieShowTime;
import com.emiz.cinema.models.TimeSlot;
import com.emiz.cinema.repos.MovieShowTimeRepo;
import com.emiz.cinema.services.MovieShowTimeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieShowTimeServiceImpl implements MovieShowTimeService {

    private MovieShowTimeRepo movieShowTimeRepo;

    public MovieShowTimeServiceImpl(MovieShowTimeRepo movieShowTimeRepo) {
        this.movieShowTimeRepo = movieShowTimeRepo;
    }

    @Override
    public List<MovieShowTime> getAllByMovieId(Long id) {
        return movieShowTimeRepo.findByMovieId(id);
    }

    @Override
    public List<MovieShowTime> findDuplicateShowTimes(DateSlot date, TimeSlot time) {
        return movieShowTimeRepo.findByDateSlotAndTimeSlot(date, time);
    }

    @Override
    public MovieShowTime store(MovieShowTime movieShowTime) {
        return movieShowTimeRepo.save(movieShowTime);
    }

    @Override
    public MovieShowTime getShowTimeById(Long id) {
        return movieShowTimeRepo.findById(id).get();
    }

    @Override
    public void deleteShowTime(Long id) {
        movieShowTimeRepo.deleteById(id);
    }
}
