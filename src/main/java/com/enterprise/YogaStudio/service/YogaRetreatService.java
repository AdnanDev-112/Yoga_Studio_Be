package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.YogaRetreat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface YogaRetreatService {
    public List<YogaRetreat> getAllYogaRetreat();

    YogaRetreat getRetreatById(Integer id);
}
