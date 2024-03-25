package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.dto.ReservationMailDTO;
import com.enterprise.YogaStudio.dto.WaitingListEmailDTO;
import org.springframework.stereotype.Service;

@Service
public interface MailService {

    void waitingListMail(String to, WaitingListEmailDTO mail);

    void reservationConfirmationMail(String to, ReservationMailDTO message);
}
