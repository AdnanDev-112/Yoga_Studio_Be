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

    // Calculate the discounted price
    public BigDecimal calculateDiscountedPrice(BigDecimal originalPrice, BigDecimal discountPercent) {
        return originalPrice.multiply(BigDecimal.ONE.subtract(discountPercent.divide(new BigDecimal("100"))));

    }

    @Override
    public List<ScheduleDTO> getScheduleList() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    @Override
    public Schedule addSchedule(ScheduleFormDTO scheduleForm) {
        Schedule schedule = convertScheduledFormDTOToSchedule(scheduleForm);
        return scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(Integer id) {
        bookingRepository.deleteById(id);
        scheduleRepository.deleteById(id);
    }


    private Schedule convertScheduledFormDTOToSchedule(ScheduleFormDTO scheduleForm) {
        Schedule schedule = new Schedule();
        schedule.setCategoryType(scheduleForm.getCategoryType());
        schedule.setStartTime(scheduleForm.getStartTime());
        schedule.setDate(scheduleForm.getDate());
        scheduleForm.setEndTime(scheduleForm.getEndTime());
        return schedule;
    }

    private ScheduleDTO convertToDto(Schedule schedule) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setCategoryType(schedule.getCategoryType());
        dto.setStartTime(schedule.getStartTime());

        // Assuming `YogaSession` and `Pricing` are properties of `Schedule`
        if (schedule.getYogaSession() != null) {
            YogaSession yogaSession = schedule.getYogaSession();
            dto.setLevel(yogaSession.getLevel());
            dto.setInstructorName(yogaSession.getInstructor().getInstructorName());
            dto.setDuration(yogaSession.getDuration());
            dto.setMaxCapacity(yogaSession.getMaxCapacity());
            dto.setRecurring(yogaSession.getRecurring().booleanValue());

            // Check if Pricing is not null before accessing it
            if (yogaSession.getPricing() != null) {
                dto.setAmount(yogaSession.getPricing().getAmount());
                dto.setManagerName(yogaSession.getManager().getManagerName());
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
    public Schedule addNewScheduleEntry(ScheduleRequest newEntry) {
        Schedule schedule = scheduleFormtoDTO(newEntry);
        return scheduleRepository.save(schedule);
    }


    private Schedule scheduleFormtoDTO(ScheduleRequest newEntry) {
        Schedule schedule = new Schedule();
        schedule.setCategoryType(newEntry.getCategory_type());
        schedule.setStartTime(LocalTime.parse(newEntry.getStartTime()));
        schedule.setDate(newEntry.getDate());
        schedule.setEndTime(LocalTime.parse(newEntry.getEndTime()));
        newEntry.setScheduleId(newEntry.getScheduleId());
        return schedule;
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

