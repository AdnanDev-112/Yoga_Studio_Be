package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.dto.ScheduleFormDTO;
import com.enterprise.YogaStudio.model.*;
import com.enterprise.YogaStudio.service.ClientService;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.enterprise.YogaStudio.dto.ScheduleDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "http://localhost:3000")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/addschedule")
    public ResponseEntity<Schedule> addSchedule(@RequestBody ScheduleFormDTO scheduleform) {
        scheduleService.addSchedule(scheduleform);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getschedulelist")
    public ResponseEntity<List<ScheduleDTO>> getScheduleList() {
        List<ScheduleDTO> schedule = scheduleService.getScheduleList();
        return ResponseEntity.ok(schedule);
    }

    @DeleteMapping("/deleteschedule/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getcategorizedschedule")
    public ResponseEntity<List<?>> getScheduleByCategory(@RequestParam String categoryType) {
        List<?> schedules = scheduleService.getScheduleByCategory(categoryType);
        return ResponseEntity.ok(schedules);
    }

    @PostMapping("/addnewscheduleentry")
    public ResponseEntity<Schedule> addNewScheduleEntry(@RequestBody ScheduleRequest newEntry) {
        Schedule schedule = scheduleService.addNewScheduleEntry(newEntry);
        return ResponseEntity.ok(schedule);
    }

    @GetMapping("/getschedule/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Integer id) {
        Schedule schedule = scheduleService.getScheduleById(id);
        if (schedule != null) {
            return ResponseEntity.ok(schedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateclient/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Integer id, @RequestBody Schedule schedule) {
        Schedule updateschedule = scheduleService.updateSchedule(id, schedule);
        if (updateschedule != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
