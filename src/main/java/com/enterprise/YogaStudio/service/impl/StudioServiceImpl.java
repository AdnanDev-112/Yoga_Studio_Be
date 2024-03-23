package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Studio;
import com.enterprise.YogaStudio.repository.StudioRepository;
import com.enterprise.YogaStudio.service.StudioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
@Transactional
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioRepository studioRepository;

    public List<Studio> getStudioDetails() {
        return studioRepository.findAll();
    }

    @Override
    public Studio getStudioById(Integer id) {
        return studioRepository.findById(id).orElse(null);
    }


}







