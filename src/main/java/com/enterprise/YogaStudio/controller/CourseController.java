package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.dto.CourseDTO;
import com.enterprise.YogaStudio.dto.StudioDTO;
import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Course;
import com.enterprise.YogaStudio.model.Studio;
import com.enterprise.YogaStudio.model.YogaSession;
import com.enterprise.YogaStudio.service.CourseService;
import com.enterprise.YogaStudio.service.StudioService;
import com.enterprise.YogaStudio.service.YogaSessionService;
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

    @Autowired
    private YogaSessionService yogaSessionService;

    @GetMapping("/getcoursedetails")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> dtos = courseService.getAllCourses();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/getcoursebyid/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getcourselist")
    public ResponseEntity<List<Course>> getCourseList() {
        List<Course> courses = courseService.getCourseList();
        return ResponseEntity.ok(courses);

    }


    @PostMapping("/addcoursedata")
    public ResponseEntity<Course> addCourseData(@RequestBody Course course){
        Studio studiodata = studioService.getStudioById(course.getStudioId());
        YogaSession yogaSession = yogaSessionService.getYogaSessionById(course.getYogasessionId());
        course.setStudio(studiodata);
        course.setPricing(yogaSession.getPricing());
        course.setYogaSession(yogaSession);
        courseService.addCourseData(course);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletecourse/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updatecourse/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Integer id, @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(id, course);
        if (updatedCourse != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
