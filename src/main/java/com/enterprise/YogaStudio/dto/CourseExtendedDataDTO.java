package com.enterprise.YogaStudio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseExtendedDataDTO{
    private String classDate;

    private String classEndTime;

    private String classStartTime;
}