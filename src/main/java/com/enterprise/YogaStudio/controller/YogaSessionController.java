package com.enterprise.YogaStudio.controller;


import com.enterprise.YogaStudio.model.YogaSession;
import com.enterprise.YogaStudio.service.YogaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yogasession")
@CrossOrigin(origins = "http://localhost:3000")
public class YogaSessionController {

    @Autowired
    private YogaSessionService yogaSessionService;

    @GetMapping("/getactivitytype")
    public ResponseEntity<List<YogaSession>> getYogaSessionsWithRecurring() {
        List<YogaSession> yogaSessions = yogaSessionService.getYogaSessionsWithRecurring();
        if (!yogaSessions.isEmpty()) {
            return ResponseEntity.ok(yogaSessions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getyogasessionbyid/{id}")
    public ResponseEntity<YogaSession> getYogaSessionById(@PathVariable Integer id) {
        YogaSession yogaSession = yogaSessionService.getYogaSessionById(id);
        if (yogaSession != null) {
            return ResponseEntity.ok(yogaSession);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}