package com.enterprise.YogaStudio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private String categoryType;
    private String level;
    private BigDecimal amount;
    private LocalTime startTime;
    private String instructorName;
    private Integer duration;
    private Integer maxCapacity;
    private Boolean recurring;
    private String managerName;
    private String address;

}
