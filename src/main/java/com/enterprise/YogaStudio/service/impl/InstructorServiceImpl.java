package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Instructor;
import com.enterprise.YogaStudio.repository.InstructorRepository;
import com.enterprise.YogaStudio.service.InstructorService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Setter
@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getInstructorsList() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(Integer id) {
    return instructorRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteInstructor(Integer id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public void addInstructor(Instructor instructor) {
        instructorRepository.save(instructor);

    }

    @Override
public Instructor updateInstructor(Integer id, Instructor instructorDetails) {
  return instructorRepository.findById(id)
            .map(instructor -> {
                instructor.setInstructorName();
                instructor.setTelnum();
                // Set other fields as needed
                return instructorRepository.save(instructor);
            })
            .orElse(null);
}
}

//public Instructor updateInstructor(Integer id, Instructor instructorDetails) {
//    return instructorRepository.findById(id)
//            .map(instructor -> {
//                instructor.setInstructorName(instructorDetails.getInstructorName());
//                instructor.setTelnum(instructorDetails.getTelnum());
//                // Set other fields as needed
//                return instructorRepository.save(instructor);
//            })
//            .orElse(null);
// Also go to Instructor class in model to remove functions if needs be
//}