package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.ScheduleDTO;
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


//    @Override
//    public List<ScheduleDTO> getScheduleList() {
//        List<Schedule> schedules = scheduleRepository.findAll();
//        return schedules.stream().map(this::convertToDto).collect(Collectors.toList());
//    }


    @Override
    public void deleteSchedule(Integer id) {
        bookingRepository.deleteById(id);
        scheduleRepository.deleteById(id);
    }
//
//
//    private ScheduleDTO convertToDto(Schedule schedule) {
//        ScheduleDTO dto = new ScheduleDTO();
//        dto.setCategoryType(schedule.getCategoryType());
//        dto.setStartTime(schedule.getStartTime());
//
//        if (schedule.getYogaSession() != null) {
//            YogaSession yogaSession = schedule.getYogaSession();
//            dto.setLevel(yogaSession.getLevel());
//            dto.setInstructorName(yogaSession.getInstructor().getInstructorName());
//            dto.setDuration(yogaSession.getDuration());
//            dto.setMaxCapacity(yogaSession.getMaxCapacity());
//            dto.setRecurring(yogaSession.getRecurring().booleanValue());
//
//            if (yogaSession.getPricing() != null) {
//                dto.setAmount(yogaSession.getPricing().getAmount());
//            }
//
//            if (yogaSession.getStudio() != null) {
//                dto.setAddress(yogaSession.getStudio().getAddress());
//            }
//        }
//
//        return dto;
//    }


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


    @Override
    public Schedule addSchedule(ScheduleDTO schedule) {
        Schedule newSchedule = new Schedule();
        newSchedule.setCategoryType(schedule.getCategoryType());
        newSchedule.setDate(LocalDate.parse(schedule.getDate()));
        newSchedule.setStartTime(LocalTime.parse(schedule.getStartTime()));
        newSchedule.setEndTime(LocalTime.parse(schedule.getEndTime()));
        System.out.println(schedule.getCategoryType());
        switch (schedule.getCategoryType()) {
            case "yoga_session":
                newSchedule.setYogaSession(yogaSessionService.getYogaSessionById(Integer.parseInt(schedule.getSelectedSessionId())));
                break;
            case "retreat":
                newSchedule.setRetreat(yogaRetreatService.getRetreatById(Integer.parseInt(schedule.getSelectedSessionId())));
                break;
            case "course":
                newSchedule.setCourse(courseService.getCourseById(Integer.parseInt(schedule.getSelectedSessionId())));
                break;
            default:
                // Handle unsupported category type
                break;
        }

        return scheduleRepository.save(newSchedule);

    }

//
//    public boolean isScheduleConflict(AddScheduleDTO addScheduleDTO) {
//        List<Schedule> conflictingSchedules = scheduleRepository.findByDateAndTime(
//                addScheduleDTO.getDate(),
//                addScheduleDTO.getStartTime(),
//                addScheduleDTO.getEndTime());
//        return !conflictingSchedules.isEmpty();
//    }
//
//    @Override
//    public void addCourseSchedule(List<AddScheduleDTO> addScheduleDTO) throws Exception {
//        for (AddScheduleDTO addSchedule : addScheduleDTO) {
//            if (isScheduleConflict(addSchedule)) {
//                throw new Exception("There is a schedule conflict. Please choose a different date/time.");
//            }
//            Schedule schedule = new Schedule();
//            schedule.setRetreatId(addSchedule.getRetreatId());
//            schedule.setYogasessionId(addSchedule.getYogasessionId());
//            schedule.setCourseId(addSchedule.getCourseId());
//            schedule.setDate(addSchedule.getDate());
//            schedule.setStartTime(addSchedule.getStartTime());
//            schedule.setEndTime(addSchedule.getEndTime());
//            scheduleRepository.save(schedule);
//        }
//    }
}

