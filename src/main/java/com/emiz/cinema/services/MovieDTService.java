package com.emiz.cinema.services;

import com.emiz.cinema.models.MovieDateTime;

import java.util.List;

public interface MovieDTService {
    List<MovieDateTime> getDTByMovieId(Long id);
    MovieDateTime storeMDT(MovieDateTime movieDateTime);
    void deleteShowDT(Long id);
}
