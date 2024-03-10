package com.enterprise.software.ESED.CW.controller;

import com.enterprise.software.ESED.CW.model.StudioModel;
import com.enterprise.software.ESED.CW.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studio")
public class StudioController {

    @Autowired
    StudioService studioService;

        @GetMapping("/getstudiodetails")
        public List<StudioModel> getStudioDetails(){
            return studioService.getStudioDetails();
        }

    @GetMapping("/getid/{studioID}")
    public StudioModel getStudioIDDetails(Long studioID){
        return studioService.getStudioIDDetails(studioID);
    }

    @PostMapping("/addDetails")
    public StudioModel saveStudioDetails(@RequestBody StudioModel studioModel){
        return studioService.addStudioDetails(studioModel);
    }

    @PutMapping("/update/{studioID}")
    public ResponseEntity<Void> updateStudioID(@PathVariable Long studioID, @RequestBody StudioModel studioModel){
        studioService.updateStudioID(studioID,studioModel);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{studioID}")
    public ResponseEntity<Void> deleteStudioId(@PathVariable Long studioID){
        studioService.deleteStudioId(studioID);
        return ResponseEntity.noContent().build();
    }

}
