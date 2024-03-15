package com.enterprise.YogaStudio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Integer courseId;
    private String courseName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer numberOfClasses;
    private BigDecimal price;
    private StudioDTO studio;
}
