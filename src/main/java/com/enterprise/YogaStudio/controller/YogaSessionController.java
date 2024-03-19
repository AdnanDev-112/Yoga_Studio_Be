package com.enterprise.YogaStudio.controller;


import com.enterprise.YogaStudio.model.*;
import com.enterprise.YogaStudio.service.InstructorService;
import com.enterprise.YogaStudio.service.YogaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yoga_session")
@CrossOrigin(origins = "http://localhost:3000")
public class YogaSessionController {

    @Autowired
    private YogaSessionService yogaSessionService;

    @GetMapping("/getYogaSessions")
    public List<YogaSession> getYogaSessions() {
        return yogaSessionService.getYogaSession();
    }

    @PostMapping("/addYogaSession")
    public ResponseEntity<YogaSession> addYogaSession(@RequestBody YogaSession yogaSession) {
        Instructor instructor = new Instructor();
        instructor.setId(2);
        yogaSession.setInstructor(instructor);

        Manager manager = new Manager();
        manager.setId(2);
        yogaSession.setManager(manager);

        yogaSession.setMaxCapacity(500);

        Pricing pricing = new Pricing();
        pricing.setId(3);
        yogaSession.setPricing(pricing);

        Studio studio = new Studio();
        studio.setId(6);
        yogaSession.setStudio(studio);

        yogaSessionService.addYogaSession(yogaSession);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletesession/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer id) {
        yogaSessionService.deleteYogaSession(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/updatesession/{id}")
    public ResponseEntity<Instructor> updatesession(@PathVariable Integer id, @RequestBody YogaSession yogaSession) {
        YogaSession updatedyogaSession = yogaSessionService.updateYogaSession(id, yogaSession);
        if (updatedyogaSession != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getoneyogasession/{id}")
    public ResponseEntity<YogaSession> getYogaSessionById(@PathVariable Integer id) {
        YogaSession yogaSession = yogaSessionService.getYogaSessionById(id);
        if (yogaSession != null) {
            return ResponseEntity.ok(yogaSession);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
