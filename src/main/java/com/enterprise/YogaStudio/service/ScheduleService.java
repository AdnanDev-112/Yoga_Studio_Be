package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.model.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {

  //  List<ScheduleDTO> getScheduleList();

    void addSchedule(ScheduleDTO schedule);

    void deleteSchedule(Integer id);

    List<?> getScheduleByCategory(String categoryType);

    Schedule getScheduleById(Integer id);

    Schedule updateSchedule(Integer id, Schedule schedule);

   // void addCourseSchedule(List<AddScheduleDTO> addScheduleDTO) throws Exception;
}
