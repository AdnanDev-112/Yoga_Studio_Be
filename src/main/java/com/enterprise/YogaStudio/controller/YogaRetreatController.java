package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.model.Course;
import com.enterprise.YogaStudio.model.YogaRetreat;
import com.enterprise.YogaStudio.service.YogaRetreatService;
import com.enterprise.YogaStudio.service.YogaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yogaretreat")
@CrossOrigin(origins = "http://localhost:3000")
public class YogaRetreatController {

    @Autowired
    private YogaRetreatService yogaRetreatService;
    @GetMapping("/getcourse/{id}")
    public ResponseEntity<YogaRetreat> getRetreatById(@PathVariable Integer id) {
        YogaRetreat yogaRetreat = yogaRetreatService.getRetreatById(id);
        if (yogaRetreat != null) {
            return ResponseEntity.ok(yogaRetreat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
