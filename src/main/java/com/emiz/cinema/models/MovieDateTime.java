package com.emiz.cinema.models;

import javax.persistence.*;

@Entity
@Table(name = "movie_dates_times")
public class MovieDateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long movieId;
    private String showDate;
    private String showTime;
    private Long availableSeats;

    public MovieDateTime() {
    }

    public MovieDateTime(Long movieId, String showDate, String showTime, Long availableSeats) {
        this.movieId = movieId;
        this.showDate = showDate;
        this.showTime = showTime;
        this.availableSeats = availableSeats;
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

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public Long getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Long availableSeats) {
        this.availableSeats = availableSeats;
    }
}
