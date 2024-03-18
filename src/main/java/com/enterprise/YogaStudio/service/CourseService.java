package com.enterprise.YogaStudio.service;


import com.enterprise.YogaStudio.dto.CourseDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.Course;
import com.enterprise.YogaStudio.model.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<Course> getAllCourses();
     void addCourse(Course course);

    Course updateCourse(Integer id, Course courseDetails);

    void deleteCourse(Integer id);

}
