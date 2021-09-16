package com.emiz.cinema.models;

import javax.persistence.*;

@Entity
@Table(name = "date_slots")
public class DateSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;

    public DateSlot() {
    }

    public DateSlot(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
