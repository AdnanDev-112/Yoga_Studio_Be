package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorService {
    public List<Instructor> getInstructorsList();

    void addInstructor(Instructor instructor);

    void deleteInstructor(Integer id);
}
