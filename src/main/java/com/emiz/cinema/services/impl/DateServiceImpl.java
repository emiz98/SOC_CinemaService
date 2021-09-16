package com.emiz.cinema.services.impl;

import com.emiz.cinema.models.DateSlot;
import com.emiz.cinema.repos.DateRepo;
import com.emiz.cinema.services.DateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateServiceImpl implements DateService {

    private DateRepo dateRepo;

    public DateServiceImpl(DateRepo dateRepo) {
        this.dateRepo = dateRepo;
    }

    @Override
    public List<DateSlot> getAllDates() {
        return dateRepo.findAll();
    }

    @Override
    public DateSlot storeDate(DateSlot dateSlot) {
        return dateRepo.save(dateSlot);
    }

    @Override
    public void deleteDateSlot(Long id) {
        dateRepo.deleteById(id);
    }


}
