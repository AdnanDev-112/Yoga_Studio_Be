package com.enterprise.YogaStudio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequest {
    private Integer scheduleId;

    private String category_type;

    private String startTime;

    private String endTime;

    private LocalDate date;

}
