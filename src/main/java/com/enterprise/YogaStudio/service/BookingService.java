package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

   // List<Booking> getBookingsByClientId(Integer clientId);

    List<Booking> getAllBookings();

    void deleteBooking(Integer id);

    List<BookingDTO> getBookingDetails(Integer clientId);
}
