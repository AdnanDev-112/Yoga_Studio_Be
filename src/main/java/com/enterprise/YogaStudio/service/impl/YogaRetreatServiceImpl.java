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
    public List<YogaRetreat> getAllYogaRetreat() {
        return yogaRetreatRepository.findAll();
    }
}
