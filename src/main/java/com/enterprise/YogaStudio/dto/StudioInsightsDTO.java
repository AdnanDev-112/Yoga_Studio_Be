package com.enterprise.YogaStudio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudioInsightsDTO {
    private Integer studioId;
    private Integer totalClasses;
    private Integer waitingList;
    private Integer totalBookings;
    private Double revenue;


}
