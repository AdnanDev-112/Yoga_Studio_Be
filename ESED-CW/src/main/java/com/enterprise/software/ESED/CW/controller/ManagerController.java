package com.enterprise.software.ESED.CW.controller;

import com.enterprise.software.ESED.CW.model.Manager;
import com.enterprise.software.ESED.CW.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @GetMapping("/getmanagerdetails")
    public List<Manager> getManagerDetails(){
        return managerService.getManagerDetails();
    }



    @PostMapping("/addDetails")
    public Manager saveManagerDetails(@RequestBody Manager manager){
        return managerService.saveManagerDetails(manager);
    }

    @PutMapping("/update/{managerID}")
    public ResponseEntity<Void> updateManagerId(@PathVariable Long managerID, @RequestBody Manager manager){
        managerService.updateManagerId(managerID,manager);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{managerID}")
    public ResponseEntity<Void> deleteManagerId(@PathVariable Long managerID){
        managerService.deleteManagerId(managerID);
        return ResponseEntity.noContent().build();
    }


}
