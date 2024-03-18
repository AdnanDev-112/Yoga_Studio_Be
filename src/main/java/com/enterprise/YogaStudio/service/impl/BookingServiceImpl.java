package com.enterprise.YogaStudio.service.impl;
<<<<<<<<< Temporary merge branch 1
import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.YogaSession;
=========

import com.enterprise.YogaStudio.dto.AddBookingDTO;
import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.model.*;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Discount;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.service.BookingService;
import com.enterprise.YogaStudio.service.ClientService;
import com.enterprise.YogaStudio.service.DiscountCalculationService;
import com.enterprise.YogaStudio.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

<<<<<<<<< Temporary merge branch 1


//    @Override
//    public List<Booking> getBookingsByClientId(Integer clientId) {
//
//        return bookingRepository.findByClientId(2);
//    }
=========
    @Autowired
    private DiscountCalculationService discountCalculationService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private ClientService clientService;


//    @Override
//    public List<Booking> getBookingsByClientId(Integer clientId) {
//
//        return bookingRepository.findByClientId(2);
//    }



    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }


    public List<BookingDTO> getBookingDetails(Integer id) {
        List<Booking> bookings = bookingRepository.findByClientId(id);

        return bookings.stream().map(booking -> {
            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setCategoryType(booking.getSchedule().getCategoryType());
            bookingDTO.setStartDate(booking.getSchedule().getDate());

            if (booking.getSchedule().getYogaSession() != null) {
                YogaSession yogaSession = booking.getSchedule().getYogaSession();
                bookingDTO.setLevel(yogaSession.getLevel());
                bookingDTO.setInstructorName(yogaSession.getInstructor().getInstructorName());
                bookingDTO.setDuration(yogaSession.getDuration());
    @Override
    public List<Booking> getBookingsByClientId(Integer clientId) {

        return bookingRepository.findByClientId(2);
    }
                // Check if Pricing is not null before accessing it
                if (yogaSession.getPricing() != null) {
                    bookingDTO.setAmount(yogaSession.getPricing().getAmount());
                }
            }
            return bookingDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public Booking addBooking(AddBookingDTO bookingData) {
        Booking booking = new Booking();
        Client client = clientService.getClientById(bookingData.getClientId());
        Schedule schedule = new Schedule();
        // Setters on Objects
        schedule.setId(bookingData.getScheduleId());
        @Override
        public Booking addBooking (AddBookingDTO bookingData){
            Booking booking = new Booking();
            Client client = clientService.getClientById(bookingData.getClientId());
            Schedule schedule = new Schedule();
            // Setters on Objects
            schedule.setId(bookingData.getScheduleId());

//        Processing
            if (bookingData.getCategory_type().equals("course")) {
                int clientAge = discountCalculationService.calculateAge(client.getDob());
                List<Discount> discounts = discountService.getDiscountList();
                Discount applicableDiscount = discountCalculationService.getApplicableDiscount(clientAge, discounts);
                booking.setDiscountId(applicableDiscount);
            }

            // Setters on Booking
            booking.setClient(client);
            booking.setSchedule(schedule);

            // Save the booking
            return bookingRepository.save(booking);
        }
        // Save the booking
        return bookingRepository.save(booking);
    }

//    @Override
//    public void addSchedule(ScheduleRequest request) {
//        Schedule schedule = new Schedule();
//        schedule.setId(request.getScheduleId());
//        schedule.setCategoryType(request.getCategory_type());
//        schedule.setStartTime(request.getStartTime());
//        schedule.setEndTime(request.getEndTime());
//        schedule.setDate(request.getDate());
//
//        // Save booking to the database
//        bookingRepository.save(schedule);
//    }


    @Override
    public List<Booking> getBookingsByClientId(Integer clientId) {
        return null;
    }
}
