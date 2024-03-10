package com.enterprise.software.ESED.CW.service;


import com.enterprise.software.ESED.CW.model.StudioModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudioService {

public StudioModel addStudioDetails(StudioModel studioModel);


    List<StudioModel> getStudioDetails();

    StudioModel getStudioIDDetails(Long studioID);

    void updateStudioID(Long studioID, StudioModel studioModel);

    void deleteStudioId(Long studioID);
}
