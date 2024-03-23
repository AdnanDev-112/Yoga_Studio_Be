
package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.model.Studio;
import com.enterprise.YogaStudio.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studio")
public class StudioController {

    @Autowired
    private StudioService studioService;

    @GetMapping("/getstudioslist")
    public List<Studio> getStudioDetails(){
        return studioService.getStudioDetails();
    }

    @GetMapping("/getstudiobyid/{id}")
    public ResponseEntity<Studio> getStudioById(@PathVariable Integer id) {
        Studio studio = studioService.getStudioById(id);
        if (studio != null) {
            return ResponseEntity.ok(studio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}



