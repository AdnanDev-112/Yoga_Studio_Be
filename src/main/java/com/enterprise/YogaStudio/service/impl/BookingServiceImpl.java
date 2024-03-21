package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.YogaSession;


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

    @Autowired
    private DiscountCalculationService discountCalculationService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private ClientService clientService;


    @Override
    public List<Booking> getBookingsByClientId(Integer clientId) {

        return bookingRepository.findByClientId(2);
    }



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
                // Check if Pricing is not null before accessing it
                if (yogaSession.getPricing() != null) {
                    bookingDTO.setAmount(yogaSession.getPricing().getAmount());
                }
            }
            return bookingDTO;
        }).collect(Collectors.toList());
    }


    }


