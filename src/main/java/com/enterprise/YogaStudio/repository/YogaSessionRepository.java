package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.YogaSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YogaSessionRepository extends JpaRepository<YogaSession, Integer> {

    @Query("SELECT y FROM YogaSession y WHERE y.recurring = :recurring")
    List<YogaSession> findClassTypeByRecurring(@Param("recurring") boolean recurring);

}
