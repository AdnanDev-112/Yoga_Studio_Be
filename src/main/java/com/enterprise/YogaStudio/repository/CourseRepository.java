package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
