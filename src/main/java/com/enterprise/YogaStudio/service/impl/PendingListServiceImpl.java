package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.PendingList;
import com.enterprise.YogaStudio.model.Reservation;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.repository.PendingRepository;
import com.enterprise.YogaStudio.service.PendingListService;
import com.enterprise.YogaStudio.service.ReservationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PendingListServiceImpl implements PendingListService {

    @Autowired
    PendingRepository pendingRepository;

    @Autowired
    ReservationService reservationService;

    @Override
    public void addPendingList(PendingList pendingList) {
        pendingRepository.save(pendingList);


    }

    @Override
    public List<PendingList> getpendingLists() {
        return pendingRepository.findAll();
    }


    //    @Scheduled(cron = "0 0 * * * *")
//public void handlePendingLists() {
//    List<PendingList> pendingLists = pendingListService.getpendingLists();
//    for (PendingList pendingList : pendingLists) {
//        if (pendingList.getBookedTime().isBefore(LocalDateTime.now().minusHours(24))) {
//            pendingList.setConfirmedStatus(true);
//            pendingRepository.save(pendingList);
//        }
//    }
//}
    @Scheduled(cron = "0 * * * * *") // This cron expression means the method will be executed every minute
    @Transactional
    public void handlePendingLists() {
        List<PendingList> pendingLists = getpendingLists();
        for (PendingList pendingList : pendingLists) {
//            if (pendingList.getBookedTime().isBefore(LocalDateTime.now().minusHours(24)) && !pendingList.getConfirmedStatus()) {
//
//            }
            if (pendingList.getBookedTime().isBefore(LocalDateTime.now().minusMinutes(5)) && !pendingList.getConfirmedStatus()) {
                pendingList.setConfirmedStatus(true);
                pendingRepository.save(pendingList);

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


                System.out.println("Pending List ITEM Confirmed");
            }
        }
    }
}
