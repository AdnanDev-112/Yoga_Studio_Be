package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorService {
    public List<Instructor> getInstructorsList();

    void addInstructor(Instructor instructor);
    public Instructor getInstructorById(Integer id);

    Instructor updateInstructor(Integer id, Instructor instructorDetails);

    void deleteInstructor(Integer id);
}
