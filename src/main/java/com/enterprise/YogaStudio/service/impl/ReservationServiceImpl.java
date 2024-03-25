package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Reservation;
import com.enterprise.YogaStudio.repository.ReservationRepository;
import com.enterprise.YogaStudio.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository ReservationRepository;
    @Override
    public Reservation addReservation(Reservation reservation) {
        return ReservationRepository.save(reservation);
    }
}
