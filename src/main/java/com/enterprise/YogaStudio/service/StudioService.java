package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.StudioDTO;
import com.enterprise.YogaStudio.model.Studio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudioService {

    List<Studio> getStudioDetails();

    Studio getStudioById(Integer id);
}

