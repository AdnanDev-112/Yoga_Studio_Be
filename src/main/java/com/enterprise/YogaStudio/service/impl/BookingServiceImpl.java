package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.dto.AddBookingDTO;
import com.enterprise.YogaStudio.model.*;
import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Discount;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.repository.PendingRepository;
import com.enterprise.YogaStudio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
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
    private ScheduleService scheduleService;
    @Autowired
    private WaitingListService waitingListService;
    //    Methods
    private void createAndSavePendingList(Client client, Booking newBooking) {
        LocalDateTime date = LocalDateTime.now();
        PendingList pendingList = new PendingList();
        pendingList.setBookedTime(date);
        pendingList.setClient(client);
        pendingList.setBooking(newBooking);
        pendingList.setConfirmedStatus(false);

        // Save the pending list
        pendingListService.addPendingList(pendingList);
    }
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingDetails(Integer clientId) {
        return bookingRepository.findByClientId(clientId);
    }
    @Override
    public Booking addBooking(AddBookingDTO bookingData) {
        Booking booking = new Booking();
        Client client = clientService.getClientById(bookingData.getClientId());
        Schedule schedule = scheduleService.getScheduleById(bookingData.getScheduleId());

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
        Booking newBooking = bookingRepository.save(booking);

//        Check Capacity and Bookings
        if (bookingData.getCategory_type().equals("yoga_session") && bookingData.getCategorySubType().equals("Class")) {
//            Calculate Capacity
            int maxCapacity = schedule.getYogaSession().getMaxCapacity();
            int currentCapacity = pendingListService.getPendingDataForSchedule(schedule.getYogaSession().getId()).size();
            System.out.println("Max Capacity: " + maxCapacity);
            System.out.println("Current Capacity: " + currentCapacity);

            if (currentCapacity >= maxCapacity) {
                System.out.println("Class is full");
                System.out.println("Waiting List Initiated");

                WaitingList waitingList = new WaitingList();
                waitingList.setClient(client);
                waitingList.setBooking(newBooking);
                waitingList.setAddDate(new Timestamp(System.currentTimeMillis()));
                waitingList.setYogaSession(newBooking.getSchedule().getYogaSession());
                waitingListService.addWaitingList(waitingList);
                System.out.println("Waiting List Added");
            } else {
                createAndSavePendingList(client, newBooking);
            }
        } else {
            createAndSavePendingList(client, newBooking);
        }
        return newBooking;
    }
    @Override
    public void removeBooking(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
        System.out.println("Booking Removed");
    }
}
