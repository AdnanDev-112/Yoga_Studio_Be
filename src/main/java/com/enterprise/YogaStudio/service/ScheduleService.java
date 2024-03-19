package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.dto.ScheduleFormDTO;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.model.ScheduleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {

    List<ScheduleDTO> getScheduleList();

    Schedule addSchedule(ScheduleFormDTO scheduleForm);

    void deleteSchedule(Integer id);

    List<?> getScheduleByCategory(String categoryType);


    Schedule addNewScheduleEntry(ScheduleRequest newEntry);

    Schedule getScheduleById(Integer id);

    Schedule updateSchedule(Integer id, Schedule schedule);
}
