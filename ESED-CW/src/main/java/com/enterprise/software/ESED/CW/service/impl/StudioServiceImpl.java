package com.enterprise.software.ESED.CW.service.impl;

import com.enterprise.software.ESED.CW.model.StudioModel;
import com.enterprise.software.ESED.CW.repository.StudioRepository;
import com.enterprise.software.ESED.CW.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioRepository studioRepository;

    @Override
    public StudioModel addStudioDetails(StudioModel studioModel) {
        return studioRepository.save(studioModel);
    }

    @Override
    public List<StudioModel> getStudioDetails() {
        return studioRepository.findAll();
    }

    @Override
    public StudioModel getStudioIDDetails(Long studioID) {
        StudioModel studioModel = studioRepository.findById(studioID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Studio ID not found. " + studioID));
        return studioModel;
    }

    @Override
    public void updateStudioID(Long studioID, StudioModel studioModel) {
        studioRepository.findById(studioID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid studio ID." + studioID));
        studioModel.setStudioId(studioID);
        studioRepository.save(studioModel);
    }

    @Override
    public void deleteStudioId(Long studioID) {
       StudioModel studioModel=  studioRepository.findById(studioID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid studio ID." + studioID));
       studioRepository.delete(studioModel);
    }
}
