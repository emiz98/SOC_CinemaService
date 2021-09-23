package com.emiz.cinema.models;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long movieId;
    private Long showDTId;
    private String email;
    private Long seats;

    public Tickets() {
    }

    public Tickets(Long movieId, Long showDTId, String email, Long seats) {
        this.movieId = movieId;
        this.showDTId = showDTId;
        this.email = email;
        this.seats = seats;
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

    public Long getShowDTId() {
        return showDTId;
    }

    public void setShowDTId(Long showDTId) {
        this.showDTId = showDTId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSeats() {
        return seats;
    }

    public void setSeats(Long seats) {
        this.seats = seats;
    }
}
