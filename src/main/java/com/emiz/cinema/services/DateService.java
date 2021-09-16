package com.emiz.cinema.services;

import com.emiz.cinema.models.DateSlot;

import java.util.List;

public interface DateService {
    List<DateSlot> getAllDates();
    DateSlot storeDate(DateSlot dateSlot);
    void deleteDateSlot(Long id);
}
