package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.YogaRetreatDTO;
import com.enterprise.YogaStudio.model.Instructor;
import com.enterprise.YogaStudio.model.Pricing;
import com.enterprise.YogaStudio.model.YogaRetreat;
import com.enterprise.YogaStudio.model.YogaSession;
import com.enterprise.YogaStudio.repository.YogaRetreatRepository;
import com.enterprise.YogaStudio.service.InstructorService;
import com.enterprise.YogaStudio.service.PricingService;
import com.enterprise.YogaStudio.service.YogaRetreatService;
import com.enterprise.YogaStudio.service.YogaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YogaRetreatServiceImpl implements YogaRetreatService {
    @Autowired
    private YogaRetreatRepository yogaRetreatRepository;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    PricingService pricingService;
    @Autowired
    YogaSessionService yogaSessionService;
    @Override
    public List<YogaRetreat> getAllYogaRetreats() {
        return  yogaRetreatRepository.findAll();
    }
    @Override
    public void addYogaRetreat(YogaRetreat yogaRetreat) {
        Instructor instructor = instructorService.getInstructorById(yogaRetreat.getInstructorId());
        Pricing pricing = pricingService.validateAmountExists(yogaRetreat.getPrice());
        YogaSession yogaSession = yogaSessionService.getYogaSessionById(yogaRetreat.getWorkshopId());
        yogaRetreat.setYogaSession(yogaSession);
        yogaRetreat.setPricing(pricing);
        yogaRetreat.setInstructor(instructor);
        yogaRetreatRepository.save(yogaRetreat);
    }
    @Override
    public YogaRetreat getYogaRetreatById(Integer id) {
        return yogaRetreatRepository.findById(id).orElse(null);
    }
    @Override
    public YogaRetreat updateYogaRetreat(Integer id, YogaRetreat yogaRetreatDetails) {
        return yogaRetreatRepository.findById(id)
                .map(yogaRetreat -> {
                    yogaRetreat.setInstructor(instructorService.getInstructorById(yogaRetreatDetails.getInstructorId()));
                    Pricing pricing = pricingService.validateAmountExists(yogaRetreatDetails.getPrice());
                    YogaSession yogaSession = yogaSessionService.getYogaSessionById(yogaRetreatDetails.getWorkshopId());
                    yogaRetreat.setPricing(pricing);
                    yogaRetreat.setYogaSession(yogaSession);
                    // Set other fields as needed
                    return yogaRetreatRepository.save(yogaRetreat);
                })
                .orElse(null);
    }
    @Override
    public void deleteYogaRetreat(Integer id) {
        yogaRetreatRepository.deleteById(id);
    }
}