package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.model.Pricing;
import com.enterprise.YogaStudio.model.Instructor;
import com.enterprise.YogaStudio.model.YogaSession;
import com.enterprise.YogaStudio.dto.YogaRetreatDTO;
import com.enterprise.YogaStudio.model.YogaRetreat;
import com.enterprise.YogaStudio.service.ClientService;
import com.enterprise.YogaStudio.service.InstructorService;
import com.enterprise.YogaStudio.service.YogaRetreatService;
import com.enterprise.YogaStudio.service.impl.InstructorServiceImpl;
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

    @Autowired
    private InstructorService instructorService;
    @GetMapping("/getyogaretreatlist")
    public List<YogaRetreat> getAllYogaRetreats() {
        return yogaRetreatService.getAllYogaRetreats();
    }

    @GetMapping("/getyogaretreat/{id}")
    public ResponseEntity<YogaRetreat> getYogaRetreatById(@PathVariable Integer id) {
        YogaRetreat yogaRetreat = yogaRetreatService.getYogaRetreatById(id);
        yogaRetreat.setInstructorId(yogaRetreat.getInstructor().getId());
        return yogaRetreat != null ? ResponseEntity.ok(yogaRetreat) : ResponseEntity.notFound().build();
    }

    @PostMapping("/addyogaretreat")
    public ResponseEntity<Void> addYogaRetreat(@RequestBody YogaRetreatDTO yogaRetreatDto) {
        YogaRetreat yogaRetreat = new YogaRetreat();
        yogaRetreat.setRetreatName(yogaRetreatDto.getRetreatName());
        yogaRetreat.setMeal(yogaRetreatDto.getMeal());
        yogaRetreat.setActivityType(yogaRetreatDto.getActivityType());
        yogaRetreat.setDate(yogaRetreatDto.getDate());


        Pricing prc = new Pricing();
        prc.setId(1);
        yogaRetreat.setPricing(prc);

//        Instructor instr = new Instructor();
//        instr.setId(yogaRetreatDto.getInstructorId());
//        InstructorServiceImpl inst = new InstructorServiceImpl();
        yogaRetreat.setInstructor(instructorService.getInstructorById(yogaRetreatDto.getInstructorId()));

        YogaSession yogasess = new YogaSession();
        yogasess.setId(1);
        yogaRetreat.setYogaSession(yogasess);



        yogaRetreatService.addYogaRetreat(yogaRetreat);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateyogaretreat/{id}")
    public ResponseEntity<Void> updateYogaRetreat(@PathVariable Integer id, @RequestBody YogaRetreatDTO yogaRetreatDetails) {
        if (yogaRetreatService.updateYogaRetreat(id, yogaRetreatDetails) != null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteyogaretreat/{id}")
    public ResponseEntity<Void> deleteYogaRetreat(@PathVariable Integer id) {
        yogaRetreatService.deleteYogaRetreat(id);
        return ResponseEntity.noContent().build();
    }
}
