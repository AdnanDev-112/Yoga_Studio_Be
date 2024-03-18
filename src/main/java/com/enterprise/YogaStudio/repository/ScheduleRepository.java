package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
