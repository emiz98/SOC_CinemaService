package com.emiz.cinema.services.impl;

import com.emiz.cinema.models.MovieDateTime;
import com.emiz.cinema.repos.MovieDTRepo;
import com.emiz.cinema.services.MovieDTService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDTServiceImpl implements MovieDTService {

    private MovieDTRepo movieDTRepo;

    public MovieDTServiceImpl(MovieDTRepo movieDTRepo) {
        this.movieDTRepo = movieDTRepo;
    }

    @Override
    public List<MovieDateTime> getDTByMovieId(Long id) {
        return movieDTRepo.findByMovieId(id);
    }
}
