package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.dto.CourseDTO;
import com.enterprise.YogaStudio.dto.StudioDTO;
import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Course;
import com.enterprise.YogaStudio.model.Studio;
import com.enterprise.YogaStudio.service.CourseService;
import com.enterprise.YogaStudio.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudioService studioService;

    @GetMapping("/getcoursedetails")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> dtos = courseService.getAllCourses();
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/allstudiolocation")
    public ResponseEntity<List<String>> getAllStudioLocations() {
        List<String> locations = courseService.getAllStudioLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @PostMapping("/addcourseformdata")
    public ResponseEntity<Course> addCourseForm(@RequestBody Course course) {
        Studio studio = courseService.getStudioByIdForLocation(Integer.valueOf(course.getId()));
        course.setStudio(studio);
        courseService.addCourseForm(course);
        return ResponseEntity.ok().build();
    }

}
