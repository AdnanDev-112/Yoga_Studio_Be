package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.PendingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PendingRepository extends JpaRepository<PendingList, Integer> {
//    @Query("SELECT s FROM PendingList s WHERE s.booking.schedule.categoryType = 'yoga_session'  AND s.booking.schedule.yogaSession.id = :yogaSessionId AND s.booking.schedule.yogaSession.recurring = true")
    @Query("SELECT s FROM PendingList s WHERE s.booking.schedule.yogaSession.id = :yogaSessionId")
    List<PendingList> getSchedulesByYogaSessionClasses(Integer yogaSessionId);
    @Query("SELECT s FROM PendingList s WHERE s.client.id = :clientId")
    List<PendingList> getPendingListByClientId(Integer clientId);
}
