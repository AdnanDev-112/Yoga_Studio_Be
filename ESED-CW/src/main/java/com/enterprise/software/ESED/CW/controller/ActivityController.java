package com.enterprise.software.ESED.CW.controller;

import com.enterprise.software.ESED.CW.model.Activity;
import com.enterprise.software.ESED.CW.model.Manager;
import com.enterprise.software.ESED.CW.service.ActivityService;
import com.enterprise.software.ESED.CW.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/getmanagerdetails")
    public List<Manager> getActivityDetails(){
        return activityService.getActivityDetails();
    }



    @PostMapping("/addDetails")
    public Manager saveManagerDetails(@RequestBody Activity activity){
        return activityService.saveActivityDetails(activity);
    }

    @PutMapping("/update/{managerID}")
    public ResponseEntity<Void> updateActivityId(@PathVariable Long activityId, @RequestBody Activity activity){
        activityService.updateActivityId(activityId,activity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{managerID}")
    public ResponseEntity<Void> deleteActivityId(@PathVariable Long activityId){
        activityService.deleteActivityId(activityId);
        return ResponseEntity.noContent().build();
    }
}
