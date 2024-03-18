package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.AddBookingDTO;
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


import java.util.List;

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
        return bookingRepository.save(booking);
    }

}
