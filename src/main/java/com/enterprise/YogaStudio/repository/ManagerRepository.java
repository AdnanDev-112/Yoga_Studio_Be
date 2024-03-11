package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Manager;
import com.enterprise.YogaStudio.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
