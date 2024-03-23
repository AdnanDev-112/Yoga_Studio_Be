package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.WaitingListDTO;
import com.enterprise.YogaStudio.model.*;
import com.enterprise.YogaStudio.repository.BookingRepository;
import com.enterprise.YogaStudio.repository.WaitingListRepository;
import com.enterprise.YogaStudio.service.PendingListService;
import com.enterprise.YogaStudio.service.ReservationService;
import com.enterprise.YogaStudio.service.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WaitingListServiceImpl implements WaitingListService {
    @Autowired
    private WaitingListRepository waitingListRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PendingListService pendingListService;

    @Autowired
    private ReservationService reservationService;

    @Override
    public WaitingList addWaitingList(WaitingList waitingList) {
        return waitingListRepository.save(waitingList);
    }

    @Override
    public void removeWaitingList(Integer waitingListID) {
//        On Decline remove the waiting list and clear the booking
        WaitingList waitingList = waitingListRepository.findById(waitingListID).orElse(null);
        if (waitingList == null) {
            return;
        }
        Booking newBooking = waitingList.getBooking();
        bookingRepository.deleteById(newBooking.getId());

        waitingListRepository.deleteById(waitingListID);

    }

    @Override
    public void approveWaitingList(Integer waitingListID) {
        WaitingList waitingList = waitingListRepository.findById(waitingListID).orElse(null);
        if (waitingList == null) {
            return;
        }
        Booking newBooking = waitingList.getBooking();

        //        Save pendin List
        LocalDateTime date = LocalDateTime.now();
        PendingList pendingList = new PendingList();
        pendingList.setBookedTime(date);
        pendingList.setClient(newBooking.getClient());
        pendingList.setBooking(newBooking);
        pendingList.setConfirmedStatus(true);

        // Save the pending list
        pendingListService.addPendingList(pendingList);

//        Confirm the Reservation
        Reservation reservation = new Reservation();
        Schedule schedule = pendingList.getBooking().getSchedule();

//                Setter Methods
        reservation.setClient(pendingList.getClient());
        reservation.setPending(pendingList);
        reservation.setSchedule(schedule);

        String categoryType = pendingList.getBooking().getSchedule().getCategoryType();
        reservation.setCategoryType(categoryType);
        switch (categoryType) {
            case "course":
                reservation.setCourse(schedule.getCourse());
                break;
            case "yoga_session":
                reservation.setYogaSession(schedule.getYogaSession());
                break;
            case "retreat":
                reservation.setRetreat(schedule.getRetreat());
                break;
        }

        reservationService.addReservation(reservation);


        waitingListRepository.deleteById(waitingListID);
    }

    @Override
    public WaitingListDTO getWaitingListStats(Integer yogaSessionId) {
        int currentCapacity = pendingListService.getPendingDataForSchedule(yogaSessionId).size();
        WaitingListDTO waitingListDTO = new WaitingListDTO();
        waitingListDTO.setCurrentCapacity(String.valueOf(currentCapacity));

        return waitingListDTO;
    }

    @Override
    public List<Map<String, Object>> getCustomData() {
        List<WaitingList> waitingListItems = getWaitingListItems();
        Map<Integer, List<WaitingList>> sessionIdToWaitingList = new HashMap<>();
        Map<Integer, String> sessionIdToSessionName = new HashMap<>();

        for (WaitingList waitingList : waitingListItems) {
            Integer sessionId = waitingList.getYogaSession().getId();
            String sessionName = waitingList.getYogaSession().getSessionName();
            if (!sessionIdToWaitingList.containsKey(sessionId)) {
                sessionIdToWaitingList.put(sessionId, new ArrayList<>());
            }
            sessionIdToWaitingList.get(sessionId).add(waitingList);
            sessionIdToSessionName.put(sessionId, sessionName);
        }

        List<Map<String, Object>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<WaitingList>> entry : sessionIdToWaitingList.entrySet()) {
            Map<String, Object> entryMap = new HashMap<>();
            entryMap.put("className", sessionIdToSessionName.get(entry.getKey()));
            entryMap.put("items", entry.getValue());
            result.add(entryMap);
            int currentCapacity = pendingListService.getPendingDataForSchedule(entry.getKey()).size();
            entryMap.put("currentCapacity", currentCapacity);
        }

        return result;
    }


    @Override
    public List<WaitingList> getWaitingListItems() {
        return waitingListRepository.findAll();
    }
}
