package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.dto.ScheduleFormDTO;
import com.enterprise.YogaStudio.model.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {

  //  List<ScheduleDTO> getScheduleList();

    List<Schedule> getBookingsByCategoryType(String categoryType, String clientID);
    List<Schedule> getScheduleList();

    List<Schedule> getScheduleByDescending();

    Schedule getScheduleById(Integer id);

    List<?> getScheduleByCategory(String categoryType);

    void addSchedule(ScheduleDTO schedule);
    void deleteSchedule(Integer id);
    Schedule updateSchedule(Integer id, Schedule schedule);

   // void addCourseSchedule(List<AddScheduleDTO> addScheduleDTO) throws Exception;
}
