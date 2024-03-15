package com.enterprise.YogaStudio.service;


import com.enterprise.YogaStudio.dto.CourseDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<CourseDTO> getAllCourses();
}
