package com.enterprise.YogaStudio.service;


import com.enterprise.YogaStudio.model.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {



    public List<Schedule> getBookingsByCategoryType(String categoryType, String clientID);
}
