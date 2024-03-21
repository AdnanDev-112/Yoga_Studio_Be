package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.dto.AddBookingDTO;
import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.dto.CourseDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Booking>> getBookingByClient() {
        List<Booking> bookings = bookingService.getBookingsByClientId(1);
        return ResponseEntity.ok(bookings);
    }
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

//    @DeleteMapping("/deletebooking/{id}")
//    public ResponseEntity<Void> deleteBooking(@PathVariable Integer id) {
//        bookingService.deleteBooking(id);
//        return ResponseEntity.noContent().build();
//    }

//    @PostMapping("/addschedule")
//    public ResponseEntity<?> addSchedule(@RequestBody ScheduleRequest request) {
//        try {
//            bookingService.addSchedule(request);
//            return ResponseEntity.ok("Booking added successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding booking: " + e.getMessage());
//        }
//    }



}
