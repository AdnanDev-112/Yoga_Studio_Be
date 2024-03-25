package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query("SELECT s FROM Schedule s WHERE s.categoryType = :categoryType")
    List<Schedule> findByCategoryType(String categoryType);

    @Query("SELECT s FROM Schedule s WHERE s.date = :date AND s.startTime = :startTime AND s.endTime = :endTime")
    List<Schedule> findByDateAndTime(@Param("date") LocalDate date, @Param("startTime") LocalTime startTime, @Param("endTime") LocalTime endTime);

    @Query("SELECT s FROM Schedule s ORDER BY s.date DESC, s.startTime DESC")
    List<Schedule> getScheduleByDescending();
}


