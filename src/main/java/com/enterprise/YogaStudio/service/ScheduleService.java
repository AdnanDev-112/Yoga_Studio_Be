package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.dto.ScheduleFormDTO;
import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {



    public List<Schedule> getBookingsByCategoryType(String categoryType, String clientID);
    List<ScheduleDTO> getScheduleList();

    List<Schedule> getScheduleByCategoryType(String categoryType);

    Schedule addNewScheduleEntry(Schedule newEntry);
    Schedule addSchedule(ScheduleFormDTO scheduleForm);

    void deleteSchedule(Integer id);
}
