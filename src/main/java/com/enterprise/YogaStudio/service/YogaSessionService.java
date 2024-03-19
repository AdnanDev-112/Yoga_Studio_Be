package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Instructor;
import com.enterprise.YogaStudio.model.YogaSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface YogaSessionService {
    public List<YogaSession> getYogaSession();

    void addYogaSession(YogaSession yogaSession);
    public YogaSession getYogaSessionById(Integer id);

    //Instructor updateInstructor(Integer id, Instructor instructorDetails);

    void deleteYogaSession(Integer id);

    YogaSession updateYogaSession(Integer id, YogaSession yogaSession);
}
