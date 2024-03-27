package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Booking;
import com.enterprise.YogaStudio.model.PendingList;
import com.enterprise.YogaStudio.model.Reservation;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.repository.BookingRepository;
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
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public void addPendingList(PendingList pendingList) {
        pendingRepository.save(pendingList);
    }
    @Override
    public List<PendingList> getPendingListByClientId(Integer clientId) {
        return pendingRepository.getPendingListByClientId(clientId);
    }
    @Override
    public List<PendingList> getpendingLists() {
        return pendingRepository.findAll();
    }
    @Override
    @Transactional
    public List<PendingList> getPendingDataForSchedule(Integer yogaSessionId) {
        return pendingRepository.getSchedulesByYogaSessionClasses(yogaSessionId);
    }
    @Override
    public Booking cancelBooking(Integer id) {
        PendingList pendingList = pendingRepository.findById(id).get();
        Booking bookedFor = pendingList.getBooking();
        Integer bookingId = bookedFor.getId();

        bookingRepository.deleteById(bookingId);
        pendingRepository.deleteById(id);
        System.out.println("Booking Cancelled");
        return bookedFor;
    }
    @Scheduled(cron = "0 * * * * *") // This cron expression means the method will be executed every minute
    @Transactional
    public void handlePendingLists() {
        List<PendingList> pendingLists = getpendingLists();
        for (PendingList pendingList : pendingLists) {
            if (pendingList.getBookedTime().isBefore(LocalDateTime.now().minusHours(1)) && !pendingList.getConfirmedStatus()) {
                pendingList.setConfirmedStatus(true);
                pendingRepository.save(pendingList);
                Reservation reservation = new Reservation();
                Schedule schedule = pendingList.getBooking().getSchedule();
            //Setter Methods
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
