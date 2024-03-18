package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.BookingDTO;
import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.dto.ScheduleFormDTO;
import com.enterprise.YogaStudio.model.*;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.repository.CourseRepository;
import com.enterprise.YogaStudio.repository.ScheduleRepository;
import com.enterprise.YogaStudio.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private List<ScheduleDTO> schedules = new ArrayList<>();

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private BookingRepository bookingRepository;

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

        // Set other properties of ScheduleDTO as needed
        return dto;
    }
}
