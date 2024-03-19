package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.YogaRetreatDTO;
import com.enterprise.YogaStudio.model.YogaRetreat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface YogaRetreatService {
    List<YogaRetreat> getAllYogaRetreats();

    void addYogaRetreat(YogaRetreat yogaRetreat);

    YogaRetreat getYogaRetreatById(Integer id);

    YogaRetreat updateYogaRetreat(Integer id, YogaRetreatDTO yogaRetreatDetails);

    void deleteYogaRetreat(Integer id);
}
