package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.CourseExtendedDataDTO;
import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.model.Course;
import com.enterprise.YogaStudio.model.YogaSession;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.repository.ScheduleRepository;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.repository.ClientRepository;
import com.enterprise.YogaStudio.repository.YogaSessionRepository;
import com.enterprise.YogaStudio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private YogaRetreatService yogaRetreatService;

    @Autowired
    private YogaSessionService yogaSessionService;

    @Autowired
    private CourseService courseService;

    @Override
    public void deleteSchedule(Integer id) {
        bookingRepository.deleteById(id);
        scheduleRepository.deleteById(id);
    }

    @Override
    public List<?> getScheduleByCategory(String categoryType) {
        List<?> data = new ArrayList<>();
        switch (categoryType) {
            case "yoga_session":
                data = yogaSessionService.getAllYogaSessions();
                break;

            case "retreat":
                data = yogaRetreatService.getAllYogaRetreat();
                break;

            case "course":
                data = courseService.getCourses();
                break;

        }
        return data;
    }

    @Override
    public Schedule getScheduleById(Integer id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    @Override
    public Schedule updateSchedule(Integer id, Schedule schedule) {
        return scheduleRepository.findById(id)
                .map(schedule1 -> {
                    schedule1.setCategoryType(schedule.getCategoryType());
                    schedule1.setDate(schedule1.getDate());
                    schedule1.setStartTime(schedule1.getStartTime());
                    schedule1.setEndTime(schedule1.getEndTime());
                    return scheduleRepository.save(schedule1);
                })
                .orElse(null);
    }

    private void processSchedule(ScheduleDTO schedule) {
        ArrayList<Map<String, String>> classesList = schedule.getClasses();

            for (Map<String, String> classData : classesList) {

                Schedule newSchedule = new Schedule();
                newSchedule.setDate(LocalDate.parse(classData.get("classDate")));
                newSchedule.setStartTime(LocalTime.parse(classData.get("classStartTime")));
                newSchedule.setEndTime(LocalTime.parse(classData.get("classEndTime")));
                newSchedule.setCategoryType(schedule.getCategoryType());
                newSchedule.setCourse(courseService.getCourseById(Integer.parseInt(schedule.getSelectedSessionId())));
                scheduleRepository.save(newSchedule);
            }


    }


    @Override
    public void addSchedule(ScheduleDTO schedule) {
        Schedule newSchedule = new Schedule();
        newSchedule.setCategoryType(schedule.getCategoryType());

        if (schedule.getCategoryType().equals("yoga_session") || schedule.getCategoryType().equals("retreat")) {
            newSchedule.setDate(LocalDate.parse(schedule.getDate()));
            newSchedule.setStartTime(LocalTime.parse(schedule.getStartTime()));
            newSchedule.setEndTime(LocalTime.parse(schedule.getEndTime()));
            switch (schedule.getCategoryType()) {
                case "yoga_session":
                    newSchedule.setYogaSession(yogaSessionService.getYogaSessionById(Integer.parseInt(schedule.getSelectedSessionId())));
                    break;
                case "retreat":
                    newSchedule.setRetreat(yogaRetreatService.getRetreatById(Integer.parseInt(schedule.getSelectedSessionId())));
                    break;
                default:
                    break;
            }
            scheduleRepository.save(newSchedule);
        } else {
            processSchedule(schedule);

    }
    }





    public boolean isScheduleConflict(ScheduleDTO scheduleDTO) {
        LocalDate date = LocalDate.parse(scheduleDTO.getDate());
        LocalTime startTime = LocalTime.parse(scheduleDTO.getStartTime());
        LocalTime endTime = LocalTime.parse(scheduleDTO.getEndTime());
        List<Schedule> conflictingSchedules = scheduleRepository.findByDateAndTime(date, startTime, endTime);
        return !conflictingSchedules.isEmpty();
    }


}


