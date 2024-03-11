package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer>{
}
