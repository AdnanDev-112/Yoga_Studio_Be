package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.dto.ScheduleFormDTO;
import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Instructor;
import com.enterprise.YogaStudio.model.Schedule;
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

    @GetMapping("/getschedulebycategory")
    public ResponseEntity<List<Schedule>> getBookingByCategory(@RequestParam String categoryType, @RequestParam String clientID) {

    List<Schedule> schedules = scheduleService.getBookingsByCategoryType(categoryType, clientID);


    return ResponseEntity.ok(schedules);
    }

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



    @PostMapping("/addnewscheduleentry")
    public Schedule addNewScheduleEntry(@RequestBody Schedule newEntry) {
        return scheduleService.addNewScheduleEntry(newEntry);
    }

    @DeleteMapping("/deleteschedule/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

}
