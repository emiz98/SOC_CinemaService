package com.emiz.cinema.models;

import javax.persistence.*;

@Entity
@Table(name = "time_slots")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String time;

    public TimeSlot() {
    }

    public TimeSlot(String title, String time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
