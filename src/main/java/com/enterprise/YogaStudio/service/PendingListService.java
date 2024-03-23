package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.PendingList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PendingListService {

    void addPendingList(PendingList pendingList);

    List<PendingList> getPendingListByClientId(Integer clientId);

    List<PendingList> getpendingLists();

    List<PendingList> getPendingDataForSchedule(Integer yogaSessionId);

    Booking cancelBooking(Integer id);


}

