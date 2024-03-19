package com.enterprise.YogaStudio.dto;

import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Instructor;
import com.enterprise.YogaStudio.model.Pricing;
import com.enterprise.YogaStudio.model.YogaSession;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YogaRetreatDTO {

    private Integer id;

    private String retreatName;

    private String meal;

    private String activityType;

    private LocalDate date;

    private Integer instructorId;

    private Integer pricingId;

    private Integer yogaSessionId;

}
