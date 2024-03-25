package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.model.Instructor;
import com.enterprise.YogaStudio.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@CrossOrigin(origins = "http://localhost:3000")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;
    @GetMapping("/getinstructorslist")
    public List<Instructor> getInstructorsList() {
        return instructorService.getInstructorsList();
    }
    @GetMapping("/getoneinstructor/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Integer id) {
    Instructor instructor = instructorService.getInstructorById(id);
    if (instructor != null) {
        return ResponseEntity.ok(instructor);
    } else {
        return ResponseEntity.notFound().build();
    }
    }
    @PostMapping("/addinstructor")
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
     instructorService.addInstructor(instructor);
    return ResponseEntity.ok().build();
    }
    @PutMapping("/updateinstructor/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Integer id, @RequestBody Instructor instructorDetails) {
    Instructor updatedInstructor = instructorService.updateInstructor(id, instructorDetails);
    if (updatedInstructor != null) {
        return ResponseEntity.ok().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}
    @DeleteMapping("/deleteinstructor/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Integer id) {
    instructorService.deleteInstructor(id);
    return ResponseEntity.noContent().build();
}
}
