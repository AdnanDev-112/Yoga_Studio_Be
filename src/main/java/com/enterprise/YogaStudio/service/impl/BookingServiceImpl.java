package com.enterprise.YogaStudio.service.impl;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

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


//    Another method Beliw is to only set the required DTO fields and return but then
//    You would have to make so many specific use cases DTO? SO better use the above one
//    with the custom Query in the Repository
//    @Override
//public List<BookingDTO> getAllBooking() {
//    List<Booking> allBookings = bookingRepository.findAll();
//    List<BookingDTO> newDto = new ArrayList<>();
//
//    for(Booking oneBooking : allBookings){
//        BookingDTO dto = new BookingDTO();
//        dto.setBookingid(oneBooking.getBookingid());
//        dto.setClientId(oneBooking.getClient().getClientid());
//        dto.setClientName(oneBooking.getClient().getClientName());
//        dto.setYogaSessionId(oneBooking.getYogaSession().getId());
//        dto.setActivityType(oneBooking.getYogaSession().getActivityType());
//        dto.setLevel(oneBooking.getYogaSession().getLevel());
//        newDto.add(dto);
//    }
//    return newDto;
//}
}
