package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.AddBookingDTO;
import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    List<Booking> getAllBookings();

//    List<BookingDTO> getBookingDetails(Integer clientId);
  //  List<Booking> getAllBooking();

    List<Booking> getAllBooking();

    List<Booking> getBookingsByClientId(Integer clientId);

    Booking addBooking(AddBookingDTO bookingData);

    void removeBooking(Integer bookingId);

  //  void addSchedule(ScheduleRequest request);
}
