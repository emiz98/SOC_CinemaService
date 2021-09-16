package com.emiz.cinema.services;

import com.emiz.cinema.models.TimeSlot;

import java.util.List;

public interface TimeSlotService {
    List<TimeSlot> getAllTimeSlots();
    TimeSlot storeTimeSlot(TimeSlot timeSlot);
    TimeSlot updateTimeSlot(TimeSlot timeSlot);
    TimeSlot getTimeSlotById(Long id);
    void deleteTimeSlot(Long id);
}
