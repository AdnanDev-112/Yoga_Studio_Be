package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public List<Booking> getBookingDetails() {
        return bookingRepository.findAll();
    }
}
