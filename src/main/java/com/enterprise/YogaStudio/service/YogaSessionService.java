package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.model.YogaSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface YogaSessionService {
    public List<?> getAllYogaSessions();
}
