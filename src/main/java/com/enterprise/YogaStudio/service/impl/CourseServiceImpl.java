package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.CourseDTO;
import com.enterprise.YogaStudio.dto.ManagerDTO;
import com.enterprise.YogaStudio.dto.StudioDTO;
import com.enterprise.YogaStudio.model.*;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.repository.CourseRepository;
import com.enterprise.YogaStudio.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> dtos = new ArrayList<>();
        for (Course course : courses) {
            dtos.add(convertToDTO(course));
        }
        return dtos;
    }

    public CourseDTO convertToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setCourseId(course.getId());
        dto.setCourseName(course.getCourseName());
        dto.setStudio(convertToStudioDTO(course.getStudio()));
        // Set other fields similarly
        return dto;
    }

    @Override
    public void addCourse (Course course){
        CourseRepository.save(course);
    }
    private StudioDTO convertToStudioDTO(Studio studio) {
        if (studio == null) {
            return null;
        }
        StudioDTO studioDTO = new StudioDTO();
        studioDTO.setId(studio.getId());
        studioDTO.setAddress(studio.getAddress());
        studioDTO.setTelnum(studio.getTelnum());
        studioDTO.setManager(convertToManagerDTO(studio.getManager()));
        return studioDTO;
    }

    private ManagerDTO convertToManagerDTO(Manager manager) {
        if (manager == null) {
            return null;
        }
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setId(manager.getId());
        managerDTO.setManagerName(manager.getManagerName());
        managerDTO.setEmail(manager.getEmail());
        return managerDTO;
    }

    @Override
    public Course updateCourse (Integer id, Course courseDetails) {
        return CourseRepository.findById(id)
                .map(course -> {
                    course.setCourseName(courseDetails.getCourseName());
                    course.setTelnum(courseDetails.getTelnum());
                    // Set other fields as needed
                    return CourseRepository.save(course);
                })
                .orElse(null);
    }

    @Override
    public void deleteCourse(Integer id) {
        CourseRepository.deleteById(id);
    }
}
