package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.model.YogaRetreat;
import com.enterprise.YogaStudio.service.YogaRetreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yogaretreat")
@CrossOrigin(origins = "http://localhost:3000")

public class YogaRetreatController {
    @Autowired
    private YogaRetreatService yogaRetreatService;

    @GetMapping
    public List<YogaRetreat> getAllYogaRetreats() {
        return yogaRetreatService.getAllYogaRetreats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<YogaRetreat> getYogaRetreatById(@PathVariable Integer id) {
        YogaRetreat yogaRetreat = yogaRetreatService.getYogaRetreatById(id);
        return yogaRetreat != null ? ResponseEntity.ok(yogaRetreat) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> addYogaRetreat(@RequestBody YogaRetreat yogaRetreat) {
        yogaRetreatService.addYogaRetreat(yogaRetreat);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateYogaRetreat(@PathVariable Integer id, @RequestBody YogaRetreat yogaRetreatDetails) {
        if (yogaRetreatService.updateYogaRetreat(id, yogaRetreatDetails) != null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteYogaRetreat(@PathVariable Integer id) {
        yogaRetreatService.deleteYogaRetreat(id);
        return ResponseEntity.noContent().build();
    }
}
