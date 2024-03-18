package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query("SELECT s FROM Schedule s WHERE s.categoryType = :categoryType")
    List<Schedule> findByCategoryType(String categoryType);
}


