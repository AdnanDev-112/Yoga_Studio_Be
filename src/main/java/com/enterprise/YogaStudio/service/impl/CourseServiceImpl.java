package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.CourseDTO;
import com.enterprise.YogaStudio.model.Course;
import com.enterprise.YogaStudio.model.Studio;
import com.enterprise.YogaStudio.repository.CourseRepository;
import com.enterprise.YogaStudio.repository.StudioRepository;
import com.enterprise.YogaStudio.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudioRepository studioRepository;

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> dtos = new ArrayList<>();
        for (Course course : courses) {
            dtos.add(convertToDTO(course));
        }
        return dtos;
    }



    @Override
    public List<?> getCourses() {
       return courseRepository.findAll();
    }

    @Override
    public List<String> getAllStudioLocations() {
        return studioRepository.findAllLocations();
    }

    @Override
    public Course addCourseForm(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Studio getStudioByIdForLocation(Integer id) {
       return (Studio) studioRepository.findAllLocations();
    }


//    public CourseDTO courseFormDTO(Course course){
//        CourseDTO dto = new CourseDTO();
//        dto.setCourseId(course.getId());
//        dto.setCourseName(course.getCourseName());
//        dto.setStartDate(course.getStartDate());
//        dto.setEndDate(course.getEndDate());
//        dto.setNumberOfClasses(course.getNumberOfClasses());
//        dto.setStudio(convertToStudioDTO(course.getStudio()));
//        dto.setPrice(course.getPricing().getAmount()); // Assuming pricing is associated with course
//        return dto;
//    }
//
//    public CourseDTO convertToDTO(Course course) {
//        CourseDTO dto = new CourseDTO();
//        dto.setCourseId(course.getId());
//        dto.setCourseName(course.getCourseName());
//        dto.setStudio(convertToStudioDTO(course.getStudio()));
//        // Set other fields similarly
//        return dto;
//    }
//
//    private StudioDTO convertToStudioDTO(Studio studio) {
//        if (studio == null) {
//            return null;
//        }
//        StudioDTO studioDTO = new StudioDTO();
//        studioDTO.setId(studio.getId());
//        studioDTO.setAddress(studio.getAddress());
//        studioDTO.setTelnum(studio.getTelnum());
//        studioDTO.setManager(convertToManagerDTO(studio.getManager()));
//        return studioDTO;
//    }
//
//    private ManagerDTO convertToManagerDTO(Manager manager) {
//        if (manager == null) {
//            return null;
//        }
//        ManagerDTO managerDTO = new ManagerDTO();
//        managerDTO.setId(manager.getId());
//        managerDTO.setManagerName(manager.getManagerName());
//        managerDTO.setEmail(manager.getEmail());
//        return managerDTO;
//    }

    ///////////for the course form




    private CourseDTO convertToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getId());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setStartDate(course.getStartDate());
        courseDTO.setEndDate(course.getEndDate());
        courseDTO.setNumberOfClasses(course.getNumberOfClasses());
        courseDTO.setPrice(course.getPricing().getAmount());
        courseDTO.setStudio(course.getStudio());

        return courseDTO;
    }



}
