package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Manager;
import org.springframework.stereotype.Service;

@Service
public interface ManagerService {
    void updateManagerId(Integer managerId, Manager manager);
}
