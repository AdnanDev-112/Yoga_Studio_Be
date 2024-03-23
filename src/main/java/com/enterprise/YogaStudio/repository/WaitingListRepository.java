package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitingListRepository extends JpaRepository<WaitingList, Integer> {
}
