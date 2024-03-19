package com.enterprise.YogaStudio.controller;


import com.enterprise.YogaStudio.model.Instructor;
import com.enterprise.YogaStudio.model.Pricing;
import com.enterprise.YogaStudio.model.Studio;
import com.enterprise.YogaStudio.model.YogaSession;
import com.enterprise.YogaStudio.service.InstructorService;
import com.enterprise.YogaStudio.service.PricingService;
import com.enterprise.YogaStudio.service.StudioService;
import com.enterprise.YogaStudio.service.YogaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/yoga_session")
@CrossOrigin(origins = "http://localhost:3000")
public class YogaSessionController {
    @Autowired
    private YogaSessionService yogaSessionService;

    @Autowired
    private StudioService studioService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private PricingService pricingService;

    @GetMapping("/getYogaSessions")
    public List<YogaSession> getYogaSessions() {
        return yogaSessionService.getYogaSession();
    }

    @PostMapping("/addYogaSession")
    public ResponseEntity<YogaSession> addYogaSession(@RequestBody YogaSession yogaSession) {

        Studio studio = studioService.getStudioById(Integer.valueOf(yogaSession.getStudioId()));
        Instructor instructor = instructorService.getInstructorById(Integer.valueOf(yogaSession.getInstructorId()));

        String priceFromForm = yogaSession.getPrice();
        BigDecimal price = new BigDecimal(priceFromForm);
        Pricing pricing = new Pricing();
        pricing.setAmount(price);
        pricing.setLevel(yogaSession.getLevel());
        pricing.setType("yoga_session");



        Pricing savedPrice = pricingService.addPricingDetails(pricing);

        yogaSession.setStudio(studio);
        yogaSession.setPricing(savedPrice);
        yogaSession.setInstructor(instructor);

        yogaSessionService.addYogaSession(yogaSession);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletesession/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer id) {
        yogaSessionService.deleteYogaSession(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/updatesession/{id}")
    public ResponseEntity<YogaSession> updatesession(@PathVariable Integer id, @RequestBody YogaSession yogaSession) {
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