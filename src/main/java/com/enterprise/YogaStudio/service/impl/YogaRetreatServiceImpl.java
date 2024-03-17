package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.YogaRetreat;
import com.enterprise.YogaStudio.repository.YogaRetreatRepository;
import com.enterprise.YogaStudio.service.YogaRetreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YogaRetreatServiceImpl implements YogaRetreatService {

    @Autowired
    private YogaRetreatRepository yogaRetreatRepository;

    @Override
    public List<YogaRetreat> getAllYogaRetreats() {
        List<YogaRetreat> yogaRetreats = yogaRetreatRepository.findAll();
        for (YogaRetreat retreat : yogaRetreats) {
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
    public YogaRetreat updateYogaRetreat(Integer id, YogaRetreat yogaRetreatDetails) {
        return yogaRetreatRepository.findById(id)
                .map(yogaRetreat -> {
                    yogaRetreat.setRetreatName(yogaRetreatDetails.getRetreatName());
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