package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.service.ClientService;
import com.enterprise.YogaStudio.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "http://localhost:3000")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/getschedulelist")
    public ResponseEntity<List<ScheduleDTO>> getScheduleList() {
        List<ScheduleDTO> schedule = scheduleService.getScheduleList();
        return ResponseEntity.ok(schedule);
    }
}
