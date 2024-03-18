package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.dto.CourseDTO;
import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.Course;
import com.enterprise.YogaStudio.model.Instructor;
import com.enterprise.YogaStudio.service.BookingService;
import com.enterprise.YogaStudio.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getcoursedetails")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> dtos = courseService.getAllCourses();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        CourseService.addCourse(course);
        return ResponseEntity.ok().build();
    }

    @PutMapping("updateCourse/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Integer id, @RequestBody Course courseDetails) {
        Course updatedCourse = CourseService.updateCourse(id, courseDetails);
        if (updatedCourse != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        CourseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
        }

}}
