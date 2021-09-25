package com.emiz.cinema.models;

import org.hibernate.mapping.Array;

import javax.persistence.*;

@Entity
@Table(name = "movie_show_times")
public class MovieShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long availableSeats;
    private String seats;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="date_slot")
    private DateSlot dateSlot;

    @ManyToOne
    @JoinColumn(name="time_slot")
    private TimeSlot timeSlot;

    public MovieShowTime() {
    }

    public MovieShowTime(Long availableSeats, String seats, Movie movie, DateSlot dateSlot, TimeSlot timeSlot) {
        this.availableSeats = availableSeats;
        this.seats = seats;
        this.movie = movie;
        this.dateSlot = dateSlot;
        this.timeSlot = timeSlot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Long availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public DateSlot getDateSlot() {
        return dateSlot;
    }

    public void setDateSlot(DateSlot dateSlot) {
        this.dateSlot = dateSlot;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
