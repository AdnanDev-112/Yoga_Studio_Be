package com.enterprise.YogaStudio.service;


import com.enterprise.YogaStudio.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<CourseDTO> getAllCourses();

    List<?> getCourses();
}
