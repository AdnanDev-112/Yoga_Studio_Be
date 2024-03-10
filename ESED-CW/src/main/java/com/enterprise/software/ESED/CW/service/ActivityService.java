package com.enterprise.software.ESED.CW.service;

import com.enterprise.software.ESED.CW.model.Activity;
import com.enterprise.software.ESED.CW.model.Manager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {


    List<Manager> getActivityDetails();

    Manager saveActivityDetails(Activity activity);

    void deleteActivityId(Long activityId);

    void updateActivityId(Long activityId, Activity activity);
}
