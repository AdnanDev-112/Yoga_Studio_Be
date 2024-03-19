package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Studio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudioService {

//    public Studio addStudioDetails(Studio studioModel);

//
    List<Studio> getStudioDetails();
//
    Studio getStudioById(Integer studioID);
//
// //   void updateStudioID(Integer studioID, Studio studio);
//
//    void deleteStudioId(Integer studioID);

//    void updateStudioAndManager(Integer studioID, UpdateStudioDetails updateStudioDetails);
}
