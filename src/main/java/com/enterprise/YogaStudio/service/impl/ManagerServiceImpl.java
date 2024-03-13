package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.repository.ManagerRepository;
import com.enterprise.YogaStudio.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public void updateManagerId(Integer managerId, Manager manager) {
        Manager manager1 = managerRepository.findById(managerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid manager ID." + managerId));
        manager1.setManagerId(managerId);
        manager1.setManagerName(manager1.getManagerName());
        manager1.setManagerType(manager1.getManagerType());
        manager1.setAddress(manager1.getAddress());
        manager1.setEmail(manager1.getEmail());
        manager1.setTelnum(manager1.getTelnum());
        // Update any other fields as needed
        managerRepository.save(manager1);
    }

//    @Override
//    public void deleteStudioId(Integer studioID) {
//        Studio studio=  studioRepository.findById(studioID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid manager ID." + managerId));
//        studioRepository.delete(studio);
//    }


}
