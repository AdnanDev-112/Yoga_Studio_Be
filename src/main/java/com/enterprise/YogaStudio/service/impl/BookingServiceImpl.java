package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.AddBookingDTO;
import com.enterprise.YogaStudio.model.*;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.repository.PendingRepository;
import com.enterprise.YogaStudio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
