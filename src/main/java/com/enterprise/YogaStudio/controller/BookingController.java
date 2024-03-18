package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.dto.BookingDTO;
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

    @GetMapping("/getbookingdetails/{id}")
    public ResponseEntity<List<BookingDTO>> getBookingDetails(@PathVariable Integer id) {
    List<BookingDTO> bookings = bookingService.getBookingDetails(id);
    return ResponseEntity.ok(bookings);
}


    @GetMapping("/getallbooking")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @DeleteMapping("/deletebooking/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

}
