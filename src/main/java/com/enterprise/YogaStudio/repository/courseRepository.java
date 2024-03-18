package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepository extends JpaRepository<Course, Integer> {
}
