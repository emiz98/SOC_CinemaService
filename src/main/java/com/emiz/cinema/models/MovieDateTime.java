package com.emiz.cinema.models;

import javax.persistence.*;

@Entity
@Table(name = "movie_dates_times")
public class MovieDateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long movieId;
    private Long dateId;
    private Long timeId;

    public MovieDateTime() {
    }

    public MovieDateTime(Long movieId, Long dateId, Long timeId) {
        this.movieId = movieId;
        this.dateId = dateId;
        this.timeId = timeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }

    public Long getTimeId() {
        return timeId;
    }

    public void setTimeId(Long timeId) {
        this.timeId = timeId;
    }
}
