package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.service.*;
import com.enterprise.YogaStudio.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "http://localhost:3000")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

//    @GetMapping("/getschedulelist")
//    public ResponseEntity<List<ScheduleDTO>> getScheduleList() {
//        List<ScheduleDTO> schedule = scheduleService.getScheduleList();
//        return ResponseEntity.ok(schedule);
//    }
    @Autowired
    private YogaRetreatService yogaRetreatService;

    @Autowired
    private YogaSessionService yogaSessionService;

    @Autowired
    private CourseService courseService;

    //add function for yoga session and yoga retreat
    @PostMapping("/addschedule")
    public ResponseEntity<ScheduleDTO> addSchedule(@RequestBody ScheduleDTO schedule) {
        scheduleService.addSchedule(schedule);
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/addcourseclasses")
//    public ResponseEntity<AddScheduleDTO> addCourseSchedule(@RequestBody List<AddScheduleDTO> addScheduleDTO) throws Exception {
//        scheduleService.addCourseSchedule(addScheduleDTO);
//        return ResponseEntity.ok().build();
//    }


    @GetMapping("/getschedulebycategory")
    public ResponseEntity<List<Schedule>> getBookingByCategory(@RequestParam String categoryType, @RequestParam String clientID) {

        List<Schedule> schedules = scheduleService.getBookingsByCategoryType(categoryType, clientID);


        return ResponseEntity.ok(schedules);
    }





//    @PostMapping("/addnewscheduleentry")
//    public Schedule addNewScheduleEntry(@RequestBody Schedule newEntry) {
//        return scheduleService.addNewScheduleEntry(newEntry);
//    }

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

    @GetMapping("/getschedule/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Integer id) {
        Schedule schedule = scheduleService.getScheduleById(id);
        if (schedule != null) {
            return ResponseEntity.ok(schedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//
//    @PutMapping("/updateclient/{id}")
//    public ResponseEntity<Schedule> updateSchedule(@PathVariable Integer id, @RequestBody Schedule schedule) {
//        Schedule updateschedule = scheduleService.updateSchedule(id, schedule);
//        if (updateschedule != null) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
