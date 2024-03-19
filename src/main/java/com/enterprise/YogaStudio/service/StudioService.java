package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.StudioDTO;
import com.enterprise.YogaStudio.model.Studio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudioService {
    List<StudioDTO> getAllStudioLocations();

    Studio getStudioById(Integer integer);

//    public Studio addStudioDetails(Studio studioModel);
//
//
//    List<Studio> getStudioDetails();
//
//    Studio getStudioIDDetails(Integer studioID);
//
// //   void updateStudioID(Integer studioID, Studio studio);
//
//    void deleteStudioId(Integer studioID);
//
//    void updateStudioAndManager(Integer studioID, UpdateStudioDetails updateStudioDetails);
}
