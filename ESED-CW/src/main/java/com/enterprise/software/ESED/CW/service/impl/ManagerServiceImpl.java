package com.enterprise.software.ESED.CW.service.impl;

import com.enterprise.software.ESED.CW.model.Manager;
import com.enterprise.software.ESED.CW.repository.ManagerRepository;
import com.enterprise.software.ESED.CW.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public List<Manager> getManagerDetails() {
        return managerRepository.findAll();
    }

    @Override
    public Manager saveManagerDetails(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public void updateManagerId(Long managerID, Manager manager) {
        managerRepository.findById(managerID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid studio ID." + managerID));
        manager.setId(managerID);
        managerRepository.save(manager);
    }

    @Override
    public void deleteManagerId(Long managerID) {
        Manager manager=  managerRepository.findById(managerID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid studio ID." + managerID));
        managerRepository.delete(manager);
    }
}
