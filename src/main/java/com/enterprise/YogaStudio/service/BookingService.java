package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    List<Booking> getBookingDetails();
}
