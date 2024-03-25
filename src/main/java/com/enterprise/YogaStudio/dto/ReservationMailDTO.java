package com.enterprise.YogaStudio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationMailDTO {
    private String clientName;
    private String sessionName;
    private String sessionDate;
    private String sessionTime;
    private String sessionInstructor;
    private String studioLocation;

    private String subject = "Reservation Confirmation";
}
