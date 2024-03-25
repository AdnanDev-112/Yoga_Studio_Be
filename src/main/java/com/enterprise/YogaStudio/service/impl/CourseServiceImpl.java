package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.CourseDTO;
import com.enterprise.YogaStudio.model.Course;
import com.enterprise.YogaStudio.model.Pricing;
import com.enterprise.YogaStudio.model.Studio;
import com.enterprise.YogaStudio.model.YogaSession;
import com.enterprise.YogaStudio.repository.CourseRepository;
import com.enterprise.YogaStudio.repository.StudioRepository;
import com.enterprise.YogaStudio.service.CourseService;
import com.enterprise.YogaStudio.service.StudioService;
import com.enterprise.YogaStudio.service.YogaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private StudioService studioService;
    @Autowired
    private YogaSessionService yogaSessionService;
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
    public Course addCourseData(Course course) {
        Studio studio = studioService.getStudioById(course.getStudioId());
        YogaSession yogaSession = yogaSessionService.getYogaSessionById(course.getYogasessionId());

        course.setPricing(yogaSession.getPricing());

        course.setStudio(studio);
       course.setYogaSession(yogaSession);
        return courseRepository.save(course);
    }
    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }
    @Override
    public List<Course> getCourseList() {
        return courseRepository.findAll();
    }
    @Override
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
    @Override
    public Course updateCourse(Integer id, Course course) {
        return courseRepository.save(course);
    }
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
