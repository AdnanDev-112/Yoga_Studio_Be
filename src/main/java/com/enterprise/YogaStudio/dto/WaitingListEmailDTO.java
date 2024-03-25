package com.enterprise.YogaStudio.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WaitingListEmailDTO {
    private String clientName;
    private String sessionName;
    private String sessionDate;
    private String sessionTime;
    private String sessionInstructor;
    private String studioLocation;

    private String subject = "Yoga Studio - Waiting List Notification";

}
