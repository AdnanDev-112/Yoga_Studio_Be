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

    Course addCourseData(Course course);

    Course getCourseById(Integer id);

    List<Course> getCourseList();

    void deleteCourse(Integer id);

    Course updateCourse(Integer id, Course course);

}
