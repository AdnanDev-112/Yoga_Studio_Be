package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.YogaSession;
import com.enterprise.YogaStudio.repository.YogaSessionRepository;
import com.enterprise.YogaStudio.service.YogaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YogaSessionServiceImpl implements YogaSessionService {

    @Autowired
    private YogaSessionRepository yogaSessionRepository;

    @Override
    public List<YogaSession> getAllYogaSessions() {
        return yogaSessionRepository.findAll();
    }

    @Override
    public List<YogaSession> getYogaSessionsWithRecurring() {
        return yogaSessionRepository.findClassTypeByRecurring(true);
    }

    @Override
    public YogaSession getYogaSessionById(Integer id) {
        return yogaSessionRepository.findById(id).orElse(null);
    }

}
