package com.enterprise.YogaStudio.service;


import com.enterprise.YogaStudio.dto.CourseDTO;
import com.enterprise.YogaStudio.model.Course;
import com.enterprise.YogaStudio.model.Studio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<CourseDTO> getAllCourses();

      List<?> getCourses();


    List<String> getAllStudioLocations();

    Course addCourseForm(Course course);

    Studio getStudioByIdForLocation(Integer integer);
}
