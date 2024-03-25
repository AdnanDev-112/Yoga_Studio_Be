package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.YogaSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface YogaSessionService {
    public List<YogaSession> getYogaSession();
    void addYogaSession(YogaSession yogaSession);
    public YogaSession getYogaSessionById(Integer id);
    List<YogaSession> getYogaSessionsWithRecurring();
    void deleteYogaSession(Integer id);
    YogaSession updateYogaSession(Integer id, YogaSession yogaSession);
    List<YogaSession> getSessionsByWorkshop();
}



