package com.enterprise.YogaStudio.dto;

import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Pricing;
import com.enterprise.YogaStudio.model.YogaSession;
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
public class BookingDTO {


    private String categoryType;
    private String level;
    private BigDecimal amount;
    private LocalTime startTime;
    private String instructorName;
    private Integer duration;
}
