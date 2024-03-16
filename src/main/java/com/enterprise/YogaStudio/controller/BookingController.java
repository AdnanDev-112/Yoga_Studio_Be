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
    public ResponseEntity<List<Booking>> getBookingByClient() {
    List<Booking> bookings = bookingService.getBookingsByClientId(1);
    return ResponseEntity.ok(bookings);
}

}
