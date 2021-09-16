package com.emiz.cinema.services.impl;

import com.emiz.cinema.models.TimeSlot;
import com.emiz.cinema.repos.TimeSlotRepo;
import com.emiz.cinema.services.TimeSlotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    private TimeSlotRepo timeSlotRepo;

    public TimeSlotServiceImpl(TimeSlotRepo timeSlotRepo) {
        this.timeSlotRepo = timeSlotRepo;
    }

    @Override
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotRepo.findAll();
    }

    @Override
    public TimeSlot storeTimeSlot(TimeSlot timeSlot) {
        return timeSlotRepo.save(timeSlot);
    }

    @Override
    public TimeSlot updateTimeSlot(TimeSlot timeSlot) {
        return timeSlotRepo.save(timeSlot);
    }

    @Override
    public TimeSlot getTimeSlotById(Long id) {
        return timeSlotRepo.findById(id).get();
    }

    @Override
    public void deleteTimeSlot(Long id) {
        timeSlotRepo.deleteById(id);
    }
}
