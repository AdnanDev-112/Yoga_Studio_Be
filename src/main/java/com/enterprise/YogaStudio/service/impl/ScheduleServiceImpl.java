package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.dto.ScheduleFormDTO;
import com.enterprise.YogaStudio.model.*;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.repository.ScheduleRepository;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.repository.ClientRepository;
import com.enterprise.YogaStudio.repository.YogaSessionRepository;
import com.enterprise.YogaStudio.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import java.math.BigDecimal;

@Service
public class ScheduleServiceImpl implements ScheduleService {


    private List<ScheduleDTO> schedules = new ArrayList<>();

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private YogaRetreatService yogaRetreatService;

    @Autowired
    private YogaSessionService yogaSessionService;

    @Autowired
    private DiscountCalculationService discountCalculationService;
    @Autowired
    private YogaSessionRepository yogaSessionRepository;

    @Autowired
    private CourseService courseService;


    @Override
    public List<ScheduleDTO> getScheduleList() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    @Override
    public Schedule addSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(Integer id) {
        bookingRepository.deleteById(id);
        scheduleRepository.deleteById(id);
    }


    private ScheduleDTO convertToDto(Schedule schedule) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setCategoryType(schedule.getCategoryType());
        dto.setStartTime(schedule.getStartTime());

        if (schedule.getYogaSession() != null) {
            YogaSession yogaSession = schedule.getYogaSession();
            dto.setLevel(yogaSession.getLevel());
            dto.setInstructorName(yogaSession.getInstructor().getInstructorName());
            dto.setDuration(yogaSession.getDuration());
            dto.setMaxCapacity(yogaSession.getMaxCapacity());
            dto.setRecurring(yogaSession.getRecurring().booleanValue());

            if (yogaSession.getPricing() != null) {
                dto.setAmount(yogaSession.getPricing().getAmount());
            }

            if (yogaSession.getStudio() != null) {
                dto.setAddress(yogaSession.getStudio().getAddress());
            }
        }

        return dto;
    }


    @Override
    public List<?> getScheduleByCategory(String categoryType) {
        List<?> data = new ArrayList<>();
        switch (categoryType){
            case "yoga_session":
                data =  yogaSessionService.getAllYogaSessions();
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
    public Schedule addNewScheduleEntry(Schedule schedule) {
        YogaRetreat yogaRetreat = yogaRetreatService.getRetreatById(schedule.getRetreatId());
        YogaSession yogaSession = yogaSessionService.getYogaSessionById(schedule.getYogasessionId());
        Course course = courseService.getCourseById(schedule.getCourseId());
        schedule.setYogaSession(yogaSession);
        schedule.setRetreat(yogaRetreat);
        schedule.setCourse(course);
        return scheduleRepository.save(schedule);
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


}

