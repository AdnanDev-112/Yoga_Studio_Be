package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.dto.CourseDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/getbookingdetails")
    public ResponseEntity<List<Booking>> getBookingsByClientId(Integer clientId) {
    List<Booking> bookings = bookingService.getBookingsByClientId(clientId);
    return ResponseEntity.ok(bookings);
}


    @GetMapping("/getallbooking")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

}
