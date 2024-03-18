package com.enterprise.YogaStudio.service.impl;
import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.YogaSession;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;



    @Override
    public List<Booking> getBookingsByClientId(Integer clientId) {

        return bookingRepository.findByClientId(2);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteBooking(Integer id) {
        bookingRepository.deleteById(id);
    }

    public List<BookingDTO> getBookingDetails(Integer id) {
        List<Booking> bookings = bookingRepository.findAll();

       return bookings.stream().map(booking -> {
               BookingDTO bookingDTO = new BookingDTO();
               bookingDTO.setCategoryType(booking.getSchedule().getCategoryType());
               bookingDTO.setStartTime(booking.getSchedule().getStartTime());

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
