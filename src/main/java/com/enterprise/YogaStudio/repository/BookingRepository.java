package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query("SELECT b FROM Booking b WHERE b.client.id = :clientId")
    List<Booking> findByClientId(Integer clientId);
}
