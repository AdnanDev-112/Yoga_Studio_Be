package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
}
