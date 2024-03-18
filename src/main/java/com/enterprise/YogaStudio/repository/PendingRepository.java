package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.PendingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PendingRepository extends JpaRepository<PendingList, Integer> {
}
