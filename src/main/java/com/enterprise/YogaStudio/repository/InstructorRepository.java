package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {


}
