package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Reservation;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {

    Reservation addReservation(Reservation reservation);
}
