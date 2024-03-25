package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.WaitingListDTO;
import com.enterprise.YogaStudio.model.WaitingList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface WaitingListService {
//    List all the CRUD methods
    WaitingList addWaitingList(WaitingList waitingList);
    void removeWaitingList(Integer waitingListID);
    List<WaitingList> getWaitingListItems();
    List<Map<String, Object>> getCustomData();
    void approveWaitingList(Integer waitingListID);
    WaitingListDTO getWaitingListStats(Integer yogaSessionId);
    void moveFirstout(Integer bookingId);
}
