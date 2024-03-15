package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Instructor;
import com.enterprise.YogaStudio.repository.InstructorRepository;
import com.enterprise.YogaStudio.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;
    public List<Instructor> getInstructorsList() {
        return instructorRepository.findAll();
    }

    @Override
    public void deleteInstructor(Integer id) {
        instructorRepository.deleteById(id);
    }

    @Override
public void addInstructor(Instructor instructor) {
        instructorRepository.save(instructor);

}
}
