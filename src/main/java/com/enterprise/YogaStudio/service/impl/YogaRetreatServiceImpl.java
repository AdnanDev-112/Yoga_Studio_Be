package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.YogaRetreatDTO;
import com.enterprise.YogaStudio.model.YogaRetreat;
import com.enterprise.YogaStudio.repository.YogaRetreatRepository;
import com.enterprise.YogaStudio.service.InstructorService;
import com.enterprise.YogaStudio.service.YogaRetreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YogaRetreatServiceImpl implements YogaRetreatService {

    @Autowired
    private YogaRetreatRepository yogaRetreatRepository;

    @Autowired
    private InstructorService instructorService;

    @Override
    public List<YogaRetreat> getAllYogaRetreats() {
        List<YogaRetreat> yogaRetreats = yogaRetreatRepository.findAll();
        for (YogaRetreat retreat : yogaRetreats) {
            retreat.setInstructorId(retreat.getInstructor().getId());
            retreat.setInstructorName(retreat.getInstructor().getInstructorName());
            retreat.setPricingAmount(retreat.getPricing().getAmount());
        }
        return yogaRetreats;
    }

    @Override
    public void addYogaRetreat(YogaRetreat yogaRetreat) {
        yogaRetreatRepository.save(yogaRetreat);
    }

    @Override
    public YogaRetreat getYogaRetreatById(Integer id) {

        return yogaRetreatRepository.findById(id).orElse(null);
    }

    @Override
    public YogaRetreat updateYogaRetreat(Integer id, YogaRetreatDTO yogaRetreatDetails) {
        return yogaRetreatRepository.findById(id)
                .map(yogaRetreat -> {
                    yogaRetreat.setRetreatName(yogaRetreatDetails.getRetreatName());
                    yogaRetreat.setActivityType(yogaRetreatDetails.getActivityType());
                    yogaRetreat.setMeal(yogaRetreatDetails.getMeal());
                    yogaRetreat.setDate(yogaRetreatDetails.getDate());

                    yogaRetreat.setInstructor(instructorService.getInstructorById(yogaRetreatDetails.getInstructorId()));

//                    yogaRetreat.setLocation(yogaRetreatDetails.getLocation());
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