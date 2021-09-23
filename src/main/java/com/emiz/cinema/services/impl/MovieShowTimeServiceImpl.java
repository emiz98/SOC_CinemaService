package com.emiz.cinema.services.impl;

import com.emiz.cinema.models.MovieShowTime;
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
    public MovieShowTime store(MovieShowTime movieShowTime) {
        return movieShowTimeRepo.save(movieShowTime);
    }

    @Override
    public void deleteShowTime(Long id) {
        movieShowTimeRepo.deleteById(id);
    }
}
