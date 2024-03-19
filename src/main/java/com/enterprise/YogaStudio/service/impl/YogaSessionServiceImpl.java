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
    public List<YogaSession> getYogaSession() {
        return yogaSessionRepository.findAll();
    }
    @Override
    public void addYogaSession(YogaSession yogaSession) {
        yogaSessionRepository.save(yogaSession);
    }
    @Override
    public YogaSession getYogaSessionById(Integer id) {
        return yogaSessionRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteYogaSession(Integer id) {
        yogaSessionRepository.deleteById(id);
    }

    @Override
    public YogaSession updateYogaSession(Integer id, YogaSession yogaSessionDetails) {
        return yogaSessionRepository.findById(id)
                .map(yogaSession -> {
                    yogaSession.setDuration(yogaSessionDetails.getDuration());
                    yogaSession.setLevel(yogaSessionDetails.getLevel());
                    yogaSession.setActivityType(yogaSessionDetails.getActivityType());

                    return yogaSessionRepository.save(yogaSession);
                })
                .orElse(null);
    }
}
