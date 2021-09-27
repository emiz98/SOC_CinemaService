package com.emiz.cinema.models;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "show_time")
    private MovieShowTime movieShowTime;
    private String email;
    private String seats;

    public Tickets() {
    }

    public Tickets(Movie movie, MovieShowTime movieShowTime, String email, String seats) {
        this.movie = movie;
        this.movieShowTime = movieShowTime;
        this.email = email;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public MovieShowTime getMovieShowTime() {
        return movieShowTime;
    }

    public void setMovieShowTime(MovieShowTime movieShowTime) {
        this.movieShowTime = movieShowTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
