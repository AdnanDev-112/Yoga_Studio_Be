package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer>{
    @Query("SELECT s FROM Studio s WHERE s.location = : location")
    List<String> findAllLocations();
}