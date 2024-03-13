package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PutMapping("/update/{managerId}")
    public ResponseEntity<Void> updateManagerId(@PathVariable Integer managerId, @RequestBody Manager manager){
        managerService.updateManagerId(managerId,manager);
        return ResponseEntity.noContent().build();
    }

}
