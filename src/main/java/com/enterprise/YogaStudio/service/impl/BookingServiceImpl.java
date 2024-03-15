package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.service.BookingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

  /*  @Override
    @Transactional
    public List<Booking> getBookingDetails() {
        List<Booking> allBookings = bookingRepository.findAllWithYogaSession();
        return allBookings;
    }*/

    @Override
    public List<BookingDTO> getAllBooking() {
        List<Booking> allBookings = bookingRepository.findAllWithYogaSession();
        List<BookingDTO> bookingDTOs = new ArrayList<>();
        for(Booking oneBooking : allBookings){
            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setBookingid(oneBooking.getBookingid());
            bookingDTO.setClient(oneBooking.getClient());
            bookingDTO.setYogaSession(oneBooking.getYogaSession());
            bookingDTOs.add(bookingDTO);
        }
        return bookingDTOs;
    }

//    @Override
//    public List<Booking> getBookingDetails() {
//       List<Booking> allBookings = bookingRepository.findAll();
//       List<Booking> customBookings = new ArrayList<Booking>();
//       for(int i= 0 ; i < allBookings.size() ; i++){
//           Booking oneBooking = allBookings.get(i);
//           oneBooking = oneBooking.getYogaSession();
//           customBookings.add(oneBooking);
//
//
//       }
//        return customBookings;
//    }
}
