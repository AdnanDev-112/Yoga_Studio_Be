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

    void addSchedule(ScheduleDTO schedule);

    List<Schedule> getScheduleList();

    void deleteSchedule(Integer id);

    Schedule getScheduleById(Integer id);

    List<?> getScheduleByCategory(String categoryType);

    Schedule updateSchedule(Integer id, Schedule schedule);

   // void addCourseSchedule(List<AddScheduleDTO> addScheduleDTO) throws Exception;
}
