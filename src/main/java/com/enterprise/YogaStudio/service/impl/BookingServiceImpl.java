package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.YogaSession;


import com.enterprise.YogaStudio.dto.AddBookingDTO;
import com.enterprise.YogaStudio.model.*;
import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.model.*;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Discount;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.repository.PendingRepository;
import com.enterprise.YogaStudio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PendingListService pendingListService;

    @Autowired
    private DiscountCalculationService discountCalculationService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PendingRepository pendingRepository;

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

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



    @Override
    public Booking addBooking(AddBookingDTO bookingData) {
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
        Booking newBooking =  bookingRepository.save(booking);

//        Creating a new Pending List
        LocalDateTime date = LocalDateTime.now();
        PendingList pendingList = new PendingList();
        pendingList.setBookedTime(date);
        pendingList.setClient(client);
        pendingList.setBooking(newBooking);
        pendingList.setConfirmedStatus(false);

        //Save the pending list
        pendingListService.addPendingList(pendingList);




        return newBooking;
    }



}
