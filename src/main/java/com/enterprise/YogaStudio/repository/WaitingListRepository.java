package com.enterprise.YogaStudio.repository;


import com.enterprise.YogaStudio.model.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaitingListRepository extends JpaRepository<WaitingList, Integer> {
    @Query("SELECT b FROM WaitingList b WHERE b.client.id = :clientId")
    List<WaitingList> findByClientId(Integer clientId);

}
