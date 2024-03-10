package com.enterprise.software.ESED.CW.service;

import com.enterprise.software.ESED.CW.model.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> getManagerDetails();

    Manager saveManagerDetails(Manager manager);

    void updateManagerId(Long managerID, Manager manager);

    void deleteManagerId(Long managerID);
}
