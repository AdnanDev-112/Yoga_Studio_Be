package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.ScheduleDTO;
import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {

    List<ScheduleDTO> getScheduleList();
}
